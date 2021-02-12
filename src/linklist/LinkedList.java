/**

https://www.geeksforgeeks.org/data-structures/linked-list/
**/

class Node{

private int value;
private Node next;

public Node(int value){
  this.value = value;
  this.next = null;
}

//getter & setter
}
Class LinkedList{

  private Node head;

    // Should insert a node at the beginning
    void insertAtBeginning(int x)
    {
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }                
    }
    
    // Should insert a node at the end
    void insertAtEnd(int x)
    {
        Node newNode = new Node(x);
        Node currentNode = head;
        
        if(head == null){
            head = newNode;
            return head;
        }
         
        //This O(n) time complexity can be reduced, if we keep one more pointer i.e tail along with head 
        while(currentNode.next !=null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        
        return head;
    }
    
 /**
 Deletes xth node.
 Time Complexity: O(n)
 **/
  void deleteNode(Node head, int x)
    {
	   int counter = 1;
	   
	   //if head element is to be deleted
	   if(head!=null && counter == x){
	       head = head.next;
	       return head;
	   }
	   
	   Node previous = head;
	   while(previous!=null && previous.next!=null && counter+1 != x){ // counter + 1 : denotes previous node
	       previous = previous.next;
	       counter++;
	   }
	   
	   if(counter+1 == x){
	       previous.next =  previous.next!=null ? previous.next.next : null;
	   }
	   
	   return head;
    }
  
   /**
    Deletes node with value x.
    Time Complexity: O(n)
   **/
  void deleteNode(Node head, int x)
    {
	   	   
	   //if head element is to be deleted
	   if(head!=null && head.data == x){
	       head = head.next;
	       return head;
	   }
	   
	   Node previous = head;
	   while(previous!=null && previous.next!=null && previous.next.data != x){ 
	       previous = previous.next;
	       counter++;
	   }
	   
	   if(previous.next.data == x){
	       previous.next =  previous.next!=null ? previous.next.next : null;
	   }
	   
	   return head;
    }
    
 }
