/**
** https://leetcode.com/problems/4sum/
** Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
**/

class Solution {

  /**
  ** Approach 1: Have 4 loop
  ** We have sorted array first.
  ** inorder to prevent duplicate indexes , next nested loop is starting from +1
  ** Since array is sorted and if two adjacent indexes are same, we will skip that index . [2,2,2,2] sum = 8
  ** And if any point sum is greate than target we can break can come out of loop.
  ** TimeComplexity: O(nlongn + n4) = O(n^4)
  **/
  public List < List < Integer >> fourSum(int[] arr, int target) {
    List < List < Integer >> result = new ArrayList();
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = 0; i < n - 3; i++) {
      //if this arr[i] is same as previous one, skip
      if (i > 0 && arr[i - 1] == arr[i]) {
        continue;
      }
      for (int j = i + 1; j < n - 2; j++) {

        //if this arr[j] is same as previous one, skip
        if (j > i + 1 && arr[j - 1] == arr[j]) {
          continue;
        }

        for (int k = j + 1; k < n - 1; k++) {
          //if this arr[k] is same as previous one, skip
          if (k > j + 1 && arr[k - 1] == arr[k]) {
            continue;
          }

          for (int l = k + 1; l < n; l++) {
            //if this arr[l] is same as previous one, skip
            if (l > k + 1 && arr[l - 1] == arr[l]) {
              continue;
            }

            int sum = arr[i] + arr[j] + arr[k] + arr[l];
            if (sum == target) {
              List < Integer > list = List.of(arr[i], arr[j], arr[k], arr[l]);
              result.add(list);
              break;
            } else if (sum > target) {
              break;
            }
          }
        }
      }
    }
    return result;
  }
}
