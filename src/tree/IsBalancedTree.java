/**
** https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
** https://www.youtube.com/watch?v=lUDgp2D6sf8
** https://leetcode.com/problems/balanced-binary-tree/submissions/
** A tree where no leaf is much farther away from the root than any other leaf. Different balancing schemes allow different definitions of “much farther” and different amounts of work to keep them balanced.
Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.
** 
** Approach : We will apply find Height algorithm and will have a global variable which will set false if |left height - right height| > 1
** Time Compleity : O(n)
**/

//User function Template for Java


/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */

class Tree
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced = true;
    boolean isBalanced(Node root)
    {
         height(root);
	     return isBalanced;
    }
    
    int height(Node root)
    {
	    if(root == null){
	        return 0;
	    }
	    
	    int lHeight = height(root.left);
	    int rHeight = height(root.right);
	    int height = 1 + Math.max(lHeight,rHeight);
	    
	    if(Math.abs(lHeight-rHeight) > 1){
	        isBalanced = false;
	    }
	
	    return height;
    }
    
}

