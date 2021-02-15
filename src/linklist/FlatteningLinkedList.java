/**
https://www.geeksforgeeks.org/flattening-a-linked-list/
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted. For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.

Apporach:
 We know how to merge two sorted linked list.
 Simply traverse from one linked list to other and merge lists.
 
 Time Complexity: O(n)
 Space Complexity: O(1)
**/

// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
		
}// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	   
	   if(root == null || root.next == null){
	       return root;
	   }
	   Node result = root;
	   
	   while(root.next!=null){
	       result = merge(result,root.next);
	       root = root.next;
	   }
	   
	   return result;
    }
    
    private Node merge(Node first, Node second){
        
        //System.out.println("First :" + first.data +" "+ "Second: "+ second.data);
        if(first == null){
            return second;
        }else if(second == null){
            return first;
        }
        
        //find head of the merged list
        Node temp;
        Node result;
        if(first.data<= second.data){
            temp = first;
            first = first.bottom;            
        }else {
            temp = second;
            second = second.bottom;
        }
        result = temp;
        while(first!=null && second!=null){         
            if(first.data<= second.data){
                temp.bottom = first; // Since Individual list is about bottom pointers, so updating botton instead of next.
                temp = temp.bottom;
                first = first.bottom;
        }else {
                temp.bottom = second;
                temp = temp.bottom;
                second = second.bottom;
            }   
            
        }
        
    if(first == null){
        temp.bottom = second;
    }else{
        temp.bottom = first;
    }
    
      
        return result;
    }
    
}
