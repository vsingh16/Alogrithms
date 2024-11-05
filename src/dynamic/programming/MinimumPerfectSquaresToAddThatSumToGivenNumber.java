/**
** Minimum perfect squares to add that sum to given number.
** A number can always be represented as a sum of squares of other numbers. Note that 1 is a square and we can always break a number as (1*1 + 1*1 + 1*1 + …). Given a number n, find the minimum number of squares that sum to X.

Examples : 


Input:  n = 100
Output: 1
Explanation:
100 can be written as 102. Note that 100 can also be written as 52 + 52 + 52 + 52, but this representation requires 4 squares.


Input:  n = 6
Output: 3

Approach: We need to explore all numbers tarting from 1 to n.
We can skip i*i>n as those will exceed.

https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
https://www.youtube.com/watch?v=aJTCcyPrPOA . Love Babbar DP Series
**/

/**
** Top Down(Recursion)
** Time Complexity: O(sqrt(n)^n)
** Space Complexity: O(n)
**/
class Solution {

    public static int MinSquares(int n) {

        //Base Case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + MinSquares(n - (i * i)));
        }

        return min;
    }
    
}
=====================================================
/**
** Top Down(Recursion) + Memorization
** Time Complexity: O(n * sqrt(n))
** Space Complexity: O(n)
**/
class Solution {
    
    public  int MinSquares(int n, int dp[]) {

        //Base Case
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (dp[n] != -1) { //Already Calculated
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + MinSquares(n - (i * i), dp));
        }

        dp[n] = min;
        return dp[n];
    }
    
    public int MinSquares(int n) {
       int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return MinSquares(n, dp);
    }
}
=====================================================
/**
** Bottom Up DP
** Time Complexity: O(n* sqrt(n))
** Space Complexity: O(n)
**/
class Solution {
    
    public static int MinSquares(int n) {


        //Base Case
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int dp[] = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, 1 + dp[i - (j * j)]); //min = Math.min(min, 1 + MinSquares(n - (j * j), dp));
                }
                dp[i] = min;
            }

            return dp[n];
        }

    }
}	
