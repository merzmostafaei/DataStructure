package com.merzmostafaei.train.hashTable;

import java.util.LinkedList;

public class HashTableChainingArray {

    private LinkedList<Entity>[] enteries = new LinkedList[5];


    public void put(int key, String value){
        var index = hash(key);
        if (enteries[index] == null)
            enteries[index] = new LinkedList<>();

        for(var entry : enteries[index]){
            if (entry.k == key)
                entry.v = value;
            return;
        }


        enteries[index].addLast(new Entity(key,value));


    }
    private int hash(int key){
        return key % enteries.length;
    }
    public String get(int k){

        return String.valueOf(enteries.get(k));
    }

    public String remove(int k){
        return String.valueOf(enteries.remove(k));
    }


    private static class Entity{
        int k;
        String v ;

        public Entity(int k, String v) {
            this.k = k;
            this.v = v;
        }

        public void setK(int k) {
            this.k = k;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

}
