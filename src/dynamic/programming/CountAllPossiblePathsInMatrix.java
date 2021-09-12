/**
** https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
** Count all possible paths from top left to bottom right of a mXn matrix
Difficulty Level : Easy
Last Updated : 24 Aug, 2021
The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down
Examples : 
 

Input :  m = 2, n = 2;
Output : 2
There are two paths
(0, 0) -> (0, 1) -> (1, 1)
(0, 0) -> (1, 0) -> (1, 1)

Input :  m = 2, n = 3;
Output : 3
There are three paths
(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
** Approach: Start with end point and move towards starting.Just move pinters in two direction (i-1,j) and (i,j-1)
** If i == 1 or j == 1 it means now we can just go to source without any direction change i.e follow same path.
**/

/**
** Time Complexity : O(2^n)
** we have two branches
**/
long numberOfPaths(int m, int n)
    {
        if(m == 1 || n == 1){
            return 1;
        }
        
        return numberOfPaths(m,n-1) + numberOfPaths(m-1,n);
        
    }

 /**
 ** Time Complexity : O(m*n)
 ** Space Complexity : O(m*n)
 **/
 long numberOfPaths(int m, int n)
    {
        long M = 1000000007;// Since ans could be long 10^9+7 modulo
        long dp[][] = new long[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i == 1 || j == 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j])%M;
                }
            }
        }
        
        return dp[m][n];
    }
