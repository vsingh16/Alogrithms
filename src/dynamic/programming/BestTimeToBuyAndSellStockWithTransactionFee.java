/**
** Ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
** https://www.youtube.com/watch?v=KFqhgQeQAXc&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=144
** You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6

** Approach: This question is same as Buy And Sell Stock Problem where we can buy and sell multiple time.s
** https://github.com/vsingh16/Alogrithms/blob/master/src/dynamic/programming/BestTimeToBuyAndSellStockII.java
** Ony Catch is when we sell, we complete one transaction, hence we pay fees
**/

import java.util.Arrays;

/**
** Space Optimized DP
** Time Complexity: O(n) //n*2, Since two is constant we can O(n)
** Space Complexity: O(1) Because of constant array size of 2
**/

class Solution {

    public static int maxProfit(int[] prices, int fee) {
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
                    int include = (profit + prices[i] - fee) + prevDp[1]; //If we have executed Sell, means we have completed one transaction, hence we can pay transaction fees.
                    currentDp[canBuy] = Math.max(exclude, include);
                }

                prevDp = Arrays.copyOf(currentDp, currentDp.length);
            }

        }

        return prevDp[1];// Recursion we were returning index 0 and canBuy true for final ans
    }

    public static void main(String[] args) {
        int nums1[] = {1, 3, 7, 5, 10, 3};
        System.out.println(maxProfit(nums1, 3));
    }
}
