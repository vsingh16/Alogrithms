/**
** https://www.techiedelight.com/find-maximum-sum-root-to-leaf-path-binary-tree/
** https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
** Approach : First we find max sum, then print path
** To find Max Sum : if leaf node, return data;
** else max(left,right) + root.data
**  To print path (root,sum) : if sum == 0, return true i.e path completed
** if root = null, retunr false
** if(left || right) i.e we are getting path either from left or right, so print this root node as part of path.
** Time Complexity : O(n)
**/

// A class to store a binary tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Function to print the root-to-leaf path with a given sum in a binary tree
    public static boolean printPath (Node root, int sum)
    {
        // base case
        if (sum == 0) {
            return true;
        }
 
        // base case
        if (root == null) {
            return false;
        }
 
        // recur for the left and right subtree with reduced sum
        boolean left = printPath(root.left, sum - root.data);
        boolean right = printPath(root.right, sum - root.data);
 
        // print the current node if it lies on a path with a given sum
        if (left || right) {
            System.out.print(root.data + " ");
        }
 
        return left || right;
    }
 
    // Function to calculate the maximum root-to-leaf sum in a binary tree
    public static int getRootToLeafSum(Node root)
    {
        // base case: tree is empty
        if (root == null) {
            return 0;
        }
 
        // calculate the maximum node-to-leaf sum for the left child
        int left = getRootToLeafSum(root.left);
 
        // calculate the maximum node-to-leaf sum for the right child
        int right = getRootToLeafSum(root.right);
 
        // consider the maximum sum child
        return (left > right? left : right) + root.data;
    }
 
    // Function to print maximum sum root-to-leaf path in a given binary tree
    public static void findMaxSumPath(Node root)
    {
        int sum = getRootToLeafSum(root);
        System.out.println("The maximum sum is " + sum);
        System.out.print("The maximum sum path is ");
 
        printPath(root, sum);
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            8   4   5   6
               /   / \   \
             10   7   9   5
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(10);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(5);
 
        findMaxSumPath(root);
    }
}
