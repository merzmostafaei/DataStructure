package com.merzmostafaei.train.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {


    public void sort(int[] arrayList){
        var length = arrayList.length;
        boolean isSorted;

        for(int time= 0 ; time < length ; time++){
            isSorted = true;
                for(int swap = 1; swap < length - time ; swap++){
                    if(arrayList[swap] < arrayList[swap -  1]){
                        System.out.println("   -> Swap needed!");
                        swapper(arrayList, swap);
                        isSorted = false;
                    }else {
                        System.out.println("   -> No swap.");
                    }
                    if (isSorted)
                        System.out.println("Sorted" + Arrays.toString(arrayList));
                }


        }
    }

    private static void swapper(int[] arrayList, int swap) {
        var temp = arrayList[swap];
        arrayList[swap] = arrayList[swap - 1];
        arrayList[swap - 1] = temp;
    }
}
