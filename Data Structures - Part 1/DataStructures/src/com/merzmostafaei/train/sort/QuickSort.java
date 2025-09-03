package com.merzmostafaei.train.sort;

public class QuickSort {
    public void sort(int[]array){
        sort(array,0,array.length-1);
    }
    private void sort(int[] array, int start, int end){
        //partitioning
        //sort left
        //sort right
        if(start >= end)return;
        var boundry = partitioning(array,start,end);
        sort(array,start,boundry-1);
        sort(array,boundry + 1,end);



    }
    private int partitioning(int[] array,int start,int end){
        var pivot = array[end];
        var boundary = start - 1;

        for(int i = start ; i < end ; i++){
            if(array[i] <= pivot)
                swap(array, i , ++boundary);
        }
        swap(array, ++boundary, end);
        return boundary;
    }
    private void swap(int[] array, int i, int b){
        var tempt = array[i];
        array[i] = array[b];
        array[b] = tempt;
    }
}
