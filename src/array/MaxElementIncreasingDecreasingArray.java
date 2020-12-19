package com.vishal.hackerrank;

/**
 * Created by vishal on 19-Dec-20.
 */
public class MaxElementIncreasingDecreasingArray {

    /**
     * Method 1: Traverse array and if find any element which is greater than max, update max
     * Time Complexity : O(n)
     */
    public static int findMaxLinear(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    /**
     * Method 2: Look for  mid element.
     * If left<mid<right, then mid element is the max
     * if mid>right, series is increasing , so we can ignore left part
     * if mid<right, series is decreasing , so we can ignore right part
     * if there is only one element, then that element is max
     * if there are two element, we can simply compare
     * Time Complexity : O(log n)
     */
    public static int findMaxBinary(int a[]) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            //When only one element is left
            if (l == h) {
                return a[l];
            }
            //when there are two elements
            else if (l + 1 == h) {
                if (a[l] > a[h]) {
                    return a[l];
                } else {
                    return a[h];
                }
            }
            if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
                return a[mid];
            } else if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1]) {
                //increasing part
                l = mid + 1;
            } else
                h = mid - 1;

        }
        return -1;
    }


    public static void main(String[] args) {
        int a[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        System.out.println(findMaxLinear(a));
        int a1[] = {1, 3, 50, 10, 9, 7, 6};
        System.out.println(findMaxLinear(a1));
        int a2[] = {10, 20, 30, 40, 50};
        System.out.println(findMaxLinear(a2));
        int a3[] = {120, 100, 80, 20, 0};
        System.out.println(findMaxLinear(a3));

        /***
         * Max Binary Search
         */
        System.out.println("===================");
        int a4[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        System.out.println(findMaxBinary(a4));
        int a5[] = {1, 3, 50, 10, 9, 7, 6};
        System.out.println(findMaxBinary(a5));
        int a6[] = {10, 20, 30, 40, 50};
        System.out.println(findMaxBinary(a6));
        int a7[] = {120, 100, 80, 20, 0};
        System.out.println(findMaxBinary(a7));
    }
}
