package com.merzmostafaei.train.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NonRepeationCharacter {

    public char getSting(String phrase) {


        Map<Character, Integer> map = new HashMap<>();

        var chars = phrase.toCharArray();
        for (char c : chars) {
            var count = map.containsKey(c) ? map.get(c): 0;
            map.put(c ,count+1);

            System.out.println(map);

        }
        var array = new ArrayList<>();
        for (char c : chars) {
            if (map.get(c) == 1) {
                array.add(c);
            }
        }
        if(array.isEmpty()){System.out.println("No non-repetation");}
        else {
            System.out.println("non-repetition characters = " + array);
        }

        return Character.MIN_VALUE;
    }
}



