package org.viktsh;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomExpandedLinkedList<T> implements CustomList<T> {
    private Node<T> head;

    private static class Node<T> {
        private Node<T> next;
        private T[] data;

        public Node() {
            this.data = (T[]) new Object[3];
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

        public Node(T value) {
            this.data = (T[]) new Object[3];
            this.data[0] = value;
        }

        private Node(T[] data) {
            this.data = data;
        }

        public boolean isEmpty() {
            boolean isEmpty = true;
            for (T i : data) {
                if (i != null) isEmpty = false;
            }
            return isEmpty;
        }

        public boolean getFull() {
            boolean isFull = true;
            for (T i : data) {
                if (i == null) isFull = false;
            }
            return isFull;
        }

        public void addToNodeHead(T value) {
            T[] temp = (T[]) new Object[3];
            temp[0] = value;
            for (int i = 1; i < data.length; i++) {
                temp[i] = data[i - 1];
            }
            data = temp;
        }

        public Node<T> addToTail(T value) {
            if (getFull()) {
                return (Node<T>) new Node(value);
            } else {
                for (int i = 0; i < data.length; i++) {
                    if (data[i] == null) {
                        data[i] = value;
                        break;
                    }
                }
                return this;
            }
        }

        public Node<T> removeFromHead() {
            T[] temp = (T[]) new Object[data.length];
            for (int i = 1; i < data.length; i++) {
                temp[i - 1] = data[i];
                if (data[i] == null) {
                    break;
                }
            }
            data = temp;
            return (isEmpty()) ? this.next : this;
        }


    }

    public void addToHead(T value) {
        if (isEmpty()) {
            head = new Node<>(value);
        } else if (head.getFull()) {
            Node<T> temp = new Node<>(value);
            temp.next = head;
            head = temp;
        } else {
            head.addToNodeHead(value);
        }
    }

    public void printHead() {
        System.out.println(head.data[0]);
    }

    public void printHeadDelete() {
        if (!isEmpty()) {
            System.out.println(head.data[0]);
            head = head.removeFromHead();
        }
    }

    public void addToTail(T value) {
        if (isEmpty()) {
            addToHead(value);
        } else {
            if (getTail().getFull()) {
                getTail().next = getTail().addToTail(value);
            } else {
                getTail().addToTail(value);
            }
        }

    }

    public void printTail() {
        if (!isEmpty()) {
            Node<T> tail = getTail();
            for (int i = tail.data.length - 1; i >= 0; i--) {
                if (tail.data[i] != null) {
                    System.out.println("Tail is " + tail.data[i]);
                }
            }
        }
    }

    public void printTailDelete() {
    }

    public boolean contains(T value) {

        return true;
    }

    public void deleteValue(T value) {
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void printAll() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    private Node<T> getTail() {
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
                if (current==null) {
                    throw new NoSuchElementException();
                }
                return current.data[indexInNode++];
            }
        };
    }

}
