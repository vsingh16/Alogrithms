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
**/

/**
** Time Complexity : 
**
 static int knapSack(int W, int wt[], int val[], int n)
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
                                  val, n - 1),
                       knapSack(W, wt, val, n - 1));
    }

