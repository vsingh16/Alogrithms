package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 */
public class NoSibilingNodes {

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

    //Time Complexity : O(n)
    public void printNoSiblingNodes(Node root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.left != null && root.right != null) {
            printNoSiblingNodes(root.left);
            printNoSiblingNodes(root.right);
        } else if (root.right == null) {
            System.out.println(root.left.data);
            printNoSiblingNodes(root.left);
        } else if (root.left == null) {
            System.out.println(root.right.data);
            printNoSiblingNodes(root.right);
        }

    }

    public static void main(String[] args) {
        NoSibilingNodes noSibilingNodes = new NoSibilingNodes();
        noSibilingNodes.printNoSiblingNodes(buildTree1());
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
}
