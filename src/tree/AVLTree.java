package tree;

/**
 * Created by vishal on 17-Jun-18.
 * <p>
 * AVL tree is a self-balancing Binary Search Tree (BST) where the difference
 * between heights of left and right subtrees cannot be more than one for all nodes.
 * <p>
 * There are four cases for AVL insertion:
 * 1)LL insertion: Right rotate
 * 2)RR insertion :  Left Rotate
 * 3)LR insertion: Left rotate and then right rotate
 * 4)RL insertion: Right rotate and then Left rotate
 * <p>
 * Time Complexity: O(logn)
 *
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 *
 */
public class AVLTree {

    private Node root;

    class Node {

        private int key;
        private Node left;
        private Node right;
        private int height;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private int height(Node node) {

        return node != null ? node.height : 0;
    }

    private int getBalance(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node leftRotate(Node x) {

        Node y = x.right;
        Node T = y.left;

        y.left = x;
        x.right = T;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(x.left), height(x.right));

        return y;
    }

    private Node rightRotate(Node x) {

        Node y = x.left;
        Node T = y.right;

        y.right = x;
        x.left = T;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(x.left), height(x.right));

        return y;
    }

    private void preOrderTraversal(Node node) {

        if (node != null) {
            System.out.print(node.key + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }

    }

    public Node insert(Node node, int key) {

        //if tree is empty
        if (node == null) {
            return new Node(key);
        } else if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        //LL insertion
        /**
         *  example
         *  30
         *  /
         *  20
         *  /
         * 10
         *
         * After
         *   20
         *   /\
         *  10 30
         */
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        //RR insertion
        /**
         *  example
         *  10
         *   \
         *   20
         *    \
         *    30
         *
         * After
         *   20
         *   /\
         *  10 30
         */
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        //LR insertion
        /**
         *  example
         *  20
         *  /
         * 10
         *   \
         *    15
         *
         * First Rotate left
         *   20
         *   /
         *  15
         *  /
         *  10
         *
         *  Now this becomes case of LL isnertion
         *
         *   15
         *  / \
         * 10  20
         */
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL insertion
        /**
         *  example
         *  20
         *    \
         *     30
         *    /
         *  15
         *
         * First Rotate Right
         *   20
         *    \
         *     15
         *      \
         *      30
         *
         *  Now this becomes case of RR isnertion
         *
         *   15
         *  / \
         * 20  30
         */
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.root = avlTree.insert(avlTree.root, 10);
        avlTree.root = avlTree.insert(avlTree.root, 20);
        avlTree.root = avlTree.insert(avlTree.root, 305);
        avlTree.root = avlTree.insert(avlTree.root, 40);
        avlTree.root = avlTree.insert(avlTree.root, 50);
        avlTree.root = avlTree.insert(avlTree.root, 25);
         /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        avlTree.preOrderTraversal(avlTree.root);
    }
}
