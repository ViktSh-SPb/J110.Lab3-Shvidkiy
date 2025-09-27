package org.viktsh;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
            getTailNode().next = new Node<>(data);
        }
    }

    @Override
    public T getHead() {
        if (!isEmpty()) {
            return head.data;
        }
        return null;
    }

    @Override
    public T getTail() {
        if (!isEmpty()) {
            return getTailNode().data;
        }
        return null;
    }

    @Override
    public T getHeadDelete() {
        T value = null;
        if (!isEmpty()) {
            value = head.data;
            head = head.next;
        }
        return value;
    }

    @Override
    public T getTailDelete() {
        T value = null;
        if (!isEmpty()) {
            value = getTailNode().data;
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
        return value;
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

    private Node<T> getTailNode(){
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
