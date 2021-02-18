/**
https://www.geeksforgeeks.org/merge-sort-for-linked-list/

Similar to merge sort on array, we ned to do the same on linked list

Approach:
1) Find mid with two pointer approach. Keep in mind that in case of even size list, we need to return mid1. https://github.com/vsingh16/Alogrithms/blob/master/src/linklist/FindMiddleOfLinkedList.java
2)Then apply merging two sorted linked list. https://github.com/vsingh16/Alogrithms/blob/master/src/linklist/MergeTwoSortedLinkedList.java

Time Complexity: O(nlongn)
**/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class LinkedList
{
    
    static Node mergeSort(Node head)
    {
        //if list is empty or if there is only one element
        if(head == null || head.next == null){
            return head;
        }
        
        //find middle of list
        Node mid = middleNode(head);
        //System.out.println("Middle : "+ mid.data);
        Node midNext = mid.next;
        mid.next = null;
        //System.out.println("First : "+ head.data);
        Node first = mergeSort(head);
        //System.out.println("Second : "+ midNext.data);
        Node second = mergeSort(midNext);
        return mergeTwoLists(first,second);
        
    }
    
    static Node middleNode(Node head) {
        
        if(head == null){
            return head;
        }
        
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){ // Since in case of even we are considering second middle no as result, fast!=null && fast.next!=null                                              
            slow = slow.next;
            fast = fast.next.next;                        
        }
        
        return slow;
        
    }
    
     static Node mergeTwoLists(Node l1, Node l2) {
        
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        
        //Now we need to maintain head of result list
        Node result = null;
        Node temp = null; //temp is the current pointer of result list
        if(l1.data<=l2.data){
            result = l1;
            temp = l1;
            l1 = l1.next;
        }else{
            result = l2;
            temp = l2;
            l2 = l2.next;
        }
        
        while(l1!=null && l2!=null){
            
            if(l1.data<=l2.data){
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


