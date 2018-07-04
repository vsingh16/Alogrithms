package com.macquarie.shiner.batch.gcs.processor;

public class SortedRotatedArraySearch {

    public static int search(int a[], int key) {

        int l = 0, h = a.length - 1;
        while (l <= h) {

            int mid = (l + h) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (key >= a[l]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;

    }

    /**
     * @return the index where array is roated
     */
    public static int findPivot(int a[]) {

        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (mid < h && a[mid] > a[mid + 1]) {
                return mid;
            } else if (l < mid && a[mid + 1] > a[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        int a[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        //System.out.println(search(a, 3));
        System.out.println(findPivot(a));
    }
}
