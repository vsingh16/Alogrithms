/**
** https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
** Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
** The boundary includes left boundary, leaves, and right boundary in order without duplicate nodes. (The values of the nodes may still be duplicates.)
** The left boundary is defined as the path from the root to the left-most node. The right boundary is defined as the path from the root to the right-most node. If the root doesn’t have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not apply to any subtrees.
** The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if it exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
** The right-most node is also defined in the same way with left and right exchanged.

** Approach : We need to print root + left boundary(left,right) + leaf nodes(left == null && right == null) + right boundary(right,left)
** Time Complexity : O(n)
** Space Compexity : O(1)
**/

class Solution
{
    ArrayList <Integer> result = new ArrayList();
	ArrayList <Integer> printBoundary(Node node)
	{
	    if(node != null){
	        result.add(node.data); // root
	        printBoundaryLeft(node.left);
	        printBoundaryLeaf(node);
	        printBoundaryRight(node.right);
	    }
	    
	    return result;
	}
	
  // First priority is left node then right
	void printBoundaryLeft(Node node){
	    
	    if(node != null){
	        if(node.left != null){ // PS: we need to print node first and then call recurive call
	            result.add(node.data);
	            printBoundaryLeft(node.left);
	        }else if(node.right != null){
	            result.add(node.data);
	            printBoundaryLeft(node.right);
	        }
	    }
	}
	
  // First priority is right node then left
	void printBoundaryRight(Node node){
	    
	    if(node != null){
	        if(node.right != null){ // PS: We need to call right first and then print node
	            printBoundaryRight(node.right); 
	            result.add(node.data);
	        }else if(node.left != null){
	            printBoundaryRight(node.left);
	            result.add(node.data);
	        }
	    }
	}
	
  // In order traversal, just check if it is a leaf node , then only print
	void printBoundaryLeaf(Node node){
	    if(node !=null){
	        printBoundaryLeaf(node.left);
	        if(node.left == null && node.right == null){
	            result.add(node.data);
	        }
	        printBoundaryLeaf(node.right);    
	    }
	}
}
