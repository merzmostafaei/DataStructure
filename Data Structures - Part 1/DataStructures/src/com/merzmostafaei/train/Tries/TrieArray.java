package com.merzmostafaei.train.Tries;

public class TrieArray {
    private class Node{
        public int Alphabet = 26;
        char value;
        Node[] children = new Node[Alphabet];
        boolean isEndOfWord;


        public Node(char value) {
            this.value = value;
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
        for (char w : word.toLowerCase().toCharArray()){
            int index = w -'a';
            if (current.children[index] == null) {
                current.children[index] = new Node(w);
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
}

