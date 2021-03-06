/**
https://leetcode.com/problems/middle-of-the-linked-list/
https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/

Find Middle of the Linked List
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.

 Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
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
 
 Time Complexity: O(n)
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        if(head == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){ // Since in case of even we are considering second middle no as result, fast!=null && fast.next!=null                                              
            slow = slow.next;
            fast = fast.next.next;                        
        }
        
        return slow;
        
    }
 
 /**
 1->2->3-4>5->6
 If the expectation in case of even no of list is that we need to return mid1 i.e 3,
 So f.next!= null && f.next.next!=null
 **/
 public ListNode middleNode2(ListNode head) {
        
        if(head == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(f.next!= null && f.next.next!=null){ 
            slow = slow.next;
            fast = fast.next.next;                        
        }
        
        return slow;
        
    }
}
