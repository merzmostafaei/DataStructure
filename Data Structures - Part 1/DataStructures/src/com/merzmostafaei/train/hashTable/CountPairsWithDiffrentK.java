package com.merzmostafaei.train.hashTable;

import java.util.Arrays;
import java.util.Map;

public class CountPairsWithDiffrentK {
    public int countPairsWithDiff(int[] array, int k){
        Arrays.sort(array);
        int left = 0;
        int right = 1;
        int count = 0;
        int lenght = array.length;

        while (right < lenght){
            int diff = array[right] - array[left];
            if(diff == k){
                count++;
                right++;
                left++;
                while (right<lenght && array[right] == array[right]-1) right++;
            }
            else if (diff<k){
                right++;
            }
            else {
                left++;
                if (left == right) right++;
            }
        }
        return count;
    }
}
