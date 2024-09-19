/**
** Ref:
** https://www.geeksforgeeks.org/convert-min-heap-to-max-heap/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** 
** Convert Min Heap to Max Heap
** Given an array representation of min Heap, convert it to max Heap.

Examples: 

Input: arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9}

               3
            /     \
          5       9
        /   \    /  \
      6     8  20   10
    /  \   /
12   18 9 

Output: arr[] = {20, 18, 10, 12, 9, 9, 3, 5, 6, 8}

           20
         /    \
      18      10
     /    \    /  \
  12     9  9    3
 /  \   /
5    6 8 

Input: arr[] = {3, 4, 8, 11, 13}
Output:  arr[] = {13, 11, 8, 4, 3}
** Approach 1: We can call maxheapify on array.
** https://github.com/vsingh16/Alogrithms/blob/master/src/Hashing%26Heap/MaxHeap.java
** Time Complexity : O(n)
** Space Complexity : O(1)
**/

import java.util.Arrays;

public class Solution {

    static void maxHeapify(int a[], int i) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int maxPos = i;
        if (left < a.length && a[left] > a[i]) {
            maxPos = left;
        } else if (right < a.length && a[right] > a[i]) {
            maxPos = right;
        }

        if (maxPos != i) {
            swap(a, i, maxPos);
            maxHeapify(a, maxPos);
        }

    }

    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    static void convertMinToMaxHeap(int n, int a[]) {

        for (int i = (n / 2) - 1; i >= 0; i--) {

            maxHeapify(a, i);

        }

    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        convertMinToMaxHeap(a.length, a);
        Arrays.stream(a).forEach(System.out::println);
    }
}


