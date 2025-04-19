/**
** Ref: https://leetcode.com/problems/subsets-ii/description/
** https://www.youtube.com/watch?v=pNzljlzDCiI&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&index=45. Apna College

** Approach:
** Subset, we have two choices, either to include or exclude a number
** When we backtrack, remove element
** For duplicates, we need to sort array first.Then skip the next index until we find unique element.

** Time Complexity: O(2^n)
** Recursive Stack Space: O(n)
**/

class Solution {

     public static void subsetsWithDup(int[] nums, int i, List<Integer> tempResult, List<List<Integer>> finalResult) {

        //Base Case
        if (i == nums.length) {
            finalResult.add(List.copyOf(tempResult));
            return;
        }

        //Include
        tempResult.add(nums[i]);
        subsetsWithDup(nums, i + 1, tempResult, finalResult);
        //Backtracking, remove last added element
        tempResult.remove(tempResult.size() - 1);

        //Exclude. To Handle Duplicate we go to unique element in exclude        
        int nextIndex = i + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[i]) {
            nextIndex++;
        }
        subsetsWithDup(nums, nextIndex, tempResult, finalResult);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> tempResult = new ArrayList<>();
        List<List<Integer>> finalResult = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        subsetsWithDup(nums, 0, tempResult, finalResult);

        return finalResult;
    }
}
