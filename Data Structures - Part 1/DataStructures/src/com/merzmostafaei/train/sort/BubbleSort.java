package com.merzmostafaei.train.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {


    public void sort(int[] arrayList){
        var length = arrayList.length;

        for(int time= 0 ; time < length - 1; time++){
                for(int swap = 0; swap < length - time -1; swap++){
                    if(arrayList[swap] > arrayList[swap +  1]){
                        System.out.println("   -> Swap needed!");
                        var temp = arrayList[swap];
                        arrayList[swap] = arrayList[swap + 1];
                        arrayList[swap + 1] = temp;
                    }else {
                        System.out.println("   -> No swap.");
                    }
                }

        }
        System.out.println("Sorted" + Arrays.toString(arrayList));
    }
}
