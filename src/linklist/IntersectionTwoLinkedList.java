package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vishal on 09-Jul-18.
 */
public class IntersectionTwoLinkedList {

    static class LinkedList {

        private Node head;

    }

    static class Node {

        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    //Method 1:

    /**
     * Traverse Linked List and mark visited node
     * Again traverse second list, if u find any node which is already visisted
     * that is the intersection
     */
    public static Integer findIntersection(LinkedList l1, LinkedList l2) {

        Node n1 = l1.head;
        Set<Integer> visitedNodes = new HashSet<>();
        while (n1 != null) {
            visitedNodes.add(n1.data);
            n1 = n1.next;
        }

        Node n2 = l2.head;
        while (n2 != null) {
            if (visitedNodes.contains(n2.data)) {
                return n2.data;
            }
            visitedNodes.add(n2.data);
            n2 = n2.next;
        }

        return -1;
    }

    /**
     * Traverse Linked List and mark visited node
     * Again traverse second list, if u find any node which is already visisted
     * that is the intersection
     */
    public static Integer findIntersectionByDistance(LinkedList l1, LinkedList l2) {

        Node n1 = l1.head;
        int length1 = 0;
        while (n1 != null) {
            length1++;
            n1 = n1.next;
        }

        Node n2 = l2.head;
        int length2 = 0;
        while (n2 != null) {
            length2++;
            n2 = n2.next;
        }

        int diff = Math.abs(length1 - length2);
        n1 = l1.head;
        n2 = l2.head;
        if (length1 > length2) {
            for (int i = 0; i < diff; i++) {
                n1 = n1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                n2 = n2.next;
            }
        }

        while (n1 != null && n2 != null) {
            if (n1.data == n2.data) {
                return n1.data;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return -1;
    }

    public static void main(String[] args) {

        LinkedList l1 = createList1();
        LinkedList l2 = createList2();

        System.out.println(findIntersection(l1, l2));
        System.out.println(findIntersectionByDistance(l1, l2));
    }

    private static LinkedList createList1() {

        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(9);
        Node node4 = new Node(15);
        Node node5 = new Node(30);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LinkedList l1 = new LinkedList();
        l1.head = node1;

        return l1;
    }

    private static LinkedList createList2() {

        Node node1 = new Node(10);
        Node node2 = new Node(15);
        Node node3 = new Node(30);

        node1.next = node2;
        node2.next = node3;

        LinkedList l1 = new LinkedList();
        l1.head = node1;

        return l1;
    }
}
