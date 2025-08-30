/**
** https://leetcode.com/problems/3sum/description/
** Ref: https://www.youtube.com/watch?v=K-RsltkN63w Apna College
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 
**
** Approach 1: Brute Force Three Loops. Time Complexity :O(n^3), Space: O(1)
** Approach 2: Sorrt the array. Fix one pointer. Now find 2Sum().
** 2 Sum Ref: https://github.com/vsingh16/Alogrithms/blob/master/src/array/TwoSumWhenArrayIsSorted.java
** Time Complexity :O(n^2), Space: O(1)**
**/

class Solution
{
 public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicates for nums[i]. if nums[i] is same as nums[i-1] that means we have already calculated pairs for this. So to avoid duplicates skip this.
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            List<List<Integer>> twoSumResults = twoSum(nums, i + 1, nums.length - 1, 0 - nums[i]);
            for (List<Integer> twoSumResult : twoSumResults) {
                twoSumResult.add(nums[i]);
                result.add(twoSumResult);
            }
        }


        return result;
    }
    
    public static List<List<Integer>> twoSum(int a[], int l, int h, int k) {

        List<List<Integer>> result = new ArrayList<>();

        while (l < h) { //Because in question l!=h, hence only l<h not l<=h

            if (a[l] + a[h] == k) {
                List<Integer> twoSumPairs = new ArrayList<>();
                twoSumPairs.add(a[l]);
                twoSumPairs.add(a[h]);
                result.add(twoSumPairs);
                l++;
                h--;

                // Skip duplicates for a[l]. Similar to a[i], we can also avoid duplicates for a[l]. But this we will do once we have found result for a[l].
                //l<h as if this is the last element [l], we have already done l++ to avoid that l<h eg: {0,0,0}
                while (l < h && a[l] == a[l - 1]) {
                    l++;
                }
            } else if (a[l] + a[h] < k) { // Since the value is less, we need to increase move l
                l++;
            } else {
                h--; // Since higher, we need to decrease
            }

        }

        return result;

    }

}
