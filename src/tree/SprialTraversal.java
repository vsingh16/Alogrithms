package tree;

import java.util.Stack;

/**
 * Created by vishal on 01-Jul-18.
 */
public class SprialTraversal {

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

        public void sprialTraversal(Node root) {

            Stack<Node> s1 = new Stack();
            Stack<Node> s2 = new Stack<>();

            s1.push(root);
            while (!s1.isEmpty() || !s2.isEmpty()) {

                while (!s1.isEmpty()) {
                    Node node = s1.pop();
                    System.out.println(node.data);
                    if (node.getRight() != null) {
                        s2.push(node.getRight());
                    }
                    if (node.getRight() != null) {
                        s2.push(node.getLeft());
                    }
                }

                while (!s2.isEmpty()) {
                    Node node = s2.pop();
                    System.out.println(node.data);
                    if (node.getLeft() != null) {
                        s1.push(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        s1.push(node.getRight());
                    }
                }

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
        System.out.println("Spiral Tree Traversal");
        tree.sprialTraversal(root);

    }
}
