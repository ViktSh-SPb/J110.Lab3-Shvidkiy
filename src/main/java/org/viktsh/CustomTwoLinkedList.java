package org.viktsh;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomTwoLinkedList<T> implements CustomList<T>{
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
            tail=head;
        } else {
            Node<T> temp = new Node<>(data);
            head.prev = temp;
            temp.next=head;
            head=temp;
        }
    }

    @Override
    public void printHead() {
        if (!isEmpty()) {
            System.out.println("head is " + head.data);
        }
    }

    @Override
    public void printHeadDelete() {
        if (!isEmpty()) {
            System.out.println("head is " + head.data);
            headDelete();
        }
    }

    @Override
    public void addToTail(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
            tail=head;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(data);
            tail=temp.next;
            tail.prev=temp;
        }
    }

    @Override
    public void printTail() {
        if (!isEmpty()) {
            System.out.println("tail is " + tail.data);
        }
    }

    @Override
    public void printTailDelete() {
        if (!isEmpty()) {
            System.out.println("tail is " + tail.data);
            tailDelete();
        }
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == value) {
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
    public void printAll() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void printAllReverse() {
        Node<T> currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.prev;
        }
        System.out.println();
    }

    @Override
    public void deleteValue(T value){
        Node<T> currentNode = head;
        Node<T> previousNode = new Node<>(null);
        Node<T> nextNode = head!=null?head.next:null;
        while (currentNode!=null){
            if(currentNode.data==value){
                if(currentNode==head){
                    headDelete();
                }else if(currentNode==tail){
                    tailDelete();
                }else {
                    previousNode.next=nextNode;
                    nextNode.prev=previousNode;
                }
            }
            previousNode=currentNode;
            currentNode=currentNode.next;
            nextNode=(currentNode!=null)?currentNode.next:null;
        }
    }

    public void addArrayToHead(T[] input){
        CustomTwoLinkedList<T> tempList = new CustomTwoLinkedList<>();
        for (T i:input){
            tempList.addToTail(i);
        }
        head.prev=tempList.tail;
        tempList.tail.next=head;
        head=tempList.head;
    }

    private void tailDelete() {
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail=tail.prev;
            tail.next=null;
        }
    }

    private void headDelete() {
            head = head.next;
            if (head == null) {
                tail = null;
            }else {head.prev=null;}
    }

    public void addIterableToHead(Iterable<T>input){
        CustomTwoLinkedList<T> tempList = new CustomTwoLinkedList<>();
        for (T i:input){
            tempList.addToTail(i);
        }
        head.prev=tempList.tail;
        tempList.tail.next=head;
        head=tempList.head;
    }

    public void addArrayToTail(T[]input){
        for(T i:input){
            addToTail(i);
        }
    }

    public void addIterableToTail(Iterable<T>input){
        for (T i:input){
            addToTail(i);
        }
    }

    public void addCustomTwoLinkedListToHead(CustomTwoLinkedList<T> input){
        head.prev = input.tail;
        input.tail.next = head;
        head=input.head;
    }

    public void addCustomTwoLinkedListToTail(CustomTwoLinkedList<T> input){
        tail.next=input.head;
        input.head.prev=tail;
        tail=input.tail;
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
