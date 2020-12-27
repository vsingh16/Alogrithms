package com.vishal.hackerrank;

/**
 * Created by vishal on 27-Dec-20.
 * <p>
 * The cost of stock on each day is given in array.
 * Find the max profit by buying and selling.
 */
public class StockBuySellUnlimitedTransactions {

    /**
     * Method : First find suitable day to buy: so if price next day is increasing
     * Then suitable day to sell : if price next day is falling
     *
     * @param a
     * @return
     */
    public static int findMaxProfit(int a[]) {

        int profit = 0;
        for (int i = 0; i < a.length; i++) {
            //find buy day
            while (i < a.length - 1 && a[i] >= a[i + 1]) {
                i++;
            }
            if (i == a.length - 1) {
                break;
            }
            int buy = a[i++];
            //find sell day
            while (i < a.length - 1 && a[i] <= a[i + 1]) {
                i++;
            }
            int sell = a[i];
            profit = profit + (sell - buy);
        }

        return profit;
    }

    public static void main(String[] args) {
        int a[] = {98, 178, 250, 300, 40, 540, 690};
        System.out.println(findMaxProfit(a));

        int a2[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(findMaxProfit(a2));

    }
}
