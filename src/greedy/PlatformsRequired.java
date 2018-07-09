package greedy;

import java.util.Arrays;

/**
 * Created by vishal on 09-Jul-18.
 */
public class PlatformsRequired {

    /**
     * Naive Approach , check for all overlapping time intervals
     */
    public static int findPlatform(int arr[], int dept[]) {

        int platform, max = 1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            platform = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] <= dept[i]) {
                    platform++;
                    max = Math.max(max, platform);
                }

            }
        }

        return max;
    }

    /**
     * Approach: sort events in ascending order,
     * Then on arrival increment platform and on departure decrement
     */
    public static int findPlatformGreedy(int arr[], int dept[]) {

        Arrays.sort(arr);
        Arrays.sort(dept);

        int l = 0, h = 0;
        int platform = 0, max = 0;
        while (l < arr.length && h < arr.length) {

            if (arr[l] <= dept[h]) {
                platform++;
                l++;
                max = Math.max(max, platform);
            } else {
                platform--;
                h++;
            }

        }

        return max;
    }


    public static void main(String[] args) {

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep));
        System.out.println(findPlatformGreedy(arr,dep));
    }
}
