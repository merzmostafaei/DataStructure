package com.merzmostafaei.train.sort;

import java.util.Arrays;

public class SelectionSort {
    //find the min
    //set the first element with min
    // now min is in sorted part
    // loop for unsortedPart

    public void sort(int[] array){

        for (int i = 0; i < array.length-1; i++){
            var minIndex = i;
            // Find Unsorted Array
            for (int j = i +1 ; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }

            }
            swapper(array,i,minIndex);

        }
        System.out.println(Arrays.toString(array));

    }

    private static void swapper(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2]= temp;
    }

}
