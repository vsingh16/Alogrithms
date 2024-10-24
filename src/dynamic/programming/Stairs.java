package dynamic.programming;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top. 
 * The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
 ** https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 ** https://www.techiedelight.com/find-total-ways-reach-nth-stair-with-atmost-m-steps/
 ** https://www.youtube.com/watch?v=S31W3kohFDk&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=2&t=397s
 ** Approach: Any DP can be solved with below
 ** Top Down: Recursion + Memorisation
 ** Bottom Up: Tabular
 ** Space Optimized
 */
public class Stairs {
    
    /**
    ** Approach : for n = 1,
    ** for n = 2, he has two ways, either in one go or 1 by 1, 2
    ** f(n) = f(n-1) + f(n-2)
    ** Time Complexity : (2^n)
    **/
    int countWays(int n)
    {
        
       if(n <= 2){
           return n;
       }else {
           return countWays(n-1) + countWays(n-2);
       }
    }

    public static int nthStair(int n) {

        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        return nthStairBottomup(n, dp);
    }

    public static int nthStair(int n) {

        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        return nthStairBottomup(n, dp);
    }

    /**
    ** Recursion + Memorization
    ** Time: O(n)
    ** Sapce: O(1)
    **/
    public static int nthStairBottomup(int n, int dp[]) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        if (dp[n] != -1) { // result already calculated
            return dp[n];
        }
        dp[n] = dp[n-1]+dp[n-2];
        return dp[n];
    }


    /**
    ** Time: O(n)
    ** Space: O(n)
    **/
   public static int nthStairTopDown(int n) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    /**
    ** Time : O(n)
    ** Space: O(1)
    **/
    public static int nthStairTopDownSpaceOptimized(int n) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int prev1 = 2;
        int prev2 = 1;
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % 1000000007;
            prev2 = prev1;
            prev1 = current;

        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
    }

}
