package com.merzmostafaei.train.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    Queue<Integer> queueLeft = new ArrayDeque<>();

    Queue<Integer> queueRight = new ArrayDeque<>();

    public void push(int elemet){
        queueLeft.add(elemet);
        while (!queueRight.isEmpty()){
            queueLeft.add(queueRight.remove());
        }
        Queue<Integer> temprary = queueRight;
        queueRight = queueLeft;
        queueLeft = temprary;
    }
    public int pop(){
        if (queueRight.isEmpty()) throw new IllegalStateException("Stack is empty");

        return queueRight.remove();
    }
    public int peek(){
        if (queueRight.isEmpty()) throw new IllegalStateException("Stack is empty");
        return queueRight.peek();
    }
    public int size(){
        return queueRight.size();
    }
    public boolean isEmpty(){
        return queueRight.isEmpty();
    }

    @Override
    public String toString() {
        return "StackWithTwoQueues{" + queueRight +
                '}';
    }

}
