package com.macquarie.shiner.batch.gcs.processor;

public class SortedRotatedArraySearch {

    //Time Complexity O(Log n)
    public static int search(int a[], int key) {

        int l = 0, h = a.length - 1;

        int pivotIndex = findPivotIndex(a);
        if (key == a[pivotIndex]) {
            return key;
        } else if (key >= a[0] && key < a[pivotIndex]) {
            h = pivotIndex - 1;
        } else {
            l = pivotIndex + 1;
        }

        while (l <= h) {
            int mid = (l + h) / 2;

            if (a[mid] == key) {
                return mid;
            } else if (key > a[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return -1;

    }

    /**
     * @return the index where array is rotated
     */
    public static int findPivotIndex(int a[]) {

        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (mid < h && a[mid] > a[mid + 1]) {
                return mid;
            } else if (mid > l && a[mid - 1] > a[mid]) {
                return mid - 1;
            } else if (a[l] < a[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        int a[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(search(a, 3));
        System.out.println(findPivotIndex(a));
    }
}
