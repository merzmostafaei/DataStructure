package com.merzmostafaei.train.StringManipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringManipulation {


    public static int FindTheNumberOfVowels(String string){
        Character[] array = {'A', 'E', 'O', 'U', 'I'};
        int count = 0;

        for(char i : string.toUpperCase().toCharArray()){
            for(var item : array)
                if(i == item)
                    count++;
        }
        return count;
    }

    public static String ReverseAString(String string){
        Stack<Character> stack = new Stack<>();
        var stringNew = new StringBuilder();

        for (var item : string.toCharArray())
            stack.push(item);

        while (!stack.isEmpty())
            stringNew.append(stack.pop());

        return stringNew.toString();
    }

    public static String ReverseTheOrderOfWords(String string){
        Stack<String> stack = new Stack<>();
        var stringNew = new StringBuilder();

        for (var item : string.split("\\s+"))
            stack.push(item);

        while (!stack.isEmpty()) {
            stringNew.append(stack.pop());
            if (!stack.isEmpty())
                stringNew.append(" "); // add space between words
        }

        return stringNew.toString();
    }
}
