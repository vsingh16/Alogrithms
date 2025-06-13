/**
** https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
** Given weights and values of n items, put these items in a knapsack of capacity W to get 
** the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and
** wt[0..n-1] which represent values and weights associated with n items respectively.
** Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] 
** such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
** eg: Value[] {60,100,120}
** weight[] = {10,20,30}
** W = 50
** Possible Combinations:
** weight =10, value = 60
** weight =20, value = 100
** weight =30, value = 120
** weight =(20+10), value = 100+60 = 160
** weight =(30+10), value = 120+60 = 180
** weight =(30+20), value = 120+100 = 220
** weight =(30+20+10)
** Ans: 220 is max

** Approach : we will skip an item if its weight is greater than total W
** At each  item, we have 2 choices either include or exclude
** Max(include(val[i]+fun(n-1,w-wt[i])), exclude(n-1,w))
** PS: this is no infinite, so we can' use same item hence we do n-1 on including
**/

/**
** Bottm Up(Recursion)
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/

class Solution {
    
     static int knapsack(int W, int val[], int wt[], int index) {

      //Base Case, Single Item	  
        if (index == 0) {
           if (wt[index] <= W) {
                return val[index];
            } else {
                return 0;
            }
        } else if (W == 0) {
            return 0;
        }


        int include = Integer.MIN_VALUE;
        if (wt[index] <= W) {
            include = val[index] + knapsack(W - wt[index], val, wt, index - 1);
        }

        int exclude = knapsack(W, val, wt, index - 1);

        return Math.max(include, exclude);

    }
    
    static int knapsack(int W, int val[], int wt[]) {
        return knapsack(W, val, wt, wt.length - 1);        
    }
}
=====================================================================================
/**
** Bottm Up(Recursion) + Memorization
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity*val.length)
**/
class Solution {
    
static int knapsackUtil(int W, int val[], int wt[], int index, int dp[][]) {

        //Base Case
        if (index < 0) {
            return 0;
        } else if (W == 0) {
            return 0;
        } else if (dp[W][index] != -1) { //Already Calculated
            return dp[W][index];
        }


        int include = Integer.MIN_VALUE;
        if (wt[index] <= W) {
            include = val[index] + knapsackUtil(W - wt[index], val, wt, index - 1, dp);
        }

        int exclude = knapsackUtil(W, val, wt, index - 1, dp);

        dp[W][index] = Math.max(include, exclude);

        return dp[W][index];
    }

    
    static int knapsack(int W, int val[], int wt[]) {
        int dp[][] = new int[W + 1][wt.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return knapsackUtil(W, val, wt, wt.length - 1, dp);     
    }
}

========================================================================================
/**
** Top Down DP
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity*val.length)
**/
class Solution {
    
    static int knapsack(int targetWeight, int val[], int wt[]) {

        int dp[][] = new int[targetWeight + 1][wt.length];

        for (int index = 0; index < wt.length; index++) {

            for (int W = 0; W <= targetWeight; W++) {
                //Base Case
                if (index == 0) {
                    dp[W][index] = (wt[index] <= W) ? val[index] : 0;
                } else if (W == 0) {
                    dp[W][index] = 0;
                } else {

                    int include = Integer.MIN_VALUE;
                    if (wt[index] <= W) {
                        include = val[index] + dp[W - wt[index]][index - 1];
                    }

                    int exclude = dp[W][index - 1];

                    dp[W][index] = Math.max(include, exclude);
                }

            }
        }


        return dp[targetWeight][wt.length - 1];
    }

}
========================================================================================
/**
** Top Down DP + Space Optimized
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity)
**/
class Solution {

    
    static int knapsack(int targetWeight, int val[], int wt[]) {
        int currentDp[] = new int[targetWeight + 1];
        int previousDp[] = new int[targetWeight + 1];

        for (int index = 0; index < wt.length; index++) {

            for (int W = 0; W <= targetWeight; W++) {
                //Base Case
                if (index == 0) {
                    currentDp[W] = (wt[index] <= W) ? val[index] : 0;
                } else if (W == 0) {
                    currentDp[W] = 0;
                } else {

                    int include = Integer.MIN_VALUE;
                    if (wt[index] <= W) {
                        include = val[index] + previousDp[W - wt[index]];
                    }

                    int exclude = previousDp[W];

                    currentDp[W] = Math.max(include, exclude);
                }

            }
            //Copy current to previous
            previousDp = Arrays.copyOf(currentDp, currentDp.length);
        }


        return previousDp[targetWeight];
    }
}


