package com.merzmostafaei.train.heap;

import java.util.Arrays;

public class buildingAheap {

    int[] array = new int[10];

    int size = 0;

    public void insert(int node) {
        if (isFull())
            throw new IllegalStateException();

        array[size] = node;
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

    public int remove(){
        if (isEmpty())throw new IllegalStateException();

        var root = array[0];
        array[0] = array[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        var index = 0;

        while (index <= size && !isValidParent(index)){

            var LargChildIndex = largerChildIndex(index);
            swap(index,lefChildIndex(index));
            index = LargChildIndex;
        }
    }

    private boolean isValidParent(int index){
        if (!hasLeftChild(index))
            return true;

        var isValid = array[index] > leftChild(index);

        if (hasRightChild(index))
            isValid &= array[index] > rightChild(index);

        return isValid;
    }
    private int largerChildIndex(int index){
        if (hasLeftChild(index))return index;
        if(hasRightChild(index))return lefChildIndex(index);

        return (leftChild(index) > rightChild(index) ? lefChildIndex(index) : rightChildIndex(index));

    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int rightChild(int index){
        return array[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return array[lefChildIndex(index)];
    }

    private int lefChildIndex(int index){
        return 2 * index + 1;
    }
    private int rightChildIndex(int index){
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index){
        return lefChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }



    @Override
    public String toString() {
        return "buildingAheap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }


}


