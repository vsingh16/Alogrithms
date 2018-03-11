package dynamic.programming;

/**
 * Created by vishal on 11-Mar-18.
 * <p>
 * Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].
 * <p>
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 */
public class MaxDifference {

    /**
     * Method 1: Use two loops, to calculate diff of each element in outer loop with each element in inner loop and
     * compare the maxDiff
     * <p>
     * Time Complexity:O(n*n)
     * Space:O(1)
     */
    public static int maxDiff(int a[]) {

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int diff = a[j] - a[i];
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }

    /**
     * Method 2: if we can store the min_found_so_far , then we dont need to compare the new element in iteration with
     * all the element on its left side but with the min_found_so_far only.
     * Time Complexity:O(n)
     * Space Complexity:O(1)
     */
    public static int maxDiffTricky(int a[]) {

        int minSoFar = a[0];
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 1; i < a.length; i++) {

            int diff = a[i] - minSoFar;
            if (diff > maxDiff) {
                maxDiff = diff;
            }

            if (a[i] < minSoFar) {
                minSoFar = a[i];
            }
        }

        return maxDiff;
    }

    /**
     * Method 3: First find the difference between the adjacent elements of the array and store all differences
     * in an auxiliary array diff[] of size n-1. Now this problems turns into finding the
     * maximum sum subarray of this difference array.
     * <p>
     * Time Complexity:O(n)
     * Space Complexity : O(n)
     */
    public static int maxDiffWithSum(int a[]) {

        int diff[] = new int[a.length];
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            diff[i] = a[i] - a[i - 1];
        }

        for (int i = 1; i < a.length; i++) {

            if (diff[i - 1] > 0) {
                diff[i] = diff[i] + diff[i - 1];
            }
            if (diff[i] > maxDiff) {
                maxDiff = diff[i];
            }

        }

        return maxDiff;
    }

    /**
     * Method 4: Improved version of Method 3.
     * If we calculate diff and do sum together in iteration itself, don't need array to hold values
     * and hence space complexity can be reduced to O(1)
     *
     * Time Complexity:O(n)
     * Space Complexity : O(1)
     */
    public static int maxDiffWithSumImproved(int a[]) {

        int sum = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            int diff = a[i] - a[i - 1];
            if (diff < 0) {
                sum = 0;
            } else {
                sum = sum + diff;
            }
            if (sum > maxDiff) {
                maxDiff = sum;
            }
        }

        return maxDiff;
    }


    public static void main(String[] args) {

        int a[] = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDiff(a));//8
        System.out.println(maxDiffTricky(a));//8
        System.out.println(maxDiffWithSum(a));//8
        System.out.println(maxDiffWithSumImproved(a));//8

    }
}
