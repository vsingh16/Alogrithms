/**
** 983. Minimum Cost For Tickets
Solved
Medium
Topics
Companies
You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.

Approach: At any point, we have 3 options.
We need to explore 3 points.
**/

/**
** Top Down + Recursion
** Time Complexity: O(3^n)
** Space Complexity: O(n)
**/


class Solution {


  public int mincostTickets(int[] days, int[] costs, int index) {

   //Base Case
        if (index < 0) {
            return 0;
        }

        //Day 1
        int opt1 = costs[0] + mincostTickets(days, costs, index - 1);
        //Day 7
        int start = days[index];
        int stop = start - 6;
        int i;
        for (i = index; i >= 0 && days[i] >= stop; i--) ; //We can cover current day -6
        int opt2 = costs[1] + mincostTickets(days, costs, i);
        //Day 30
        start = days[index];
        stop = start - 29;
        for (i = index; i >= 0 && days[i] >= stop; i--) ; ////We can cover current day -29
        int opt3 = costs[2] + mincostTickets(days, costs, i);

        return Math.min(Math.min(opt1, opt2), opt3);


    }

    public int mincostTickets(int[] days, int[] costs) {
        return mincostTickets(days, costs, days.length - 1);
    }
}
==========================================================
/**
** Recursion + Memorization
** Time Complexity: O(n)
** Space Complexity: O(n)
**/
class Solution {

    public int mincostTickets(int[] days, int[] costs, int index, int dp[]) {

  //Base Case
        if (index < 0) {
            return 0;
        } else if (dp[index] != -1) { //Result Already Calculated
            return dp[index];
        }

        //Day 1
        int opt1 = costs[0] + mincostTickets(days, costs, index - 1, dp);
        //Day 7
        int start = days[index];
        int stop = start - 6;
        int i;
        for (i = index; i >= 0 && days[i] >= stop; i--) ;
        int opt2 = costs[1] + mincostTickets(days, costs, i, dp);
        //Day 30
        start = days[index];
        stop = start - 29;
        for (i = index; i >= 0 && days[i] >= stop; i--) ;
        int opt3 = costs[2] + mincostTickets(days, costs, i, dp);

        dp[index] = Math.min(Math.min(opt1, opt2), opt3);

        return dp[index];

    }


    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length + 1];
        Arrays.fill(dp, -1);
        return mincostTickets(days, costs, days.length - 1, dp);
    }
}
==========================================================
/**
** Bottom Up 
** Time Complexity: O(n)
** Space Complexity: O(n)
**/

class Solution {

    public int mincostTickets(int[] days, int[] costs) {
   int n = days.length;
        int dp[] = new int[n];
        for (int j = 0; j < n; j++) {

            int opt1 = costs[0] + ((j > 0) ? dp[j - 1] : 0);
            //Day 7
            int i;
            for (i = j; i >= 0 && days[i] >= days[j] - 6; i--) ;
            int opt2 = costs[1] + (i >= 0 ? dp[i] : 0);
            //Day 30
            for (i = j; i >= 0 && days[i] >= days[j] - 29; i--) ;
            int opt3 = costs[2] + (i >= 0 ? dp[i] : 0);

            dp[j] = Math.min(Math.min(opt1, opt2), opt3);

        }

        return dp[dp.length - 1];
    }
}
=================================================
