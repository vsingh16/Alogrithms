package dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 11-Mar-18.
 * <p>
 * Stock Buy Sell to Maximize Profit
 * The cost of a stock on each day is given in an array, find the max profit that you can make by
 * buying and selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 * the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6.
 * If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 * <p>
 * Variant : If we are allowed to buy and sell only once, then this problem is similar to max difference array.
 */
public class BuyAndSellStockAnyNumberOfTimes {

    /**
     * Find Minimum at i such that next element(i+1) is greater
     * Find Maximum at i+1 such that previous element(i-1) is less than.
     * <p>
     * Keep on searching for such pairs and then add their diff to calculate total profit earned.
     *
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int maxProfit(int price[]) {

        int i = 0;
        int n = price.length;

        if (n == 1) {
            return 0;
        }
        List<Integer> days = new ArrayList<>();
        int totalProfit = 0;
        int min;
        int max;
        while (i < n) {

            while (i < n - 1 && price[i] > price[i + 1]) {
                i++;
            }
            //price is always decreasing
            if (i == n - 1) {
                return 0;
            }
            min = price[i];
            days.add(i++);

            while (i < n && price[i] > price[i - 1]) {
                i++;
            }

            max = price[i - 1];
            days.add(i - 1);
            totalProfit = totalProfit + (max - min);
        }

        for (i = 0; i < days.size() - 1; i += 2) {
            System.out.println("Buy on day " + days.get(i) + " and sell on day " + days.get(i + 1));
        }
        return totalProfit;
    }

    public static void main(String[] args) {

        int price[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(price));
    }

}
