/**
** https://www.geeksforgeeks.org/painting-fence-algorithm/
** https://www.youtube.com/watch?v=5eFh5CC-8KY&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=9&t=27s
** Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. Since the answer can be large, return it modulo 10^9 + 7.

Examples:

Input : n = 2 k = 4
Output : 16
Explanation: We have 4 colors and 2 posts.
Ways when both posts have same color : 4 
Ways when both posts have diff color :4(choices for 1st post) * 3(choices for 2nd post) = 12


Input : n = 3 k = 2
Output : 6
** Approach: We can paint max 2 post with same color
** If we have 1 post, we can paint with all K colors. Possible ways = k
** If we have 2 posts, we have two options.
** Paint Both With Same Colour = K
** Paint Them Differently = k*(k-1) //Post1 = K, post2 = (k-1)
** If we have 3 posts, two cases
** Paint last 2 With Same Colour = solve(n-2)*(k-1) //Since we have painted last 2 same colurs, n-2 more gate color we need to find. k-1 becuase l1st and 2 nd gate need to have different color
** Paint last 2 With different Colour = solve(n-1)*(k-1) //Since we have painted last 2 different colurs, we are only sure of last gate colour . n-1 more gate color we need to find. k-1 becuase 2 and 3 nd gate need to have different color

** solve(n,k) = last 2 same + last 2 different color
** last 2 same = solve(n-2, k) * (k-1)
** last 2 different = solve(n-1,k) * (k-1)
** solve(n,k) = solve(n-2, k) * (k-1) + solve(n-1,k) * (k-1)
**/

/**
	* Recursion
	* Time Complexity: O(n^2)
	* Space Complexity: O(n)
**/
class Solution
{
    
     private static int MOD = 1000000007;
    long countWays(int n,int k)
    {
            if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + k * (k - 1);
        }
		
        return ((countWays((n % MOD) - 2, k)) % MOD * (k - 1) + (countWays((n % MOD) - 1, k) * (k - 1)) % MOD) % MOD;
    }
}
======================================================
/**
	* Recursion + Memorization
	* Time Complexity: O(n^2)
	* Space Complexity: O(n)
**/

class Solution {

    //private static long MOD = (10 ^ 9) + 7;
    private static int MOD = 1000000007;

    private static long add(long a, long b) {

        return ((a % MOD) + (b % MOD)) % MOD;

    }

    private static long mul(long a, long b) {

        return ((a % MOD) * (b % MOD)) % MOD;

    }


    static long countWays(int n, int k, long result[]) {

        if (n == 1) {
            return k % MOD;
        } else if (n == 2) {
            return add(k, mul(k, k - 1));//k + k * (k - 1);
        } else if (result[n] != -1) { //Already Computed
            return result[n];
        }

        long lastTwoSameColour = mul(countWays(n - 2, k, result), (k - 1)); //countWays(n - 2, k, result) * (k - 1);
        long lastTwoDifferentColour = mul(countWays(n - 1, k, result), (k - 1));  // countWays(n - 1, k, result) * (k - 1);

        result[n] = add(lastTwoSameColour, lastTwoDifferentColour); //lastTwoSameColour + lastTwoDifferentColour
        return result[n];
    }

    static long countWays(int n, int k) {

        long result[] = new long[n + 1];
        Arrays.fill(result, -1);
        return countWays(n, k, result);

    }

    public static void main(String[] args) {
        System.out.println(countWays(27608, 99118));
    }
}
==================================================


/**
	* Top Down
	* Time Complexity: O(n)
	* Space Complexity: O(n)
**/

class Solution
{
    
    private static int MOD = 1000000007;
    
    private static long add(long a, long b) {

        return ((a % MOD) + (b % MOD)) % MOD;

    }

    private static long mul(long a, long b) {

        return ((a % MOD) * (b % MOD)) % MOD;

    }
 
     
    long countWays(int n, int k) {

        long dp[] = new long[n + 1];

        if (n >= 1) {
            dp[1] = k;
        }

        if (n >= 2) {
            dp[2] = add(k, mul(k, k - 1));
        }

        for (int i = 3; i <= n; i++) {
            long lastTwoSameColour = mul(dp[i - 2], (k - 1)); //countWays(n - 2, k, result) * (k - 1);
            long lastTwoDifferentColour = mul(dp[i - 1], (k - 1));  // countWays(n - 1, k, result) * (k - 1);

            dp[i] = add(lastTwoSameColour, lastTwoDifferentColour); //lastTwoSameColour + lastTwoDifferentColour
        }

        return dp[n];

    }
}
=====================================
/**
	* Top Down Space Optimized
	* Time Complexity: O(n)
	* Space Complexity: O(1)
**/


class Solution
{
    
    private static int MOD = 1000000007;
    
    private static long add(long a, long b) {

        return ((a % MOD) + (b % MOD)) % MOD;

    }

    private static long mul(long a, long b) {

        return ((a % MOD) * (b % MOD)) % MOD;

    }
 
     
    long countWays(int n, int k) {

      if (n == 1) {
            return k;
        } else if (n == 2) {
            return add(k, mul(k, k - 1));
        } else {
            long result, prev1 = add(k, mul(k, k - 1)), prev2 = k;
            
            for (int i = 3; i <= n; i++) {
                long lastTwoSameColour = mul(prev2, (k - 1)); //countWays(n - 2, k, result) * (k - 1);
                long lastTwoDifferentColour = mul(prev1, (k - 1));  // countWays(n - 1, k, result) * (k - 1);

                result = add(lastTwoSameColour, lastTwoDifferentColour); //lastTwoSameColour + lastTwoDifferentColour
                prev2 = prev1;
                prev1 = result;
            }

            return prev1;
        }
    }
}

