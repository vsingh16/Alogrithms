package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 */
public class SortedIntersectionLinkList {


    static class LinkedList {

        private Node head;

        public LinkedList commonNodes(LinkedList l1, LinkedList l2) {

            Node left = l1.head;
            Node right = l2.head;

            Node last = null;
            LinkedList newLinkedList = new LinkedList();
            while (left != null && right != null) {

                if (left.data == right.data) {
                    last = insert(left.data, last, newLinkedList);
                    left = left.next;
                    right = right.next;
                } else if (left.data < right.data) {
                    left = left.next;
                } else {
                    right = right.next;
                }
            }

            return newLinkedList;
        }

        private Node insert(int data, Node last, LinkedList newLinkedList) {

            Node newNode = new Node(data);
            //link list is empty
            if (last == null) {
                newLinkedList.head = newNode;
            } else {
                last.setNext(newNode);
            }

            return newNode;
        }

    }

    static class Node {

        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

        LinkedList  list = new LinkedList();

        LinkedList newLinkedList = list.commonNodes(get1(),get2());

        //print
        Node node = newLinkedList.head;
        while(node!=null){
            System.out.println(node.getData());
            node = node.getNext();
        }

    }

    private static LinkedList get1() {

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(6);

        linkedList.head = node1;
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        return linkedList;
    }

    private static LinkedList get2() {

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(8);

        linkedList.head = node1;
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        return linkedList;
    }


}
