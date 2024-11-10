/**
** Ref:https://www.geeksforgeeks.org/combinational-sum/
** https://www.youtube.com/watch?v=Wct0mN2SCRQ&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=10

** Given an array of positive integers arr[] and an integer x, The task is to find all unique combinations in arr[] where the sum is equal to x. 
The same repeated number may be chosen from arr[] an unlimited number of times. Elements in a combination (a1, a2, …, ak) must be printed in non-descending order. (ie, a1 <= a2 <= … <= ak). If there is no combination possible print “Empty”.

Examples: 

Input: arr[] = 2, 4, 6, 8, x = 8
Output: 
[2, 2, 2, 2]
[2, 2, 4]
[2, 6]
[4, 4]
[8]
**/



/**
** Top Down(Recursion)
** Time Complexity: O(n^n)
** Space Complexity: O(n)
**/

class Solution {
    int combinationSum4(int[] a, int targetSum) {
        if (targetSum < 0) {
            return 0;
        } else if (targetSum == 0) {
            return 1;
        }

        int ways = 0;
        for (int i = 0; i < a.length; i++) {
            ways = ways + combinationSum4(a, targetSum - a[i]);
        }

        return ways;
    }
}
=====================================================================================
/**
** Top Down(Recursion) + Memorization
** Time Complexity: O(n)
** Space Complexity: O(capacity*val.length)
**/
class Solution {
    
     int combinationSum4(int[] a, int targetSum, int dp[]) {

        if (targetSum < 0) {
            return 0;
        } else if (targetSum == 0) {
            return 1;
        } else if (dp[targetSum] != -1) { // Already Calculated
            return dp[targetSum];
        }

        int ways = 0;
        for (int i = 0; i < a.length; i++) {
             ways = ways + combinationSum4(a, targetSum - a[i], dp);
        }

        dp[targetSum] = ways;

        return dp[targetSum];
    }

    
    int combinationSum4(int[] a, int targetSum) {
        int dp[] = new int[targetSum + 1];
        Arrays.fill(dp, -1);
        return combinationSum4(a, targetSum, dp);
    }
}

========================================================================================
/**
** Bottom Up DP
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity*val.length)
**/
class Solution {
    
     int combinationSum4(int[] a, int targetSum) {

      if (targetSum < 0) {
            return 0;
        } else if (targetSum == 0) {
            return 1;
        } else {

            int dp[] = new int[targetSum + 1];
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                int ways = 0;
                for (int j = 0; j < a.length; j++) {
                    if (a[j] <= i) {
                        ways = ways + dp[i - a[j]];
                    }
                }
                dp[i] = ways;
            }
            return dp[targetSum];
        }
    }

    
  
}
========================================================================================
/**
** Bottom Up DP + Space Optimized
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity)
**/
cant be done

