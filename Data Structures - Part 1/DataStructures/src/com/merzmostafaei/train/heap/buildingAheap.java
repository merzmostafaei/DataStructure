package com.merzmostafaei.train.heap;

import java.util.Arrays;

public class buildingAheap {

    int[] array = new int[10];

    int size = 0;

    public void insert(int node) {
        if (isFull())
            throw new IllegalStateException();

        array[size]= node;
        size++;
        bubbleUp();


    }

    private void bubbleUp(){
        var index = size -1;;

        while (index > 0 && array[index] > array[parent(index)]){
            swap(index,parent(index));
            index = parent(index);
        }

    }

    private int parent(int index){
        return (index-1) / 2;
    }


    private void swap(int first, int second){
        var tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return "buildingAheap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }


}


