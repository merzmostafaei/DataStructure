package com.merzmostafaei.train.hashTable;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTableChainingArray {

    private LinkedList<Entry>[] enteries = new LinkedList[5];


    public void put(int key, String value){

        var entry = getEntry(key);
        if(entry != null){
            entry.value = value;
            return;
        }


        getOrCreateBucket(key).addLast(new Entry(key,value));


    }

    public String get(int key){

        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;



    }
    public void remove(int key){
       var entry = getEntry(key);
       if (entry == null)
            throw new IllegalStateException();

       getBucket(key).remove(entry);


    }

    private int hash(int key){

        return key % enteries.length;
    }


    private LinkedList<Entry> getBucket(int key){
//        var index = hash(key);
//        var bucket = enteries[index];
//        return bucket;
        return enteries[hash(key)];
    }

    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if (bucket == null){return null;}

        for (var entry : bucket) {
            if (entry.key == key) {
                return entry;
            }
        }
         return null;
    }

    private LinkedList<Entry> getOrCreateBucket(int key){
        var index = hash(key);
        var bucket = enteries[index];
        if (bucket == null){
            bucket = new LinkedList<>();
            enteries[index] = bucket;
        }


        return bucket;
    }

    @Override
    public String toString() {
        return "HashTableChainingArray{" +
                "enteries=" + Arrays.toString(enteries) +
                '}';
    }

    private static class Entry {

        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(String value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }

    }
}
