package com.macquarie.shiner.batch.gcs.tasklet;

import org.junit.Test;

/**
 *  Find first and last occurrnece of x element is sorted array
 * @author vsingh16
 */
public class FindFirstAndLast {

    /**
     * Time Complexity : O(n)
     */
    public static void findFirstAndLast(int a[], int x) {

        int first = -1, last = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                if (first < 0) {
                    first = i;
                }
                last = i;
            }
        }

        System.out.println("First " + first);
        System.out.println("Last " + last);

    }

    /**
     * Time Complexity : O(log n)
     */
    public static void findFirstAndLastBinary(int a[], int x) {

        System.out.println("First " + findFirst(a, x));
        System.out.println("Last " + findLast(a, x));

    }

    public static int findFirst(int a[], int x) {

        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;

            if ((mid == 0 && (x == a[mid])) || a[mid] == x && a[mid - 1] < x) {
                return mid;
            } else if (x <= a[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static int findLast(int a[], int x) {

        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if ((mid == a.length - 1 && x == a[mid]) || (a[mid] == x && a[mid + 1] > x)) {
                return mid;
            } else if (x >= a[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int a5[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int x = 1;
        System.out.println("Occurrence of 1");
        findFirstAndLast(a5, x);
        findFirstAndLastBinary(a5, x);

        int a6[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        x = 0;
        System.out.println("Occurrence of 0");
        findFirstAndLast(a5, x);
        findFirstAndLastBinary(a5, x);

        int a7[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        x = 2;
        System.out.println("Occurrence of 2");
        findFirstAndLast(a7, x);
        findFirstAndLastBinary(a7, x);

        int a1[] = {2, 2, 2, 2, 3, 4, 7, 8, 8};
        x = 2;
        System.out.println("Occurrence of 2");
        findFirstAndLast(a1, x);
        findFirstAndLastBinary(a1, x);

        int a4[] = {2, 2, 2, 2, 3, 4, 7, 8, 8};
        x = 3;
        System.out.println("Occurrence of 3");
        findFirstAndLast(a4, x);
        findFirstAndLastBinary(a4, x);

        int a3[] = {2, 2, 2, 2, 3, 4, 7, 8, 8};
        x = 2;
        System.out.println("Occurrence of 2");
        findFirstAndLast(a3, x);
        findFirstAndLastBinary(a3, x);

        int a10[] = {2, 2, 2, 2, 3, 4, 7, 8, 8};
        x = 8;
        System.out.println("Occurrence of 8");
        findFirstAndLast(a10, x);
        findFirstAndLastBinary(a10, x);

        int a2[] = {2, 2, 2, 2, 3, 4, 7, 8, 8};
        x = 9;
        System.out.println("Occurrence of 9");
        findFirstAndLast(a2, x);
        findFirstAndLastBinary(a2, x);

    }

    @Test
    public void test() {

        //int a = 1;
        char str = 'a' + 1;

        int a = 'a';
        System.out.println(a);
        System.out.println(str);

        char ch = (char)(97 + 1);
        System.out.println(ch);

    }
}
