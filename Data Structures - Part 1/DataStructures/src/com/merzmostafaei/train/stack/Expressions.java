package com.merzmostafaei.train.stack;

import java.util.Map;
import java.util.Stack;

public class Expressions {

    public void isBalanced(String input) {

        var expressions = Map.of(
                ']', '[',
                '}', '{',
                '>', '<',
                ')', '('
        );

        var stack = new Stack<Character>();

        for (char ch : input.toCharArray()) {
            if (expressions.containsValue(ch)) {
                stack.push(ch);
            } else if (expressions.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != expressions.get(ch)) {
                    System.out.println("notBalanced");
                    return;
                }
            }
        }

        if (stack.isEmpty())
            System.out.println("Balanced");
        else
            System.out.println("notBalanced");
    }
}
