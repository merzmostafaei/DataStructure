package com.merzmostafaei.train.stack;

import java.util.Arrays;

public class TwoStackOneArray {
    private final int[] array = new int[10];


    private int left = 0;
    private int right = (array.length)-1;


    public void push1(int number){
        if (left <= right)
            array[left++] = number;

    }
    public void push2(int number){
        if (left <= right)
            array[right--] = number;
    }

    public int pop1(){
        if (isEmpty1()){
            throw new RuntimeException("stack1 is Empty");
        }
        left--;
        int popItem = array[left];
        array[left] = 0;
        return popItem;
    }

    public int pop2(){
        if (isEmpty2()) {
            throw new RuntimeException("stack2 is Empty");
        }
        ++right;
        int popItem = array[right];
        array[right] = 0;
        return popItem;
    }

    public boolean isEmpty1(){
        return left == 0;
    }

    public boolean isEmpty2(){
        return right == array.length-1 ;
    }
    public boolean isFull1(){
        return left > right;
    }
    public boolean isFull2(){
        return right < left ;
    }


    @Override
    public String toString() {
        return "TwoStackOneArray{" +
                "array=" + Arrays.toString(array);
    }


}
