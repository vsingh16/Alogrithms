/**
** Ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
** https://www.youtube.com/watch?v=tuhjovVtDII&t=250s. Love Babbar
** You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

** Approach: This question is the same as at most 2 transactions.
** Refer: https://github.com/vsingh16/Alogrithms/blob/master/src/dynamic/programming/BestTimeToBuyAndSellStock-iii.java
**/

/**
** Time Complexity: O(n) //n*2*3, Since two is constant we can O(n)
** Space Complexity: O(1) Because of constant array size of 2 & 3
**/
class Solution {

    public static int maxProfit(int k, int[] prices) {
        int prevDp[][] = new int[2][k + 1]; ////variables index, canBuy(0,1), transaction count(1,2) , prices.length+1 to handle array out of bound
        int currentDp[][] = new int[2][k + 1];

        int profit = 0;
        for (int index = prices.length - 1; index >= 0; index--) { //index we started from 0 to n-1 in recursion, so here we will do reverse
            for (int canBuy = 0; canBuy <= 1; canBuy++) { //canBuy we started from 1 to 0 in recursion, so here we will do reverse
                for (int transactionCount = 1; transactionCount <= k; transactionCount++) { //transactionCount we started from 2 to 0 in recursion, so here we will do reverse. Base Case transaction count =0 is 0,so skip
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

        return prevDp[1][k];
    }

    public static void main(String[] args) {
        int nums1[] = {3,2,6,5,0,3};
        System.out.println(maxProfit(2, nums1));
    }
}
