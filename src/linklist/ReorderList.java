/**
* https://leetcode.com/problems/reorder-list/
* https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
* reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

* You may not modify the values in the list's nodes, only nodes itself may be changed.

* Example 1:

* Given 1->2->3->4, reorder it to 1->4->2->3.
* Example 2:

* Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

Approach : Two pointers , Left and Right.
We will move right pointer to extreme right.
Now, we can link left and right pointers.
But one thing is to oberve that with linking, we are also creating loops in list which we need to take care of.
So one thing, we can do is once we reach stop condition, we can set null 
Stop condition: in case of odd no of nodes. left == right
In case of even no of nodes, left.next == right

ODD Case :
1->2-3>4->5
Output: 1->5->2-4->3
reorderListUtil(1); // left = 4, left = left.next = 
reorderListUtil(2); // Since left == null no processing
reorderListUtil(3); // left = 3, when left = right, means we have moved all nodes to left part, nothing shuld be aftet this, left.next = null, left = null
1->5->2->4->3
reorderListUtil(4); // left = 2, 1->5->2-4->3>4->5, left = 3
reorderListUtil(5); //left = 1, 1->5->2-3>4->5, left = 2
reorderListUtil(null);

EVEN CASE:
1->7->3->4

output: 1->4->7->3
reorderListUtil(1); 
reorderListUtil(7); //left = 3
reorderListUtil(3); // left = 7, Since left.next == right,stop and set null to left.next,  1->4->7->3 
reorderListUtil(4); // left = 1 , 1->4->7->3->4, left = 7
reorderListUtil(null);
===============================================
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
    
    ListNode left = null;
    
    public void reorderList(ListNode head) {
        
         if(head != null){
            left = head;
            reorderListUtil(left);    
        }
                        
    }
    
     void reorderListUtil(ListNode right) {
        
        if(right == null){
            return ;
        }
        //System.out.println("right :"+ right.data);   
        reorderListUtil(right.next);
        
        //we set left = null, when we reach stop condition, so no processing required after that
        if(left == null){
            return;
        }
        
        //Stop condition: odd case : left = right, even case : left.next = right
        if(left != right && left.next != right){
            ListNode temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;    
        }else{ // stop case , set null to left nodes
            if(left.next == right){
                left.next.next = null; //even case
                left = null;
            }else{
                left.next = null; // odd case
                left = null;    
            }            
        }
        
     }
   
}
