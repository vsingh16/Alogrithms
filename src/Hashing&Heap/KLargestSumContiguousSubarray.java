/**
** Ref: https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray within the array of numbers that has both negative and positive numbers.

Examples: 

Input: a[] = {20, -5, -1}, K = 3
Output: 14
Explanation: All sum of contiguous subarrays are (20, 15, 14, -5, -6, -1) 
so the 3rd largest sum is 14.

Input: a[] = {10, -10, 20, -40}, k = 6
Output: -10
Explanation: The 6th largest sum among
sum of all contiguous subarrays is -10.
** Approach 1 : Naive Approach
** Do Sum for all subarrays.
** Sort and find Kth largest.
** Time Complexity: O(n2*log(n2))
** Auxiliary Space: O(n)

** Approach 2: Kth Largest Min Heap
** Do Sum for all subarrays and put them in Min Heap of Size K
** In case if sum > Min Heap top element, remove top element and put new sum in MIn Heap.
** At end top of Min heap of size k will be kth largest sum.
** Time Complexity: O(n^n log k)
** Space Complexity : O(k)
**/

public class Solution {

    public static int kthLargest(int[] a, int k) {

        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];

                if (minHeap.size() < k) {
                    minHeap.add(sum);
                } else {
                    if (sum > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.add(sum);
                    }
                }
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        /**
         * Input: arr[] = [2, 6, 4, 1], k = 3
         * Output: 11
         * Explanation: The different subarray sums we can get from the arrayare = [13, 12, 11, 10, 8, 6, 5, 4, 2, 1]. Where 11 is the 3rd largest.
         */
        int a[] = {2, 6, 4, 1};
        int k = 3;
        System.out.println(kthLargest(a, k));


    }
}
