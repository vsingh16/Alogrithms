/**
** https://leetcode.com/problems/sudoku-solver/submissions/
** Write a program to solve a Sudoku puzzle by filling the empty cells.

** A sudoku solution must satisfy all of the following rules:

** Each of the digits 1-9 must occur exactly once in each row.
** Each of the digits 1-9 must occur exactly once in each column.
** Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
** The '.' character indicates empty cells.
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Time Complexity : O(9^n*n)
Space Complexity :O(1)
**/

class Solution {
    
    private static final char EMPTY_CELL = '.';
    public void solveSudoku(char[][] grid){
        solveSudoku(grid,0,0);
    }
    
    public boolean solveSudoku(char[][] grid, int i,int j) {
        
        if(i == grid.length){                        
            return true;
        }
        
        int ni,nj;
        if(j == grid[0].length - 1){
            nj = 0;
            ni = i + 1;
        }else{
            ni = i;
            nj = j + 1;
        }
        
        if(grid[i][j] != EMPTY_CELL){
            return solveSudoku(grid, ni, nj);
        }else{
            for(int po=1;po<=9;po++){
                char c=(char) (po+'0');  //to convert int 1 to char '1'
                if(isValid(grid,i,j,c)){
                    grid[i][j] = c;                                        
                    if(solveSudoku(grid, ni, nj)){
                        return true;
                    }
                      grid[i][j] = EMPTY_CELL;
                }
            }
        }
        
        return false;
        
    }
            
    private boolean isValid(char grid[][], int row, int col, char po){
        
        //check po should not be there in row
        for(int j=0;j<grid[0].length;j++){
            if(grid[row][j] == po){
                return false;
            } 
        }
        
        //check po should not be there in col 
        for(int i=0;i<grid.length;i++){
            if(grid[i][col] == po){
                return false;
            } 
        }
        
        //check po should not be there in sub matrix of 3 * 3
        int smi = row/3 * 3;
        int smj = col/3 * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
              if(grid[smi + i][smj + j] == po){
                return false;
              }   
            }
        }
        
        return true;
    }
    
    private void printGrid(char grid[][])
    {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]);
                if(j<grid[0].length-1){
                    System.out.print(",");    
                }
            }
            System.out.println();
        }
    }
}
