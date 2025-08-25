package com.merzmostafaei.train.heap;

import java.util.Arrays;

public class buildingAheap {

    int[] array = new int[10];
    int size = 0;

    public void insert(int node) {
        if (isFull()) throw new IllegalStateException(); // or grow()
        array[size++] = node;
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && array[index] > array[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) { return (index - 1) / 2; }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private boolean isFull() { return size == array.length; }
    public boolean isEmpty() { return size == 0; }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException();
        int root = array[0];
        array[0] = array[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int index = 0;
        while (hasLeftChild(index) && !isValidParent(index)) {
            int largerChild = largerChildIndex(index);
            swap(index, largerChild);
            index = largerChild;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) return true;                // leaf
        boolean valid = array[index] >= leftChild(index);
        if (hasRightChild(index))
            valid &= array[index] >= rightChild(index);
        return valid;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) return index;               // no children
        if (!hasRightChild(index)) return leftChildIndex(index);
        return leftChild(index) >= rightChild(index)
                ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    private int leftChild(int index)  { return array[leftChildIndex(index)]; }
    private int rightChild(int index) { return array[rightChildIndex(index)]; }

    private int leftChildIndex(int index)  { return 2 * index + 1; }
    private int rightChildIndex(int index) { return 2 * index + 2; }

    private boolean hasLeftChild(int index)  { return leftChildIndex(index)  < size; }
    private boolean hasRightChild(int index) { return rightChildIndex(index) < size; }

    @Override
    public String toString() {
        return "buildingAheap{array=" + Arrays.toString(Arrays.copyOf(array, size)) + '}';
    }
}
