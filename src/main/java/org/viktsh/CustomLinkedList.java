package org.viktsh;

public class CustomLinkedList<T> implements CustomList<T>{
    private Node<T> head;

    private static class Node<T> {
        private T data;
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
            Node currentNode = head;
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
        boolean contains = false;
        Node currentNode = head;
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
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    @Override
    public void deleteValue(T value){
        Node<T> currentNode = head;
        Node<T> previousNode = new Node<>(null);
        while (currentNode!=null){
            if(currentNode.data==value){
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

    public void peek(int i){
//        Node currentNode = head;
//        while (currentNode!=null){
//            currentNode.data= currentNode.data+i;
//            currentNode=currentNode.next;
//        }
    }

    private Node getTail(){
        Node temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
}
