package com.merzmostafaei.train.AvlTree;

public class BuildingAvlTree {
    public class AvlNode {

        int value;
        int height;

        AvlNode leftAvlNode;
        AvlNode rightAvlNode;
        public AvlNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftNode=" + leftAvlNode +
                    ", rightNode=" + rightAvlNode +
                    '}';
        }

    }

    private AvlNode root;

    private AvlNode insert(AvlNode avlNode, int value){
        if (avlNode == null)
             return new AvlNode(value);

        if (value < avlNode.value) {
            avlNode.leftAvlNode = insert(avlNode.leftAvlNode,value);
        } else if (value > avlNode.value ) {
            avlNode.rightAvlNode = insert(avlNode.rightAvlNode,value);
        }


        setHeight(avlNode);



        return balance(avlNode);
    }

    private AvlNode balance(AvlNode avlNode){

        if(isLeftHeavy(avlNode)){
            if (balanceFactor(avlNode.leftAvlNode) < 0)
                System.out.println(avlNode.leftAvlNode.value + " is LeftRotate in Balance");
                System.out.println(avlNode.value + " RightRotate in root in Balance");
                avlNode.leftAvlNode = leftRotate(avlNode.leftAvlNode);
                return rightRotate(avlNode);

        }
        else if(isRightHeavy(avlNode)){
            if(balanceFactor(avlNode.rightAvlNode) > 0)
                System.out.println(avlNode.rightAvlNode.value + " is RightRotate in Balance");
                System.out.println(avlNode.value + " leftRotate in root in Balance");
                avlNode.rightAvlNode = rightRotate(avlNode.rightAvlNode);
                return leftRotate(avlNode);
        }
        return avlNode;

    }

    private int balanceFactor(AvlNode node){
        return (node == null) ? 0 : height(node.leftAvlNode)- height(node.rightAvlNode);
    }

    private boolean isLeftHeavy(AvlNode node){
        return balanceFactor(node) > 1;

    }
    private boolean isRightHeavy(AvlNode node){
        return balanceFactor(node) < -1;

    }
    private AvlNode rightRotate(AvlNode node){
        if (node == null || node.leftAvlNode == null) return node;

       var newNode = node.leftAvlNode;
       var rightChildNewNode = (newNode.rightAvlNode != null) ? newNode.rightAvlNode : null;
       node.leftAvlNode = rightChildNewNode;
       newNode.rightAvlNode = node;

       setHeight(node);
       setHeight(newNode);


        System.out.println("leftRotate at " + node.value + " -> new root " + newNode.value);
        return newNode;
    }
    private AvlNode leftRotate(AvlNode node){
        if (node == null || node.rightAvlNode == null) return node;

        var newNode = node.rightAvlNode;
        var leftChildNewNode = (newNode.leftAvlNode!= null) ? newNode.leftAvlNode : null;
        node.rightAvlNode = leftChildNewNode;
        newNode.leftAvlNode = node;

        setHeight(node);
        setHeight(newNode);

        System.out.println("leftRotate at " + node.value + " -> new root " + newNode.value);System.out.println("leftRotate " + node.value);
        return newNode;
    }

    private void setHeight(AvlNode node){
        node.height = Math.max(
                height(node.leftAvlNode)
                ,height(node.rightAvlNode))+1;
    }



    public void insert(int value){
        root = insert(root,value);
    }

    private int height(AvlNode node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeaf(AvlNode node){
        return node != null && node.leftAvlNode == null && node.rightAvlNode == null;
    }



}
