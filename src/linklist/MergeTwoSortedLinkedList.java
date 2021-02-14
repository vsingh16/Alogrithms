/**
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]

Merging must be in place i.e no extra space
Approach : Find head of resulted linked list
Temp is the current node of resulted array.
Simply keep comparing l1 and l2 value and append smallest to temp(current node of resulted linked list) node.

Time Complexity: O(l1 + l2)
Space Complexity: O(1)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        
        //Now we need to maintain head of result list
        ListNode result = null;
        ListNode temp = null; //temp is the current pointer of result list
        if(l1.val<=l2.val){
            result = l1;
            temp = l1;
            l1 = l1.next;
        }else{
            result = l2;
            temp = l2;
            l2 = l2.next;
        }
        
        while(l1!=null && l2!=null){
            
            if(l1.val<=l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else{
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
            
        }
        
        if(l1 == null){
            temp.next = l2;
        }else{
            temp.next = l1;
        }
        
        return result;
        
    }
}
