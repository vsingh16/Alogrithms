package dynamic.programming;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top. 
 * The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
 ** https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 ** https://www.techiedelight.com/find-total-ways-reach-nth-stair-with-atmost-m-steps/
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

    /**
    ** Same above approach is applied in DP.
    ** Time Complexity : O(n)
    ** Space Complexity : O(n)
    **/
    int countWays(int n)
    {
        
       int dp[] = new int[n+1];
       for(int i=1;i<=n;i++){
           if(i<=2){
               dp[i] = i;
           }else{
               dp[i] = (dp[i-1]+dp[i-2])%1000000007;
           }
       }
       
       return dp[n];
    }
    
    /**
     * Number of ways to reach n stairs in m ways
     * ways(n, m) = ways(n-1, m) + ways(n-2, m) + ... ways(n-m, m)(n<=m)
     */
    //Time Complexity:Exponential
    public static int climbStairs(int n, int m) {

        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += climbStairs(n - i, m);
        return res;
    }

    //Time Complexity:O(mn)
    //Space Complexity:O(n)
    // https://www.techiedelight.com/find-total-ways-reach-nth-stair-with-atmost-m-steps/
    //Below implementation is asked when m>=2
    public static int climbStairsDyn(int n, int m) {

        int res[] = new int[n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = 0;
            for (int j = 1; j <= m && j <= i; j++)
                res[i] += res[i - j];
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
    }

}
