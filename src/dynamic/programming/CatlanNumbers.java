package dynamic.programming;

/**
 * Created by vishal on 06-Mar-18.
 * <p>
 * Catlan Numbers are given by formulae:
 * <p>
 * C(n+1) = Sigma i=0 to i<=n : C(i)*C(n-i)
 * <p>
 * Catlan Numbers can be used to describe:
 * <p>
 * 1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 * <p>
 * 2) Count the number of possible Binary Search Trees with n keys (See this)
 * <p>
 * 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
 * <p>
 * 4)Calculate number of ways circle can be divided with n chords:
 */
public class CatlanNumbers {

    // A recursive function to find nth catalan number
    //Time complexity:Exponential
    private int catalanRec(int n) {
        int res = 0;

        // Base case
        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += catalanRec(i) * catalanRec(n - i - 1);
        }
        return res;
    }

    //Dynamic Programming
    //Time Complexity:o(n*n)
    private int catalanDyn(int n) {
        //int res = 0;
        int res[] = new int[n + 1];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            res[i] = 0;
            for (int j = 0; j < i; j++)
                res[i] += res[j] * res[i - j - 1];
        }

        return res[n];
    }

    //Using Bionomial Coefficeint

    /**
     * Formulae: Catalan(n)=(1/(n+1))*(C(2n,n))
     *
     * TimeComplexity : O(n) which is to find bionomial coeffiecient
     *
     */

    private int catalanBioCoff(int n) {

        int coeff = BionomialCoefficient.binomialCoeff(2 * n, n);
        return (coeff / (n + 1));

    }

}
