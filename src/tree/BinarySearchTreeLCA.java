package com.macquarie.shiner.batch.gcs.service;

/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
public class BinarySearchTreeLCA {

    static class Tree {
        private Node root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    //Time Complexity:O(n) as we traverse whole tree once

    /**
     * In case of Binary tree complexity is O(n) and we need two traversal one for n1 and other for n2
     * Here Time Complexity is O(log n) and we need only Single traversal
     */
    public static int findLCA(Node node, int n1, int n2) {

        if (node == null) {
            return -1;
        }

        //if n1 and n2 both are smaller than node then LCA will be in left
        if (n1 < node.data && n2 < node.data) {
            return findLCA(node.left, n1, n2);
        }

        //if n1 and n2 both are greater than node then LCA will be in right
        if (n1 > node.data && n2 > node.data) {
            return findLCA(node.right, n1, n2);
        }

        //if none of above is true it means n1 is on left side and n2 is on right side, so current node is LCA
        return node.data;
    }


    public static Tree createTree1() {

        Node node1 = new Node(20);
        Node node2 = new Node(8);
        Node node3 = new Node(22);
        Node node4 = new Node(4);
        Node node5 = new Node(12);
        Node node6 = new Node(10);
        Node node7 = new Node(14);

        Tree t = new Tree();
        t.root = node1;

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node5.left = node6;
        node5.right = node7;

        return t;
    }

    public static void main(String[] args) {

        Tree t1 = createTree1();
        System.out.println(findLCA(t1.root, 10, 14));
        System.out.println(findLCA(t1.root, 14, 8));
        System.out.println(findLCA(t1.root, 10, 22));
    }
}


