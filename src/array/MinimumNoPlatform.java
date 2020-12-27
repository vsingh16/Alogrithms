package com.vishal.hackerrank;

import java.util.Arrays;

/**
 * Created by vishal on 27-Dec-20.
 * <p>
 * Given arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop.
 */
public class MinimumNoPlatform {


    /**
     * Method 1: Naive Approach
     * <p>
     * Traverse array by two nested loops and lookk for overlapping tarins
     * Time Complexity : O(n^2)
     * Space Complexity :O(1)
     *
     * @return
     */
    public static int noOfPlatform(int arr[], int dept[]) {

        int maxPlatform = 1; //By default we need 1 platform
        for (int i = 0; i < arr.length; i++) {
            int platform = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= dept[i]) {
                    platform++;
                }
            }
            maxPlatform = Math.max(platform, maxPlatform);
        }

        return maxPlatform;
    }

    /**
     * Method 2: Sort arrival and departure array.
     * It becomes like merge sort.
     * Traverse two arrays. if event is arrival, platform ++
     * if departure , platform --
     * <p>
     * Time Complexity: O(nlogn) due to sorting
     */
    public static int noOfPlatform2(int arr[], int dept[]) {

        Arrays.sort(arr);
        Arrays.sort(dept);

        int i = 0;
        int j = 0;
        int platform = 0;
        int maxPlatform = 0;
        while (i < arr.length && j < dept.length) {
            if (arr[i] <= dept[j]) {
                platform++;
                maxPlatform = Math.max(platform, maxPlatform);
                i++;
            } else { //departure
                platform--;
                j++;
            }
        }

        return maxPlatform;
    }

    public static void main(String[] args) {
        int arr1[] = {900, 940, 950, 1100, 1500, 1800};
        int dep1[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(noOfPlatform(arr1, dep1));
        System.out.println(noOfPlatform2(arr1, dep1));
    }

}
