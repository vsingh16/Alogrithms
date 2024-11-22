/**
** Ref: https://leetcode.com/problems/minimum-sideway-jumps/description/
** https://www.youtube.com/watch?v=dvTTtzamEEo&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=16 Love Babbar DP
** There is a 3 lane road of length n that consists of n + 1 points labeled from 0 to n. A frog starts at point 0 in the second lane and wants to jump to point n. However, there could be obstacles along the way.

You are given an array obstacles of length n + 1 where each obstacles[i] (ranging from 0 to 3) describes an obstacle on the lane obstacles[i] at point i. If obstacles[i] == 0, there are no obstacles at point i. There will be at most one obstacle in the 3 lanes at each point.

For example, if obstacles[2] == 1, then there is an obstacle on lane 1 at point 2.
The frog can only travel from point i to point i + 1 on the same lane if there is not an obstacle on the lane at point i + 1. To avoid obstacles, the frog can also perform a side jump to jump to another lane (even if they are not adjacent) at the same point if there is no obstacle on the new lane.

For example, the frog can jump from lane 3 at point 3 to lane 1 at point 3.
Return the minimum number of side jumps the frog needs to reach any lane at point n starting from lane 2 at point 0.

Approach: If no obstacle at next positon in same lane, simply move
else we have to side jump to other lane in same position.

**/

/**
** Top Down(Becuase starting point is 0, start) + Recursion
** Time Complexity: O(2^n), as in case of side jump we will explore rest two lanes
** Space Complexity: O(n)
**/


class Solution {

    public int minSideJumps(int[] obstacles, int currentPos, int currentLane) {

        //Base Case
        if (currentPos == obstacles.length - 1) {
            return 0;
        }

        //No Obstacle in current Lane
        if (obstacles[currentPos + 1] != currentLane) {
            return minSideJumps(obstacles, currentPos + 1, currentLane);
        } else {

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                //Side Jump cant be to same lane && there should be no obstacles in the jumping lane
                if (i != currentLane && obstacles[currentPos] != i) {
                    min = Math.min(min, 1+minSideJumps(obstacles, currentPos, i));
                }
            }

            return min;

        }

    }

    public int minSideJumps(int[] obstacles) {
        return minSideJumps(obstacles, 0, 2);

    }
}	
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*3*3) = O(n)
** Space Complexity: O(n) //2D Array but col size is fix 
**/
class Solution {

 public int minSideJumpsMem(int[] obstacles, int currentPos, int currentLane, int dp[][]) {

   //Base Case
        if (currentPos == obstacles.length - 1) {
            return 0;
        } else if (dp[currentPos][currentLane] != -1) { //Pre Calculated
            return dp[currentPos][currentLane];
        }

        //No Obstacle in current Lane
        if (obstacles[currentPos + 1] != currentLane) {
            dp[currentPos][currentLane] = minSideJumpsMem(obstacles, currentPos + 1, currentLane, dp);
            return dp[currentPos][currentLane];
        } else {

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                //Side Jump cant be to same lane && there should be no obstacles in the jumping lane
                if (i != currentLane && obstacles[currentPos] != i) {
                    min = Math.min(min, 1+ minSideJumpsMem(obstacles, currentPos, i, dp));
                }
            }

            dp[currentPos][currentLane] = min;
            return dp[currentPos][currentLane];

        }

    }


    public int minSideJumps(int[] obstacles) {
       int dp[][] = new int[obstacles.length][4];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minSideJumpsMem(obstacles, 0, 2, dp);
    }
}
==========================================================
/**
** Bottom Up(Becuae Starting form last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.
** Handling 1:
** In recursion we started from a fix position (0,2) and landed at last position any lane.
** But in Bottom Up , we are starting from last position and all 3 lanes.
** Hence ans can be (0,2) itself or (0,1) or (0,2).
** In case of (0,1) and (0,3), we need to add 1 for a sidejump. Math.min(dp[0][2], 1 + Math.min(dp[0][1], dp[0][3]));

** Handling 2:
** Now we are coming from last to start.
** At points where we have obstacle in next position, we cant move hence we explore lanes at current position
** But in this case because of bottom up, lanes at currentPos is not yet calculated.
** To handle this we can get value at a lane from next position
** Detail: https://www.youtube.com/watch?v=dvTTtzamEEo&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=16.Timestamp: 34:08

** Time Complexity: O(n*3*3) = O(n)
** Space Complexity: O(n) //2D Array but col size is fix 
**/

class Solution {

    public int minSideJumps(int[] obstacles) {

  int n = obstacles.length;
        int[][] dp = new int[n][4]; // dp[position][lane]

        // Base case: No jumps are required at the last position
        dp[n - 1][1] = dp[n - 1][2] = dp[n - 1][3] = 0;

   

        // Bottom-up DP computation
        for (int currentPos = n - 2; currentPos >= 0; currentPos--) {
            for (int currentLane = 1; currentLane <= 3; currentLane++) {

                //No Obstacle in current Lane Next Step
                if (obstacles[currentPos + 1] != currentLane) {
                    dp[currentPos][currentLane] = dp[currentPos + 1][currentLane];
                } else {

                    int min = Integer.MAX_VALUE;
                    for (int i = 1; i <= 3; i++) {
                        //Side Jump cant be to same lane && there should be no obstacles in the jumping lane
                        if (i != currentLane && obstacles[currentPos] != i) {
                            min = Math.min(min, 1 + dp[currentPos + 1][i]); //Handling 2
                        }
                    }

                    dp[currentPos][currentLane] = min;
                }
            }
        }

        return Math.min(dp[0][2], 1 + Math.min(dp[0][1], dp[0][3])); //Handling 1

    }

}
=================================================
/**
** Bottom-up and More Space Optimized Approach. 
** Time Complexity: O(n*3*3) = O(n)
** Space Complexity: O(1) //two array of fix 4 size 
**/
public class Test {

    public static int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int currentPosDp[] = new int[4];
        int prevPosDp[] = new int[4];


        // Base case: No jumps are required at the last position
        prevPosDp[1] = prevPosDp[2] = prevPosDp[3] = 0;


        // Bottom-up DP computation
        for (int currentPos = n - 2; currentPos >= 0; currentPos--) {
            for (int currentLane = 1; currentLane <= 3; currentLane++) {

                //No Obstacle in current Lane Next Step
                if (obstacles[currentPos + 1] != currentLane) {
                    currentPosDp[currentLane] = prevPosDp[currentLane];
                } else {

                    int min = Integer.MAX_VALUE;
                    for (int i = 1; i <= 3; i++) {
                        //Side Jump cant be to same lane && there should be no obstacles in the jumping lane
                        if (i != currentLane && obstacles[currentPos] != i) {
                            min = Math.min(min, 1 + prevPosDp[i]);
                        }
                    }

                    currentPosDp[currentLane] = min;
                }
            }
            prevPosDp = Arrays.copyOf(currentPosDp, 4);
        }

        return Math.min(prevPosDp[2], 1 + Math.min(prevPosDp[1], prevPosDp[3]));
    }

    public static void main(String[] args) {
        int obstacle[] = {0, 1, 2, 3, 0};
        System.out.println(minSideJumps(obstacle));
    }
}
