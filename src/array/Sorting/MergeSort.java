package com.vishal.hackerrank;

import java.util.Arrays;

/**
 * Created by vishal on 18-Dec-20.
 * It is based on Divide and conquer policy.
 * First we divide elements and then merge sorted arrays.
 * <p>
 * Time complexity : Division = o(logn ) and merge = n
 * So total Time Complexity : o(nlogn)
 * Space Complexity : o(n)
 */
public class MergeSort {

    public static void mergeSort(int a[], int l, int h) {

        if (l == h) {
            return;
        }
        int mid = (l + h) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, h);
        merge(a, l, mid, h);

    }

    public static void merge(int a[], int l, int mid, int h) {

        int result[] = new int[h - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= h) {
            if (a[i] <= a[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = a[j++];
            }
        }
        while (i <= mid) {
            result[k++] = a[i++];
        }
        while (j <= h) {
            result[k++] = a[j++];
        }

        //copy sorted elements to original array staring from l index
        for (i = 0; i < result.length; i++) {
            a[l++] = result[i];
        }
    }

    public static void main(String[] args) {
        int a[] = {8, 4, 3, 12, 25, 6, 13, 10};
        mergeSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(System.out::println);
    }
}
