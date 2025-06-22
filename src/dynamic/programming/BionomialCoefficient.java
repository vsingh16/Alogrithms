package dynamic.programming;

/**
* Ref: https://www.geeksforgeeks.org/dsa/permutation-coefficient/
 * Created by vishal on 06-Mar-18.
 * <p>
 * C(n,k) = n!/(n-k)!*k!
 * <p>
 * Number of ways we can choose subset of size k among n elements
 * <p>
 * Method 1 : Calculate the values as per the formulae.
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

 ** One More Simple Approach : 
 ncr = npr/r!
 We can calculate npr = n * (n-1)*....upto r places
 Refer https://github.com/vsingh16/Alogrithms/blob/master/src/dynamic/programming/PermutationCoefficientProblem.java and then find r factorial.
 */
/**
** Bottm Up(Recursion)
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/
class Solution {
    public int nCr(int n, int r) {
          //Base Case
        if (r == 0) {
            return 1;
        } else if (r == n) {
            return 1;
        } else if (r > n) {
            return 0;
        }


        int include = nCr(n - 1, r - 1);
        int exclude = nCr(n - 1, r);

        return include + exclude;
        
    }
}
===================================================================
/**
** Bottm Up(Recursion) + Memorization
** Time Complexity: O(n1*r1)
** Space Complexity: O(n1*r1)
**/

class Solution {
    
    public int nCrUtil(int n, int r, int dp[][]) {

        //Base Case
        if (r == 0) {
            return 1;
        } else if (r == n) {
            return 1;
        } else if (r > n) {
            return 0;
        } else if (dp[n][r] != -1) { //Already Calculated
            return dp[n][r];
        }

        int include = nCrUtil(n - 1, r - 1, dp);
        int exclude = nCrUtil(n - 1, r, dp);

        dp[n][r] = include + exclude;
        return dp[n][r];

    }
    
    
    public int nCr(int n, int r) {
     int dp[][] = new int[n + 1][r + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return nCrUtil(n, r, dp);
        
    }
}

============================================
/**
** Top Down DP
** Time Complexity: O(n1*r1)
** Space Complexity: O(n1*r1)
**/

class Solution {
    
    public int nCr(int n1, int r1) {
    int dp[][] = new int[n1 + 1][r1 + 1];

        for (int n = 0; n <= n1; n++) {
            for (int r = 0; r <= r1; r++) {
                //Base Case
                if (r == 0) {
                    dp[n][r] = 1;
                } else if (r == n) {
                    dp[n][r] = 1;
                } else if (r > n) {
                    dp[n][r] = 0;
                } else {
                    int include = dp[n - 1][r - 1];
                    int exclude = dp[n - 1][r];

                    dp[n][r] = include + exclude;
                }
            }
        }

        return dp[n1][r1];
        
    }
}
========================================================
/**
** Top Down DP + Space Optimized
** Time Complexity: O(n1*r1)
** Space Complexity: O(r1)
**/

class Solution {
    
    public int nCr(int n1, int r1) {
        int previousDp[] = new int[r1 + 1]; //This array will be of internal loop
        int currentDp[] = new int[r1 + 1];

        for (int n = 0; n <= n1; n++) {
            for (int r = 0; r <= r1; r++) {
                //Base Case
                if (r == 0) {
                    currentDp[r] = 1;
                } else if (r == n) {
                    currentDp[r] = 1;
                } else if (r > n) {
                    currentDp[r] = 0;
                } else {
                    int include = previousDp[r - 1];
                    int exclude = previousDp[r];

                    currentDp[r] = include + exclude;
                }
            }

            //Copy current to previous
            previousDp = Arrays.copyOf(currentDp, currentDp.length);
        }

        return previousDp[r1];
    }
}

