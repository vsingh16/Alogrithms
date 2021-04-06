/**
** https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/
** https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/LargestBSTInBinaryTree.java
** https://www.youtube.com/watch?v=4fiDs7CCxkc
** Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). 
** If the complete Binary Tree is BST, then return the size of the whole tree.
** 
** Approach: At every node, we maintain : isBST, min, miax, count
** if left is bst and right is bst and left.min < root && root > right.max, then this root in also BST.
** for this node, min = min (left.max, root), max = max(right.min, root)
** if not BST, no need to update min , max, count will max of left and right
** Time Complexity : O(n)
** Space Complexity : O(h), recursive call stack
**/

class Solution{
    
    static class Result{
        
        boolean isBST;
        int min;
        int max;
        int count;
        
        Result(boolean isBST, int count){
            this.isBST = isBST;
            this.min = Integer.MAX_VALUE; 
            this.max = Integer.MIN_VALUE;
            this.count = count;
        }
        
        Result(boolean isBST, int min, int max, int count){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.count = count;
        }
        
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
           Result result = largestBstUtil(root);
           return result.count;
    }
    
    static Result largestBstUtil(Node root){
        
        if(root == null){
            return new Result(true, 0);
        }
        
        if(root.left == null && root.right == null){
            return new Result(true,root.data, root.data,1);
        }
        
       Result left = largestBstUtil(root.left);
       Result right = largestBstUtil(root.right);
       int count = left.count + right.count + 1;
       if(left.isBST && right.isBST && left.max < root.data && right.min > root.data){
           int min = left.min < root.data ? left.min : root.data;
           int max = right.max > root.data ? right.max : root.data;
           return new Result(true,min,max,count);
       }
    
       count = left.count > right.count ? left.count : right.count;    
       return new Result(false,count);
    }
    
    
}
