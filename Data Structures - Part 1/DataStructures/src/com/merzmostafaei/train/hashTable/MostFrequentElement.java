package com.merzmostafaei.train.hashTable;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    public int mostFrequent(int[] array){
        // [1,2,2,3,3,3,4]
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : array){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int KeyMostFrequent = array[0];
        int maxCount = 0;

        for  (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                KeyMostFrequent = entry.getKey();
            }
        }
        return KeyMostFrequent;
    }
}
