package org.viktsh;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements CustomList<T>{
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
        if (isEmpty()) {
            head = new Node<>(data);
        } else {
            Node<T> temp=new Node<>(data);
            temp.next=head;
            head=temp;
        }
    }

    @Override
    public void addToTail(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
        } else {
            getTail().next = new Node<>(data);
        }
    }

    @Override
    public void printHead() {
        if (!isEmpty()) {
            System.out.println("head is " + head.data);
        }
    }

    @Override
    public void printTail() {
        if (!isEmpty()) {
            System.out.println("tail is " + getTail().data);
        }
    }

    @Override
    public void printHeadDelete() {
        if (!isEmpty()) {
            System.out.println("head is " + head.data);
            head = head.next;
        }
    }

    @Override
    public void printTailDelete() {
        if (!isEmpty()) {
            System.out.println("tail is " + getTail().data);
            Node<T> currentNode = head;
            if(currentNode.next==null) {
                head = null;
            }else {
                while (currentNode.next.next!=null){
                    currentNode=currentNode.next;
                }
                currentNode.next=null;
            }
        }
    }

    @Override
    public boolean contains(T value) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(value)) {
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
    public void printAll() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    @Override
    public void deleteValue(T value){
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        while (currentNode!=null){
            if(currentNode.data.equals(value)){
                if(currentNode==head){
                    head = currentNode.next;
                }else {
                    previousNode.next=currentNode.next;
                }
            }
            previousNode=currentNode;
            currentNode=currentNode.next;
        }
    }

    private Node<T> getTail(){
        Node<T> temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current=current.next;
                return data;
            }
        };
    }

}
