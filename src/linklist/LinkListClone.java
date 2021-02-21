package com.macquarie.shiner.batch.gcs.service;


import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 
 We can optimise this further and solev this without extra space.
 https://github.com/vsingh16/Alogrithms/blob/master/src/linklist/CloneLinkedList.java
 */
public class LinkListClone {

    static class LinkList {

        private Node head;
    }

    static class Node {
        private int data;
        private Node next;
        private Node random;

        Node(int data) {
            this.data = data;
        }
    }

    public static LinkList clone(LinkList l1) {

        LinkList clonedList = new LinkList();

        //Traverse original link list and create map of original and clone nodes
        Node current = l1.head;
        Map<Node, Node> map = new HashMap<>();
        while (current != null) {
            Node clone = new Node(current.data);
            map.put(current, clone);
            current = current.next;
        }

        current = l1.head;
        while (current != null) {
            Node clone = map.get(current);
            clone.next = map.get(current.next);
            clone.random = map.get(current.random);
            if (clonedList.head == null) {
                clonedList.head = clone;
            }
            current = current.next;
        }

        return clonedList;
    }

    private static void print(LinkList list) {

        Node current = list.head;
        while (current != null) {
            System.out.println(current.data + " " + ((current.next != null) ? current.next.data : null) + " " + current.random.data);
            current = current.next;
        }

    }

    public static void main(String[] args) {
        LinkList l1 = createList1();
        print(l1);
        System.out.println("Printing Cloned Copy");
        LinkList l2 = clone(l1);
        print(l2);
    }

    private static LinkList createList1() {

        LinkList l1 = new LinkList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node2;

        l1.head = node1;

        return l1;
    }
}
