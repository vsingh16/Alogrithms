/**
https://leetcode.com/problems/reverse-nodes-in-k-group/
https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

Could you solve the problem in O(1) extra memory space?
You may not alter the values in the list's nodes, only nodes itself may be changed.

Input: 1->2-3>-4->5->6->7->8, K=3
Output: 3->2->1>-6->5->4->7->8

Approach : Calculate size of input list.
if size > k, traverse nodes from input and addFrist them to to result list.
else addLast them to result list.
Add first will put them in reverse order and add last keeps their order.

Keep two lists: 1) Previous List 2) Current List
if Previous List == null, Previous List = Current List
else 
Previous List. tail.next =  current List head

Time Complexity : O(n)
Space Complexity: O(n) //result linked list of size n

Since in the below code, we are creating new node , space compleity: O(n)
We can optimize this by removing node from original list and use that node in the result list rather than creating new node, therefore Space Complexity : O(1)
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    static ListNode currentHead = null;
    static ListNode previousHead = null;
    
    static ListNode currentLast = null;
    static ListNode previousLast = null;
    
    public ListNode reverseKGroup(ListNode node, int k) {
                
         previousHead = null;
         int inputListSize = size(node);
         while(inputListSize > 0){
            
            if(inputListSize >= k){
                
                for(int i=0;i<k;i++){
                    int val = node.val;
                    addFirst(val);
                    node = node.next;
                }
                
                //update size of input list left to be processed size -k
                inputListSize = inputListSize - k;
            }else{
                  
                  //loop till left elements in input list
                  for(int i=0;i<inputListSize;i++){
                      int val = node.val;
                      addLast(val);
                      node = node.next;
                  }
                inputListSize = 0;
            }
            
            /**System.out.println("Printing current list");
            print(currentHead);
            System.out.println("Printing Result list");
            print(previousHead);**/
             //Updating result list i.e previous list
                if(previousHead == null){
                    previousHead = currentHead;
                    previousLast = currentLast;
                }else{
                    previousLast.next = currentHead;
                    previousLast = currentLast;
                }
                currentHead = null;
                currentLast = null;               
    }
        
    return previousHead;
}
        
    public static int size(ListNode node){
        
        int size = 0;
        ListNode current = node;
        while(current != null){
            current = current.next;
            size++;
        }
        
        return size;
    }
        
    //Adds to current list
    public static void addFirst(int data){
        
        ListNode newNode = new ListNode(data);
        if(currentHead == null){
            currentHead = newNode;
            currentLast = newNode;
        }else{
            newNode.next = currentHead;
            currentHead = newNode;
        }
        
    }
        
    public static void addLast(int data){
        
        ListNode newNode = new ListNode(data);        
        //empty list
        if(currentLast == null){
            currentLast = newNode;
            currentHead = newNode;
        }else{
            currentLast.next = newNode;
            currentLast = newNode;
        }
        
    }
                            
}
