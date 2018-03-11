package dynamic.programming;

/**
 * Created by vishal on 11-Mar-18.
 * <p>
 * Maximum profit by buying and selling a share at most k times
 * <p>
 * Profit with max k transactions and ith day:
 * on ith day either we sell the stock or not sell the stock
 * if not sell, p[k][i] = p[k][i-1]
 * and if sold:p[k][i]= price[i]-price[j] + profit earned upto jth day p[k-1][j]
 * there could be any day 0<j<i i.e before ith day
 * p[k][i] = Max(p[k][i-1],max(price[i]-price[j] + p[k-1][j]))
 */
public class BuyAndSellStockKTimes {

    /**
     * TimeComplexity : O(k*n*n)
     * Space Complexity: O(k*n)
     *
     * @param price
     * @param k
     * @return
     */
    private static int maxProfit(int price[], int k) {
        int n = price.length;
        int profit[][] = new int[k][n];

        for (int t = 0; t < k; t++) {
            for (int i = 0; i < n; i++) {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    max = Integer.max(max, (price[i] - price[j] + ((t == 0) ? 0 : profit[t - 1][j])));
                }
                profit[t][i] = Integer.max((i == 0) ? 0 : profit[t][i - 1], max);
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(profit[i][j] + " ");
            }
            System.out.println();
        }
        return profit[k - 1][n - 1];
    }


    /**
     * TimeComplexity : O(k*n)
     * Space Complexity: O(k*n)
     **/
    private static int maxProfitOptimized(int price[], int k) {
        int n = price.length;
        int profit[][] = new int[k][n];

        for (int t = 0; t < k; t++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                prevDiff = Integer.max(prevDiff, (t == 0 ? 0 : profit[t - 1][i - 1]) - price[i - 1]);
                profit[t][i] = Integer.max(profit[t][i - 1], price[i] + prevDiff);

            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(profit[i][j] + " ");
            }
            System.out.println();
        }
        return profit[k - 1][n - 1];
    }


    public static void main(String[] args) {

        int k = 2, profit[] = {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit(profit, k)); //output:87
        k = 3;
        int profit2[] = {12, 14, 17, 10, 14, 13, 12, 15};//output :12
        System.out.println(maxProfit(profit2, k));
        k = 1;
        int profit3[] = {90, 80, 70, 60, 50};//output : 0
        System.out.println(maxProfit(profit3, k));

        System.out.println(maxProfitOptimized(profit, k)); //output:87
    }
}
