/**
You have a linked list , need to reverse it
eg 1->2->3-4>5
Time Complexity: O(n)
Space Compexity : O(1)
**/

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
// This function should reverse linked list and return
    // head of the modified linked list.
    Node reverseList(Node head)
    {
        // code here
        Node prev = null;
        Node current = head;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    ================================Recursive===============
     reverse(Node current){
      if(current.next == null){
       //update head pointer to current;
	      return;
      }
      reverse(current.next); //(null,1)-->(1,2)-->(2,3)-->(3,4)-->(4,5)
      current.next.next = current;
      }

reverse(Node head){
	if(head == null){
		return;
	}
	reverse(null, head);
return head;
}
