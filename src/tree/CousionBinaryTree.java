/**
** https://leetcode.com/problems/cousins-in-binary-tree/
** https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
** In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
** Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
** We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

** Return true if and only if the nodes corresponding to the values x and y are cousins.
                 1
              2     3   
         4

** Input: root = [1,2,3,4], x = 4, y = 3
Output: false

** Approach : First find level .
** Note while finding level, we will only go to right side if target is not found in left.
** Then check same parent, i.e if left == a && right == b and vice versa.

** Time Complexity : 3n = O(n) : 3 time tree traversal
** Space Complexity : 3h = O(h) : recurive stack call.
**/

class Solution {
    public boolean isCousins(TreeNode root, int a, int b) {
        
       int aLevel = findLevel(root, a, 0);
       int bLevel = findLevel(root, b, 0);
       
      return (aLevel == bLevel) 
       && !isSibling(root, a , b);
        
    }
    
    private int findLevel(TreeNode root, int a, int level){
        
        if(root == null){
            return 0;
        }
        
        if(root.val == a){
            return level;
        }
        
        int left = findLevel(root.left, a, level + 1);
        if(left != 0){
            return left;
        }
        
        return findLevel(root.right, a, level + 1);
    }
    
     private boolean isSibling(TreeNode node, int a , int b){
        
        if (node == null)
            return false;
  
       boolean check1 = (node.left!=null && node.left.val == a)
       && (node.right!=null && node.right.val == b);
       
       boolean check2 = (node.left!=null && node.left.val == b)
       && (node.right!=null && node.right.val == a);
       
        return  check1  ||
                check2 ||
                isSibling(node.left, a, b) ||
                isSibling(node.right, a, b);
    }
}
