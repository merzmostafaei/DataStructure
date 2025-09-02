package com.merzmostafaei.train.sort;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] array){
        // first: item supose is in correct position
        // second: count j from last index

        for(int i = 1; i < array.length; i++){
            var current = array[i];
            var j = i-1;
            while (j >= 0 && array[j] > current){
                array[j+1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }

    }
}
