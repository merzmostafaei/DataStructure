package com.merzmostafaei.train.binaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildingATree {
    public class Node {

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

    private boolean isBinarySearchTree(Node node, int min, int max){
        if(node == null)return true;
        if(node.value < min || node.value > max) return false;

        return isBinarySearchTree(node.leftChild,min,node.value -1) && isBinarySearchTree(node.rightChild,node.value+1,max);

    }
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, java.lang.Integer.MIN_VALUE, java.lang.Integer.MAX_VALUE);
    }

    public ArrayList<java.lang.Integer> getNodesAtDistance(int distance){
        var list = new ArrayList<java.lang.Integer>();
        getNodesAtDistance(root,distance,list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<java.lang.Integer> list){
       if(root == null)return;

       if(distance == 0){
           list.add(root.value);
           return;
       }
       getNodesAtDistance(root.leftChild,distance-1,list);
       getNodesAtDistance(root.rightChild,distance-1,list);
    }

    public void traverseLevelOrder(){
        for (var i = 0; i<= hight(); i++){
            var list = getNodesAtDistance(i);
            for( var value: list) System.out.println(value);
        }
    }

    private int size(Node node){
        if (node == null){
            return 0;
        }
        if (isLeaf(node))
            return 1;

        return 1 + size(node.rightChild) + size(node.leftChild);


    }
    public int size(){
        return size(root);
    }

    private ArrayList<Integer> countLeaves(Node node){
        var list = new ArrayList<Integer>();
        if (node == null)return list;

        if(isLeaf(node)){
            list.add(node.value);

        }else{
            list.addAll(countLeaves(node.leftChild));
            list.addAll(countLeaves(node.rightChild));
        }

            return list;
    }

    public ArrayList<Integer> countLeaves(){
        return countLeaves(root);
    }

    private boolean contains(Node node, int value){
        if (node == null)return false;
        if(node.value == value)return true;

        return contains(node.leftChild,value) || contains(node.rightChild,value);
    }

    public boolean contains(int value){
        return contains(root,value);
    }

    private int max(Node node){
        if(isLeaf(node))return node.value;
        var left = max(node.leftChild);
        var right= max(node.rightChild);

        return Math.max(Math.max(left,right),node.value);

    }

    public int max(){
        return max(root);
    }

    private boolean areSibling(Node root,Node node1, Node node2){
       if(root == null)return false;

       if (root.leftChild == node1 && root.rightChild == node2) return true;
       if(root.rightChild == node1 && root.leftChild == node2) return true;

       return areSibling(root.leftChild,node1,node2) || areSibling(root.rightChild,node1,node2);
    }

    public boolean areSibling(int value1, int value2){
        Node node1 = findNode(value1);
        Node node2 = findNode(value2);
        if (node1 == null || node2 == null)return false;

        return areSibling(root,node1,node2);
    }

    private Node findNode(Node root,int value){
        if(root == null)return null;
        if(root.value == value) return root;

        var left = findNode(root.leftChild,value);
        if (left != null) return left;

        return findNode(root.rightChild,value);

    }
    public Node findNode(int value){
        return findNode(root,value);
    }

    private boolean getAncestors(Node root, int value, List<Integer> ancestors){
        if (root == null)return false;

        if (root.value == value)return true;

        if(getAncestors(root.leftChild,value,ancestors) || getAncestors(root.rightChild,value,ancestors)){
            ancestors.add(root.value);
            return true;
        }

        return false;





    }

    public List<Integer> getAncestors(int value){
        var ancestores = new ArrayList<Integer>();
        getAncestors(root,value,ancestores);
        return ancestores;
    }

}
