/**
** Ref: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/
** https://www.youtube.com/watch?v=XY297u8qRDI&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=22. Love Babbar

** Approach:
** Here all dices are thrown together but once.
** For a dice, we can have values from 1 to faces. We need to explore all faces.
** Since all dices are thrown together we need to check this for all dices.
**/

/**
** Recursion(Bottom Up Approach, as starting from right most dice):
** Time Complexity: O(dice*sum*face)
** Space Complexity: O(dice*sum)
**/
class Solution {
    static long noOfWays(int faces, int dices, int x) {
        
     //Base Cases
        if (x < 0) { //If sum is -ve
            return 0;
        } else if (dices == 0 && x == 0) { //Since all dices are thrown together, for valid ans n should also be 0
            return 1;
        } else if (dices != 0 && x == 0) { //Because we need to take sum of all dices, hence dices cant be left
            return 0;
        } else if (dices == 0 && x != 0) { //No Dices left but sum is there
            return 0;
        }

        long ans = 0;
        for (int i = 1; i <= faces; i++) {
            ans = ans + noOfWays(faces, dices - 1, x - i);
        }

        return ans;
    }
}
==========================================================
/**
** Recursion(Bottom Up) + Memorization
** Time Complexity: O(dice*sum*face)
** Space Complexity: O(dice*sum)
**/
class Solution {
    
    static long noOfWaysMem(int faces, int dices, int targetSum, long dp[][]) {

        //Base Cases
        if (targetSum < 0) {
            return 0;
        } else if (dices == 0 && targetSum == 0) { //Since all dices are thrown together, for valid ans n should also be 0
            return 1;
        } else if (dices != 0 && targetSum == 0) { //Because we need to take sum of all dices, hence dices cant be left
            return 0;
        } else if (dices == 0 && targetSum != 0) { //No Dices left but sum is there
            return 0;
        } else if (dp[dices][targetSum] != -1) { //Already Calculated
            return dp[dices][targetSum];
        }

        long ans = 0;
        for (int i = 1; i <= faces; i++) {
            ans = ans + noOfWaysMem(faces, dices - 1, targetSum - i, dp);
        }

        dp[dices][targetSum] = ans;
        return dp[dices][targetSum];
    }
    
    static long noOfWays(int faces, int dices, int targetSum) {
        
     long dp[][] = new long[dices + 1][targetSum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return noOfWaysMem(faces, dices, targetSum, dp);
    }
};
==========================================================
/**
** Top Down Approach(Because Starting from 0 index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(dice*sum*face*)
** Space Complexity: O(dice*sum) 
**/

class Solution {

    static long noOfWays(int faces, int dices, int targetSum) {
        
       long dp[][] = new long[dices + 1][targetSum + 1];

        //Base Case
        dp[0][0] = 1;

        for (int dice = 1; dice <= dices; dice++) {
            for (int sum = 1; sum <= targetSum; sum++) {
                long ans = 0;
                for (int face = 1; face <= faces; face++) {
                    if (sum - face >= 0) { //To handle -ve index
                        ans = ans + dp[dice - 1][sum - face];
                    }
                }
                dp[dice][sum] = ans;
            }
        }

        return dp[dices][targetSum];
    }
};
=================================================
/**
** Space Optimized DP
** Time Complexity: O(dice*sum*face*)
** Space Complexity: O(sum) 
**/

class Solution {

    static long noOfWays(int faces, int dices, int targetSum) {
        
   
        long currentDp[] = new long[targetSum + 1];
        long prevDp[] = new long[targetSum + 1];

        //Base Case
        prevDp[0] = 1;

        for (int dice = 1; dice <= dices; dice++) {
            for (int sum = 1; sum <= targetSum; sum++) {
                long ans = 0;
                for (int face = 1; face <= faces; face++) {
                    if (sum - face >= 0) { //To handle -ve index
                        ans = ans + prevDp[sum - face];
                    }
                }
                currentDp[sum] = ans;
            }
            prevDp = Arrays.copyOf(currentDp, currentDp.length);
        }

        return prevDp[targetSum];
    }
};
