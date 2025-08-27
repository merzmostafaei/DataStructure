package com.merzmostafaei.train.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieHashMap {
    private class Node {

        private char value;

        private HashMap<Character, Node> children = new HashMap<>();

        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }
        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }
        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void removeChild(char ch){
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }



    }
    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        if (word == null || word.isEmpty()) return;
        for (var ch : word.toLowerCase().toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);

        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null || word.isEmpty())return false;

        var current = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!current.hasChild(ch)) return false;

            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }
    public void travversal(){
        travesal(root);
    }

    private Node travesal(Node root){
        //Pri-Order Traversal : rootNode First Visit

        Node charNode = root;
        System.out.println(root.value);
        for(var child : root.getChildren()){
            charNode =travesal(child);
        }
        //Pos-Order Traversal : child First Visit

        return charNode;

    }

    public void remove(String word) {

        if (word == null || word.isEmpty()) return;
        remove(root,word.toLowerCase(),0);

    }

    private void remove(Node current,String word, int index){
        if(index == word.length()){
            // mark the current node as not end of word
            current.isEndOfWord = false;
            return;
        }
        //returnCharacter
        var ch = word.charAt(index);
        var child = current.getChild(ch);
        if (child == null){
            return;
        }

        remove(child,word,index +1);
        // remove the child reference if child has no children and is NOT end of another word
        if (!child.hasChildren() && !child.isEndOfWord){
            current.removeChild(ch);
        }

    }

    public List<String> autoCompletion(String word){
        List<String> words = new ArrayList<>();
        if (word == null) return words;
        String prefix = word.toLowerCase();

        var current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.getChild(ch);
            if (current == null) return words;
        }
        autoCompletion(current, prefix, words);
        return words;
    }
    private void autoCompletion(Node node, String prefix, List<String> out){
        if (node.isEndOfWord) out.add(prefix);
        for (var child : node.getChildren()){
            autoCompletion(child, prefix + child.value, out);
        }
    }
    public boolean containsRecursive(String word) {

        return containsRecursive(root,word);


    }
    private boolean containsRecursive(Node node, String word){
        if(node == null) return false;
        if (word.isEmpty()) return node.isEndOfWord;

        var firstChar = word.charAt(0);
        var nodeChild = node.getChild(firstChar);

        return containsRecursive(nodeChild,word.substring(1));

    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node node){
        if (node == null) return 0;
        int count = node.isEndOfWord ? 1 : 0;
        for (var child : node.getChildren()){
            count+= countWords(child);
        }
        return count;
    }

    public String longestCommonPrefix(String word1, String word2) {
        StringBuffer prefix = new StringBuffer();
        var current = root;

        int minlen = Math.min(word1.length(),word2.length());

        for (int i = 0 ; i < minlen; i++){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if(c1 != c2)break;

            current =current.getChild(c1);
            prefix.append(c1);

        }
        return prefix.toString();

    }


}
