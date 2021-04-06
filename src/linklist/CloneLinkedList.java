/**
https://www.youtube.com/watch?v=VNf6VynfpdM
https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
https://leetcode.com/problems/copy-list-with-random-pointer/submissions/

Clone a linked list with next and random pointer in O(1) space
Given a linked list having two pointers in each node. The first one points to the next node of the list, however, the other pointer is random and can point to any node of the list. Write a program that clones the given list in O(1) space, i.e., without any extra space.

Approach : Its easy to create clone nodes while traversing original list. But the challenge is that we can't link nodes in clone list becuase next node is not yet created.
We realise that there is a need to create mappping/ linking of original and clone nodes, so that we know clone node corresponding to orignal node.
We can store this information in Hashmap but since we need to solve problem without extra space, we will insert the clone new node in mid of two nodes in original list,
so that we always have clone node infront of orignal node.

Step 1: Insert new clone node in mid of two nodes in original linked list.
Step 2: Traverse list created in step 1 and pouplate random , we can do this becuase we have original and clone node mapping.
Step 3: Segregate original and clone linked list.

Time Complexity: O(n)
Space Compmlexit: O(1)

With extra space :https://github.com/vsingh16/Alogrithms/blob/master/src/linklist/LinkListClone.java
**/

class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}
// function to copy linked list
class Clone {
    Node copyList(Node head) {
        
        //1. Create clone nodes in mid of original, so that
        //we have mapping of original and clone nodes
        Node current = head;
        while(current != null){
            Node clone = new Node(current.data);
            Node temp = current.next;
            current.next = clone;
            clone.next = temp;
            current = temp;
        }
        //System.out.println("After Step 1:");
        //print(head);
        
        //2. Populate random pointers
        current = head;
        while(current != null){
            if(current.next!=null && current.arb!=null){
             current.next.arb = current.arb.next;   
            }
            current = current.next.next;
        }
        //System.out.println("After Step 2:");
        //print(head);
        
        
        //3.extract clone list
        current = head;
        Node cloneHead = null;
        Node clone = null;
        while(current != null){
            
            if(cloneHead == null){
                cloneHead = current.next;
                clone = current.next;
                //System.out.println("Clone list head :"+clone.data);
            }else{
                clone.next = current.next; 
                clone = clone.next;
                //System.out.println("Clone list next node :"+clone.data);
            }
            current.next = current.next.next;
            current = current.next;
        }
        
        //System.out.println("After Step 3: Original List");
        //print(head);
        
        //System.out.println("After Step 3: Clone List");
        //print(cloneHead);
        
        return cloneHead;
        
    }
    
    void print(Node head){
        
        Node current = head;
        while(current != null){
            System.out.println("Data: " +current.data +"Arb: " +(current.arb!=null ? current.arb.data : null) +"---->");
            current = current.next;
        }
    }
}

