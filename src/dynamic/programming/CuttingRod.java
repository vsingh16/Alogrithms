package dynamic.programming;

/**
 * Created by vishal on 17-Jun-18.
 * <p>
 * Given a rod of length n inches and an array of prices that contains
 * prices of all pieces of size smaller than n. Determine the maximum value
 * obtainable by cutting up the rod and selling the pieces. For example,
 * if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 */
public class CuttingRod {


    /**
     * Time Complexity:O(l*l)
     *
     */
    public static int maxProfit(int price[], int l) {

        if (l <= 0) {
            return 0;
        }

        //compare price of cutting at each length
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, price[i] + maxProfit(price, l - i - 1));
        }

        return max;
    }

    /**
     * Time Complexity : O(l *l)
     *
     */
    public static int maxProfitDyn(int price[], int l) {

        int result[] = new int[l + 1];
        for (int i = 1; i <= l; i++) {
            Integer max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, price[j] + result[i - j - 1]);
            }
            result[i] = max;
        }

        return result[l];
    }

    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxProfit(price, price.length));
        System.out.println(maxProfitDyn(price, price.length));
    }
}
