package com.vishal.hackerrank;

import java.util.Arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array.
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * Created by vishal on 22-Dec-20.
 */
public class SegregateZeroOneTwo {

    /**
     * Method 1: take 3 counter variables, count 0,1,2
     * then update array as per count
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int[] segregate(int a[]) {

        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                zero++;
            } else if (a[i] == 1) {
                one++;
            } else {
                two++;
            }
        }

        int i = 0;
        while (zero > 0) {
            a[i++] = 0;
            zero--;
        }
        while (one > 0) {
            a[i++] = 1;
            one--;
        }
        while (two > 0) {
            a[i++] = 2;
            two--;
        }

        return a;

    }

    /**
     * Method 2: If it is ask we literally need to have only 1 traversal.
     * We can take 2 pointers. left,right
     * Traverse array , if a[i] == 0, move it to a[left++]
     * if a[i] == 2, move it to a[right--]
     * if a[i] == 1, i++
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int[] segregate2(int a[]) {

        int left = 0, right = a.length - 1, i = 0;
        while (i <= right) {
            if (a[i] == 0) {
                swap(a, left, i);
                i++;
                left++;
            } else if (a[i] == 2) {
                swap(a, right, i);
                //we are not doing i++ because it could be the case
                // that we swap with 0, so we again need to move it to left
                right--;
            } else {
                i++; //when 1
            }
        }

        return a;

    }

    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a1[] = {0, 1, 2, 0, 1, 2};
        Arrays.stream(segregate(a1)).forEach(a -> System.out.print(a + " "));
        System.out.println("=======================");
        int a2[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        Arrays.stream(segregate(a2)).forEach(a -> System.out.print(a + " "));
        System.out.println("=======================");
        int a3[] = {0, 1, 2, 0, 1, 2};
        Arrays.stream(segregate2(a3)).forEach(a -> System.out.print(a + " "));
        System.out.println("=======================");
        int a4[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        Arrays.stream(segregate2(a4)).forEach(a -> System.out.print(a + " "));
    }
}
