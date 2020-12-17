package com.vishal.hackerrank;

/**
 * Created by vishal on 17-Dec-20.
 * Time complexity to find an element in an array is O(n).
 * But if array is sorted , we can locate element in O(log n) time using Binary Search.
 */
public class BinarySearch {

    public static int searchRec(int a[], int search, int l, int h) {

        if (l > h) {
            return -1;
        }
        int mid = (l + h) / 2;
        if (search == a[mid]) {
            return mid;
        } else if (search < a[mid]) {
            return searchRec(a, search, l, mid - 1);
        } else
            return searchRec(a, search, mid + 1, h);
    }


    public static int search(int a[], int search, int l, int h) {

        int mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (a[mid] == search) {
                return mid;
            } else if (search < a[mid]) {
                h = mid - 1;
            } else
                l = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int a[] = {1, 3, 5, 7, 9, 11, 12};
        System.out.println("No. found at array index :" + searchRec(a, 3, 0, a.length - 1));
        System.out.println("No. found at array index :" + search(a, 3, 0, a.length - 1));

        System.out.println("No. found at array index :" + searchRec(a, 12, 0, a.length - 1));
        System.out.println("No. found at array index :" + search(a, 12, 0, a.length - 1));

        System.out.println("No. found at array index :" + searchRec(a, 0, 0, a.length - 1));
        System.out.println("No. found at array index :" + search(a, 0, 0, a.length - 1));
    }
}
