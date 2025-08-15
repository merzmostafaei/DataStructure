package com.merzmostafaei.train.hashTable;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedCharacter {
    public char getString(String character){
        Set<Character> set = new HashSet<>();
        for (var ch : character.toCharArray()){
            if(set.contains(ch)){return ch; }

            set.add(ch);

        }
        return Character.MIN_VALUE;
    }

    }

