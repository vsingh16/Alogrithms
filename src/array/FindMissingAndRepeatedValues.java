/**
** Ref: https://leetcode.com/problems/find-missing-and-repeated-values/description/
** https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
** https://www.youtube.com/watch?v=0Fxc_jKj2vo&t=1321s Apna College
** You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

 

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].

** Approach:
**/


/**
** Appraoch 1: Using Maths.
** Two variables, we need two equations
** Time Complexity: O(n), Space: O(1)
**/
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
      int n = grid.length * grid[0].length;
        long sumOfGivenNumbers = Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
        long sumOfSquareOfGivenNumbers = Arrays.stream(grid).flatMapToInt(Arrays::stream).map(a -> a * a).sum();
        long sumOfN = (n * (n + 1)) / 2;
        long sumOfSquareOfN = (n * (n + 1) * (2 * n + 1)) / 6;
        //x = repeating, y=missing
        long xminusy = (sumOfGivenNumbers - sumOfN);
        long xplusy = (sumOfSquareOfGivenNumbers - sumOfSquareOfN) / (xminusy);

        long x = (xplusy + xminusy) / 2;
        long y = x - xminusy;

        int result[] = {(int)x, (int)y};

        return result;
    }
}

===========================================================================
/**
** Appraoch 2: Using Maths.
** With Set we can find repating number.
** Later using sum of n, we can find missing number
** Time Complexity: O(n), Space: O(n)
**/
public class Solution {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = rows * cols;

        HashSet<Integer> seen = new HashSet<>();
        int repeated = -1;
        int totalSum = 0;

        for (int[] row : grid) {
            for (int num : row) {
                if (seen.contains(num)) {
                    repeated = num;
                }
                seen.add(num);
                totalSum += num;
            }
        }

        int expectedSum = n * (n + 1) / 2;
        int missing = expectedSum - (totalSum - repeated);

        return new int[]{repeated, missing};
    }
}
