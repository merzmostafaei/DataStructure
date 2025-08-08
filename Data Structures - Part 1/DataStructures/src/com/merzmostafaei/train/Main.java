package com.merzmostafaei.train;

import com.merzmostafaei.train.linkedList.LinkedList;

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
        list.printList();

        list.deleteFirst();
        System.out.println(list.contains(5));
        System.out.println(list.indexof(10));
    }
}
