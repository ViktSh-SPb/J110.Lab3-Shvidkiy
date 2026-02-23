package org.viktsh;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomExpandedLinkedList<T> implements CustomList<T> {
    private Node<T> head;

    private static class Node<T> {
        private Node<T> next;
        private Object[] data;

        public Node() {
            this.data = new Object[3];
        }

        public Node(T value) {
            this.data = new Object[3];
            this.data[0] = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                if (data[i] != null) {
                    sb.append(data[i]).append(" ");
                }
            }
            return sb.toString().trim();
        }

        public boolean isEmpty() {
            boolean isEmpty = true;
            for (Object i : data) {
                if (i != null) isEmpty = false;
            }
            return isEmpty;
        }

        public boolean isFull() {
            boolean isFull = true;
            for (Object i : data) {
                if (i == null) isFull = false;
            }
            return isFull;
        }

        public T getNodeHead() {
            return (T) data[0];
        }

        public T getNodeTail() {
            for (int i = data.length - 1; i >= 0; i--) {
                if (data[i] != null) {
                    return (T) data[i];
                }
            }
            return null;
        }

        public void addToNodeHead(T value) {
            Object[] temp = new Object[3];
            temp[0] = value;
            for (int i = 1; i < data.length; i++) {
                temp[i] = data[i - 1];
            }
            data = temp;
        }

        public Node<T> addToNodeTail(T value) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    data[i] = value;
                    break;
                }
            }
            return this;
        }

        public T removeFromNodeHead() {
            Object[] temp = new Object[data.length];
            for (int i = 1; i < data.length; i++) {
                temp[i - 1] = data[i];
                if (data[i] == null) {
                    break;
                }
            }
            Object removed = data[0];
            data = temp;
            return (T) removed;
        }

        public T removeFromNodeTail() {
            Object removed = null;
            for (int i = data.length - 1; i >= 0; i--) {
                if (data[i] != null) {
                    removed = data[i];
                    data[i] = null;
                    return (T) removed;
                }
            }
            return (T) removed;
        }

    }

    public void addToHead(T value) {
        if (isEmpty()) {
            head = new Node<>(value);
        } else if (head.isFull()) {
            Node<T> temp = new Node<>(value);
            temp.next = head;
            head = temp;
        } else {
            head.addToNodeHead(value);
        }
    }

    public T getHead() {
        if(!isEmpty()){
            return ((T) head.data[0]);
        }
        return null;
    }

    public T getHeadDelete() {
        T value = null;
        if (!isEmpty()) {
            value =  (head.removeFromNodeHead());
            if (head.isEmpty()) {
                head = head.next;
            }
        }
        return value;
    }

    public void addToTail(T value) {
        if (isEmpty()) {
            addToHead(value);
        } else {
            Node<T> tail = getTailNode();
            if (tail.isFull()) {
                tail.next = new Node<>(value);
            } else {
                tail.addToNodeTail(value);
            }
        }
    }

    public T getTail() {
        if (!isEmpty()) {
            Node<T> tail = getTailNode();
            return tail.getNodeTail();
        }
        return null;
    }

    public T getTailDelete() {
        if (isEmpty()) return null;

        if (head.next == null) {
            T value = head.removeFromNodeTail();
            if (head.isEmpty()) head = null;
            return value;
        }

        Node<T> prev = head;
        Node<T> curr = head.next;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        T value = curr.removeFromNodeTail();

        if (curr.isEmpty()) {
            prev.next = null;
        }

        return value;
    }

    public boolean contains(T value) {
        for (T element : this) {
            if (Objects.equals(value, element)) {
                return true;
            }
        }
        return false;
    }

    public void deleteValue(T value) {
        CustomExpandedLinkedList<T> temp = new CustomExpandedLinkedList<>();
        for (T element : this) {
            if (!Objects.equals(element, value)) {
                temp.addToTail(element);
            }
        }

        this.head = temp.head;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public List<T> getAll() {
        List<T> resultList = new LinkedList<>();
        for (T element : this) {
            resultList.add(element);
        }
        return resultList;
    }

    public void addArrayToHead(T[] input) {
        addIterableToHead(Arrays.asList(input));
    }

    public void addIterableToHead(Iterable<T> input) {
        CustomExpandedLinkedList<T> temp = new CustomExpandedLinkedList<>();
        for (T t : input) {
            temp.addToTail(t);
        }
        if (temp.isEmpty()) {
            return;
        }
        if (temp.getTailNode().isFull()) {
            temp.getTailNode().next = this.head;
        } else {
            for (T element : this) {
                temp.addToTail(element);
            }
        }
        this.head=temp.head;
    }

    public void addArrayToTail(T[] input) {
        addIterableToTail(Arrays.asList(input));
    }

    public void addIterableToTail(Iterable<T> input) {
        for (T t : input) {
            this.addToTail(t);
        }
    }

    public void addCustomEListToHead(CustomExpandedLinkedList<T> input){
        addIterableToHead(input);
    }

    public void addCustomEListToTail(CustomExpandedLinkedList<T> input){
        addIterableToTail(input);
        input.head=null;
    }

    private Node<T> getTailNode() {
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            private int indexInNode = 0;

            //ищет следующий непустой элемент
            private void moveToNext() {
                while (current != null) {
                    //пропускаем null-значения в массиве
                    while (indexInNode < current.data.length && current.data[indexInNode] == null) {
                        indexInNode++;
                    }
                    //если нашли элемент, выходим
                    if (indexInNode < current.data.length) {
                        return;
                    }
                    //если в этом узле элементы закончились, идем к следующему
                    current = current.next;
                    indexInNode = 0;
                }
            }

            @Override
            public boolean hasNext() {
                moveToNext();
                return current != null;
            }

            @Override
            public T next() {
                moveToNext();
                if (current == null) {
                    throw new NoSuchElementException();
                }
                return (T) current.data[indexInNode++];
            }
        };
    }

}
