/**
** Ref: https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Given k sorted linked lists of different sizes, the task is to merge them all maintaining their sorted order.

Examples: 

Input: k = 3,
list1 = 1->3->5->7->NULL
list2 = 2->4->6->8->NULL
list3 = 0->9->10->11->NULL
Output: 0->1->2->3->4->5->6->7->8->9->10->11
Merged lists in a sorted order where every element is greater than the previous element.

Input: k = 3
list1 = 1->3->7->NULL
list2 = 2->4->8->NULL
list3 = 9->NULL
Output: 1->2->3->4->7->8->9
Merged lists in a sorted order where every element is greater than the previous element.

** Approach: This is very similar to Merge K sorted array.
**/

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    // Function to merge K sorted linked list.
    static Node mergeKLists(List<Node> a) {

        Queue<Node> minHeap = new PriorityQueue<>((a1, a2) -> a1.data - a2.data);
        //Add 0th element of k lists
        for (int i = 0; i < a.size(); i++) {
            minHeap.add(a.get(i));
        }

        Node resultHead = null;
        Node resultTail = null;
        while (minHeap.size() > 0) {

            Node min = minHeap.peek();

            //add min.next to minHeap
            if (min.next != null) {
                minHeap.add(min.next);
            }

            //add this min to result link list
            if (resultHead == null) {
                resultHead = min;
                resultTail = min;
            } else {
                resultTail.next = min;
                resultTail = min;
            }

            minHeap.poll(); //remove min element

        }

        return resultHead;
    }

    public static void main(String[] args) {

        /**
         * Input: arr = [1->2->3, 4->5, 5->6, 7->8]
         * Output: 1->2->3->4->5->5->6->7->8
         * Explanation:
         * The test case has 4 sorted linked
         * list of size 3, 2, 2, 2
         * 1st    list     1 -> 2-> 3
         * 2nd   list      4->5
         * 3rd    list      5->6
         * 4th    list      7->8
         * The merged list will be
         */
        Node three = new Node(3);
        Node two = new Node(2);
        two.next = three;
        Node one = new Node(1);
        one.next = two;


        Node five1 = new Node(5);
        Node four = new Node(4);
        four.next = five1;


        Node six = new Node(6);
        Node five2 = new Node(5);
        five2.next = six;


        Node eight = new Node(8);
        Node seven = new Node(7);
        eight.next = seven;
        List<Node> input = List.of(one, four, five2, seven);
        Node result = mergeKLists(input);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }


    }
}
