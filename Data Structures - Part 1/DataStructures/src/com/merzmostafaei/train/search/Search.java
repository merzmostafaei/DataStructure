package com.merzmostafaei.train.search;

public class Search {
    public static int LinearSearch(int[] array,int target){
        for(int i = 0 ; i < array.length ; i++){
            if (array[i] == target)
                return i;


        }  return -1;
    }

    public static int BinarySearchIterative(int[] array, int target){
        int start = 0;
        int end = array.length-1;


    while (start <= end)
    {
        int middle = start + (end - start) / 2;

        if (array[middle] == target) {
            return middle;
        }
        if (array[middle] < target) {
            start = middle + 1 ;
        } else {
            end = middle -1 ;
        }
    }
        return -1;
    }

    public static int BinarySearchrecursion(int[] array,int target){
        int start = 0;
        int end = array.length-1;
        return BinarySearchrecursion(array,start,end,target);
    }
    private static int BinarySearchrecursion(int[] array, int start, int end,int target){
        if(start > end)return -1;

        int middle = (start+end) /2;
        if (array[middle] == target) {
            return middle;
        }
        if(array[middle] > target)
            BinarySearchrecursion(array,start,middle-1,target);
        else
            BinarySearchrecursion(array,middle+1,end,target);

        return -1;
    }

    public static int Ternarysearch(int[] array,int target){

        return Ternarysearch(array,0,array.length-1 ,target);
    }
    private static int Ternarysearch(int[] array, int start, int end, int target){
        // base Condition
        if (start >= end) return -1;

        int partition = (end - start) /3 ;
        int mid1 = start +  partition;
        int mid2 =  end - partition ;


        if (array[mid1] == target)return mid1;
        if(array[mid2] == target) return  mid2;


        if (target < array[mid1]) {
            return Ternarysearch(array, start, mid1 - 1, target);
        } else if (target > array[mid2]) {
            return Ternarysearch(array, mid2 + 1, end, target);
        } else {
            return Ternarysearch(array, mid1 + 1, mid2 - 1, target);
        }

    }
}
