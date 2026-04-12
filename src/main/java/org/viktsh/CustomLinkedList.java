package org.viktsh;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<T> implements CustomList<T> {

    private Node<T> head;

    private static class Node<T> {

        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void addToHead(T data) {
        Node<T> temp = new Node<>(data);
        temp.next = head;
        head = temp;
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
        head = head.next;
        return value;
    }

    @Override
    public void addToTail(T data) {
        Node<T> tail = getTailNode();
        if (tail == null) {
            head = new Node<>(data);
            return;
        }
        tail.next = new Node<>(data);
    }

    @Override
    public T getTail() {
        Node<T> tail = getTailNode();
        if(tail==null){
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public T getTailDelete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<T> current = head;
        T value = current.data;
        if (current.next == null) {
            head = null;
        } else {
            while (current.next.next !=null) {
                current = current.next;
            }
            value = current.next.data;
            current.next = null;
        }
        return value;
    }

    @Override
    public boolean contains(T value) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (Objects.equals(currentNode.data, value)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
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

    @Override
    public void deleteValue(T value) {
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        while (currentNode != null) {
            if (Objects.equals(currentNode.data, value)) {
                if (currentNode == head) {
                    head = currentNode.next;
                    currentNode = head;
                } else {
                    previousNode.next = currentNode.next;
                    currentNode = previousNode.next;
                }
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
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

    private Node<T> getTailNode() {
        if (head == null) {
            return null;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
