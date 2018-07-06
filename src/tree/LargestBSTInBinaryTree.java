package com.macquarie.shiner.batch.gcs.service;

/**
 * https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 */
public class LargestBSTInBinaryTree {

    private Node root;

    static class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }


    }

    static class MinMax {

        private int size;
        private int lmax;
        private int rmin;
        private Boolean isBST;

        public MinMax() {
            isBST = Boolean.TRUE;
            size = 0;
            rmin = Integer.MAX_VALUE;
            lmax = Integer.MIN_VALUE;
        }

    }

    //Time Complexity:O(n)
    //Post Order Traversal
    public static int getMaxBSTSize(Node root) {

        return getMaxBST(root).size;

    }

    private static MinMax getMaxBST(Node root) {

        //Base Case
        if (root == null) {
            return new MinMax();
        }

        MinMax left = getMaxBST(root.left);
        MinMax right = getMaxBST(root.right);

        MinMax minMax = new MinMax();

        if (!left.isBST || !right.isBST || left.lmax > root.data || right.rmin <= root.data) {

            minMax.isBST = false;
            minMax.size = Math.max(left.size, right.size);

            return minMax;
        }

        minMax.isBST = true;
        minMax.size = 1 + left.size + right.size;
        minMax.lmax = Math.max(root.data, left.lmax);
        minMax.rmin = Math.min(root.data, right.rmin);

        return minMax;

    }

    public static void main(String[] args) {

        LargestBSTInBinaryTree tree = buildTree();
        System.out.println(tree.getMaxBSTSize(tree.root));

    }

    private static LargestBSTInBinaryTree buildTree() {

        Node node1 = new Node(5);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(50);

        Node node5 = new Node(60);
        Node node6 = new Node(45);
        Node node7 = new Node(70);
        Node node8 = new Node(65);
        Node node9 = new Node(80);

        node4.left = node3;
        node4.right = node5;

        node3.left = node1;
        node3.right = node2;

        node7.left = node8;
        node7.right = node9;

        node5.left = node6;
        node5.right = node7;

        LargestBSTInBinaryTree tree = new LargestBSTInBinaryTree();
        tree.root = node4;

        return tree;

    }


}
