/**
** https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/
** https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
** https://www.youtube.com/watch?v=x1Hp_2Lc0xM
** https://www.youtube.com/watch?v=_QPrHo88mAc
** Approach : There are few cases where we will not move : if (i,j) is out of matrix, if (i,j) = obstacle , if(i,j) = is alreayd included in path
** To track moves we already have , path[][] matrix is maintained.

Time Complexity: O(3^(n^2)). 
As there are N^2 cells from each cell there are 3 unvisited neighbouring cells. So the time complexity O(3^(N^2).
Auxiliary Space: O(3^(n^2)). // n * n = path matrix, else 3^(n*n) recursive call
As there can be atmost 3^(n^2) cells in the answer so the space complexity is O(3^(n^2))
**/

class Solution {
    ArrayList<String> output;
    public ArrayList<String> findPath(int[][] m, int n) {
        output = new ArrayList<>();
        boolean path[][] = new boolean[n][n];
        findPath(m, 0, 0, path, "");
        return output;
    }
    
    private void findPath(int[][] m, int i, int j, boolean[][] path,
    String result) {
        
        //destination is obstacle && edge case
        if(m[m.length-1][m.length-1] == 0){
            output.add("-1");
            return ;
        }
        
        //destination reached
        if(i == m.length - 1 && j == m[0].length-1){
            //print answer
            path[i][j] = true;
            output.add(result);
            return ;
        }

        
        //if out of matrix or path is already there in solution
        // or obstacle
        if(i == -1 || i == m.length || j == -1 || j == m[0].length 
        || path[i][j] || m[i][j] == 0){ 
            return ;
        }
        
        path[i][j] = true;
        findPath(m, i+1, j, path,result+"D");
        findPath(m, i, j-1, path,result+"L");
        findPath(m, i, j+1, path,result+"R");
        findPath(m, i-1, j, path,result+"U");
        path[i][j] = false; //backtrack
        
    }
    
    private boolean isOutOfMaze(int m, int i, int j){
        
        return i == -1 || i == m
        || j == -1 || j == m;
        
    }
}
