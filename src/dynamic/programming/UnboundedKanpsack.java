/**
** https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
** Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate the maximum amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
Examples: 

Input : W = 100
       val[]  = {1, 30}
       wt[] = {1, 50}
Output : 100
There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
   instances of 1 unit weight items.
We get maximum value with option 2.

Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}       
Output : 110 
We get maximum value with one unit of
weight 5 and one unit of weight 3.
** This is similar to 0/1 knapsack.
** Only difference is that since we can take any element n time, therefore even on including we won't do i-1 , and keep i
**/


/**
** Time Complexity : 2^n. At each level we have two options
**/
 int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;
 
        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
 
        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else
            return max(val[n - 1]
                       + knapSack(W - wt[n - 1], wt,
                                  val, n),
                       knapSack(W, wt, val, n - 1));
    }

/**
** DP. Time Complexity : O(n*w)
** Space Complexity: O(n*w)
**/
int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][] = new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(wt[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]]
                    ,dp[i-1][j]);    
                }
            }
        }
        
        return dp[n][W];
    } 

/**
** Method 2: Other way of looking this problem could be just check if last item can be used give it try
** and stop when n or w == 0
** Time Complexity : O(n^n), at each step n choices to make
**/
int knapSack(int n, int W, int val[], int wt[])
    {
        if(n == 0 || w == 0){
            return 0;   
        }
       int result = 0;
       for(int i=0;i<n;i++){              
           if(wt[i] <= w){
               return Math.max(result, val[i] + knapSack(n, W - wt[i], va, wt));   
           }   
       }       
    }

/**
** Time Complexity : O(n*w)
** Space Complexity : O(w)
**/
int knapSack(int n, int W, int val[], int wt[])
    {
        int dp[] = new int[W+1];
        for(int i=1;i<=W;i++){
            for(int j=0;j<n;j++){ // because for each weight , we can pick from n items
                if(wt[j]<=i){
                 dp[i] = Math.max(dp[i], val[j]+ dp[i-wt[j]]);   
                }
            }
        }
        
        return dp[W];
    }
