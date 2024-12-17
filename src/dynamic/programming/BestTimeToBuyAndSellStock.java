/**
** https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
** You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

** Approach: To Maximize profit we need to buy at low and sell at high.
** We will explore all possible days(starting from 1st index) to sell
** We will keep min variable which will represent min buy.
** Iterate and find max Profit
** Time Complexity: O(n)
** Space Complexity :O(n)
**/

class Solution {

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            min = Math.min(min, prices[i - 1]);
            int buy = min;
            int profit = sell - buy;
            maxProfit = Math.max(maxProfit, profit);

        }

        return maxProfit;

    }

    public static void main(String[] args) {
        int nums1[] = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(nums1));
    }
}
