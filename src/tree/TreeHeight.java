package tree;

/**
 * Created by vishal on 01-Jul-18.
 *
 * Calculate Binary Tree height
 * Time Complexity : O(log n)
 */
public class TreeHeight {

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

        public int getHeight(Node root) {

            if (root == null) {
                return 0;
            }

            return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
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
            System.out.println(tree.getHeight(root));
        }
    }

}
