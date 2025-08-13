package com.merzmostafaei.train.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKelement {



    public Queue<Integer> reverser(Queue<Integer> queue, int k ){
        if (queue.isEmpty())
            throw new IllegalArgumentException("Empty Queue");
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException(" must 0 <= k <= size of Queue");
        if (k == 0)
            return queue;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k ; i++){
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        int rotate = queue.size() -k ;
        for (int i = 0; i <rotate ; i++){
            queue.add(queue.remove());
        }
        return queue;

    }
}
