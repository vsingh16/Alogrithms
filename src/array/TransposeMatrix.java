package com.macquarie.shiner.batch.gcs.config;


/**
 * https://www.geeksforgeeks.org/program-to-find-transpose-of-a-matrix/
 */
public class TransposeMatrix {

    public static int[][] transpose(int a[][]) {

        int m = a.length;
        int n = a[0].length;

        int b[][] = new int[n][m];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = a[j][i];
            }
        }

        return b;
    }

    public static void main(String[] args) {

        int A[][] = {{1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3}};

        int b[][] = transpose(A);

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
