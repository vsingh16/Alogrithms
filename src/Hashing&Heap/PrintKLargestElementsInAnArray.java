/**
** Ref: https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Print K largest(or smallest) elements in an array
** Given an array arr[] of size N, the task is to printing K largest elements in an array.
Note: Elements in output array can be in any order

Examples:

Input:  [1, 23, 12, 9, 30, 2, 50], K = 3
Output: 50, 30, 23

Input:  [11, 5, 12, 9, 44, 17, 2], K = 2
Output: 44, 17
** Approach 1: Naive. Sort in decending order and print first k elements.
** Time Complexity : O(nlogn)
** Space Complexity: O(1)
**/

public class Solution {

  /**
  ** Approach 2: Min Heap which will eventually reduce min elements and hold larget kth element at end.
  ** Insert elements in Min heap, when size is >k, remove. 
  ** TIme Compleity: O(n * logk)
  ** Space : O(K), min heap of size k
  **/
    static int[] kLargest(int[] a, int n, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) { //n
            minHeap.add(a[i]);

            if (minHeap.size() > k) {
                minHeap.poll(); //log k, as heap is size k
            }
        }

        int result[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int a[] = {12, 5, 787, 1, 23};
        int k = 2;
        Arrays.stream(kLargest(a, a.length, k)).forEach(System.out::println);


    }
