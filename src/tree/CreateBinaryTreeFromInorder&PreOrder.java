/**
** https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
** https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
** Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

Approach : Preorder we know the left most node is root.So we wil have a current  = 0 and will increse it for every node.
Now find index of root obtained from preorder in inorder and then divide it in left and right subtree.

Time Complexity : O(n)
Space Complexity : O(1)
**/
class Solution {
        
    int current = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, preorder, 0, inorder.length - 1);
    }
    
  private TreeNode buildTree(int inorder[], int preorder[], int l, int r)
    {
        if( l > r){
            return null;
        }        
    TreeNode node = new TreeNode(preorder[current++]);      
    if(l == r){
        return node;
    }    
    int index = searchInOrder(inorder, node.val, l, r);
    node.left = buildTree(inorder, preorder, l, index - 1);
    node.right = buildTree(inorder, preorder, index + 1, r);
    
    return node;
    }
    
    private int searchInOrder(int inorder[], int data, int l, int r){
        
        for(int i=l; i <= r ; i++){
            if(inorder[i] == data){
                return i;
            }
        }
        
        return -1;
    }
}
