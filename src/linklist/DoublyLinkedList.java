/**
http://geeksquiz.com/doubly-linked-list/
Each node has pointer to previous and next node in doubly linked list 
Doubly Linked list insert/delete requires us to modify pointers in prevoius, new node and next node.
**/

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}

class DLinkedList
{
	
  /**
  Given a doubly-linked list, a position p, and an integer x. The task is to add a new node with value x at the position just after pth node in the doubly linked list.
  Indexing starts from 0.
  Time Complexity : O(n)
  PS: Keep in mind in doubly l
  **/
 void addNode(Node head_ref, int pos, int data)
	{
		// Your code here
		Node newNode = new Node(data);
		Node current = head_ref;
		int count=0;
		while(current!=null && count<pos){
		    current = current.next;
		    count++;
		}
		if(current!=null){
		 newNode.prev = current;
		 newNode.next = current.next;
		 current.next = newNode;
		 if(newNode.next!=null){
		 newNode.next.prev = newNode;    
		 }
		 
	}
  
  /**
  Given a doubly linked list and a position. The task is to delete a node from given position in a doubly linked list.
  Input:
LinkedList = 1 <--> 3 <--> 4 
x = 3
Output: 1 3  
Explanation: After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.
  **/
  Node deleteNode(Node head,int x)
    {
	
	  int count = 1;
	  Node current = head;
	  while(current!=null && count < x){
	      current = current.next;
	      count++;
	  }
	  
	  if(count == 1){ //delete head node
	      head = current.next;
	      current.next.prev = head;
	  }else{
	      if(current.prev != null){
	      current.prev.next = current.next;    
	      }
	      if(current.next != null){
	      current.next.prev = current.prev;    
	      }
	      
	  }
	  
	  return head;
    }
  
	
	}
}
