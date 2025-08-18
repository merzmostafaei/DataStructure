package com.merzmostafaei.train.hashTable;

import java.util.*;

public class twoSumOneTarget {
    public void TwoSum(int[] array,int target){
        HashMap<Integer,Integer> map = new HashMap();


        for (int i = 0; i < array.length; i++){
            map.put(array[i],i);
        }
        for(int i = 0 ; i < array.length; i++) {
            int x = array[i];
            int y = target-x;
            if (map.containsKey(y)) {

                System.out.println(i + "," + map.get(y));
                map.remove(x);
                map.remove(y);

            }
        }

    }
}
