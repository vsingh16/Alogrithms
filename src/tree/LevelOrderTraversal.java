package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vishal on 01-Jul-18.
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * Approach : Order Level Traversal or Breadth First Traversal requires us to print root first then its left and right children.
 * So we will take a queue and follows R P A (remove print add)
 * Time Complexity : O(n)
 * Space Complexity : O(n) // extra queue
 */
public class LevelOrderTraversal {

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

    static class Tree {
        private Node root;

        public Tree(Node root) {
            this.root = root;
        }

        /**
         * Time Complexity : O(n)
         * As we will traverse all no nodes
         * <p>
         * Space Complexity : O(n)
         */
        public void levelTraversal() {

            Queue<Node> q = new LinkedList<>();
            //Root element
            if (root != null) {
                q.offer(root);
            }

            while (!q.isEmpty()) {
                Node node = q.poll();
                System.out.println(node.data);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

        }

        public static void main(String[] args) {
            Node root = new Node(1);
            Node second = new Node(2);
            Node third = new Node(3);
            Node fourth = new Node(4);
            Node five = new Node(5);
            Node six = new Node(6);
            Node seven = new Node(7);

            root.left = second;
            root.right = third;
            second.left = fourth;
            second.right = five;
            third.left = six;
            third.right = seven;

            Tree tree = new Tree(root);
            System.out.println("Level Order Traversal");
            tree.levelTraversal();

        }
    }
}
