package com.merzmostafaei.train.queue;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class ReversingAQueue {
    Stack<Integer> stack =new Stack<>();


    public String reverse1(Queue<Integer> queue){
        int[] array = new int[queue.size()];
        int index = 0;
        for(int i : queue){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            array[index++] = stack.pop();
        }
        return Arrays.toString(array);


    }
    public Queue<Integer> reverse2(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Move all queue elements to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Step 2: Push them back into queue (reversed order)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }




}
