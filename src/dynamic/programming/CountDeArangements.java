/**
** Ref: https://www.geeksforgeeks.org/count-derangements-permutation-such-that-no-element-appears-in-its-original-position/
** Count Derangements (Permutation such that no element appears in its original position)
Last Updated : 20 Jul, 2022
A Derangement is a permutation of n elements, such that no element appears in its original position. For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.
Given a number n, find the total number of Derangements of a set of n elements.

Examples : 

Input: n = 2
Output: 1
For two elements say {0, 1}, there is only one 
possible derangement {1, 0}

Input: n = 3
Output: 2
For three elements say {0, 1, 2}, there are two 
possible derangements {2, 0, 1} and {1, 2, 0}

Input: n = 4
Output: 9
For four elements say {0, 1, 2, 3}, there are 9
possible derangements {1, 0, 3, 2} {1, 2, 3, 0}
{1, 3, 0, 2}, {2, 3, 0, 1}, {2, 0, 3, 1}, {2, 3,
1, 0}, {3, 0, 1, 2}, {3, 2, 0, 1} and {3, 2, 1, 0}
** https://www.youtube.com/watch?v=NW-BLDQHFXk&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=7
** Approach: We have n elements. Since we cant move element to its original poistion,
** we can move it to (n-1) positions.
** eg: Lets say first element is 0, we can move it to (n-1) places
** For every such move, we have two options
** We can swap element 0 and i positions. That means 2 elements are at their place we need to solve f(n-2)
** or we move element to ith position but ith element not at 0th place, some other index. In this case
** only one element is at its place and we need to find place for f(n-1)
** ans = (n-1) * (f(n-2) + f(n-1))
**/


/**
** Recusrion
** Time Complexity: O (2^n)
** Space Complexity: O(n)
**/
class Solution{
    private static int MOD = 1000000007;
    
    static long disarrange(int n){
         if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        return ((n - 1) % MOD) * ((disarrange(n - 2) % MOD) + (disarrange(n - 1) % MOD));
    }
}
===========================================
/**
* Top Down
* Recusrion + Memorization
* Time Complexity: O (n)
* Space Complexity: O(n)
**/

class Solution{
    private static int MOD = 1000000007;
    
    static long disarrange(int n, long dp[]) {

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (dp[n] != -1) { //Already Calculated
            return dp[n];
        }

        dp[n] = ((n - 1) % MOD) * ((disarrange(n - 2) % MOD) + (disarrange(n - 1) % MOD));
        return dp[n];
    }
    
    static long disarrange(int n){
        long dp[] = new long[n + 1];
        Arrays.fill(dp, -1);
        return disarrange(n, dp);
    }
    
    
}
===================================
/**
* Bottom Up
* DP
* Time Complexity: O (n)
* Space Complexity: O(n)
**/


static long disarrange(int n) {

        long dp[] = new long[n + 1];
         if (dp.length >= 2) {
            dp[1] = 0;
        }
        if (dp.length >= 3) {
            dp[2] = 1;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) % MOD) * ((dp[i - 2] % MOD) + (dp[i - 1] % MOD));
        }


        return dp[n]% MOD;
    }
==============================
/**
* Bottom Up + Space Optimized
* DP
* Time Complexity: O (n)
* Space Complexity: O(1)
**/

class Solution{
    private static int MOD = 1000000007;
    
    static long disarrange(int n) {

      if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }


        long prev2 = 0, prev1 = 1;
        long ans;
        for (long i = 3; i <= n; i++) {
            ans = (((i - 1) % MOD) * ((prev2 % MOD) + (prev1 % MOD)))%MOD;
            prev2 = prev1;
            prev1 = ans;
        }


        return prev1%MOD;
    }
    
}
