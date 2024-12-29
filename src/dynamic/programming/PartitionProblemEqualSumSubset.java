/**
** https://www.geeksforgeeks.org/partition-problem-dp-18/
** https://leetcode.com/problems/partition-equal-subset-sum/submissions/1474276868/
** https://www.youtube.com/watch?v=UGY7FMHt-M8&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=23&t=81s. Love Babbar
** Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same. 

Examples: 

arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.
** Approach : Find Sum of array.
** If sum is odd, we can't divide them equally return false.
** else find if subset is possible for sum/2 in given array. : https://github.com/vsingh16/Alogrithms/blob/master/src/dynamic/programming/CountSubsetWithGivenSum.java
**/

/**
** Recursion(TOp Down Approach, as starting from Left 0th Index):
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/
class Solution {

     static boolean isSusbset(int nums[], int index, int targetSum) {

        if (targetSum == 0) {
            return true;
        } else if (index == nums.length) {
            return false;
        }


        boolean include = false;
        if (nums[index] <= targetSum) {
            include = isSusbset(nums, index + 1, targetSum - nums[index]);
        }

        boolean exclude = isSusbset(nums, index + 1, targetSum);

        return include || exclude;

    }

    public boolean canPartition(int[] nums) {
           //Find Sum
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        } else {
            return isSusbset(nums, 0, sum / 2);
        }
    }
}
==========================================================
/**
** Recursion(Bottom Up) + Memorization
** Time Complexity: O(n * sum/2)
** Space Complexity: O(n * sum/2)
**/
class Solution {

    static boolean isSusbsetMem(int nums[], int index, int targetSum, int dp[][]) {

        if (targetSum == 0) {
            return true;
        } else if (index == nums.length) {
            return false;
        } else if (dp[index][targetSum] != -1) { //Already Calculated. 0 = false . 1 = true
            return dp[index][targetSum] == 1 ? true : false;
        }


        boolean include = false;
        if (nums[index] <= targetSum) {
            include = isSusbsetMem(nums, index + 1, targetSum - nums[index], dp);
        }

        boolean exclude = isSusbsetMem(nums, index + 1, targetSum, dp);

        boolean result = include || exclude;
        dp[index][targetSum] = result == true ? 1 : 0;
        return result;

    }


    public static boolean canPartition(int[] nums) {

        //Find Sum
        int sum = Arrays.stream(nums).sum();
        int dp[][] = new int[nums.length][(sum / 2) + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        if (sum % 2 != 0) {
            return false;
        } else {
            return isSusbsetMem(nums, 0, sum / 2, dp);
        }

    }


    public static void main(String[] args) {
        int nums[] = {1, 2, 5};
        System.out.println(canPartition(nums));
    }
}

==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabular Approach is just the opposite of recursion.
** This is the opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n*sum/2)
** Space Complexity: O(n*sum/2) 
**/

class Solution {

    static boolean isSusbset(int nums[], int targetSum) {

       boolean dp[][] = new boolean[nums.length + 1][targetSum + 2]; // nums.length + 1 to avoid Array out of Bound Index && targetSum + 2, +1 as sum/2 we need array index +1, +1 for Array out of Bound Index
        for (int index = nums.length - 1; index >= 0; index--) { //Recursion: index = 0 to nums.length - 1
            for (int sum = 0; sum <= targetSum; sum++) { //Recursion: sum = targetSum to 0

                //Base Case
                if (sum == 0) {
                    dp[index][sum] = true;
                } else if (index == nums.length) {
                    dp[index][sum] = false;
                } else {

                    boolean include = false;
                    if (nums[index] <= sum) {
                        include = dp[index + 1][sum - nums[index]];
                    }

                    boolean exclude = dp[index + 1][sum];

                    boolean result = include || exclude;
                    dp[index][sum] = result;

                }

            }
        }


        return dp[0][targetSum]; //Recursion isSusbset(nums, 0, sum / 2)

    }

    public static boolean canPartition(int[] nums) {

        //Find Sum
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        } else {
            return isSusbset(nums, sum / 2);
        }

    }


    public static void main(String[] args) {
        int nums[] = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}

=================================================
/**
** Space Optimized DP
** Time Complexity: O(n*sum/2)
** Space Complexity: O(sum/2) 
**/

import java.util.Arrays;

class Solution {

    static boolean isSusbset(int nums[], int targetSum) {

        boolean currentDp[] = new boolean[targetSum + 1]; // +1 to handle Array out of bound
        boolean previousDp[] = new boolean[targetSum + 1]; // +1 to handle Array out of bound

        //Base Case Handling
        for (int i = 0; i < nums.length; i++) {
            previousDp[0] = true;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int sum = targetSum; sum > 0; sum--) { //Since sum=0, already calculated

                boolean include = false;
                if (nums[i] <= sum) {
                    include = previousDp[sum - nums[i]];
                }

                boolean exclude = previousDp[sum];
                currentDp[sum] = include || exclude;

            }
            previousDp = Arrays.copyOf(currentDp, currentDp.length);
        }

        return previousDp[targetSum];

    }

    public static boolean canPartition(int[] nums) {

        //Find Sum
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        } else {
            return isSusbset(nums, sum / 2);
        }

    }


    public static void main(String[] args) {
        int nums[] = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
