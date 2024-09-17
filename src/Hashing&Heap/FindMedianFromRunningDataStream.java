/**
** Ref: https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Approach 1: 
** We can sort element and the find median.
** odd: mid element is medain
** even : (mid + mid+1)/ 2 is median
** We can sort elements and find median.
** Sorting: We can use Insertion sort which can be done if array is already sorted.
** Since this is stream, we have to srot everytime.
** Time Complexity: O(n*n)
** Space : O(1)

** Approach 2: We can take two heaps.
Left Side Max Heap
Right Side Min Heap
** For insertion 3 cases can be.
Case 1: if left == right, insert in left
Case 2: If left > right, insert in right
Case 3: Insert in left
After insertion we also need to balance heaps. i.e Top of Max heap < Top of Min Heap

** Balancing:
If Top of Max heap > Top of Min Heap , we can swap top elements across heaps
Time Complexity: O(n * logn)
Space Complexity: O(n)
**/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    private static Queue<Integer> maxHeap = new PriorityQueue<>((a1, a2) -> a2 - a1);
    private static Queue<Integer> minHeap = new PriorityQueue<>();

    //Function to insert heap.
    public static void insertHeap(int x) {

        if (maxHeap.size() == minHeap.size()) {

            maxHeap.add(x);
            balanceHeaps();

        } else if (maxHeap.size() > minHeap.size()) {
            // we should insert in min heap
            minHeap.add(x);
            balanceHeaps();

        } else {
            // we should insert in max heap
            maxHeap.add(x);
            balanceHeaps();
        }
    }

    //Function to balance heaps.
    public static void balanceHeaps() {

        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            int maxheap_peek = maxHeap.peek();
            int minheap_peek = minHeap.peek();
            if (maxheap_peek > minheap_peek) {
                //maxHeap.peek we need to put this in min heap
                // Min heap peek we need to put this in max heap
                maxHeap.poll();
                minHeap.poll();
                maxHeap.add(minheap_peek);
                minHeap.add(maxheap_peek);

            }
        }

    }

    //Function to return Median.
    public static double getMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }


    public static void main(String[] args) {
        /**
         * Input:
         * N = 4
         * X[] = 5,15,1,3
         * Output:
         * 5
         * 10
         * 5
         * 4
         * Explanation:Flow in stream : 5, 15, 1, 3
         * 5 goes to stream --> median 5 (5)
         * 15 goes to stream --> median 10 (5,15)
         * 1 goes to stream --> median 15 (5,15,1)
         * 3 goes to stream --> median 4 (5,15,1 3)
         */

        int a[] = {-1, -2, -3, -4, -5};
        Arrays.stream(a).forEach(x -> {
            insertHeap(x);
            System.out.println(getMedian());
        });


    }
}
