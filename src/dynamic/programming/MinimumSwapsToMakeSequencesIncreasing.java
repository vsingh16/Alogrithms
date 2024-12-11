/**
** Ref: https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
** https://www.youtube.com/watch?v=IeT9Qz_vqHo&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=23&t=2228s
** You are given two integer arrays of the same length nums1 and nums2. In one operation, you are allowed to swap nums1[i] with nums2[i].

For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8].
Return the minimum number of needed operations to make nums1 and nums2 strictly increasing. The test cases are generated so that the given input always makes it possible.

An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1].

 

Example 1:

Input: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
Output: 1
Explanation: 
Swap nums1[3] and nums2[3]. Then the sequences are:
nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
which are both strictly increasing.
Example 2:

Input: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
Output: 1

Approach:
We can start from the starting index.
At every index, we have the  option to swap or not.
We need to take min of both.
If an order is strictly increasing, there is no need to swap
If n2 > left1 && n1 > left2, we can swap //Cross Check, as after swap this will be their positions
Since we are not swapping items in array, as we just need count, we will have a swap flag to track this
if swap flag is true, we will swap left 1 and left 2

**/

/**
** Recursion(TOp Down Approach, as starting from Left 0th Index):
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/
class Solution {

        public int minSwap(int[] nums1, int[] nums2, int i, boolean swap) {


        //Base Case
        if (i == nums1.length) {
            return 0;
        }

        int left1 = nums1[i - 1];
        int n1 = nums1[i];

        int left2 = nums2[i - 1];
        int n2 = nums2[i];

        if (swap) {
            //swap left1 and left2
            int temp = left1;
            left1 = left2;
            left2 = temp;
        }

        int noSwapCount = Integer.MAX_VALUE;
        int swapCount = Integer.MAX_VALUE;
        if (left1 < n1 && left2 < n2) { //No Swaps
            noSwapCount = minSwap(nums1, nums2, i + 1, false);
        }

        if (n1 > left2 && n2 > left1) { //Swap
            swapCount = 1 + minSwap(nums1, nums2, i + 1, true);
        }

        return Math.min(noSwapCount, swapCount);
            }

    public int minSwap(int[] nums1, int[] nums2) {
         //Append -1 to Beginning of num1 and nums2
        int newNums1[] = new int[nums1.length + 1];
        newNums1[0] = -1;
        System.arraycopy(nums1, 0, newNums1, 1, nums1.length);

        //Append -1 to Beginning of num1 and nums2
        int newNums2[] = new int[nums2.length + 1];
        newNums2[0] = -1;
        System.arraycopy(nums2, 0, newNums2, 1, nums2.length);

        return minSwap(newNums1, newNums2, 1, false);
    }
}
==========================================================
/**
** Recursion(Bottom Up) + Memorization
** Time Complexity: O(n) Array length
** Space Complexity: O(n) Because of constant array size of 2
**/
import java.util.Arrays;

class Solution {

    public static int minSwap(int[] nums1, int[] nums2, int i, int swap, int dp[][]) {

        //Base Case
        if (i == nums1.length) {
            return 0;
        } else if (dp[i][swap] != -1) { //Already Calculated
            return dp[i][swap];

        }

        int left1 = nums1[i - 1];
        int n1 = nums1[i];

        int left2 = nums2[i - 1];
        int n2 = nums2[i];

        if (swap == 1) {
            //swap left1 and left2
            int temp = left1;
            left1 = left2;
            left2 = temp;
        }

        int noSwapCount = Integer.MAX_VALUE;
        int swapCount = Integer.MAX_VALUE;
        if (left1 < n1 && left2 < n2) { //No Swaps
            noSwapCount = minSwap(nums1, nums2, i + 1, 0, dp);
        }

        if (n1 > left2 && n2 > left1) { //Swap
            swapCount = 1 + minSwap(nums1, nums2, i + 1, 1, dp);
        }


        dp[i][swap] = Math.min(noSwapCount, swapCount);

        return dp[i][swap];

    }


    public static int minSwap(int[] nums1, int[] nums2) {

        //Append -1 to Beginning of num1 and nums2
        int newNums1[] = new int[nums1.length + 1];
        newNums1[0] = -1;
        System.arraycopy(nums1, 0, newNums1, 1, nums1.length);

        //Append -1 to Beginning of num1 and nums2
        int newNums2[] = new int[nums2.length + 1];
        newNums2[0] = -1;
        System.arraycopy(nums2, 0, newNums2, 1, nums2.length);

        int dp[][] = new int[newNums1.length][2];
        for (int i = 0; i < newNums1.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minSwap(newNums1, newNums2, 1, 0, dp);
    }

    public static void main(String[] args) {
        int nums1[] = {0, 4, 4, 5, 9};
        int nums2[] = {0, 1, 6, 8, 10};
        System.out.println(minSwap(nums1, nums2));
    }
}
==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n) Array length
** Space Complexity: O(n) Because of constant array size of 2
**/

