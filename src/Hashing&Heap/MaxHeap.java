/**
** https://www.geeksforgeeks.org/heap-sort/
** Ref: https://www.youtube.com/watch?v=NKJnHewiGdc&t=2443s
**/

import java.util.Arrays;

public class MaxHeap {

    private int a[];
    private int size; //Max Heap Size

    public MaxHeap() {
    }

    public MaxHeap(int n) {
        this.a = new int[n];
        this.size = 0;
    }

    /**
     * This function insert an element into heap
     * First insert element at end.
     * compare with its parent
     * Since we are comparing with parent and traversing upward.
     * Time COmplexity : O(log2n)
     * Space Complexity: O(1), as no additional space required
     */
    public void insert(int element) {

        if (size == a.length) {
            return;
        }

        size++;
        int lastPos = size - 1;
        a[lastPos] = element;
        int currentPos = lastPos;
        while (currentPos > 0) {
            int parent = (currentPos - 1) / 2;
            if (a[currentPos] > a[parent]) {
                swap(currentPos, parent);
                currentPos = parent;
            } else {
                return;
            }

        }

    }

    /**
     * This function returns max element from heap and removes it.
     * Copy last element at top and then start comparing with its child.
     * This will traverse downwards in Tree.
     * Time Complexity: O(log2n)
     * Space Complexity: O(1), as no additional space required
     */
    public int remove() {

        if (size == 0) {
            return -1;
        }

        int max = a[0];

        //copy last element to top
        int currentPos = 0;
        a[currentPos] = a[size - 1];
        size--;
        while (currentPos < size) {

            int left = 2 * currentPos + 1;
            int right = 2 * currentPos + 2;
            if (a[currentPos] < a[left]) {
                swap(currentPos, left);
            } else if (a[currentPos] < a[right]) {
                swap(currentPos, right);
            } else {
                return max;
            }

        }

        return max;

    }


    /**
     * This function takes an array and creates max heap out of it.
     * we can skip leaf nodes. n/2+1 to n, as they are already max heap in themselves.
     * Time COmplexity: O(n * log2n)
     * Space Complexity: O(1)
     */
    public void heapify(int input[]) {

        this.a = input;
        this.size = a.length;
        for (int i = (a.length / 2 - 1); i >= 0; i--) {
            heapify(i);
        }


    }

    public void heapify(int currentPos) {

        int left = 2 * currentPos + 1;
        int right = 2 * currentPos + 2;
        int max = currentPos;
        if (left < a.length && a[left] > a[max]) {
            max = left;
        }

        if (right < a.length && a[right] > a[max]) {
            max = right;
        }

        if (max != currentPos) {
            swap(max, currentPos);
            heapify(max); // post swap , we need to check for position from which we have picked element.
        }


        return;
    }


    private void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void print() {
        Arrays.stream(this.a).forEach(System.out::println);
    }
}
=============================================================================================================
    package com.vishal.ds;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    private List<Integer> a;

    // Constructor
    public MaxHeap() {
        // Initialize your data members
        a = new ArrayList<>();
    }

    /**
     * insert x at last pos.
     * Then compare with parent and move upward
     * Time: O(logn)
     * Space:O(n) . ArrayList
     */
    public void push(int x) {
        // Insert x into the heap
        a.add(x);
        int currentPos = a.size() - 1;
        while (currentPos > 0) {

            int parentPos = (currentPos - 1) / 2;
            if (a.get(currentPos) > a.get(parentPos)) {
                swap(a, currentPos, parentPos);
                currentPos = parentPos;
            } else {
                return;
            }

        }

    }

    /**
     * Copy last element at top. Then compare this with left and right and move downward.
     * Also, while removing we need to update heap size. Therefore we copy last element at top and then remove last element.
     * Time: O(logn)
     * Space:O(n) . ArrayList
     */
    public void pop() {

        if (a.isEmpty()) {
            return;
        } else if (a.size() == 1) {
            a.remove(0);
            return;
        }

        int last = a.remove(a.size() - 1);
        a.set(0, last);

        int currentPos = 0;
        while (currentPos < a.size()) {

            int leftPos = 2 * currentPos + 1;
            int rightPos = 2 * currentPos + 2;

            int maxPos = currentPos;
            if (leftPos < a.size() && a.get(leftPos) > a.get(maxPos)) {
                maxPos = leftPos;
            }
            if (rightPos < a.size() && a.get(rightPos) > a.get(maxPos)) {
                maxPos = rightPos;
            }
            if (maxPos != currentPos) {
                swap(a, maxPos, currentPos);
                currentPos = maxPos;
            } else {
                return;
            }

        }
    }

    public int peek() {
        // Return the top element or -1 if empty
        return !a.isEmpty() ? a.get(0) : -1;
    }

    public int size() {
        return a.size();
    }

    private void swap(List<Integer> a, int xpos, int ypos) {

        int temp = a.get(xpos);
        a.set(xpos, a.get(ypos));
        a.set(ypos, temp);

    }

}

    
