package com.merzmostafaei.train.heap;

public class MaxHeap {
    public static void heapfy(int[] array){
        var lastParent = array.length / 2 -1;
        for (var i = lastParent ; i >= 0; i-- ){
           heapfy(array,i);
        }
        
    }
    private static void heapfy(int[] array, int index){
        int largeIndex = index;
        if (array[index] < array[largeIndex]){
            index = largeIndex;
        }

        var rightChildIndex = 2 * index + 1 ;
        if ( rightChildIndex < array.length && array[largeIndex] < array[rightChildIndex]){
            largeIndex = rightChildIndex;
        }

        var leftChildIndex = 2 * index + 2 ;
        if (leftChildIndex < array.length && array[largeIndex] < array[leftChildIndex]){
            largeIndex = leftChildIndex;
        }

        if (index == largeIndex)
            return;

        swap(array,index,largeIndex);
        heapfy(array,largeIndex);

    }

    private static void swap(int[] array,int index,int largeIndex){
        var temp = array[index];
        array[index] = array[largeIndex];
        array[largeIndex] = temp;
    }

}
