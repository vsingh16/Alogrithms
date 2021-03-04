/**
** https://www.youtube.com/watch?v=WVFk9DwRgpY
** https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
** https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1#
** Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
** 
** Approach 1: Do in order traversal. We need to somehow have information about previous node, then we can link current and previous nodes.
** Keep a global variable previous, which will be populated on the first node of in order traversal i.e extreme left node.
** When this varibale is not null, we can simply link current and previous nodes.
** Time Complexity : O(n)
**/

//This function should return head to the DLL

class Solution
{
    //Global Variables
    Node previous = null; 
    Node head = null;
  
    Node bToDLL(Node root)
    {
	      inOrder(root);
	      
	      return head;
    }
    
    void inOrder(Node node){
          if(node == null){
	            return ;         
	      }
	      
	      inOrder(node.left);
	      
	      if(previous == null){
	          previous = node;
	          head = node;
	      }else{
	          previous.right = node;
	          node.left = previous;
	          previous = node;
	      }
	      
	      inOrder(node.right);
	    
    }
    
    
}
