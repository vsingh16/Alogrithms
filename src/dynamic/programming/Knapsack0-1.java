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
** Top Down(Recursion)
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/

class Solution {
    
    static int knapSack(int capacity, int val[], int wt[], int index) {

     //Base Case: Single Item
        if (index == 0) {
            if (wt[index] <= capacity) {
                return val[index];
            } else {
                return 0;
            }
        }


        int include = (wt[index] <= capacity) ? val[index] + knapSack(capacity - wt[index], val, wt, index - 1) : 0;
        int exclude = knapSack(capacity, val, wt, index - 1);

        return Math.max(include, exclude);
    }
    
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        return knapSack(capacity, val, wt, wt.length-1);
    }
}
=====================================================================================
/**
** Top Down(Recursion) + Memorization
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity*val.length)
**/
class Solution {
    
     static int knapSack(int capacity, int val[], int wt[], int index, int dp[][]) {

        //Base Case: Single Item
        if (index == 0) {
            if (wt[index] <= capacity) {
                return val[index];
            } else {
                return 0;
            }
        } else if (dp[capacity][index] != -1) { //Result already computed
            return dp[capacity][index];
        }


        int include = (wt[index] <= capacity) ? val[index] + knapSack(capacity - wt[index], val, wt, index - 1, dp) : 0;
        int exclude = knapSack(capacity, val, wt, index - 1, dp);

        dp[capacity][index] = Math.max(include, exclude);

        return dp[capacity][index];
    }
    
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int dp[][] = new int[capacity + 1][wt.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSack(capacity, val, wt, wt.length - 1, dp);
    }
}

========================================================================================
/**
** Bottom Up DP
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity*val.length)
**/
class Solution {
    
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
          int dp[][] = new int[capacity + 1][wt.length];

        //Single Item
        if (val.length == 1) {
            if (wt[0] <= capacity) {
                return val[0];
            } else {
                return 0;
            }
        }

        //Single Item Initialization. j =0
        for (int i = 0; i <= capacity; i++) {
            dp[i][0] = wt[0] <= i ? val[0] : 0;
        }

        for (int i = 1; i <= capacity; i++) {
            for (int j = 1; j < val.length; j++) {
                int include = (wt[j] <= i) ? val[j] + dp[i - wt[j]][j - 1] : 0;//(wt[index] <= capacity) ? val[index] + knapSack(capacity - wt[index], val, wt, index - 1, dp) : 0;
                int exclude = dp[i][j - 1]; // knapSack(capacity, val, wt, index - 1, dp);

                dp[i][j] = Math.max(include, exclude);
            }

        }


        return dp[capacity][wt.length - 1];
    }
}
========================================================================================
/**
** Bottom Up DP + Space Optimized
** Time Complexity: O(capacity*val.length)
** Space Complexity: O(capacity)
**/
class Solution {
    
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
    
     
     int previous[] = new int[capacity + 1];
        int current[] = new int[capacity + 1];

        //Single Item
        if (val.length == 1) {
            if (wt[0] <= capacity) {
                return val[0];
            } else {
                return 0;
            }
        }

        //Single Item Initialization. j = 0
        for (int i = 0; i <= capacity; i++) {
            previous[i] = wt[0] <= i ? val[0] : 0;
        }


        for (int j = 1; j < val.length; j++) {
            for (int i = 1; i <= capacity; i++) { // Since we are updating capacity for all combination, hence moved weight inside
                int include = (wt[j] <= i) ? val[j] + previous[i - wt[j]] : 0;//(wt[index] <= capacity) ? val[index] + knapSack(capacity - wt[index], val, wt, index - 1, dp) : 0;
                int exclude = previous[i];                 // knapSack(capacity, val, wt, index - 1, dp);

                current[i] = Math.max(include, exclude);
            }
            // Copy current results to previous for the next iteration
            System.arraycopy(current, 0, previous, 0, capacity + 1);
        }


        return previous[capacity];
    }
}


