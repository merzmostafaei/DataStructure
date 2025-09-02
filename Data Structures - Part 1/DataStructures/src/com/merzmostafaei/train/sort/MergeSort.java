package com.merzmostafaei.train.sort;

public class MergeSort {

    public void sort(int[] array){
        // base Condition
        if (array.length <2)return;

        //divided array to half
        var indexMiddle = array.length /2 ;
        int[] left = new int[indexMiddle];

        for(int i = 0 ; i < indexMiddle ; i++){
            left[i] = array[i];
        }

        int[] right = new int[array.length-indexMiddle];
        for(int j = indexMiddle ; j < array.length ; j++){
            right[j - indexMiddle] = array[j];
        }

        //sort each half
        sort(left);
        sort(right);

        // merge the result
        merge(left,right,array);

    }
    private void merge(int[] left,int[] right, int[] result){
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }


}
