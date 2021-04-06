/**
https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/

Segregate even and odd nodes in a Linked List
Difficulty Level : Medium
 Last Updated : 25 Mar, 2020
Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.

Examples:

Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL

Input: 8->12->10->5->4->1->6->NULL
Output: 8->12->10->4->6->5->1->NULL

// If all numbers are even then do not change the list
Input: 8->12->10->NULL
Output: 8->12->10->NULL

// If all numbers are odd then do not change the list
Input: 1->3->5->7->NULL
Output: 1->3->5->7->NULL

Approach1: Go to the the last node.
Whenever any odd node comes move it to end.
Time Complexity : O(n) but it has two traversal

Approach2: Have even & odd pointer.
Append even nodes to even pointer and odd nodes to odd pointer.
Lastly merge even.next = odd starting
This will require sinlge traversal only
Time Complexity : O(n) 
Below is Approach2 implementaion
**/

class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans); 
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        // code here
        
        if(N < 0){
            return head;
        }
        
        Node current = head;
        Node even = null, odd = null;
        Node evenHead = null, oddHead = null;
        
        while(current !=null){
            if((current.data % 2) == 0 ){
                      
                if(evenHead == null){ //first occurence handling
                    evenHead = current;
                }
                if(even != null){ 
                    even.next = current;    
                }
                even = current;
                
            }else{
                if(oddHead == null){
                    oddHead = current;
                }
                if(odd != null){ //first occurence handling
                    odd.next = current;    
                }
                odd = current;
            }
            
            current = current.next;
        }
        
        //limiting odd list . This is imporatnt else we may have infinite loop
        if(odd!=null){
            odd.next = null;    
        }
        
        
         //linking of even and odd list
        if(even!=null){
            even.next = oddHead;    
        }
        
        // we may have list having all even or odd nodes
        return evenHead != null ? evenHead : oddHead ;
    }
}
