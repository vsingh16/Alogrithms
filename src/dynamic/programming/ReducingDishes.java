/**
** https://leetcode.com/problems/reducing-dishes/description/
** https://www.youtube.com/watch?v=_iGlRDLPLxM. Love Babbar DP Series
** A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].

Return the maximum sum of like-time coefficient that the chef can obtain after preparing some amount of dishes.

Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.

 

Example 1:

Input: satisfaction = [-1,-8,0,5,-9]
Output: 14
Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
Each dish is prepared in one unit of time.
Example 2:

Input: satisfaction = [4,3,2]
Output: 20
Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
Example 3:

Input: satisfaction = [-1,-4,-5]
Output: 0
Explanation: People do not like the dishes. No dish is prepared.

** Approach: We need to sort array. As time will increase for each dish, so if we place dish with higher value at right side, thier product will be maxmized
** At each index we have two options either to include or exclude.
**/

/**
** Top Down(Becuase starting point is 0, start) + Recursion
** Time Complexity: O(2^n), Since we have two options either include or exclude
** Space Complexity: O(n)
**/


class Solution {

      public int maxSatisfaction(int[] satisfaction, int index, int time) {

        int n = satisfaction.length;
        //Base Case
        if (index == n) {
            return 0;
        }

        int include = (satisfaction[index] * time) + maxSatisfaction(satisfaction, index + 1, time + 1);
        int exclude = maxSatisfaction(satisfaction, index + 1, time);  //Since excluding dish, no update to time

        return Math.max(include, exclude);

    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return maxSatisfaction(satisfaction, 0, 1);
    }
}
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*n) 
** Space Complexity: O(n*n)
**/
class Solution {

      public int maxSatisfactionMem(int[] satisfaction, int index, int time, int dp[][]) {

        int n = satisfaction.length;
        //Base Case
        if (index == n) {
            return 0;
        } else if (dp[index][time] != -1) { //Pre Calculated
            return dp[index][time];
        }

        int include = (satisfaction[index] * time) + maxSatisfactionMem(satisfaction, index + 1, time + 1, dp);
        int exclude = maxSatisfactionMem(satisfaction, index + 1, time, dp); //Since excluding dish, no update to time

        dp[index][time] = Math.max(include, exclude);

        return dp[index][time];
    }

    public int maxSatisfaction(int[] satisfaction) {
       int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxSatisfactionMem(satisfaction, 0, 1, dp);
    }
}
==========================================================
/**
** Bottom Up(Because Starting form last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n*n)
** Space Complexity: O(n*n) 
**/

class Solution {

    public int maxSatisfaction(int[] satisfaction) {
       int n = satisfaction.length;
        Arrays.sort(satisfaction);
       int dp[][] = new int[n + 1][n + 2]; //Original Array Needed int dp[n][n+1] but to handle array out of bound for last index where we have index+1 or time+1, increase size by 1

        for (int index = n - 1; index >= 0; index--) {
            for (int time = index + 1; time >= 1; time--) { //At any index, timer value will be index+1

                int include = (satisfaction[index] * time) + dp[index + 1][time + 1];
                int exclude = dp[index + 1][time]; //Since excluding dish, no update to time

                dp[index][time] = Math.max(include, exclude);
            }
        }

        return dp[0][1];
    }
}
=================================================
/**
** Bottom-up and Space Optimized Approach. 
** Time Complexity: O(n*n)
** Space Complexity: O(n)
**/
class Solution {

    public int maxSatisfaction(int[] satisfaction) {
   int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int prevIndex[] = new int[n + 2];
        int currentIndex[] = new int[n + 2];

        for (int index = n - 1; index >= 0; index--) {
            for (int time = index + 1; time >= 1; time--) {

                //Base Case Handling

                int include = (satisfaction[index] * time) + prevIndex[time + 1];
                int exclude = prevIndex[time]; //Since excluding dish, no update to time

                currentIndex[time] = Math.max(include, exclude);
            }
            prevIndex = Arrays.copyOf(currentIndex, n + 2);
        }

        return prevIndex[1];
    }
}
