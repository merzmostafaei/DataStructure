package com.merzmostafaei.train;

import com.merzmostafaei.train.AvlTree.BuildingAvlTree;
import com.merzmostafaei.train.binaryTrees.BuildingATree;
import com.merzmostafaei.train.hashTable.*;
import com.merzmostafaei.train.linkedList.LinkedList;

import com.merzmostafaei.train.queue.*;
import com.merzmostafaei.train.stack.Expressions;
import com.merzmostafaei.train.stack.ReversedString;
import com.merzmostafaei.train.stack.Stack;
import com.merzmostafaei.train.stack.TwoStackOneArray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        var numbers = new ArrayTry(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.removeAt(1);
        numbers.max();
        numbers.print();
        System.out.println(numbers.indexOf(100));
        System.out.println(numbers.max());

        var numbers2 = new ArrayTry(3);
        numbers2.insert(10);
        numbers2.insert(50);
        numbers2.insert(70);
        numbers2.insert(80);
        numbers2.insert(20);

        System.out.println("common Array");
        var common = numbers.intersect(numbers2);

        common.print();

        System.out.println(" reversed");
        var reversed = numbers2.reverse();
        reversed.print();


        System.out.println("insertAt");
        numbers.insertAt(15,3);
        numbers.print();

        //LinkedList

        System.out.println("LinkedList");
        LinkedList list = new LinkedList();

        list.addFirst(10);
        list.addFirst(5);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);


        list.printList();

        list.deleteFirst();
        System.out.println(list.contains(5));
        System.out.println(list.indexof(10));

        System.out.println("reverse");
        //list.reverse();
        var kth = list.getKthFromTheEnd(1);

        var array = list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(kth);

        System.out.println("printMiddle");
        list.printMiddle();

        System.out.println("hasLoop");
        list.hasLoop();

        // Stack
        System.out.println("Stack");

        var stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.min());



        //ReversingStack
        ReversedString reverser = new ReversedString();

        var local = reverser.ReversedString("abcd");
        System.out.println(local);

        // BalanceExpressions
        System.out.println("BalanceExpressions");
        var balanced = new Expressions();
        balanced.isBalanced("{");

        //  Implement two stacks in one array

        var twoStackOneArray = new TwoStackOneArray();
        twoStackOneArray.push1(10);
        twoStackOneArray.push1(20);
        twoStackOneArray.push1(30);




        twoStackOneArray.push2(10);
        twoStackOneArray.push2(20);
        twoStackOneArray.push2(30);

        System.out.println(twoStackOneArray);

        twoStackOneArray.pop1();
        twoStackOneArray.pop2();

        System.out.println(twoStackOneArray.isEmpty1());
        System.out.println(twoStackOneArray.isFull2());
        System.out.println(twoStackOneArray);


        // Revesing a Queue
        System.out.println("Revesing a Queue");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        var reversingAQueue = new ReversingAQueue();
        String reverse1 = reversingAQueue.reverse1(queue);
        Queue<Integer> reverse2 = reversingAQueue.reverse2(queue);

        System.out.println("Reversed queue" + reverse1);
        System.out.println("Reversed queue" + reverse2);


        // Implementing the Queue using Array
        System.out.println("Implementing the Queue using Array");

        var arrayQueue = new ArrayQueue(5);

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.dequeue();
        arrayQueue.enqueue(60);


        System.out.println(arrayQueue);

        System.out.println(arrayQueue.peek());

        // Implementing the StackQueue
        System.out.println("Implementing the StackQueue");

        var stackQueue =new StackQueue();

        stackQueue.enqueue(10);
        stackQueue.enqueue(20);
        stackQueue.enqueue(30);

        System.out.println(stackQueue);
        stackQueue.enqueue(40);
        System.out.println(stackQueue);

        stackQueue.dequeue();
        System.out.println(stackQueue);

        stackQueue.enqueue(500);
        System.out.println(stackQueue);
        stackQueue.dequeue();
        System.out.println(stackQueue);
        System.out.println(stackQueue.dequeue());

        // Implementing PriorityQueue using Array
        System.out.println("Implementing PriorityQueue using Array");

        var priorityQueue = new PriorityQueue(5);

        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(6);
        priorityQueue.add(1);
        priorityQueue.add(4);


        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.pull());

        // Implementing Reverse k Element
        System.out.println("Implementing Reverse k Element");

        Queue<Integer> q = new ArrayDeque<>();
        q.add(10); q.add(20); q.add(30); q.add(40); q.add(50);

        ReverseKelement r = new ReverseKelement();
        System.out.println(r.reverser(q, 3));

        // Implementing LinkListQueue

        LinkedListQueue queueLinkeList = new LinkedListQueue();


        queueLinkeList.enqueue(10);
        queueLinkeList.enqueue(20);
        queueLinkeList.enqueue(30);

        System.out.println(queueLinkeList.size());
        System.out.println(queueLinkeList.peek());


        queueLinkeList.dequeue();
        queueLinkeList.dequeue();
        System.out.println(queueLinkeList.size());

        // Implementing StackWithTwoQueues
        System.out.println("Implementing StackWithTwoQueues");
        StackWithTwoQueues stackWithTwoQueues = new StackWithTwoQueues();
        stackWithTwoQueues.push(10);
        stackWithTwoQueues.push(20);
        stackWithTwoQueues.push(30);
        System.out.println(stackWithTwoQueues.peek());
        System.out.println(stackWithTwoQueues.pop());
        System.out.println(stackWithTwoQueues);
        System.out.println(stackWithTwoQueues.size());


        // HashTables
        System.out.println("HashTables");
        NonRepeationCharacter f = new NonRepeationCharacter();
        f.getSting("HashTables");   // expected: H (or if you want to ignore case/space, see next example)

        FirstRepeatedCharacter f2 = new FirstRepeatedCharacter();
        var ch = f2.getString("HashTables");
        System.out.println(ch);

        System.out.println(" HashTableChaningArray ");
        var ht = new HashTableChainingArray();
        ht.put(1,"hello");
        ht.put(2,"Hello");
        ht.put(3,"HEllo");
        ht.put(2,"HeLLLo");


        System.out.println(ht.get(2));
        ht.remove(3);
        System.out.println(ht);

        // MostFrequentElement
        System.out.println("MostFrequentElement");
        var mostFrequentElement=new MostFrequentElement();

        var result = mostFrequentElement.mostFrequent(new int[]{1,2,2,3,3,3,4});
        System.out.println(result);

        // CountPairsWithDiffrentK
        System.out.println("CountPairsWithDiffrentK");
        var countPairsWithDiffrentK= new CountPairsWithDiffrentK();
        var result2 = countPairsWithDiffrentK.countPairsWithDiff(new int[]{1,7,5,9,2,12,3}, 2);
        System.out.println(result2);

        //twoSumOneTarget
        System.out.println("twoSumOneTarget");
        var  twoSumOneTarget = new twoSumOneTarget();
        twoSumOneTarget.TwoSum(new int[]{2,7,11,15},9);


        //HashMapLinearProbingStrategy
        System.out.println("HashMapLinearProbingStrategy");
        var hashMapLinearProbingStrategy=new HashMapLinearProbingStrategy();
        hashMapLinearProbingStrategy.put(1,"A");
        hashMapLinearProbingStrategy.put(10,"B");
        hashMapLinearProbingStrategy.put(15,"D");
        hashMapLinearProbingStrategy.put(16,"C");
        System.out.println(hashMapLinearProbingStrategy.get(1));
        System.out.println(hashMapLinearProbingStrategy.size());
        hashMapLinearProbingStrategy.remove(10);
        System.out.println(hashMapLinearProbingStrategy.size());


        // Building A Tree
        System.out.println("Building A Tree");

        BuildingATree buildingATree = new BuildingATree();
        buildingATree.insert(7);
        buildingATree.insert(4);
        buildingATree.insert(9);
        buildingATree.insert(1);
        buildingATree.insert(6);
        buildingATree.insert(8);
        buildingATree.insert(10);
        System.out.println(buildingATree.find(10));


        // Traversal - PreOrder
        System.out.println("Traversal-PreOrder");
        buildingATree.traversePreOrder();
        System.out.println("traverseInOrder");
        buildingATree.traverseInOrder();
        System.out.println("traversePosOrder");
        buildingATree.traversePosOrder();

        // hight-root
        System.out.println("hight-root");
        System.out.println(buildingATree.hight());

        // for BinaryTree
        // min-root    O(n)
        System.out.println("min-root");
        System.out.println(buildingATree.min());

        // for BinareySearchTree
        // minSearchBinaryTree  O(Log n)
        System.out.println("minSearchBinaryTree");
        buildingATree.minSearchBinaryTree();


        // is-Equal
        System.out.println("isEqual");
        BuildingATree buildingATree2 = new BuildingATree();
        buildingATree2.insert(7);
        buildingATree2.insert(4);
        buildingATree2.insert(9);
        buildingATree2.insert(1);
        buildingATree2.insert(6);
        buildingATree2.insert(8);


        System.out.println(buildingATree.isEqual(buildingATree2));


        // Validating Binary Search Trees -> mean the Tree is binarySearchTree or not.
        System.out.println("isBinarySearchTree");
        System.out.println(buildingATree.isBinarySearchTree());

        // Node in K distance
        System.out.println("Node in K distance");
        System.out.println( buildingATree.getNodesAtDistance(1));

        // TraveseLevelOrder
        System.out.println("TraveseLevelOrder");
        buildingATree.traverseLevelOrder();

        // Tree.size
        System.out.println("TreeSize");
        System.out.println(buildingATree.size());

        // Count - leaves -> node with no children

        System.out.println("Count - leaves");
        System.out.println(buildingATree.countLeaves());
        System.out.println(buildingATree.countLeaves().size());

        // Contains value use Recursion - in find() we used iteration method.
        System.out.println("Contains value use Recursion");
        System.out.println(buildingATree.contains(7));

        // Tree,Max
        System.out.println("Tree,Max");
        System.out.println(buildingATree.max());

        // find Node
        System.out.println("find Node");
        System.out.println(buildingATree.findNode(4));

        // areSibling
        System.out.println("areSibling");
        System.out.println(buildingATree.areSibling(4,9));

        // getAncestors
        System.out.println("getAncestors");
        System.out.println(buildingATree.getAncestors(1));

        // AVL Tree
        System.out.println("AVL Tree");
        var avlTree = new BuildingAvlTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        System.out.println("done");

        



















    }
}
