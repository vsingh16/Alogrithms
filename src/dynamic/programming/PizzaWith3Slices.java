/**
** Ref: https://leetcode.com/problems/pizza-with-3n-slices/description/
** https://www.youtube.com/watch?v=QZ9edJ0JCPw&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=21. Love Babbar
** There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:

You will pick any pizza slice.
Your friend Alice will pick the next slice in the anti-clockwise direction of your pick.
Your friend Bob will pick the next slice in the clockwise direction of your pick.
Repeat until there are no more slices of pizzas.
Given an integer array slices that represent the sizes of the pizza slices in a clockwise direction, return the maximum possible sum of slice sizes that you can pick.

 

Example 1:


Input: slices = [1,2,3,4,5,6]
Output: 10
Explanation: Pick pizza slice of size 4, Alice and Bob will pick slices with size 3 and 5 respectively. Then Pick slices with size 6, finally Alice and Bob will pick slice of size 2 and 1 respectively. Total = 4 + 6.
Example 2:


Input: slices = [8,9,8,6,1,1]
Output: 16
Explanation: Pick pizza slice of size 8 in each turn. If you pick slice with size 9 your partners will pick slices of size 8.

**/



class Solution {

    /**
     * Start Index and Last Index is traversal space
     */

    public static int maxSizeSlices(int[] slices, int startIndex, int endIndex, int k) {

        //Base Case
        if (k == 0 || startIndex > endIndex) {
            return 0;
        }

        int include = slices[startIndex] + maxSizeSlices(slices, startIndex + 2, endIndex, k - 1);
        int exclude = maxSizeSlices(slices, startIndex + 1, endIndex, k);

        return Math.max(include, exclude);

    }

    /**
     * Approach: This is recursive approach.
     * Either it will eat first slice or not.
     * When it eats first slice, start Index will be startIndex+2 as it cant eat next clockwise and end Index will be n-2 as it cant eat anticlockwise
     * When it skip first slice, start Index will be startIndex+1 as it cant eat next clockwise and end Index will be n-1 as it cant eat anticlockwise
     * We see that endIndex change will only happen first time, hence we have explicitly handled this.
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static int maxSizeSlices(int[] slices) {

        int n = slices.length;
        int k = slices.length / 3;

        //Case1 : When we eat 0th Index Slice
        int include = slices[0] + maxSizeSlices(slices, 2, n - 2, k - 1);

        //Case 2: When we skip 0th Index Slice
        int exclude = maxSizeSlices(slices, 1, n - 1, k);

        return Math.max(include, exclude);

    }


    public static void main(String[] args) {

        int slices[] = {8, 9, 8, 6, 1, 1};
        System.out.println(maxSizeSlices(slices));
    }
}

==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*k) 
** Space Complexity: O(n*k)
**/
import java.util.Arrays;

class Solution {

    /**
     * Start Index and Last Index is traversal space
     */

    public static int maxSizeSlicesMem(int[] slices, int startIndex, int endIndex, int k, int dp[][]) {

        //Base Case
        if (k == 0 || startIndex > endIndex) {
            return 0;
        } else if (dp[startIndex][k] != -1) { //Result is pre computed
            return dp[startIndex][k];
        }

        int include = slices[startIndex] + maxSizeSlicesMem(slices, startIndex + 2, endIndex, k - 1, dp);
        int exclude = maxSizeSlicesMem(slices, startIndex + 1, endIndex, k, dp);

        dp[startIndex][k] = Math.max(include, exclude);

        return dp[startIndex][k];

    }

    public static int maxSizeSlices(int[] slices) {

        int n = slices.length;
        int k = slices.length / 3;

        //Case1 : When we eat 0th Index Slice
        int includeDp[][] = new int[n + 1][k + 1];
        for (int i = 0; i < includeDp.length; i++) {
            Arrays.fill(includeDp[i], -1);
        }
        int include = slices[0] + maxSizeSlicesMem(slices, 2, n - 2, k - 1, includeDp);

        //Case 2: When we skip 0th Index Slice
        int excludeDp[][] = new int[n + 1][k + 1];
        for (int i = 0; i < includeDp.length; i++) {
            Arrays.fill(excludeDp[i], -1);
        }
        int exclude = maxSizeSlicesMem(slices, 1, n - 1, k, excludeDp);

        return Math.max(include, exclude);

    }


    public static void main(String[] args) {

        int slices[] = {8, 9, 8, 6, 1, 1};
        System.out.println(maxSizeSlices(slices));
    }
}
==========================================================
/**
** Bottom Up(Because Starting form last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n*k)
** Space Complexity: O(n*k) 
**/

class Solution {

    /**
     * Start Index and Last Index is traversal space
     */

    public static int maxSizeSlices(int[] slices, int startIndex, int endIndex, int k) {
        int n = slices.length;
        int dp[][] = new int[n + 2][k + 1];

        for (int i = endIndex; i >= startIndex; i--) { //Base case startIndex > endIndex, handled
            for (int j = k; j > 0; j--) { //Since k=0, returns 0, only running it till k=1

                int include = slices[i] + dp[i + 2][j - 1];
                int exclude = dp[i + 1][j];
                dp[i][j] = Math.max(include, exclude);
            }
        }

        return dp[startIndex][k];
    }

    public static int maxSizeSlices(int[] slices) {

        int n = slices.length;
        int k = slices.length / 3;

        //Case1 : When we eat 0th Index Slice
        int include = slices[0] + maxSizeSlices(slices, 2, n - 2, k - 1);
        //Case 2: When we skip 0th Index Slice
        int exclude = maxSizeSlices(slices, 1, n - 1, k);

        return Math.max(include, exclude);

    }


    public static void main(String[] args) {

        int slices[] = {1, 2, 3, 4, 5, 6};
        System.out.println(maxSizeSlices(slices));
    }
}
=================================================
/**
** Space Optimized DP
** Time Complexity: O(n*k)
** Space Complexity: O(k)
**/

class Solution {

public static int maxSizeSlices(int[] slices, int startIndex, int endIndex, int k) {
        
        int currentStartIndexDP[] = new int[k + 1];
        int prev1StartIndexDP[] = new int[k + 1];
        int prev2StartIndexDP[] = new int[k + 1];


        for (int i = endIndex; i >= startIndex; i--) { //Base case startIndex > endIndex, handled
            for (int j = k; j > 0; j--) { //Since k=0, returns 0, only running it till k=1

                int include = slices[i] + prev2StartIndexDP[j - 1];
                int exclude = prev1StartIndexDP[j];
                currentStartIndexDP[j] = Math.max(include, exclude);
            }

            prev2StartIndexDP = Arrays.copyOf(prev1StartIndexDP, k + 1);
            prev1StartIndexDP = Arrays.copyOf(currentStartIndexDP, k + 1);

        }

        return prev1StartIndexDP[k];
    }
    
 public static int maxSizeSlices(int[] slices) {

        int n = slices.length;
        int k = slices.length / 3;

        //Case1 : When we eat 0th Index Slice
        int include = slices[0] + maxSizeSlices(slices, 2, n - 2, k - 1);
        //Case 2: When we skip 0th Index Slice
        int exclude = maxSizeSlices(slices, 1, n - 1, k);

        return Math.max(include, exclude);

    }

}
