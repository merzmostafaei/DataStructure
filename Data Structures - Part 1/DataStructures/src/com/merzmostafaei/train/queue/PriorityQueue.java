package com.merzmostafaei.train.queue;

import java.util.Arrays;

public class PriorityQueue {
    int size;
    int[] items;
    int index = 0;
    int count;
    public PriorityQueue(int size) {
        this.size= size;
        items = new int[size];
    }

    public void add(int item){
        if (ifFull()){
            throw new IllegalStateException("Full");
        }


        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        // ShiftingItems
        int i; //we need it because when is break the loop we whant to know which index must to set as new element
        for (i = count-1 ; i >= 0 ; i--){
            if (items[i] > item)
                items[i+1] = items[i];
            else
                break;
        }
        return i+1;
    }

    public int pull(){
        if(isEmpty())
           throw new IllegalStateException("is Empty");

        return items[--count];
    }

    public boolean ifFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "array=" + Arrays.toString(items) +
                '}';
    }
}
