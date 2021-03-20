/**
** https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
** Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). You may assume that both the values exist in the tree.
Examples:

               12
				  	4		      25
			   13	  	9    16     32
		  2     26   22
n1 = 2, n2 = 22
Output: 14

Time Complexity : O(n)

Approach : Think of cases for a node. if node is null, return null 
If node's data == left or right, return node

Think of parent node cases.
if left and right node both are not null, means this parent node is our LCA.
else retun if left != null, left
right != null , right

Time Complexity: O(n)
Space Complexity :O(1)
**/

class BST
{   
    // Returns the LCA of the nodes with values n1 and n2
    // in the BST rooted at 'root' 
	Node LCA(Node root, int n1, int n2)
	{
       if(root == null){
           return null;
       }
       
       if(root.data == n1 || root.data == n2){
        return root;   
       }
       
       Node left = LCA(root.left, n1, n2);
       Node right = LCA(root.right, n1, n2);
       if((left!= null && right !=null)){
           return root;
       }
       
       if(left != null){
           return left;
       }else if(right != null){
           return right;
       }
        
        return null;
    }
    
}
