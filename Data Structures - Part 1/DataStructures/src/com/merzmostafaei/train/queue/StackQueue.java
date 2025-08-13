package com.merzmostafaei.train.queue;

import java.util.Stack;

public class StackQueue {
    Stack<Integer> stackLeft = new Stack<>();   // in-stack
    Stack<Integer> stackRight = new Stack<>();  // out-stack

    // Enqueue: just push to in-stack
    public void enqueue(int element) {
        stackLeft.push(element);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        moveLeftToRightIfNeeded();  // in -> out
        return stackRight.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        moveLeftToRightIfNeeded();  // in -> out
        return stackRight.peek();
    }

    private boolean isEmpty() {
        return stackLeft.isEmpty() && stackRight.isEmpty();
    }

    // Move only when out-stack is empty
    private void moveLeftToRightIfNeeded() {
        if (stackRight.isEmpty()) {
            while (!stackLeft.isEmpty()) {
                stackRight.push(stackLeft.pop());
            }
        }
    }

    @Override
    public String toString() {
        return "StackQueue{in=" + stackLeft + ", out=" + stackRight + "}";
    }
}