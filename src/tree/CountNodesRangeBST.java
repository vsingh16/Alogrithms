package com.macquarie.shiner.batch.gcs.service;


/**
 * Get count of nodes falling in given range in BST
 * <p>
 * https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
 */
public class CountNodesRangeBST {

    private Node root;

    static class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    //Time Complexity: In worst case where all nodes are in range O(n)
    //O(log n) : height of tree
    public int getCount(Node root, int l, int h) {

        if (root == null) {
            return 0;
        } else if (root.data >= l && root.data <= h) { //if lies in range, need to check both side
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        } else if (h > root.data) { // if max range value is greate than node, then values falling in range will be at right side
            return getCount(root.right, l, h);
        } else {
            return getCount(root.left, l, h);
        }


    }

    public static void main(String[] args) {

        CountNodesRangeBST tree = new CountNodesRangeBST();
        tree.root = buildTree();
        System.out.println(tree.getCount(tree.root, 5, 45));
    }

    private static Node buildTree() {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(50);
        Node node4 = new Node(1);
        Node node5 = new Node(40);
        Node node6 = new Node(100);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;
        return node1;
    }

}
