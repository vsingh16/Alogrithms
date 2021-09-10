/**
** https://www.youtube.com/watch?v=L2NShjXvUNM&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=15
** https://www.geeksforgeeks.org/find-number-of-islands/
** Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
Example: 
 

Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1} 
Output : 5

Approach : We need to start from 1(i.e land) and now from here we can move in 8 directions,
** If next cordinate is 1 i.e land , it is part of same island , if 0(water) we can't move
** We will apply DFS and keep counter of how many times we able to DFS.
** Time Complexity: O(n*m)
** Space Complexity: O(n*m)
**/


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
       
       int n = grid.length;
       int m = grid[0].length;     
       boolean visited[][] = new boolean[n][m];
       int counter = 0;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j] == '1' && !visited[i][j]){ // if node is not visited and if it is land
                   counter++;
                   DFS(grid,visited,i,j,n,m);
               }
           }
       }
       return counter;
    }
    
    public void DFS(char[][] grid,boolean[][] visited,int i,int j,int n,int m){
        if(i<0 || j<0 || i>= n || j>=m) return; // out of matrix
        if(grid[i][j] != '1') return; // if not land
        if(!visited[i][j]){ // only if not visited
            visited[i][j] = true;
            DFS(grid,visited,i-1,j-1,n,m);
            DFS(grid,visited,i-1,j,n,m);
            DFS(grid,visited,i-1,j+1,n,m);
            DFS(grid,visited,i,j-1,n,m);
            DFS(grid,visited,i,j+1,n,m);
            DFS(grid,visited,i+1,j-1,n,m);
            DFS(grid,visited,i+1,j,n,m);
            DFS(grid,visited,i+1,j+1,n,m);
        }
        return ;
    }      
}








