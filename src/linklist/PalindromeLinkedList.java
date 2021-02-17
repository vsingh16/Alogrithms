/**
Given a singly linked list, determine if it is a palindrome.
Example 1:
Input: 1->2
Output: false
Example 2:
Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
https://leetcode.com/problems/palindrome-linked-list/
Approach : To check if it is palindrome, we can have two pointers, left and right and comapre values of left and right node.
We will have left  = head and then recursive fun call(right.next), so with recusion when we have left at 1st node, right will be extreme right
then with recursion, we can move right to left
also we need to move left point ahead after each comparison //Keep in mind because we need to update left we should have this at class level in heap
not in fun call.
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
    
    ListNode left; //Class level in heap, so we can modify this in each recursive call
    public boolean isPalindrome(ListNode head) {
        
        if(head == null){
            return true;
        }
        left = head;
        return isPalindromeUtil(head.next);
        
    }
    
    public boolean isPalindromeUtil(ListNode right) {
        
        if(right == null){
            return true;
        }
       
        boolean result = isPalindromeUtil(right.next) && (left.val == right.val);
       
        left = left.next;      
        
        return result;
    }
}
