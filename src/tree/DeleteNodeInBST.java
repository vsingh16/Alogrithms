/**
** https://leetcode.com/problems/delete-node-in-a-bst/submissions/
** https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
** Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?

Approach : First we need to search. if data < root.data, go left else go right when data  == root.data stop
Delete : Case 1: when root has two children. Find min on right side. This is to ensure that BST property remians intact. i.e on element on right side will be greater than root.
and since it is from right side, it will be greate than left side elements.
Now copy its data to root and after that we need to delete same data value node on right side.

Case 2: if there is only one child, retrun that child.
Case 3: if no child, return null

Time Complexity : O(h) , h is height of tree . Since either we are going in left or right part, it complexity depends on height of tree.
**/

/*
Structure of a Node is as follows:-
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tree
{
    // Return the root of the modified BST after deleting the node with value X
	public static Node deleteNode(Node root, int X)
	{ 
	    if(root == null){
	        return root;
	    }
	    
		if(X < root.data){
		    root.left = deleteNode(root.left, X);
		}else if(X > root.data){
		    root.right = deleteNode(root.right, X);
		}else{
		    //action
		    
		    if(root.left != null && root.right !=null){
		        //find min on right side
		        
		        Node current = root.right;
		        while(current.left !=null ){
		            current = current.left;
		        }
		        
		        root.data = current.data;
		        root.right = deleteNode(root.right, current.data);
		        
		    }else if(root.left != null){
		        return root.left;
		    }else if(root.right != null){
		        return root.right;
		    }else{
		        return null;
		    }
		}
		
		return root;
	}
	
}	
