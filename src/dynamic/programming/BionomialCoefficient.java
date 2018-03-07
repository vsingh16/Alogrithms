package dynamic.programming;

/**
 * Created by vishal on 06-Mar-18.
 * <p>
 * C(n,k) = n!/(n-k)!*k!
 * <p>
 * Number of ways we can choose subset of size k among n elements
 * <p>
 * Method 1 : Calculate the values as per formulae.
 * <p>
 * Method 2:Recursion  C(n, k) = C(n-1, k-1) + C(n-1, k) with Base case: C(n, 0) = C(n, n) = 1, Exponential Time complexity
 * <p>
 * Method 3:Dynamic Programming Time Complexity: O(n*k)
 * Auxiliary Space: O(n*k)
 * <p>
 * Method 4: C(n,k) = n!*(n-k)!*k!
 * = n * (n-1) * (n-2).......*(n-k+1)/(k * k-1 * ...1)
 * Time Complexity:O(k)
 * Space Complexity:O(1)
 */
public class BionomialCoefficient {

    public static int binomialCoeff(int n, int k) {
        int res = 1;

        // Since C(n, k) = C(n, n-k)//eg C(5,2) = C(5,3), so if K < (n-k) use K else (n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    public static int binomialCoeffRec(int n, int k) {

        if (k == 0) {
            return 1;
        } else if (k == n) {
            return 1;
        }

        if (n - k < k) {
            k = n - k;
        }

        return binomialCoeffRec(n - 1, k - 1) + binomialCoeffRec(n - 1, k);

    }

    public static int binomialCoeffDyn(int n, int k) {

        int res[][] = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Integer.min(i, k); j++) {

                if (j == 0 || i == j) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                }
            }
        }

        return res[n][k];

    }

    public static void main(String[] args) {

        System.out.println(binomialCoeff(5, 2)); //output :10
        System.out.println(binomialCoeffRec(5, 2));
        System.out.println(binomialCoeffDyn(5, 2));

    }
}
