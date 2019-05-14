package main.com.huburt.list;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtHead(3);
        list.addAtIndex(0,4);
        list.addAtIndex(2, 5);
        list.deleteAtIndex(2);
        System.out.println(list);
    }
}
