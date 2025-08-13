package com.merzmostafaei.train.queue;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> array =new LinkedList<>();
    public void enqueue(int element){
        array.addLast(element);

    }
    public void dequeue(){
        array.removeFirst();
    }
    public int peek(){
        return array.peek();
    }
    public int size(){
        int size = array.size();
        return size;
    }
    public boolean isEmpty(){
        return array.isEmpty();
    }
}
