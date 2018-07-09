package com.macquarie.shiner.batch.gcs.tasklet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vsingh16
 */
public class MirrorTree {

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

    /**
     * Time Complexity : O(n), in worst case we will traverse all n nodes
     */
    public Boolean isMirrorRecursive(Node root1, Node root2) {

        //Base case
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) { //if one node is null and other is not
            return false;
        }

        return root1.data == root2.data && isMirrorRecursive(root1.left, root2.right) && isMirrorRecursive(root1.right, root2.left);
    }

    //Do level order traversal , for tree1 from left to right and for tree2 right to left
    //Time Complexity : O(n),Space Complexity : O(n)
    public Boolean isMirrorIterative(Node root1, Node root2) {

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {

            Node node1 = q1.poll();
            Node node2 = q2.poll();

            if (node1 == null && node2 == null) {
                return true;
            } else if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.data != node2.data) {
                return false;
            } else {
                q1.offer(node1.getLeft());
                q1.offer(node1.getRight());

                q2.offer(node2.getRight());
                q2.offer(node2.getLeft());
            }
        }

        return true;

    }

    public static void main(String[] args) {

        MirrorTree mirrorTree = new MirrorTree();
        //System.out.println(mirrorTree.isMirrorRecursive(buildTree1(), buildTree2()));
        System.out.println(mirrorTree.isMirrorIterative(buildTree1(), buildTree2()));
    }

    private static Node buildTree1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        return node1;
    }

    private static Node buildTree2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.right = node2;
        node1.left = node3;
        node2.right = node4;

        return node1;
    }
}