class Solution {

    public static int minSwap(int[] nums1, int[] nums2) {

        //Append -1 to Beginning of num1 and nums2
        int newNums1[] = new int[nums1.length + 1];
        newNums1[0] = -1;
        System.arraycopy(nums1, 0, newNums1, 1, nums1.length);

        //Append -1 to Beginning of num1 and nums2
        int newNums2[] = new int[nums2.length + 1];
        newNums2[0] = -1;
        System.arraycopy(nums2, 0, newNums2, 1, nums2.length);


        return minSwapTab(newNums1, newNums2);

    }

    private static int minSwapTab(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length + 1][2]; //nums1.length + 1 to handle Array Out of Bound Index

        for (int i = nums1.length - 1; i >= 1; i--) { // Recursion , 1 to n, so here n-1 to 1
            for (int swap = 1; swap >= 0; swap--) { //Recursion Swap 0 to 1, here 1 to 0

                int left1 = nums1[i - 1];
                int n1 = nums1[i];

                int left2 = nums2[i - 1];
                int n2 = nums2[i];

                if (swap == 1) {
                    //swap left1 and left2
                    int temp = left1;
                    left1 = left2;
                    left2 = temp;
                }

                int noSwapCount = Integer.MAX_VALUE;
                int swapCount = Integer.MAX_VALUE;
                if (left1 < n1 && left2 < n2) { //No Swaps
                    noSwapCount = dp[i + 1][0];
                }

                if (n1 > left2 && n2 > left1) { //Swap
                    swapCount = 1 + dp[i + 1][1];
                }

                dp[i][swap] = Math.min(noSwapCount, swapCount);
            }

        }


        return dp[1][0]; //As in recursion we started from (1,0)
    }

    public static void main(String[] args) {
        int nums1[] = {0, 4, 4, 5, 9};
        int nums2[] = {0, 1, 6, 8, 10};
        System.out.println(minSwap(nums1, nums2));
    }
}

=================================================
/**
** Space Optimized DP
** Time Complexity: O(n) Array length
** Space Complexity: O(1) Because of constant array size of 2
**/

import java.util.Arrays;

class Solution {

    public static int minSwap(int[] nums1, int[] nums2) {

        //Append -1 to Beginning of num1 and nums2
        int newNums1[] = new int[nums1.length + 1];
        newNums1[0] = -1;
        System.arraycopy(nums1, 0, newNums1, 1, nums1.length);

        //Append -1 to Beginning of num1 and nums2
        int newNums2[] = new int[nums2.length + 1];
        newNums2[0] = -1;
        System.arraycopy(nums2, 0, newNums2, 1, nums2.length);


        return minSwapTab(newNums1, newNums2);

    }

    private static int minSwapTab(int[] nums1, int[] nums2) {
        int prevDp[] = new int[2]; //nums1.length + 1 to handle Array Out of Bound Index
        int currentDp[] = new int[2]; //nums1.length + 1 to handle Array Out of Bound Index

        for (int i = nums1.length - 1; i >= 1; i--) { // Recursion , 1 to n, so here n-1 to 1
            for (int swap = 1; swap >= 0; swap--) { //Recursion Swap 0 to 1, here 1 to 0

                int left1 = nums1[i - 1];
                int n1 = nums1[i];

                int left2 = nums2[i - 1];
                int n2 = nums2[i];

                if (swap == 1) {
                    //swap left1 and left2
                    int temp = left1;
                    left1 = left2;
                    left2 = temp;
                }

                int noSwapCount = Integer.MAX_VALUE;
                int swapCount = Integer.MAX_VALUE;
                if (left1 < n1 && left2 < n2) { //No Swaps
                    noSwapCount = prevDp[0];
                }

                if (n1 > left2 && n2 > left1) { //Swap
                    swapCount = 1 + prevDp[1];
                }

                currentDp[swap] = Math.min(noSwapCount, swapCount);
            }

            prevDp = Arrays.copyOf(currentDp, currentDp.length);

        }


        return prevDp[0]; //As in recursion we started from (1,0)
    }

    public static void main(String[] args) {
        int nums1[] = {0, 4, 4, 5, 9};
        int nums2[] = {0, 1, 6, 8, 10};
        System.out.println(minSwap(nums1, nums2));
    }
}
