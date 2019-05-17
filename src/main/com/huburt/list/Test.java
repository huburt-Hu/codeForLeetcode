package main.com.huburt.list;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(-1,0);
        System.out.println(list.get(0));
        list.addAtTail(1);
        list.deleteAtIndex(0);
        list.deleteAtIndex(1);

        list.addAtTail(2);
        list.addAtHead(3);
        System.out.println(list);
        System.out.println(list.get(2));
    }
}
