/**
** Ref: https://www.geeksforgeeks.org/merge-two-binary-max-heaps/
**  https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s, Love Babbar Heap Code Help Lecture 74,75,76
** Given two binary max heaps, the task is to merge the given heaps to form a new max heap.

Examples : 

Input: a[] = {10, 5, 6, 2}, b[] = {12, 7, 9}
Output: {12, 10, 9, 2, 5, 7, 6}

** Approach : We know if we have an array , we can build heap from it.
** We can leave the leaf nodes as they are already max heap on their own.
** Now start from the last right most element and heapify it i.e compare ans swap parent with its child.
**/

import java.util.Arrays;

public class Solution {

   /**
   ** Time Complexity : if index i has height k, o(log k)
   ** Space Complexity: O(1)
  **/
    public static void heapify(int a[], int i) {

        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < a.length && a[left] > a[max]) {
            max = left;
        }

        if (right < a.length && a[right] > a[max]) {
            max = right;
        }

        if (max != i) {
            swap(a, max, i);
            heapify(a, max); // This is to ensure if the latest swapping has introduced disbalance, this can further correct.
        }

    }

    private static void swap(int a[], int x, int y) {

        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;

    }


  /**
  ** We are traversing all most n elements and heapfiy will also result in travelrsal of n nodes.
  ** Intuitively, this is because heapify is not called the full height for each node—many nodes are leaf nodes or near the bottom of the tree, so the overall work done is linear.
  **/
    public static void buildMaxHeap(int a[]) {

       // Leave the leaf node and start from right most parent
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, i);
        }

    }

  /**
  ** Time : O(n+m)
  ** Space: O(n+m)
  **/
    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {

        int result[] = new int[n + m];
        int c = 0;
        for (int i = 0; i < n; i++) {
            result[c++] = a[i];
        }

        for (int i = 0; i < m; i++) {
            result[c++] = b[i];
        }

        buildMaxHeap(result);

        return result;
    }

    public static void main(String[] args) {

        int a[] = {10, 5, 6, 2};
        int b[] = {12, 7, 9};
        int n = 4, m = 3;
        Arrays.stream(mergeHeaps(a, b, n, m)).forEach(System.out::println);


    }
}
