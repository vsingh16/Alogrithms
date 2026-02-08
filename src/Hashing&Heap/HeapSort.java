/**
** https://www.geeksforgeeks.org/dsa/heap-sort/
** First convert the array into a max heap using heapify, Please note that this happens in-place.
** The array elements are re-arranged to follow heap properties. Then one by one delete the root node of the Max-heap and replace it with the last node and heapify. 
** Repeat this process while size of heap is greater than 1.
**/

package com.vishal.ds;

import java.util.Arrays;

public class HeapSort {


    private static void swap(int a[], int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }


    public static void heapify(int a[], int currentPos, int heapSize) {

        while (true) {

            int max = currentPos;
            int left = 2 * currentPos + 1;
            int right = 2 * currentPos + 2;

            if (left < heapSize && a[left] > a[max]) {
                max = left;
            }
            if (right < heapSize && a[right] > a[max]) {
                max = right;
            }

            if (max != currentPos) {
                swap(a, max, currentPos);
                currentPos = max;
            } else {
                return;
            }
        }

    }

  /** Time Complexity: O(n log n)
   ** Auxiliary Space: O(1)
  **/
    public static void heapSort(int a[]) {

        //Call Heapify for each parent node to build Max Heap
        //Build Heap: O(n).Since array is heapfiy it wont do swapping everytime 
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            heapify(a, i, a.length);
        }

        //Now to get full sorted Array, keep removing element from Max Heap, and place those at the last.
        //This way we have sorted max elements at end of array and then calling heapify on rest array
        //At end we have array sorted in ascending order
        for (int i = a.length - 1; i >= 0; i--) { //O(n)
            swap(a, 0, i);
            heapify(a, 0, i); //o(logn)
        }

    }

    static void main() {

        int a[] = {4, 1, 3, 9, 7};
        heapSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
