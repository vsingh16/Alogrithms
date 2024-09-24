/**
** Ref: https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.

Examples:

Input: arr[] = {4,3,2,6} , N = 4
Output: 29
Explanation: 

First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5. 
Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9. 
Finally connect the two ropes and all ropes have connected.
                 

Input: arr[] = {1, 2, 3} , N = 3
Output: 9
Explanation: 

First, connect ropes of lengths 1 and 2. Now we have two ropes of lengths 3 and 3. 
Finally connect the two ropes and all ropes have connected.
Approach: We can take min heap to get first two min element add them and put their sum bak in min heap.
** Time Complexity: O(n logn), as logn when we add or remoe for heapify
** Space: O(n)
**/

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static long minCost(long[] a) {

        Queue<Long> minHeap = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            minHeap.add(a[i]);
        }

        long sum = 0;
        while (minHeap.size() > 1) {
            long first = minHeap.poll();
            long second = minHeap.poll();
            sum = sum + (first + second);
            minHeap.add(first + second);
        }

        return sum;
    }

    public static void main(String[] args) {
        long rope[] = {4, 3, 2, 6};
        System.out.println(minCost(rope));
    }
}


