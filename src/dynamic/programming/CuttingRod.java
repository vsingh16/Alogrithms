package dynamic.programming;

/**
** https://www.geeksforgeeks.org/maximize-the-number-of-segments-of-length-p-q-and-r/
**
Given a rod of length L, the task is to cut the rod in such a way that the total number of segments of length p, q, and r is maximized. The segments can only be of length p, q, and r. 

Examples: 

Input: l = 11, p = 2, q = 3, r = 5 
Output: 5 
Explanation: Segments of 2, 2, 2, 2 and 3



Input: l = 7, p = 2, q = 5, r = 5 
Output: 2 
Explanation: Segments of 2 and 5
** Ref: https://www.youtube.com/watch?v=MFAAZW2znv8&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=6&t=150s
** Approach: We can cut either x, y or z length and ans will be max of all of these.
**/
=================================================
Recursion
/**
** Time Complexity: O(3^n)
** Space Complexity: O(n)
**/
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
         if (n == 0) {
            return 0;
        } else if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int a = 1 + maximizeCuts(n - x, x, y, z);
        int b = 1 + maximizeCuts(n - y, x, y, z);
        int c = 1 + maximizeCuts(n - z, x, y, z);
        return Math.max(Math.max(a, b), c);
    }
}
=====================================================
Recusion + Memorisation

/**
** Time Complexity: O(n)
** Space Complexity: O(n)
**/
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int results[] = new int[n + 1];
        Arrays.fill(results, -1);
        int result = maximizeCuts(n, x, y, z, results);
        return result < 0 ? 0 : result; ////Return 0 if ans not possible
    }
    
     public int maximizeCuts(int n, int x, int y, int z, int results[]) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return Integer.MIN_VALUE;
        } else if (results[n] != -1) { // Already Calculated
            return results[n];
        }

        int a = maximizeCuts(n - x, x, y, z, results);
        int b = maximizeCuts(n - y, x, y, z, results);
        int c = maximizeCuts(n - z, x, y, z, results);

        a = (a == Integer.MIN_VALUE) ? Integer.MIN_VALUE : 1 + a; //Need to handle case when receiving -ve value as cant add 1 to it because -ve means already not possible.
        b = (b == Integer.MIN_VALUE) ? Integer.MIN_VALUE : 1 + b;
        c = (c == Integer.MIN_VALUE) ? Integer.MIN_VALUE : 1 + c;

        results[n] = Math.max(Math.max(a, b), c);
        return results[n];
    }
}
=====================================================
Top Down
/**
** Time Complexity: O(n)
** Space Complexity: O(n)
**/
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
      int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int a = ((i - x) >= 0 && dp[i - x] >= 0) ? 1 + dp[i - x] : Integer.MIN_VALUE; ////Need to handle case when receiving -ve value as cant add 1 to it because -ve means already not possible. ALso -ve array indexes
            int b = ((i - y) >= 0 && dp[i - y] >= 0) ? 1 + dp[i - y] : Integer.MIN_VALUE;
            int c = ((i - z) >= 0 && dp[i - z] >= 0) ? 1 + dp[i - z] : Integer.MIN_VALUE;
            dp[i] = Math.max(Math.max(a, b), c);
        }

        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n]; //Return 0 if ans not possible
    }
    
  
}


