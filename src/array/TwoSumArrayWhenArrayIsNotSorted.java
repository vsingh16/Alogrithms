/**
** When Array is sorted, refer https://github.com/vsingh16/Alogrithms/blob/master/src/array/TwoSumWhenArrayIsSorted.java
** https://leetcode.com/problems/two-sum/description/
** https://www.youtube.com/watch?v=0Fxc_jKj2vo&t=1209s . Apna College
** Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


**/

Approach 1: Brute Force, generate all pairs.
Time Complexity : O(n^2)
Space Complexity : O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
            int resultIndexes[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    resultIndexes[0] = i;
                    resultIndexes[1] = j;
                }

            }
        }

        return resultIndexes;
    }
}
==========================================================
  Approach 2: Using Hashing
  We know a+b = target
  a we will generate a[i], that will give us different possible values of b
  We just need to check if b exists in array, if yes that is our pair.
  To save diffferent array elements and for quicker lookup we will use Hashmap

Time Complexity : O(n)
Space Complexity : O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
     Map<Integer, Integer> map = new HashMap<>(); //Value,Index
        int resultIndexes[] = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int b = target - nums[i];

            if (map.containsKey(b)) {
                resultIndexes[0] = i;
                resultIndexes[1] = map.get(b);
            } else {
                map.put(nums[i], i);
            }

        }

        return resultIndexes;
    }
}
