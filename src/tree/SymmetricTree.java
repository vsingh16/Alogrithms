/**
** https://leetcode.com/problems/symmetric-tree/
** https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
** Given a binary tree, check whether it is a mirror of itself.

For example, this binary tree is symmetric: 

     1
   /   \
  2     2
 / \   / \
3   4 4   3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3
   
   Approach : Apply mirror image algorithm on same root node.
   Time Complexity :O(n)
**/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return isMirror(root, root);                        
    }
    
    private boolean isMirror(TreeNode a, TreeNode b){
        
        if(a == null && b == null){
            return true;
        }else if(a == null || b == null){
            return false;
        }
        
        return a.val == b.val
            && isMirror(a.left, b.right)
            && isMirror(a.right, b.left);
        
    }
}
