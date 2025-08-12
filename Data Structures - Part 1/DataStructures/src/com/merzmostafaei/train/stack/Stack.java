package com.merzmostafaei.train.stack;

import java.util.Arrays;

public class Stack {
    int[] array = new int[5];
    int number;
    int count = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void push(int number) {
        if (count < array.length) {
            array[count++] = number;
        } else {
            throw new StackOverflowError("stack is full");
        }
    }

    public void pop() {
        if (count > 0) {
            array[--count] = 0;
        } else {
           throw new IllegalStateException();
        }
    }

    public int peek() {
        if (count > 0) {
            return array[count - 1];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public int min(){

        if(array.length ==0){
            throw new RuntimeException("Array is Empty");
        }

        int minvalue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minvalue) {
                minvalue = array[i];
            }
        }
        return minvalue;

    }
    @Override
    public String toString(){
        var content = Arrays.copyOfRange(array,0,count);
        return Arrays.toString(content);
    }
}
