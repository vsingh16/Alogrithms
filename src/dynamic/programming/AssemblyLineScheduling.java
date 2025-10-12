/**
** Ref: https://www.geeksforgeeks.org/dsa/assembly-line-scheduling-dp-34/
** Assembly line scheduling is a manufacturing problem. In automobile industries assembly lines are used to transfer parts from one station to another station.

- Manufacturing of large items like car, trucks etc. generally undergoes through multiple stations, where each station is responsible for assembling particular part only. Entire product be ready after it goes through predefined n stations in sequence. 

- Manufacturing of car may be done through several stages like engine fitting, coloring, light fitting, fixing of controlling system, gates, seats and many other things.

-The particular task is carried out at the station dedicated to that task only. Based on the requirement there may be more than one assembly line.

-In case of two assembly lines if the load at station j at assembly 1 is very high, then components are transfer to station of assembly line 2 the converse is also true. This technique helps to speed ups the manufacturing process.

 -The time to transfer the partial product from one station to next station on the same assembly line is negligible. During rush factory may transfer partially completed auto from one assembly line to another, complete the manufacturing as quickly as possible.

 ** Approach: We need to take the minimum of both assembly lines
 ** We have two choices: either move straight or diagonal

**/

/**
** Recursion(Top Down Approach)
** Time Complexity: O(2^n) 
** Space Complexity: O(n)
**/
class Solution {
    
    private static int flipAssembleLine(int currentLine) {
        return currentLine == 0 ? 1 : 0;
    }

    public static int carAssembly(int[][] a, int[][] T, int[] x, int currentLine, int currentPos) {

        //Base Case
        if (currentPos == a[0].length) {
            return currentLine == 0 ? x[0] : x[1]; // Point from where exit is happening
        }

        int straightMove = a[currentLine][currentPos] + carAssembly(a, T, x, currentLine, currentPos + 1);
        int diagonalMove = a[flipAssembleLine(currentLine)][currentPos] + T[currentLine][currentPos] + carAssembly(a, T, x, flipAssembleLine(currentLine), currentPos + 1);

        return Math.min(straightMove, diagonalMove);

    }
    
    public static int carAssembly(int n, int[][] a, int[][] T, int[] e, int[] x) {
        int assemblyLine1 = e[0] + a[0][0] + carAssembly(a, T, x, 0, 1);
        int assemblyLine2 = e[1] + a[1][0] + carAssembly(a, T, x, 1, 1);

        return Math.min(assemblyLine1, assemblyLine2);
        
    }
}


==========================================================
/**
** Top Down Approach(Since i is from 0) + Memorization.
** Time Complexity: O(n) , Since there will always be two assembly line, so only changing is no of stations
** Space Complexity: O(n)
**/

class Solution {
    
    private static int flipAssembleLine(int currentLine) {
        return currentLine == 0 ? 1 : 0;
    }

    public static int carAssembly(int[][] a, int[][] T, int[] x, int currentLine, int currentPos, int dp[][]) {
       //Base Case
        if (currentPos == a[0].length) {
            return currentLine == 0 ? x[0] : x[1]; // Point from where exit is happening
        } else if (dp[currentLine][currentPos] != -1) { //Already Calculated
            return dp[currentLine][currentPos];
        }

        int straightMove = a[currentLine][currentPos] + carAssembly(a, T, x, currentLine, currentPos + 1, dp);
        int diagonalMove = a[flipAssembleLine(currentLine)][currentPos] + T[currentLine][currentPos] + carAssembly(a, T, x, flipAssembleLine(currentLine), currentPos + 1, dp);

        dp[currentLine][currentPos] = Math.min(straightMove, diagonalMove);

        return dp[currentLine][currentPos];
    }
    
    public static int carAssembly(int n, int[][] a, int[][] T, int[] e, int[] x) {
        int dp[][] = new int[2][a[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int assemblyLine1 = e[0] + a[0][0] + carAssembly(a, T, x, 0, 1, dp);
        int assemblyLine2 = e[1] + a[1][0] + carAssembly(a, T, x, 1, 1, dp);

        return Math.min(assemblyLine1, assemblyLine2);
        
    }
}

==========================================================
/**
** Tabular(Since i is from n-1) Bottom Up Approach
** Since this is referring diagonal, at each pos we need to already know the results for both line. Hence line loop will be inner loop first.
** Time Complexity: O(n) , Since there will always be two assembly line, so only changing is no of stations
** Space Complexity: O(n)
**/

class Solution {
    
    private static int flipAssembleLine(int currentLine) {
        return currentLine == 0 ? 1 : 0;
    }

    public static int carAssembly(int n, int[][] a, int[][] T, int[] e, int[] x) {
       int dp[][] = new int[2][a[0].length + 1]; //+1 to handle array out of bound

        for (int currentPos = a[0].length; currentPos >= 0; currentPos--) { // recursion currentPos = 1 to a[0].length
            for (int currentLine = 1; currentLine >= 0; currentLine--) { // recursion currentLine = 0 to 1

                //Base Case
                if (currentPos == a[0].length) {
                    dp[currentLine][currentPos] = currentLine == 0 ? x[0] : x[1]; // Point from where exit is happening
                } else {
                    int straightMove = a[currentLine][currentPos] + dp[currentLine][currentPos + 1];
                    int diagonalMove = a[flipAssembleLine(currentLine)][currentPos] + T[currentLine][currentPos] + dp[flipAssembleLine(currentLine)][currentPos + 1];

                    dp[currentLine][currentPos] = Math.min(straightMove, diagonalMove);
                }
                
            }
        }

        int assemblyLine1 = e[0] + a[0][0] + dp[0][1];
        int assemblyLine2 = e[1] + a[1][0] + dp[1][1];

        return Math.min(assemblyLine1, assemblyLine2);
        
    }
}

=========================================================
