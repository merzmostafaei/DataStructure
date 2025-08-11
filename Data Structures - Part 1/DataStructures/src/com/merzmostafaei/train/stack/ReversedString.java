package com.merzmostafaei.train.stack;

import java.util.Stack;

public class ReversedString {

    public String ReversedString(String input){

        if (input == null)
            throw new IllegalArgumentException();

        var bocket = new Stack<Character>();
        input.chars()
                .mapToObj(c-> (char)c)
                .forEach(bocket::push);

        StringBuffer reversedString = new StringBuffer();
        while (!bocket.isEmpty()){

            reversedString.append(bocket.pop());
        }
        return reversedString.toString();
    }
}
