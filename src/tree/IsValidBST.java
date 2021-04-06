/**
** https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
** https://leetcode.com/problems/validate-binary-search-tree/submissions/
** A binary search tree (BST) is a node based binary tree data structure which has the following properties. 
** The left subtree of a node contains only nodes with keys less than the node’s key.
** The right subtree of a node contains only nodes with keys greater than the node’s key. 
** Both the left and right subtrees must also be binary search trees.
** From the above properties it naturally follows that: 
** Each node (item in the tree) has a distinct key.

** Approach 1: The quick approach comes to our mind is roo.left.data <  root.data  && root.data > root.right.data && isValidBST(root.left) && isValidBST(root.right)
** But this solution doesn't work becuase key is that in BST even if root.left < root.data or root.data > root.right and left and right subtrees are valid BST.
** But it may be th case that any node in left or right sub trees violate BST property with root. eg
**        5
		4	       6
		        3    7
** though 4 < 5 and 5< 6 and 4 is valid BST and 6 is also valid BST but 3 is on right side of root and less than 5.

** Approach 2: Inorder of BST will give us element in sorted order, so we can keep a previous node pointer and if prvious >= current, false
** Time Complexity : O(n)
** Space Complexity : O(1)
**/

class Solution {
    
    TreeNode previous = null;
    public boolean isValidBST(TreeNode root) {
        
          if(root != null){
              
              if(!isValidBST(root.left)){ // if left is not valid, no need to check further
                  return false;
              }
              if(previous !=null && previous.val >= root.val){
                  return false;
              }
              previous = root;
              if(!isValidBST(root.right)){ // if right is not valid no need to check further
                  return false;
              }              
              
          }
        
        return true;
    }
}
