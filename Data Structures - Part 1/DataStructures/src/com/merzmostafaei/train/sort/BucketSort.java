package com.merzmostafaei.train.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] array, int maxBuxketNumber){



        var i = 0;
        for (var bucket :createBucket(array,maxBuxketNumber)){
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }

    private  List<List<Integer>> createBucket(int[] array, int maxbucket) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < maxbucket; i++)
            buckets.add(new ArrayList<>());

        for(int item : array)
            buckets.get(item / maxbucket).add(item);


        return buckets;
    }
}
