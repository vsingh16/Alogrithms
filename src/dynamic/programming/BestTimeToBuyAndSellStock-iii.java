/**
** Ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
** https://www.youtube.com/watch?v=NW7XRzg3smo&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=32
** You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 ** Approach: This is similar to BestTimeToBuyAndSellStock-ii.java
 ** Only catch is here we also need to keep a transaction count of 2.
**/

/**
** Recursion(Top Down Approach, as starting from Left 0th Index):
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/
class Solution {

    public static int maxProfit(int[] prices, int index, int canBuy, int transactionCount, int profit) {

        //Base Case
        if (transactionCount == 0 || index == prices.length) {
            return 0;
        }

        if (canBuy == 1) { //Buy
            int include = (profit - prices[index]) + maxProfit(prices, index + 1, 0, transactionCount, profit);
            int exclude = maxProfit(prices, index + 1, 1, transactionCount, profit);
            return Math.max(include, exclude);
        } else { //Sell
            //Update transaction count on sell
            int include = (profit + prices[index]) + maxProfit(prices, index + 1, 1, transactionCount - 1, profit);
            int exclude = maxProfit(prices, index + 1, 0, transactionCount, profit);
            return Math.max(include, exclude);
        }

    }

    public static int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 1, 2, 0);
    }

    public static void main(String[] args) {
        int nums1[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(nums1));
    }
}
==========================================================
/**
** Recursion(Bottom Up) + Memorization
** Time Complexity: O(n) //n*2*3, Since two is constant we can O(n)
** Space Complexity: O(n) //n*2*3, Since two is constant we can O(n)
**/
import java.util.Arrays;

class Solution {

    public static int maxProfit(int[] prices, int index, int canBuy, int transactionCount, int profit, int dp[][][]) {

        //Base Case
        if (transactionCount == 0 || index == prices.length) {
            return 0;
        } else if (dp[index][canBuy][transactionCount] != -1) { //Already Calculated
            return dp[index][canBuy][transactionCount];
        }

        if (canBuy == 1) { //Buy
            int include = (profit - prices[index]) + maxProfit(prices, index + 1, 0, transactionCount, profit, dp);
            int exclude = maxProfit(prices, index + 1, 1, transactionCount, profit, dp);
            dp[index][canBuy][transactionCount] = Math.max(include, exclude);
        } else { //Sell
            //Update transaction count on sell
            int include = (profit + prices[index]) + maxProfit(prices, index + 1, 1, transactionCount - 1, profit, dp);
            int exclude = maxProfit(prices, index + 1, 0, transactionCount, profit, dp);
            dp[index][canBuy][transactionCount] = Math.max(include, exclude);
        }

        return dp[index][canBuy][transactionCount];

    }

    public static int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3]; ////variables index, canBuy(0,1), transaction count(1,2)
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfit(prices, 0, 1, 2, 0, dp);
    }

    public static void main(String[] args) {
        int nums1[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(nums1));
    }
}
==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n) //n*2*3, Since two is constant we can O(n)
** Space Complexity: O(n) //n*2*3, Since two is constant we can O(n)
**/

class Solution {
    
    public static int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length + 1][2][3]; ////variables index, canBuy(0,1), transaction count(1,2) , prices.length+1 to handle array out of bound

        int profit = 0;
        for (int index = prices.length - 1; index >= 0; index--) { //index we started from 0 to n-1 in recursion, so here we will do reverse
            for (int canBuy = 0; canBuy <= 1; canBuy++) { //canBuy we started from 1 to 0 in recursion, so here we will do reverse
                for (int transactionCount = 1; transactionCount <= 2; transactionCount++) { //transactionCount we started from 2 to 0 in recursion, so here we will do reverse. Base Case transaction count =0 is 0,so skip
                    if (canBuy == 1) { //Buy
                        int include = (profit - prices[index]) + dp[index + 1][0][transactionCount];
                        int exclude = dp[index + 1][1][transactionCount];
                        dp[index][canBuy][transactionCount] = Math.max(include, exclude);
                    } else { //Sell
                        //Update transaction count on sell
                        int include = (profit + prices[index]) + dp[index + 1][1][transactionCount - 1];
                        int exclude = dp[index + 1][0][transactionCount];
                        dp[index][canBuy][transactionCount] = Math.max(include, exclude);
                    }
                }
            }

        }

        return dp[0][1][2];
    }

    public static void main(String[] args) {
        int nums1[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(nums1));
    }
}
=================================================
/**
** Space Optimized DP
** Time Complexity: O(n) //n*2*3, Since two is constant we can O(n)
** Space Complexity: O(1) Because of constant array size of 2 & 3
**/

class Solution {

    public static int maxProfit(int[] prices) {
        int prevDp[][] = new int[2][3]; ////variables index, canBuy(0,1), transaction count(1,2) , prices.length+1 to handle array out of bound
        int currentDp[][] = new int[2][3];

        int profit = 0;
        for (int index = prices.length - 1; index >= 0; index--) { //index we started from 0 to n-1 in recursion, so here we will do reverse
            for (int canBuy = 0; canBuy <= 1; canBuy++) { //canBuy we started from 1 to 0 in recursion, so here we will do reverse
                for (int transactionCount = 1; transactionCount <= 2; transactionCount++) { //transactionCount we started from 2 to 0 in recursion, so here we will do reverse. Base Case transaction count =0 is 0,so skip
                    if (canBuy == 1) { //Buy
                        int include = (profit - prices[index]) + prevDp[0][transactionCount];
                        int exclude = prevDp[1][transactionCount];
                        currentDp[canBuy][transactionCount] = Math.max(include, exclude);
                    } else { //Sell
                        //Update transaction count on sell
                        int include = (profit + prices[index]) + prevDp[1][transactionCount - 1];
                        int exclude = prevDp[0][transactionCount];
                        currentDp[canBuy][transactionCount] = Math.max(include, exclude);
                    }
                }
            }

            //Copy currentDp to Prev DP
            for (int i = 0; i < prevDp.length; i++) {
                for (int j = 0; j < prevDp[0].length; j++) {
                    prevDp[i][j] = currentDp[i][j];
                }
            }
        }

        return prevDp[1][2];
    }

    public static void main(String[] args) {
        int nums1[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(nums1));
    }
}
