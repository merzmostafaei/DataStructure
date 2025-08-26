package com.merzmostafaei.train.Tries;

import java.util.HashMap;

public class TrieHashMap {
    private class Node{
        private char value;
        private HashMap<Character,Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }
        public void addChild(char ch){
            children.put(ch,new Node(ch));
        }
        public Node getChild(char ch){
            return children.get(ch);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
    private Node root = new Node(' ');
    public void insert(String word){
        var current = root;
        for(var ch : word.toLowerCase().toCharArray()){
            if (!current.hasChild(ch)){
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

}
