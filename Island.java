package com.macquarie.shiner.batch.gcs.service;

/**
 * https://www.geeksforgeeks.org/find-number-of-islands/
 *
 * Help Tip:Leetcode video
 *
 * Connected Island:[i][j] = 1, then all its nearby 1 makes island i.e they are part of same island
 *
 * Approach:Simply traverse array, if at any index a[i][j] = 1, make all its 8 adjacent neighbours zero
 * as they are part of same island.
 *
 *
 */
public class Island {

    public static int countNumberOfIsland(int m[][]) {

        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    count++;
                    changeLandToWater(m, i, j);
                }
            }
        }

        return count;
    }

    private static void changeLandToWater(int m[][], int i, int j) {

        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] == 0) return;
        m[i][j] = 0;
        changeLandToWater(m, i, j + 1);
        changeLandToWater(m, i - 1, j);
        changeLandToWater(m, i - 1, j);
        changeLandToWater(m, i + 1, j);

        //diagonals
        changeLandToWater(m, i + 1, j + 1);
        changeLandToWater(m, i - 1, j - 1);
        changeLandToWater(m, i + 1, j - 1);
        changeLandToWater(m, i - 1, j + 1);

    }

    public static void main(String[] args) {

        int m[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
        System.out.println(countNumberOfIsland(m));
    }
}
