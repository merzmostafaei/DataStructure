package com.merzmostafaei.train.queue;

import java.util.Arrays;
import java.util.Stack;

public  class ImplementingTheQueue {

    // Implementing with Array

        public static class ArrayQueue{
            int[] array;

            int first;
            int rear;
            int size;
            //[ 10 , 20 , 30 , 40 , 50 ]
            //  F                  Rear
            public ArrayQueue(int capacity){
                array = new int[capacity];
                first =0;
                rear = -1;
                size = 0;
            }

            public void enqueue(int element){
                if(isFull()){
                    throw new RuntimeException("queue is Full");
                }
                rear = (rear +1 ) % array.length;
                array[rear] = element;
                size++;

            }
            public int dequeue(){
                if(isEmpty()){
                    throw new RuntimeException("queue is Empty");
                }
                int removed = array[first];
                first = (first +1 ) % array.length;
                size--;
                return removed;
            }
            public int peek(){
                if(isEmpty())
                    throw new RuntimeException("empty Queue");

                return array[first];

            }
            private boolean isEmpty() {
                return size == 0;
            }

            public boolean isFull(){
                return size == array.length;
            }

            @Override
            public String toString() {
                return "ArrayQueue{" +
                        "array=" + Arrays.toString(array) +
                        '}';
            }


        }

        public static class StackQueue{
            Stack<Integer> stackLeft = new Stack<>();

            Stack<Integer> stackRight = new Stack<>();

            public void enqueue(int element){
                if(stackLeft.isEmpty())
                    stackLeft.push(element);


                stackRight.push(stackLeft.pop());

            }

            public void dequeue(){
                while (!stackRight.isEmpty()){
                    stackLeft.push(stackRight.pop());
                }
                stackLeft.pop();
                while (!stackLeft.isEmpty()){
                    stackRight.push(stackLeft.pop());
                }
            }

            @Override
            public String toString() {
                return "StackQueue{" +
                        stackRight +
                        '}';
            }





            
        }
}
