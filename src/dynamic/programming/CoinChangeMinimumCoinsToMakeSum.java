/**
** https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
** https://leetcode.com/problems/coin-change/description/
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
 Time Complexity: O(coins^sum)
 Space: O(sum)
 public static int coinChange(int[] coins, int amount) {
	 
        //Base Case
        if (amount == 0) {
            return 0;
        }

        Integer minCoinsCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int coinsCount = coinChange(coins, amount - coins[i]);
                if (coinsCount >= 0) {
                    minCoinsCount = Math.min(minCoinsCount, 1 + coinsCount);
                }
            }
        }

        return (minCoinsCount == Integer.MAX_VALUE) ? -1 : minCoinsCount;
    }
================================================================================================================
	Top Down + Memorization
	class Solution {

	/** This is top down + memorisation. Fun calls and stack will look like same as bottomn up , just in reverse order.
  ** Hence time and space complexity is same as Bottom UP
  ** Time Complexity: O(Sum * Coin)
  ** Space Complexity: O(Sum)
  **/
class Solution {

    public static int coinChangeUtil(int[] coins, int amount, int dp[]) {

        //Base Case
        if (amount == 0) {
            return 0;
        } else if (dp[amount] != -10) { //Already Calculated, Since we also have -1 as result , therefore using -10
            return dp[amount];
        }

        Integer minCoinsCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int coinsCount = coinChangeUtil(coins, amount - coins[i], dp);
                if (coinsCount >= 0) {
                    minCoinsCount = Math.min(minCoinsCount, 1 + coinsCount);
                }
            }
        }

        dp[amount] = (minCoinsCount == Integer.MAX_VALUE) ? -1 : minCoinsCount;

        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount + 1];
        //Pre Initialize
        Arrays.fill(dp, -10);

        return coinChangeUtil(coins, amount, dp);

    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));


    }

}
=========================
Bottom Up

/**
** Time Complexity: O(Sum * Coin)
** Space Complexity: O(Sum)
**/
class Solution {

    public int coinChange(int[] coins, int totalAmount) {
    
        int dp[] = new int[totalAmount + 1];

        for (int amount = 0; amount < dp.length; amount++) { //Just opposite of recursion, copy past recurisve code

            //Base Case
            if (amount == 0) {
                dp[amount] = 0;
            } else {

                Integer minCoinsCount = Integer.MAX_VALUE;
                for (int i = 0; i < coins.length; i++) {
                    if (coins[i] <= amount) {
                         int coinsCount = dp[amount - coins[i]];
                        if (coinsCount >= 0) {
                            minCoinsCount = Math.min(minCoinsCount, 1 + coinsCount);
                        }
                    }
                }

                dp[amount] = (minCoinsCount == Integer.MAX_VALUE) ? -1 : minCoinsCount;
            }

        }

        return dp[totalAmount];
    }
}
=========================================
Q)Can we further Space Optiinized?
Ans)No, Becuase we are calculating result[sum] and this sum can be any value. Hence can take so many variables.

