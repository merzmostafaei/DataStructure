package com.merzmostafaei.train.hashTable;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithDiffrentK {

    // Counts unique pairs {x, y} such that |x - y| = k
    public int countPairsWithDiff(int[] array, int k) {
        if (array == null || array.length == 0 || k < 0) return 0;

        // Build frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : array) {
            freq.merge(n, 1, Integer::sum);
        }

        int count = 0;

        if (k == 0) {
            // Pairs like (x, x) exist only when x appears at least twice
            for (int f : freq.values()) {
                if (f > 1) count++;
            }
        } else {
            // For each distinct x, check if x + k exists -> counts each unordered pair once
            for (int x : freq.keySet()) {
                if (freq.containsKey(x + k)) count++;
            }
        }

        return count;
    }
}
