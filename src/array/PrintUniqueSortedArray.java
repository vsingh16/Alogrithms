package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 */
public class PrintUniqueSortedArray {

    public static void printUniqueSortedArray(int a[]) {
        int i = 0;
        while (i < a.length) {
            if (i == a.length - 1) {
                System.out.print(a[i] + " ");
                return;
            }
            int j = i + 1;
            while (a[i] == a[j]) {
                j++;
            }
            if (j == i + 1) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                i = j;
            }
        }
    }

    public static void main(String[] args) {

        int a[] = {1, 1, 2, 3, 3, 4};
        printUniqueSortedArray(a);

        System.out.println();
        int a1[] = {1, 1, 1, 2, 3, 3, 4};
        printUniqueSortedArray(a1);

        System.out.println();
        int a2[] = {1, 2, 2, 2, 2, 3, 3, 4};
        printUniqueSortedArray(a2);

    }
}
