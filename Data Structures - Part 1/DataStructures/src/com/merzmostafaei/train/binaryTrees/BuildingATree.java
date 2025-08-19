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



}
