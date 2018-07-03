package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 *
 * Shaktiman Hackerrank Problem
 * You need to find the initial power shaktiman should have
 * so he can survvie at the end.
 *
 * At any index, power is positive add else in case of negative, he will lose power
 * At any point if power becomes zero, he will die
 */
public class Shaktiman {

    private static int power(int[] power) {

        int pInitial = 0, pCurrent = 0;
        for (int i = 0; i < power.length; i++) {

            pCurrent = pCurrent + power[i];

            if (pCurrent < 0) {
                pInitial += Math.abs(pCurrent) + 1;
                pCurrent = 1;
            }

        }

        return pInitial;

    }

    public static void main(String[] args) {

        //int a[] = {-5, 4, -2, 3, 1, -1, -6, -1, 0, 5};
        //int a[] = {-5, 4, -2, 3, 1};
        int a[] = {-1};
        System.out.println(power(a));

    }
}
