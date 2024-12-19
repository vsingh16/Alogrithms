/**
** Ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
** https://www.youtube.com/watch?v=dlKGCNVel6A&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=31. Love Babbar
**
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

** Approach: Since we can do multiple buy and sell, we have to explore all combinations
** We can start from 0th index.
** We have two options either to skip or buy
** when we buy, we can substract this from our profit as we are spending money. 
** Also since we have buy, next time we can only sell, so make canBuy flag false
** If we skip the buy, no chnages to profit and canBuy flag remains true

** Similarly if canBuy flag is false, means we need to sell
** We have two options either to skip or sell
** when we sell, we add this to our profit as we gain money. 
** Also since we have sold, next time we can only buy, so make canBuy flag true
** If we skip the sell, no chnages to profit and canBuy flag remains false
**/

/**
** Recursion(Top Down Approach, as starting from Left 0th Index):
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/
class Solution {

    public static int maxProfit(int[] prices, int i, boolean canBuy, int profit) {

        //Base Case
        if (i == prices.length) {
            return 0;
        }

        if (canBuy) {

            int exclude = maxProfit(prices, i + 1, true, profit);
            int include = (profit - prices[i]) + maxProfit(prices, i + 1, false, profit);
            return Math.max(exclude, include);

        } else { //sell
            int exclude = maxProfit(prices, i + 1, false, profit);
            int include = (profit + prices[i]) + maxProfit(prices, i + 1, true, profit);
            return Math.max(exclude, include);
        }


    }

    public static int maxProfit(int[] prices) {

        return maxProfit(prices, 0, true, 0);
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(nums1));
    }
}
==========================================================
/**
** Recursion(Bottom Up) + Memorization
** Time Complexity: O(n) //n*2, Since two is constant we can O(n)
** Space Complexity: O(n) //n*2, Since two is constant we can O(n)
**/
import java.util.Arrays;

class Solution {

    public static int maxProfit(int[] prices, int i, int canBuy, int profit, int dp[][]) {

        //Base Case
        if (i == prices.length) {
            return 0;
        } else if (dp[i][canBuy] != -1) { //Already Calculated
            return dp[i][canBuy];
        }

        if (canBuy == 1) { //Buy Case

            int exclude = maxProfit(prices, i + 1, 1, profit, dp);
            int include = (profit - prices[i]) + maxProfit(prices, i + 1, 0, profit, dp);
            dp[i][canBuy] = Math.max(exclude, include);

        } else { //sell
            int exclude = maxProfit(prices, i + 1, 0, profit, dp);
            int include = (profit + prices[i]) + maxProfit(prices, i + 1, 1, profit, dp);
            dp[i][canBuy] = Math.max(exclude, include);
        }


        return dp[i][canBuy];
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2]; //variables changing index, canBuy flag
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxProfit(prices, 0, 1, 0, dp);
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(nums1));
    }
}==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n) //n*2, Since two is constant we can O(n)
** Space Complexity: O(n) //n*2, Since two is constant we can O(n)
**/

import java.util.Arrays;

class Solution {

    public static int maxProfitTab(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2]; //variables changing index n+1 to handle array out of bound index, canBuy flag

        //Recursion index started from 0 to n-1 , tab opposite n-1 to 0
        //Recursion canBuy 0 to 1 , tab opposite 1 to 0

        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                if (canBuy == 1) { //Buy Case

                    int exclude = dp[i + 1][1];
                    int include = (profit - prices[i]) + dp[i + 1][0];
                    dp[i][canBuy] = Math.max(exclude, include);

                } else { //sell
                    int exclude = dp[i + 1][0];
                    int include = (profit + prices[i]) + dp[i + 1][1];
                    dp[i][canBuy] = Math.max(exclude, include);
                }
            }

        }

        return dp[0][1];// Recursion we were returning index 0 and canBuy true for final ans
    }

    public static void main(String[] args) {
        int nums1[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitTab(nums1));
    }
}
=================================================
/**
** Space Optimized DP
** Time Complexity: O(n) //n*2, Since two is constant we can O(n)
** Space Complexity: O(1) Because of constant array size of 2
**/

import java.util.Arrays;

class Solution {

    public static int maxProfitTab(int[] prices) {
        int n = prices.length;
        int prevDp[] = new int[2]; //variables changing index n+1 to handle array out of bound index, canBuy flag
        int currentDp[] = new int[2];

        //Recursion index started from 0 to n-1 , tab opposite n-1 to 0
        //Recursion canBuy 0 to 1 , tab opposite 1 to 0

        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                if (canBuy == 1) { //Buy Case

                    int exclude = prevDp[1];
                    int include = (profit - prices[i]) + prevDp[0];
                    currentDp[canBuy] = Math.max(exclude, include);

                } else { //sell
                    int exclude = prevDp[0];
                    int include = (profit + prices[i]) + prevDp[1];
                    currentDp[canBuy] = Math.max(exclude, include);
                }

                prevDp = Arrays.copyOf(currentDp, currentDp.length);
            }

        }

        return prevDp[1];// Recursion we were returning index 0 and canBuy true for final ans
    }

    public static void main(String[] args) {
        int nums1[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitTab(nums1));
    }
}
