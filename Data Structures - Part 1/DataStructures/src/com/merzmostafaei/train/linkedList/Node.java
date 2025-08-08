package com.merzmostafaei.train.linkedList;

public class Node {

    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;

    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }



}
