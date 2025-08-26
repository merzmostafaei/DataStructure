package com.merzmostafaei.train.heap;

public class MinPriorityQueue {

    private MinHeap minHeap = new MinHeap();

    public void insert(String value,int priority){
        minHeap.insert(priority,value);


    }

    public void remove(){
        minHeap.remove();
    }
    public void isEmplty(){
        minHeap.isEmpty();
    }

    @Override
    public String toString() {
        return "MinPriorityQueue{" +
                "minHeap=" + minHeap +
                '}';
    }
}
