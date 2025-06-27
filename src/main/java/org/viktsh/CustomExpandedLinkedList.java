package org.viktsh;

import java.util.Arrays;

public class CustomExpandedLinkedList<T> implements CustomList<T> {
    private Node<T> head;

    private class Node {
        private Node<T> next;
        private T[] data;

        public Node() {
            this.data =(T[]) new Object[3];
        }

        public Node(T value) {
            this.data = (T[]) new Object[3];
            this.data[0] = value;
        }

        public boolean getEmpty() {
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

        public Node<T> addToHead(T value) {
            if (getFull()) {
                Node<T> newNode = new Node<>(value);
                newNode.next = head;
                return newNode;
            } else {
                T[] temp = (T[]) new Object[data.length];
                temp[0] = value;
                int i = 0;
                while (data[i] != null) {
                    temp[i + 1] = data[i];
                    i++;
                }
                data = temp;
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
            return (getEmpty()) ? this.next : this;
        }

        public Node<T> addToTail(T value) {
            if (getFull()) {
                Node<T> newNode = new Node<>(value);
                return newNode;
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
    }

    public void addToHead(T value) {
        head = (isEmpty()) ? head = new Node<>(value) : head.addToHead(value);
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
            Integer value;
            Node tail = getTail();
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

    public void peek(int i) {
    }

    ;

    public boolean isEmpty() {
        return (head == null);
    }

    public void printAll() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(Arrays.toString(currentNode.data) + " ");
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
}
