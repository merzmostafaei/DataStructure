package com.merzmostafaei.train.heap;

public class PriorityQueueWIthHeap {
    private Heap heap = new Heap();

    public void enqeue(int item){
        heap.insert(item);
    }

    public void dequeue(int item){
        heap.remove();
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
