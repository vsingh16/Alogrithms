package com.macquarie.shiner.batch.gcs.service;

/**
 * *
 * https://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDroppingPuzzle {

    //Time Complexity:O(2^k) exponential, at each floor we have two options
    public static int find(int n, int k) {

        //Base Case
        if (k == 0 || k == 1) {
            return k;
        }
        //if n == 1, we will start checking from floor 1 to k,so in worst case tries required
        if (n == 1) {
            return k;
        }

        /**
         * if egg breaks, try from lower floor egg not breaks
         * else skip all lower floors
         */
        Integer result = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            result = Math.min(result, Math.max(find(n - 1, i - 1), find(n, k - i)));
        }

        return result + 1;
    }

    //Time Complxity :O(n*k*k)
    //Space Complexity: O(n*k)
    public static int findDyn(int n, int k) {

        int res[][] = new int[n + 1][k + 1];

        //n == 1
        for (int i = 0; i <= k; i++) {
            res[1][i] = i;
        }

        //k == 1
        for (int i = 0; i <= n; i++) {
            res[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                res[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x <= j; x++) {
                    res[i][j] = Math.min(res[i][j], 1 + Math.max(res[i - 1][x - 1], res[i][j - x]));
                }

            }
        }

        //print result
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

        return res[n][k];
    }


    public static void main(String[] args) {

        System.out.println(findDyn(2, 36));


    }
}
