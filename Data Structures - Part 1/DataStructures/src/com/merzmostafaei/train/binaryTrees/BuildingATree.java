package com.merzmostafaei.train.binaryTrees;

import com.sun.source.tree.Tree;

public class BuildingATree {
    public class Node{

        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;

        }


        public int getValue() {
            return value;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    private Node root;

    public void insert(int value){
        var node = new Node(value);

       if (root == null){
           root = node;
           return;
       }
       Node current = root;
       while (true){
           if (value < current.value){
               if(current.leftChild == null){
                   current.leftChild = node;
                   break;
               }
               current = current.leftChild;

           } else if (value > current.value) {
               if (current.rightChild ==null){
                   current.rightChild = node;
                   break;
               }
               current = current.rightChild;
           }
           else {
               return;
           }
       }

    }

    public boolean find(int value){
        Node current = root;
        while (current != null){
            if (value == current.value) return true;
            current = (value < current.value)? current.leftChild: current.rightChild;
        }
        return false;
    }

    private void traversePreOrder(Node root){
        if(root == null) return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traverseInOrder(Node root){
        if(root == null) return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }
    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traversePosOrder(Node root){
        if(root == null) return;

        traversePosOrder(root.leftChild);
        traversePosOrder(root.rightChild);
        System.out.println(root.value);
    }
    public void traversePosOrder(){
        traversePosOrder(root);
    }

    private int hight(Node root){
        if (root == null) return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(hight(root.leftChild),hight(root.rightChild));
    }
    public int hight(){
        return hight(root);
    }
    private boolean isLeaf(Node root){
        return root.leftChild == null && root.rightChild == null;
    }

    private int min(Node root){
        if (isLeaf(root)) return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(Math.min(left,right),root.value);
    }

    public int min() {
        return min(root);
    }

    private int minSearchBinaryTree(Node root){
        if(root==null) throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public int minSearchBinaryTree(){
        return minSearchBinaryTree(root);
    }

    public boolean isEqual (BuildingATree other){
        if (other == null) return false;

        return isEqual(root,other.root);
    }

    private boolean isEqual(Node root1, Node root2){
        if (root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.value == root2.value && isEqual(root1.leftChild,root2.leftChild) && isEqual(root1.rightChild,root2.rightChild);
    }



}
