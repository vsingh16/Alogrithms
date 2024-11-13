/**
** https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
** https://www.youtube.com/watch?v=MMr19RE7KYY&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=14&pp=iAQB. Love Babbar
** Top Down(Becuase starting point is 0, start) + Recursion
** Time Complexity: O(3^(n+m))
** Space Complexity: O(n+m)
**/


class Solution {

    private static int maxLength;


    static int maxSquare(int a[][], int i, int j) {

        //Base Case
        if (i >= a.length || j >= a[0].length) {
            return 0;
        }

        int right = maxSquare(a, i, j + 1);
        int diagonal = maxSquare(a, i + 1, j + 1);
        int down = maxSquare(a, i + 1, j);

        int result = 0;
        if (a[i][j] == 1) {
            result = 1 + Math.min(Math.min(right, diagonal), down);
            maxLength = Math.max(maxLength, result);
        }
        return result;
    }

    static int maxSquare(int a[][]) {
        maxLength = Integer.MIN_VALUE;
        maxSquare(a, 0, 0);
		return maxLength;
    }
}
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*m)
** Space Complexity: O(n*m)
**/
class Solution {
    
    private static int maxLength;
    
static int maxSquare(int a[][], int i, int j, int dp[][]) {

        //Base Case
        if (i >= a.length || j >= a[0].length) {
            return 0;
        } else if (dp[i][j] != -1) { //Already Calculated
            return dp[i][j];
        }

        int right = maxSquare(a, i, j + 1, dp);
        int diagonal = maxSquare(a, i + 1, j + 1, dp);
        int down = maxSquare(a, i + 1, j, dp);

        int result = 0;
        if (a[i][j] == 1) {
            result = 1 + Math.min(Math.min(right, diagonal), down);
            maxLength = Math.max(maxLength, result);
        }

        dp[i][j] = result;
        return dp[i][j];
    }
     
    static int maxSquare(int a[][]) {
        maxLength = 0;
        int dp[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        maxSquare(a, 0, 0, dp);

        return maxLength;
    }
}
==========================================================
/**
** Bottom Up(Becuae Starting form last index). Tabluar Approach is just opposite of recursion.
** Time Complexity: O(n*m)
** Space Complexity: O(n*m)
**/

class Solution {
    
    private static int maxLength;
    
     
    static int maxSquare(int a[][]) {
    maxLength = 0;
        int dp[][] = new int[a.length + 1][a[0].length + 1]; //Size +1 is to handle out of index

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = a[0].length - 1; j >= 0; j--) {

                int right = dp[i][j + 1];
                int diagonal = dp[i + 1][j + 1];
                int down = dp[i + 1][j];

                int result = 0;
                if (a[i][j] == 1) {
                    result = 1 + Math.min(Math.min(right, diagonal), down);
                    maxLength = Math.max(maxLength, result);
                }

                dp[i][j] = result;

            }

        }


        return maxLength;
    }
}
=================================================
/**
** Bottom Up(Becuae Starting form last index). Tabluar Approach is just opposite of recursion. Space Optimized
** Time Complexity: O(n*m)
** Space Complexity: O(m)
**/
class Solution {
    
    private static int maxLength;
    
     
    static int maxSquare(int a[][]) {
   maxLength = 0;
        int current[] = new int[a[0].length + 1];
        int next[] = new int[a[0].length + 1];

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = a[0].length - 1; j >= 0; j--) {

                int right = current[j + 1]; //i = current
                int diagonal = next[j + 1]; //i+1 = next
                int down = next[j];

                int result = 0;
                if (a[i][j] == 1) {
                    result = 1 + Math.min(Math.min(right, diagonal), down);
                    maxLength = Math.max(maxLength, result);
                }

                current[j] = result;
            }
            
            next = Arrays.copyOf(current, current.length); //copy current array into next
            current = new int[a[0].length + 1]; //create a new current array

        }


        return maxLength;
    }
}
