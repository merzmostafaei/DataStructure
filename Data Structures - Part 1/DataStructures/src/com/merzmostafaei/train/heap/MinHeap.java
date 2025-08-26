package com.merzmostafaei.train.heap;

import java.util.Arrays;
import java.util.HashMap;

public class MinHeap {
    private class Node{
        int key;
        String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }


    private Node[] nodes = new Node[10];

    int size = 0 ;


    public void insert(int key, String value) {
        if (isFull()) throw new IllegalStateException();

        nodes[size++] = new Node(key, value);

        bubbleUp();




    }

    private String remove(){
        if(isEmpty())throw new IllegalStateException();

        String root = nodes[0].value;
        nodes[0] = nodes[size - 1];
        nodes[size - 1] = null;   // avoid loitering
        size--;

        bubbleDown();
        return root;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && nodes[index].key < nodes[parentIndex(index)].key){
            swap(index,parentIndex(index));
            index = parentIndex(index);
        }
    }
    private void bubbleDown(){
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChild = smallerChildIndex(index);
            if (nodes[index].key <= nodes[smallerChild].key) break; // heap property satisfied
            swap(index, smallerChild);
            index = smallerChild;
        }
    }

    private int smallerChildIndex(int index){
        if(!hasLeftChild(index)){
            return index;
        }
        if(!hasRightChild(index)){
            return leftChildIndex(index);
        }
        return (nodes[leftChildIndex(index)].key < nodes[rightChildIndex(index)].key) ? leftChildIndex(index) : rightChildIndex(index);
    }






    private void swap(int first, int second){
        var temp = nodes[first];
        nodes[first]  = nodes[second];
        nodes[second] = temp;
    }


    private boolean isValidParent(int index){
        if(!hasLeftChild(index))return true;

        var isValid = nodes[index].key <= nodes[leftChildIndex(index)].key;

        if(hasRightChild(index)){
            isValid &= nodes[index].key <= nodes[rightChildIndex(index)].key;
        }
        return isValid;
    }

    private boolean hasLeftChild(int index){return leftChildIndex(index) < size;}

    private boolean hasRightChild(int index){return rightChildIndex(index) < size;}
    private boolean isFull(){
        return size == nodes.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private int parentIndex(int index){
        return (index -1) / 2 ;
    }

    private int leftChildIndex(int index){
        return 2 * index + 1;
    }
    private int rightChildIndex(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "nodes=" + Arrays.toString(nodes) +
                '}';
    }
}
