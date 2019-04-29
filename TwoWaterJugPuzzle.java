package com.macquarie.shiner.batch.gcs.config;

/**
 * https://www.geeksforgeeks.org/two-water-jug-puzzle/
 *
 * Approach : find number of steps to pour water from m to n and vice versa.
 * Take minimum of above two
 *
 * When Pour water , if from jug becomes empty, fill it
 * if after pour to jug becomes full, empty its
 */
public class TwoWaterJugPuzzle {

    public static int pourWater(int fromCap, int toCap, int d) {

        int step = 1;//to fill from jug
        int from = fromCap;
        int to = 0;
        while (from != d && to != d) {

            //pour water from jug m to n
            int pourWater = Math.min(from, toCap - to);

            from = from - pourWater;
            to = to + pourWater;
            step++;

            if (from == d || to == d) {
                return step;
            }

            //if from jug is empty fill it
            if (from == 0) {
                from = fromCap;
                step++;
            }

            //if to jug is filled , empty it
            if (to == toCap) {
                to = 0;
                step++;
            }
        }

        return step;
    }

    public static int minSteps(int m, int n, int d) {

        if (d > n) {
            return -1;
        }

        if (d % gcd(m, n) != 0) {
            return -1;
        }

        return Math.min(pourWater(m, n, d), pourWater(n, m, d));
    }

    private static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        System.out.println(minSteps(3, 5, 4));
    }
}
