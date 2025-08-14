package com.merzmostafaei.train.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    Queue<Integer> queueLeft = new ArrayDeque<>();

    Queue<Integer> queueRight = new ArrayDeque<>();

    public void push(int elemet){
        queueLeft.add(elemet);
        if (!queueRight.isEmpty()){
            queueLeft.add(queueRight.remove());
        }
        Queue<Integer> temporaryQueue = queueRight;
        queueRight = queueLeft;
        queueLeft = temporaryQueue;


    }
    public int pop(){
        if(queueRight.isEmpty())
            throw new IllegalArgumentException();


        return queueRight.remove();
    }
    public int peek(){
        if(queueRight.isEmpty())
            throw new IllegalArgumentException();
        return queueRight.peek();
    }
    public int size(){
        return queueRight.size();
    }


    @Override
    public String toString() {
        return "StackWithTwoQueue " + queueRight;
    }

}
