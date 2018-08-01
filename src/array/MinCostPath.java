package com.macquarie.shiner.batch.gcs.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinCostPath {

    public static int minCostPath(Integer path[][], int i, int j) {

        if (i >= path.length || j >= path.length) {
            return Integer.MAX_VALUE;
        }

        if (i == path.length - 1 && j == path.length - 1) {
            return path[i][j];
        }

        //return path[i][j] + Math.min(Math.min(minCostPath(path, i + 1, j), minCostPath(path, i, j + 1)), minCostPath(path, i + 1, j + 1));
        return path[i][j] + Math.min(minCostPath(path, i + 1, j), minCostPath(path, i, j + 1));

    }

    private static int minCostDP(Integer cost[][], int m, int n) {
        int i, j;
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];

        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
            /**tc[i][j] = Math.min(Math.min(tc[i - 1][j - 1],
             tc[i - 1][j]),
             tc[i][j - 1]) + cost[i][j];**/
                tc[i][j] = Math.min(
                        tc[i - 1][j],
                        tc[i][j - 1]) + cost[i][j];

        return tc[m][n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer[][]> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            Integer a[][] = new Integer[size][size];

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    a[j][k] = scanner.nextInt();
                }
            }

            inputs.add(a);
        }
        inputs.forEach(input -> System.out.println(minCostDP(input, 0, 0)));
    }


}
