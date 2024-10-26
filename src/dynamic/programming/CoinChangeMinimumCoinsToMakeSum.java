/**
** https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
** https://www.youtube.com/watch?v=A3FHNCAkhxE&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=4&t=1633s. Love Babar Code Help
** Given an array coins[] of size N and a target value sum, where coins[i] represents the coins of different denominations.
** You have an infinite supply of each of coins. The task is to find minimum number of coins required to make the given value sum. 
** If it’s not possible to make a change, print -1.

Examples:  

Input: coins[] = {25, 10, 5}, sum = 30
Output: 2
Explanation : Minimum 2 coins needed, 25 and 5  


Input: coins[] = {9, 6, 5, 1}, sum = 19
Output: 3
Explanation: 19 = 9 + 9 + 1


Input: coins[] = {5, 1}, sum = 0
Output: 0
Explanation: For 0 sum, we do not need a coin


Input: coins[] = {4, 6, 2], sum = 5
Output: -1
Explanation: Not possible to make the given sum.
Approach: Idea is we can try all coins permuations.
Any coin resulting in -ve value, we cant take hence returnign -1
Since when solving recursive way, we release overlapping is happening, we can use DP.
Any DP problem we can solve, recursion, Top Down+Memorisation, Bottom Up
**/

 Recursive Approach
 Time Complexity: O(m^sum)
 Space: O(sum)
 public static int minCoins(int coins[], int M, int sum) {

        if (sum == 0) {
            return 0;
        } else if (sum < 0) {
            return -1;
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int result = minCoins(coins, M, sum - coins[i]);
            if (result >= 0) {
                min = Math.min(min, 1 + result);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
	=========================
	Top Down + Memorization
	class Solution {

	/** This is top down + memorisation. Fun calls and stack will look like same as bottomn up , just in reverse order.
  ** Hence time and space complexity is same as Bottom UP
  ** Time Complexity: O(Sum * Coin)
  ** Space Complexity: O(Sum)
  **/
    public int minCoins(int coins[], int M, int sum,int results[]) {
        if (sum == 0) {
            return 0;
        } else if (sum < 0) {
            return -1;
        } else if (results[sum] != -1) {
            return results[sum];
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int result = minCoins(coins, M, sum - coins[i], results);
            if (result >= 0) {
                min = Math.min(min, 1 + result);
            }
        }
        results[sum] = min == Integer.MAX_VALUE ? -1 : min;

        return results[sum];
    }
    
     public int minCoins(int coins[], int M, int sum) {

        int results[] = new int[sum + 1];
        for (int i = 0; i < results.length; i++) {
            results[i] = -1;
        }

        return minCoins(coins, M, sum, results);

    }
}
=========================
Bottom Up

/**
** Time Complexity: O(Sum * Coin)
** Space Complexity: O(Sum)
**/
class Solution {

    public static int minCoins(int coins[], int M, int sum) {

        if (sum == 0) {
            return 0;
        } else if (sum < 0) {
            return -1;
        }

        int results[] = new int[sum + 1];
        results[0] = 0;

        for (int i = 1; i < results.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int result = ((i - coins[j]) < 0) ? -1 : results[(i - coins[j])];
                if (result >= 0) {
                    min = Math.min(min, 1 + result);
                }
            }
            results[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return results[sum];

    }

    public static void main(String[] args) {
        int coins[] = {25, 10, 5};
        System.out.println(minCoins(coins, coins.length, 30));
    }
}
=========================================
Q)Can we further Space Optiinized?
Ans)No, Becuase we are calculating result[sum] and this sum can be any value. Hence can take so many variables.

