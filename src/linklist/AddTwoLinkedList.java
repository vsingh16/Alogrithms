package com.macquarie.shiner.batch.gcs.service;

/**
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 */
public class AddTwoLinkedList {

    static class LinkedList {

        private Node head;

    }

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //Time Complexity : O(l1 + l2)
    public static LinkedList add(LinkedList l1, LinkedList l2) {

        Node h1 = l1.head, h2 = l2.head;
        LinkedList result = new LinkedList();
        int carry = 0;
        Node last = null;
        while (h1 != null | h2 != null) {
            int sum = carry;
            if (h1 != null) {
                sum = sum + h1.data;
                h1 = h1.next;
            }
            if (h2 != null) {
                sum = sum + h2.data;
                h2 = h2.next;
            }
            carry = sum / 10;
            int r = sum % 10;

            last = insertInLinkedList(result, r, last);


        }

        return result;

    }

    private static void print(LinkedList list) {

        Node current = list.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }

    /**
     * While inserting , keep update last node pointer, so that next time you dont suppose to traverse link list again to get at the end
     */
    private static Node insertInLinkedList(LinkedList l, int data, Node last) {

        Node newNode = new Node(data);

        //Empty Link list
        if (l.head == null) {
            l.head = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;

        return last;

    }

    public static void main(String[] args) {

        LinkedList l1 = createList1();
        LinkedList l2 = createList2();

        LinkedList result = add(l1, l2);

        print(result);

    }

    private static LinkedList createList1() {

        LinkedList l1 = new LinkedList();

        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(9);
        Node node4 = new Node(4);
        Node node5 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        l1.head = node1;

        return l1;
    }

    private static LinkedList createList2() {

        LinkedList l2 = new LinkedList();

        Node node1 = new Node(8);
        Node node2 = new Node(4);

        node1.next = node2;

        l2.head = node1;

        return l2;
    }
}
