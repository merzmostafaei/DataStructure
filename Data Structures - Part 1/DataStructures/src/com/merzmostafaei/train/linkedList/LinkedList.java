package com.merzmostafaei.train.linkedList;

public class LinkedList {
    private Node first;
    private Node last;

    private int count;


    public int count() {
        return count;
    }

    //addFirst

    public void addFirst(int element){
        Node newNode = new Node(element,first);
        first = newNode;
        if(last== null){
            last = first;
        }
        count++;

    }

    //addLast
    public void addLast(int element){

        Node newNode = new Node(element,null);
        if(last == null){
            first = last = newNode;
        }else {
            last.setNext(newNode);
            last = newNode;
        }
        count++;
    }


    //deleteFirst
    public void deleteFirst(){
        if(first == null) return;
        first = first.getNext();
        if (first == null) last = null;
        count--;
    }

    //deleteLast

    public void deleteLast(){
        if (last == null) return;
        if(first == last) first = last = null;
        else {
            Node current = first;
            while (current.getNext() != last){
                current = current.getNext();
            }
            current.setNext(null);
            last = current;
        }
        count--;
    }
    //contains
    public boolean contains(int element){
        return indexof(element) != -1;
    }

    //indexOf
    public int indexof(int element) {
        Node current = first;
        int index = 0;
        while (current != null){
            if (current.getValue()== element) return index;
            current = current.getNext();
            index ++;
        }
        return -1;

    }

    public int[] toArray(){
        int[] array = new int[count];
        var current = first;
        var index = 0;
        while (current != null){
            array[index++] = current.getValue();
            current= current.getNext();

        }
        return array;
    }

    public void reverse(){
        if(first == null) return;

        Node prev = null;
        Node current = first;
        Node next = null;

        while (current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        last = first;
        last.setNext(null);
        first = prev;


    }

    public void printList(){
        Node current = first;
        while (current != null){
            System.out.print(current.getValue() + "-->");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
