package com.macquarie.shiner.batch.gcs.service;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 */
public class ConnectNodesTree {

    static class Tree {

        private Node root;
    }

    static class Node {

        private String data;
        private Node left;
        private Node right;
        private Node nextRight;
        private Integer level;

        public Node(String data) {
            this.data = data;
        }
    }

    //Time Complexity:O(n)

    /**
     * Approach: We are doing level order traversal and also maintaining level of each node,
     * so that while setting right next we also check for level that they must be on same level
     * @param tree
     */
    public static void connect(Tree tree) {

        Node root = tree.root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.level = 0;
        int level = 0;
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            if (queue.peek() != null && queue.peek().level == node.level) {
                node.nextRight = queue.peek();
            }
            level++;
            if (node.left != null) {
                queue.offer(node.left);
                node.left.level = level;
            }
            if (node.right != null) {
                queue.offer(node.right);
                node.right.level = level;
            }

        }

    }

    public static void main(String[] args) {
        Tree tree = createTree1();
        connect(tree);

    }

    public static Tree createTree1() {

        Tree tree = new Tree();

        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        tree.root = node1;
        return tree;
    }
}
