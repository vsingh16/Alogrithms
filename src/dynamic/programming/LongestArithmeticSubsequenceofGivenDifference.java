/**
** Ref: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
** https://www.youtube.com/watch?v=IOOFHFXenQU
** Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].


** Approach: Iterate through all indexes as AP can start from any element.
** Since diff is already given, find prev element by subtractving from a[i]
** Check if this number exist in map, length = 1 + map.get(temp) else length = 1
** Store length for all elements and also update max
** Time Complexity: O(n)
** Space Complexity: O(n)
**/

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int longestSubsequence(int[] a, int difference) {

        int max = 0;
        Map<Integer, Integer> longestSubsequenceMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int temp = a[i] - difference; //Since we are checking element on left side
            if (longestSubsequenceMap.containsKey(temp)) {
                longestSubsequenceMap.put(a[i], 1 + longestSubsequenceMap.get(temp));
            } else {
                longestSubsequenceMap.put(a[i], 1);
            }
            max = Math.max(max, longestSubsequenceMap.get(a[i]));
        }

        return max;

    }


    public static void main(String[] args) {
        int nums1[] = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println(longestSubsequence(nums1, -2));
    }
}
