package dynamic.programming;

/**
 * Created by vishal on 11-Mar-18.
 * <p>
 * Find the max profit, if trader is allowed to do max. 2 transactions
 * <p>
 * Method 1:Max profit with at most two transactions =
 * MAX {max profit with one transaction and subarray price[0..i] +
 * max profit with one transaction and aubarray price[i+1..n-1]  }
 * i varies from 0 to n-1.
 *
 * Time Complexity : O(n*n)
 *
 * Method 2:Dynamic Programming
 *
 * Traverse from left to right to find max profit at i with one transactions.
 * Traverse in reverse direction to find max profit and return profit[0]
 * Time Complexity: O(n)
 * Space Complexity:O(n)
 */
public class BuyAndSellStock2Times {

    private static int maxProfit(int price[]) {
        int n = price.length;
        int profit[] = new int[n];
        int min_so_far = price[0];

        //Left to Right
        for (int i = 1; i < n; i++) {
            if (price[i] < min_so_far) {
                min_so_far = price[i];
            }
            profit[i] = Integer.max(profit[i - 1], price[i] - min_so_far);
        }

        //Right to Left
        int max_so_far = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (price[i] > max_so_far) {
                max_so_far = price[i];
            }
            profit[i] = Integer.max(profit[i + 1], profit[i] + (max_so_far - price[i]));
        }

        return profit[0];

    }

    public static void main(String[] args) {
        int price[] = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(maxProfit(price));
    }
}
