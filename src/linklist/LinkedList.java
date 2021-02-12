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
    
    
  }
