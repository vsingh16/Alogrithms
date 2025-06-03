/**
https://leetcode.com/problems/reverse-linked-list/description/
Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
eg 1->2->3-4>5
Time Complexity: O(n)
Space Compexity : O(1)
**/

Iterative Approach: We can use three pointers to change the address.
class Solution {
	
    public LinkedList.ListNode reverseList(LinkedList.ListNode head) {

        if (head == null || head.next == null) { // Empty or Single Element
            return head;
        }

        LinkedList.ListNode current = head;
        LinkedList.ListNode next = current.next;
        while (next != null) {
            LinkedList.ListNode next_next = next.next; //before we change the next pointer, let's save one pointer ahead
            next.next = current;
            current = next;
            next = next_next;
        }

        head.next = null; //Terminating new list end
        return current;

    }

    public static void main(String[] args) {
        LinkedList list = LinkedList.fromArray(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        solution.reverseList(list.getHead());

    }

}	
    ================================Recursive===============
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

    private ListNode reverseListHead;

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;
        reverseList(current, next);
        head.next = null;

        return reverseListHead;
        
    }

     public void reverseList(ListNode current, ListNode next) {

        if (next == null) {
            reverseListHead = current;
            return;
        }

        reverseList(current.next, next.next);
        next.next = current;

    }
}
