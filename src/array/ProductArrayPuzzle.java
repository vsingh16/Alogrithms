package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 *         <p>
 *         https://www.geeksforgeeks.org/a-product-array-puzzle/
 */
public class ProductArrayPuzzle {

    public static void main(String[] args) {

        int a[] = {10, 3, 5, 6, 2};
        int left[] = new int[a.length];
        int right[] = new int[a.length];

        left[0] = 1;
        right[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(left[i] * right[i] + " ");
        }
    }
}
