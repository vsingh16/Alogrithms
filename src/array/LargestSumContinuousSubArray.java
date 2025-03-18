package array;

/**
 * Ref: https://www.youtube.com/watch?v=9IZYqostl2M&t=972s. Apna College
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * https://leetcode.com/problems/maximum-subarray/description/
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

/**
** Brute Force Approach: Explore all Possible Sub Array.
** Every Sub Array has start and end index.
** Time Complexity: O(n^3) 
** Space Complexity: O(1)
**/
class Solution {
    public int maxSubArray(int[] a) {
     int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) { //Start Index
            for (int j = i; j < a.length; j++) { //End Index
                int sum = 0;
                for (int k = i; k <= j; k++) { //Sum of Sub Array
                    sum = sum + a[k];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }

        return maxSum;
    }
}
==========================================================
/**
** Kadane's Algorithm.
** Sum all elements. If any point sum is <=0, reset sum=0 i.e discard the sub array giving us 0
** Below code can also handle case when all elements in array is -ve. As maxSum is only updated if sum is > maxSum
** Time Complexity: O(n) 
** Space Complexity: O(1)
**/

class Solution {
    public int maxSubArray(int[] a) {
   int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            maxSum = Math.max(maxSum, sum);
            if (sum <= 0) {
                sum = 0; //Discarding this sub array
            }
        }

        return maxSum;
    }
}
