/**
** https://www.geeksforgeeks.org/dsa/permutation-coefficient/
** Permutation refers to the process of arranging all the members of a given set to form a sequence. The number of permutations on a set of n elements is given by n! , where "!" represents factorial. 

The Permutation Coefficient represented by P(n, k) is used to represent the number of ways to obtain an ordered subset having k elements from a set of n elements.
Mathematically it's given as: 
 

permu


Image Source : Wiki
Examples : 

P(10, 2) = 90
P(10, 3) = 720
P(10, 0) = 1
P(10, 1) = 10
**/
==================================================================
/**
** Approach : npr = n!/(n-r)!. We can calculate using this formulae but due to heigher values this give inccorect reuslt when n! divided (n-r)!. This formulae is derived by below
** 1st Place = n, 2nd Place = (n-1), 3rd Place = (n-2)......r Place = (n-(r-1))
** Time Complexity : O(r)
** Space Complexity: O(1)
**/
  public static int permutationCoeff(int n, int r) {

        long mod = 1000000007;

        //Base Case
        if (n == 0) {
            return 0;
        } else if (r == 0) {
            return 1;
        } else if (r > n) {
            return 0;
        }


        long result = 1; //Also long
        for (int i = 0; i < r; i++) {
            result = result * (n - i) % mod;
        }


        return (int) result; //Also long
    }
==================================================================
/**
** Bottm Up(Recursion)
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/
class Solution {
    
    public static int permutationCoeff(int n, int r) {
        long mod = 1000000007;

        //Base Case
        if (n == 0) {
            return 0;
        } else if (r == 0) {
            return 1;
        } else if (r > n) {
            return 0;
        }

        //We can keep an element at r place
        long include = ((long) r * permutationCoeff(n - 1, r - 1)) % mod; //Since r is int, need to cast it to long
        long exclude = permutationCoeff(n - 1, r) % mod;

        long result = (include + exclude) % mod;

        return (int) result;
    }
}
===================================================================
/**
** Bottm Up(Recursion) + Memorization
** Time Complexity: O(n1*r1)
** Space Complexity: O(n1*r1)
**/

class Solution {

    public static int permutationCoeffUtil(int n, int r, int[][] dp) {

        long mod = 1000000007;

        //Base Case
        if (n == 0) {
            return 0;
        } else if (r == 0) {
            return 1;
        } else if (r > n) {
            return 0;
        } else if (dp[n][r] != -1) { //Already Calculated
            return dp[n][r];
        }

        long include = (((long) r) * permutationCoeffUtil(n - 1, r - 1, dp)) % mod;
        long exclude = permutationCoeffUtil(n - 1, r, dp) % mod;

        long result = (include + exclude) % mod;

        dp[n][r] = (int) result;

        return dp[n][r];
    }

    public static int permutationCoeff(int n, int r) {


        int dp[][] = new int[n + 1][r + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return permutationCoeffUtil(n, r, dp);
    }

    public static void main(String[] args) {
        int n = 14, r = 12;
        System.out.println(permutationCoeff(n, r));

    }


}

============================================
/**
** Top Down DP
** Time Complexity: O(n1*r1)
** Space Complexity: O(n1*r1)
**/

class Solution {
    
  public static int permutationCoeff(int n1, int r1) {

        long mod = 1000000007;
        int dp[][] = new int[n1 + 1][r1 + 1];
        for (int n = 0; n <= n1; n++) { //Recursion n to 0, here opposite
            for (int r = 0; r <= r1; r++) { ////Recursion r to 0, here opposite
                //Base Case
                if (n == 0) {
                    dp[n][r] = 0;
                } else if (r == 0) {
                    dp[n][r] = 1;
                } else if (r > n) {
                    dp[n][r] = 0;
                } else {
                    long include = (((long) r) * dp[n - 1][r - 1]) % mod;
                    long exclude = dp[n - 1][r] % mod;

                    long result = (include + exclude) % mod;

                    dp[n][r] = (int) result;
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
    
   public static int permutationCoeff(int n1, int r1) {

        long mod = 1000000007;
        int previousDp[] = new int[r1 + 1];
        int currentDp[] = new int[r1 + 1];
        for (int n = 0; n <= n1; n++) { //Recursion n to 0, here opposite
            for (int r = 0; r <= r1; r++) { ////Recursion r to 0, here opposite
                //Base Case
                if (n == 0) {
                    currentDp[r] = 0;
                } else if (r == 0) {
                    currentDp[r] = 1;
                } else if (r > n) {
                    currentDp[r] = 0;
                } else {
                    long include = (((long) r) * previousDp[r - 1]) % mod;
                    long exclude = previousDp[r] % mod;

                    long result = (include + exclude) % mod;

                    currentDp[r] = (int) result;
                }
            }
            //Copy current DP to previous DP
            previousDp = Arrays.copyOf(currentDp, currentDp.length);
        }


        return previousDp[r1];
    }
}

