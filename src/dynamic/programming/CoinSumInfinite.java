package dynamic.programming;

/**
 * Created by vishal on 18-Mar-18.
 * <p>
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * <p>
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 * <p>
 * Solution:
 * We have two choices either include nth coin or exclude it.
 * if we exclude mth coin then,Count(s[],m,n) = Count(s[],m-1,n)
 * if we include,Count(s[],m,n-s[m-1]), since coins are infinite, if we include mth coin, we still have all m coins,
 * and total target sum = n - mth coin value
 * Count(s[],m,n) = Count(s[],m-1,n)+Count(s[],m,n-s[m-1])
 */
public class CoinSumInfinite {

    /**
     * Time Complexity:exponential
     * Space Complexity:O(n)
     */
    public static int countRecursive(int s[], int m, int n) {

        /**
         * Base Case, if n =0, if target sum is zero, we can exclude all coins to make it zero, so we can represent this
         * in one way
         */
        if (n == 0) {
            return 1;
        }

        /**
         * If target sum is less that zero, we cant make it even after excluding all coins
         */
        if (n < 0) {
            return 0;
        }

        /**
         * if no coins left, we can't do anything
         */
        if (m == 0) {
            return 0;
        }

        return countRecursive(s, m - 1, n) + countRecursive(s, m, n - s[m - 1]);
    }

    /**
     * Time Complexity: O(coin*target sum)
     * Space Complexity:O(coin*target sum)
     */
    public static int countDynamic(int s[], int n) {

        int m = s.length;//number of coins
        int count[][] = new int[m][n + 1];

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[0].length; j++) {
                if (j == 0) {
                    count[i][j] = 1;
                }

                //if target sum is less than coin value, we can only exclude
                else if (j < s[i]) {
                    count[i][j] = i > 0 ? count[i - 1][j] : 0;
                } else {
                    count[i][j] = (i > 0 ? count[i - 1][j] : 0) + count[i][j - s[i]];
                }
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }

        return count[m - 1][n];
    }

    /**
     * If we closely observer, we can see at ith row, we only need values of previous row i.e i-1,
     * so we can hold these values in 1 D array
     * Time Complexity: O(coin*target sum)
     * Space Complexity:O(target sum)
     */
    public static int countDynamicEfficient(int s[], int n) {

        int m = s.length;//number of coins
        int count[] = new int[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < count.length; j++) {
                if (j == 0) {
                    count[j] = 1;
                }

                //if target sum is less than coin value, we can only exclude
                else if (j < s[i]) {
                    count[j] = i > 0 ? count[j] : 0;
                } else {
                    count[j] = (i > 0 ? count[j] : 0) + count[j - s[i]];
                }
                System.out.print(count[j] + " ");
            }
            System.out.println();
        }

        return count[n];
    }
    
    //If space complexity required is O(n)
    //We can reduce space complexity of any DP problem
    //by taking dp[2][] as we always refer only previous row.
    //dp[i][j] = dp[i%2][j] 
    //dp[i-1][j] = dp[(i+1)%2][j] 
    public long count(int S[], int m, int n) 
    { 
      long dp[][] = new long[2][n+1];
      for(int i=0;i<m;i++){
          for(int j=0;j<=n;j++){
              
              if(j == 0){
                  dp[i%2][j] = 1;
              }else if(S[i] > j){
                  dp[i%2][j] = (i>0 ? dp[(i+1)%2][j] : 0);
              }else{
                  dp[i%2][j] = (i>0 ? dp[(i+1)%2][j] : 0) + dp[i%2][j - S[i]];
              }
              
          }
          
      }
      
      return dp[(m+1)%2][n];
    } 

    public static void main(String[] args) {
        int s[] = {1, 2, 3}, n = 4;
        System.out.println(countRecursive(s, s.length, n));//output:4 {1,1,1,1} , {1,1,2,2},{2,2},{1,3}

        int s1[] = {2, 5, 3, 6};
        n = 10;
        System.out.println(countRecursive(s1, s1.length, n));//output:5 {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}

        int s2[] = {1, 2, 3};
        n = 5;
        System.out.println(countDynamic(s2, n));

        int s3[] = {2, 5, 3, 6};
        n = 10;
        System.out.println(countDynamic(s3, n));//output:5 {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}

        int s4[] = {1, 2, 3};
        n = 5;
        System.out.println(countDynamicEfficient(s4, n));//output:4 {1,1,1,1,1} , {1,1,1,2},{1,2,2},{1,1,3},{2,3}
    }
}
