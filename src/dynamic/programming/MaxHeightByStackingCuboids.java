/**
** Ref: https://leetcode.com/problems/maximum-height-by-stacking-cuboids/description/
** https://www.youtube.com/watch?v=Ntzuz7XsdCI. Love Babbar
** Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed). Choose a subset of cuboids and place them on each other.

You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

Return the maximum height of the stacked cuboids.

 

Example 1:



Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
Output: 190
Explanation:
Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
Cuboid 0 is placed next with the 45x20 side facing down with height 50.
Cuboid 2 is placed next with the 23x12 side facing down with height 45.
The total height is 95 + 50 + 45 = 190.
Example 2:

Input: cuboids = [[38,25,45],[76,35,3]]
Output: 76
Explanation:
You can't place any of the cuboids on the other.
We choose cuboid 1 and rotate it so that the 35x3 side is facing down and its height is 76.
Example 3:

Input: cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
Output: 102
Explanation:
After rearranging the cuboids, you can see that all cuboids have the same dimension.
You can place the 11x7 side down on all cuboids so their heights are 17.
The maximum height of stacked cuboids is 6 * 17 = 102.
** Approach:
** Since we can rearrange any cuboid's dimensions by rotating it to put it on another cuboid. Sort a cube by its dimension
** Next we can sort cuboids by their width, length and height
** Next we can apply longest increasing subsequence with fe changes.
** Change 1: When deciding that a next element can come or not, we can compare cuboids all dimensions
** Change 2: Rather than + 1 for length we can add height of cuboid picked up.
** Ref: Longest Increasing SubSequence https://github.com/vsingh16/Alogrithms/blob/master/src/dynamic/programming/LongestIncreasingSubSequence.java
** Time Complexity: O(n^2)
** Space Complexity: O(n^2)

**/

class Solution {
    
    public static int maxHeight(int[][] cuboids) {
        //Since we can rearrange any cuboid's dimensions by rotating it to put it on another cuboid. Sort a cube by its dimension
        for (int i = 0; i < cuboids.length; i++) {
            Arrays.sort(cuboids[i]);
        }

        //Sort all cuboids based on their dimensions
        Arrays.sort(cuboids, (c1, c2) -> {

            if (c1[0] != c2[0]) { //width
                return c1[0] - c2[0];
            } else if (c1[1] != c2[1]) { //height
                return c1[1] - c2[1];
            } else {
                return c1[2] - c2[2];
            }
        });

        return longestSubsequenceCuboid(cuboids);

    }

    public static int longestSubsequenceCuboid(int[][] cuboids) {
        int n = cuboids.length;
        int dp[][] = new int[n + 1][n + 1]; // required in dp[n][n] but wer have ref currentIndex + 1 or indexOfLastElementInSubsequence + 1. To Handle this dp[n+1][n+1]. Base case is already handle to be 0
        for (int currentIndex = n - 1; currentIndex >= 0; currentIndex--) {
            for (int indexOfLastElementInSubsequence = currentIndex - 1; indexOfLastElementInSubsequence >= -1; indexOfLastElementInSubsequence--) {

                int include = 0;
                if (indexOfLastElementInSubsequence == -1 || (cuboids[indexOfLastElementInSubsequence][0] <= cuboids[currentIndex][0]
                        && cuboids[indexOfLastElementInSubsequence][1] <= cuboids[currentIndex][1]
                        && cuboids[indexOfLastElementInSubsequence][2] <= cuboids[currentIndex][2])) { //Change 1. Compare All Dimensions
                  //Change 2 cuboids[currentIndex][2] . Height
                    include = cuboids[currentIndex][2] + dp[currentIndex + 1][currentIndex + 1]; //The dp[][] table's columns are indexed by indexOfLastElementInSubsequence + 1, Hence in dp column we need to + 1
                }

                int exclude = dp[currentIndex + 1][indexOfLastElementInSubsequence + 1]; //Since -1 is not a valid index , handled by +1

                dp[currentIndex][indexOfLastElementInSubsequence + 1] = Math.max(include, exclude);

            }

        }

        return dp[0][0]; //dp[0][-1] but -1 is not valid index hence -1 +1
    }


    public static void main(String[] args) {

        //int cuboids[][] = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        int cuboids[][] = {{38, 25, 45}, {76, 35, 3}};
        System.out.println(maxHeight(cuboids));
    }
}

  
