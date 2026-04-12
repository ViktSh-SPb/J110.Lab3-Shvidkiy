package org.viktsh;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class CustomTwoLinkedList<T> implements CustomList<T> {

    private Node<T> head;
    private Node<T> tail;


    private static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void addToHead(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
            tail = head;
        } else {
            Node<T> temp = new Node<>(data);
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public T getHeadDelete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = head.data;
        headDelete();
        return value;
    }

    @Override
    public void addToTail(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    @Override
    public T getTail() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public T getTailDelete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = tail.data;
        tailDelete();
        return value;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (Objects.equals(currentNode.data, value)) {
                contains = true;
                break;
            }
            currentNode = currentNode.next;
        }
        return contains;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public List<T> getAll() {
        List<T> resultList = new LinkedList<>();
        Node<T> currentNode = head;
        while (currentNode != null) {
            resultList.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return resultList;
    }

    public List<T> getAllReverse() {
        List<T> resultList = new LinkedList<>();
        Node<T> currentNode = tail;
        while (currentNode != null) {
            resultList.add(currentNode.data);
            currentNode = currentNode.prev;
        }
        return resultList;
    }

    @Override
    public void deleteValue(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, value)) {
                if (current == head) {
                    headDelete();
                    current = head;
                    continue;
                }
                if (current == tail) {
                    tailDelete();
                    break;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current = current.next;
            } else {
                current = current.next;
            }
        }
    }

    public void addArrayToHead(T[] input) {
        addIterableToHead(Arrays.asList(input));
    }

    public void addIterableToHead(Iterable<T> input) {
        CustomTwoLinkedList<T> tempList = new CustomTwoLinkedList<>();
        for (T i : input) {
            tempList.addToTail(i);
        }

        if (tempList.isEmpty()) {
            return;
        }

        if (isEmpty()) {
            head = tempList.head;
            tail = tempList.tail;
        } else {
            head.prev = tempList.tail;
            tempList.tail.next = head;
            head = tempList.head;
        }
    }

    public void addArrayToTail(T[] input) {
        addIterableToTail(Arrays.asList(input));
    }

    public void addIterableToTail(Iterable<T> input) {
        for (T i : input) {
            addToTail(i);
        }
    }

    public void addCustomTwoLinkedListToHead(CustomTwoLinkedList<T> input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        if (isEmpty()) {
            head = input.head;
            tail = input.tail;
        }else{
            head.prev = input.tail;
            input.tail.next = head;
            head = input.head;
        }
    }

    public void addCustomTwoLinkedListToTail(CustomTwoLinkedList<T> input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        if (isEmpty()) {
            head = input.head;
            tail = input.tail;
        }else{
            tail.next = input.head;
            input.head.prev = tail;
            tail = input.tail;
        }
    }

    public void processEachReverse(Consumer<T> consumer) {
        Node<T> currentNode = tail;
        while (currentNode != null) {
            consumer.accept(currentNode.data);
            currentNode = currentNode.prev;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private void headDelete() {
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
    }

    private void tailDelete() {
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
}
