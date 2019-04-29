package com.macquarie.shiner.batch.gcs.service;

/**
 * https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 *
 * Here we will read linked list straight
 *
 * Time Complexity : O(l1+l2)
 */
public class AddTwoLinkedListStraight {

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

    private static int getLength(LinkedList linkedList) {

        Node current = linkedList.head;
        int counter = 0;
        while (current != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

    public static LinkedList add(LinkedList l1, LinkedList l2) {

        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if (length1 > length2) {
            //add zeros to list2
            int diff = length1 - length2;
            for (int i = 0; i < diff; i++) {
                insert(l2, 0);
            }
        } else {
            //add zeros to list1
            int diff = length2 - length1;
            for (int i = 0; i < diff; i++) {
                insert(l1, 0);
            }
        }

        LinkedList result = new LinkedList();
        int carry = addEqualSize(l1.head, l2.head, result);
        if (carry > 0) {
            insert(result, carry);
        }

        return result;
    }

    private static void printList(LinkedList result) {

        Node current = result.head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
    }

    public static int addEqualSize(Node n, Node m, LinkedList result) {

        if (n == null) {
            return 0;
        }

        int carry = addEqualSize(n.next, m.next, result);

        int sum = n.data + m.data + carry;
        carry = sum / 10;
        int r = sum % 10;
        insert(result, r);

        return carry;
    }

    private static void insert(LinkedList result, int data) {

        Node newNode = new Node(data);
        //list is empty
        if (result.head == null) {
            result.head = newNode;
            return;
        }

        Node current = result.head;
        result.head = newNode;
        newNode.next = current;

    }

    public static void main(String[] args) {

        LinkedList l1 = createList1();
        LinkedList l2 = createList2();

        LinkedList result = add(l1, l2);

        printList(result);

    }

    private static LinkedList createList1() {

        LinkedList l1 = new LinkedList();

        Node node1 = new Node(9);
        Node node2 = new Node(9);
        Node node3 = new Node(9);

        node1.next = node2;
        node2.next = node3;

        l1.head = node1;

        return l1;
    }

    private static LinkedList createList2() {

        LinkedList l2 = new LinkedList();

        Node node1 = new Node(1);
        Node node2 = new Node(8);

        node1.next = node2;

        l2.head = node1;

        return l2;
    }
}
