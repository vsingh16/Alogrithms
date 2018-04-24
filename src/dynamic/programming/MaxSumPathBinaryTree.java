package dynamic.programming;

/**
 * Created by vishal on 24-Apr-18.
 * <p>
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 * <p>
 * Approach:
 * <p>
 * There are four possible paths:
 * 1)only Node
 * 2)Node+max left path
 * 3)Node + max right path
 * 4)Node +max left+max right
 *
 * If we choose fourth path, in that case no ancestor of node is included in max sum
 * Therefore we always return from option 1,2,3 though to compare max value we also include option 4
 *
 */
public class MaxSumPathBinaryTree {

    private Node root;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Res {
        int value;
    }

    public int findMaxSum(Node node, Res res) {

        //Base case
        if (node == null) {
            return 0;
        }

        int l = findMaxSum(node.left, res);
        int r = findMaxSum(node.right, res);
        int maxSingle = Math.max(node.data, Math.max(node.data + l, node.data + r));
        res.value = Math.max(res.value, Math.max(maxSingle, l + node.data + r));
        return maxSingle;
    }

    public int findMaxSum() {
        Res res = new Res();
        res.value = Integer.MIN_VALUE;
        findMaxSum(root, res);
        return res.value;
    }

    public static void main(String[] args) {
        MaxSumPathBinaryTree tree = new MaxSumPathBinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                tree.findMaxSum());
    }
}
