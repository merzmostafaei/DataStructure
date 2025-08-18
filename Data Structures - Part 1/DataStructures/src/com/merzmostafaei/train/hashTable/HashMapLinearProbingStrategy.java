package com.merzmostafaei.train.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class HashMapLinearProbingStrategy {

    private class Entry{
        int key;

        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    Entry[] entries = new Entry[5];

    int count = 0;
    public void put(int key, String value){
        var entry = getEntry(key);
        if (entry != null){
            entry.value = value;
            return;
        }
        if(isFull())
            throw new IllegalStateException();

        entries[getIndex(key)] = new Entry(key,value);
        count++;

    }

    public String get(int key){
        var entry = getEntry(key);
        return entry != null ? entry.value : null;

    }

    public void remove(int key){
        var index = getIndex(key);
        if( index == -1 || entries[index] == null)
            return;
        entries[index] = null;
        count --;
    }

    public int size(){return count;}

    private Entry getEntry(int key){
        var index = getIndex(key);
        return index >=0 ? entries[index] : null;
    }

    private int getIndex(int key){
        int step = 0;
        while (step < entries.length){
            int index = index(key,step++);
            var entry = entries[index];
            if (entry == null || entry.key == key)
                return index;
        }
        return -1;
    }


    private int index(int key, int i){
        return (hash(key)+i) % entries.length;
    }

    private int hash(int key){
        return key % entries.length;
    }

    private boolean isFull(){
        return count == entries.length;
    }
    @Override
    public String toString() {
        return "HashMapLinearProbingStrategy{" +
                "entries=" + Arrays.toString(entries) +
                '}';
    }
}
