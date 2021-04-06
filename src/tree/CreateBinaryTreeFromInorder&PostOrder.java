/**
** https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
** https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
** Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

Approach : Postorder we know the left most node is root.So we wil have a current  = n - 1 and will decrease it for every node.
Now find index of root obtained from Postorder, in inorder and then divide it in left and right subtree.
Time Complexity : O(n)
Space Complexity : O(1)
**/
class Solution {
    
    int current;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        current = inorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }
    
     private TreeNode buildTree(int inorder[], int postorder[], int l, int r)
    {
        if( l > r){
            return null;
        }        
    TreeNode node = new TreeNode(postorder[current--]);      
    if(l == r){
        return node;
    }    
    int index = searchInOrder(inorder, node.val, l, r);    
    node.right = buildTree(inorder, postorder, index + 1, r);
    node.left = buildTree(inorder, postorder, l, index - 1);
    
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
