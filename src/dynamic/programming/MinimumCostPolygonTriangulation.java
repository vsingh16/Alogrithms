/**
** https://www.geeksforgeeks.org/minimum-cost-polygon-triangulation/
** https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
** https://www.youtube.com/watch?v=Eo4G_LPCgX8&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=16
** A triangulation of a convex polygon is formed by drawing diagonals between non-adjacent vertices (corners) such that the diagonals never intersect. The problem is to find the cost of triangulation with the minimum cost. The cost of a triangulation is sum of the weights of its component triangles. Weight of each triangle is its perimeter (sum of lengths of all sides)
See following example taken from this source. 
 

Minimum Cost Polygon Triangulation


Two triangulations of the same convex pentagon. The triangulation on the left has a cost of 8 + 2?2 + 2?5 (approximately 15.30), the one on the right has a cost of 4 + 2?2 + 4?5 (approximately 15.77). 
 


This problem has recursive substructure. The idea is to divide the polygon into three parts: a single triangle, the sub-polygon to the left, and the sub-polygon to the right. We try all possible divisions like this and find the one that minimizes the cost of the triangle plus the cost of the triangulation of the two sub-polygons.

** Approach: i =0 , j = n-1
** In any polygon , starting and last vertices will be adjacent.
** For a traingle we need a vertex which is non adjacent. Hence we can explore all vertexes b/w i and j
** Math.min(min, values[i] * values[k] * values[j] + minScoreTriangulation(values, i, k) + minScoreTriangulation(values, k, j));
** Base Case if(i+1 == j) i.e means we have only 2 vertex , so traingle cant be formed, hence 0
**/

/**
** Top Down(Becuase starting point is 0, start) + Recursion
** Time Complexity: O(2^n) or O(n^n)
** Space Complexity: O(n)
**/


class Solution {

      public int minScoreTriangulation(int[] values, int i, int j) {

        //Base Case
        if (i + 1 == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            min = Math.min(min, values[i] * values[k] * values[j] + minScoreTriangulation(values, i, k) + minScoreTriangulation(values, k, j));
        }

        return min;
    }


    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;
        return minScoreTriangulation(values, 0, n - 1);
    }
}
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*n*n)
** Space Complexity: O(n*n)
**/
class Solution {

      public int minScoreTriangulation(int[] values, int i, int j,int dp[][]) {

        //Base Case
        if (i + 1 == j) {
            return 0;
        } else if (dp[i][j] != -1) { //Already Calculated
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            min = Math.min(min, values[i] * values[k] * values[j] + minScoreTriangulation(values, i, k, dp) + minScoreTriangulation(values, k, j, dp));
            dp[i][j] = min;
        }

        return dp[i][j];
    }


    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);

        }
        return minScoreTriangulation(values, 0, n - 1, dp);
    }
}
==========================================================
/**
** Bottom Up(Becuae Starting form last index). Tabluar Approach is just opposite of recursion.
** Time Complexity: O(n*n*n)
** Space Complexity: O(n*n)
**/

class Solution {

   
    public int minScoreTriangulation(int[] values) {
 int n = values.length;
        int dp[][] = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i + 1 == j) {
                    dp[i][j] = 0;
                } else {

                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        min = Math.min(min, values[i] * values[k] * values[j] + dp[i][k] + dp[k][j]);
                        dp[i][j] = min;
                    }

                }

            }
        }
        return dp[0][n - 1];
    }
}
=================================================
