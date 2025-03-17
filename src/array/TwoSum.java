/**
** Ref: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
** https://www.youtube.com/watch?v=_xqIp2rj8bo&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&index=11. Apna College
** Approach: Since Array is already sorted, we can use two pointer approach.
** l=0, h=a[length]-1;
** Sum them if sum == target sum, we have hit right ans
** if less, increase l else h

** If Array is not sorted, sort the array first.
**/

/**
** When Array is already Sorted.
** Time Complexity: O(n), Space : O(1)
**/
class Solution {
    public int[] twoSum(int[] a, int target) {
        int l = 0;
        int h = a.length - 1;
        while (l < h) {

            int sum = a[l] + a[h];
            if (sum == target) {
                break;
            } else if (sum < target) {
                l++;
            } else {
                h--;
            }

        }

        int result[] = {l + 1, h + 1};
        return result;
    }
}
