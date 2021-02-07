/**
https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s. 

Example: 

Input:
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
Output :
1 1 1 1
1 1 1 1
Explanation : 
The largest rectangle with only 1's is from 
(1, 0) to (2, 3) which is
1 1 1 1
1 1 1 1 

Input:
0 1 1
1 1 1
0 1 1      
Output:
1 1
1 1
1 1
Explanation : 
The largest rectangle with only 1's is from 
(0, 1) to (2, 2) which is
1 1
1 1
1 1

Approach: We can also do this problem by Dynamic Programming but here we will see solution with stack.
iterate matrix and when 1 is encountered, add m[i][j] = m[i][j]+ m[i-1][j]
In this way we can convert this matrix into histogram at each row level.
Now we know how to calculate area of histogram using Stack.
So find area of histogram at each row and return max area.

Time Complexity : Since we traversed whole matrix . 
O(m*n)

https://practice.geeksforgeeks.org/problems/max-rectangle/1#
https://github.com/vsingh16/Alogrithms/blob/master/src/stack/FindMaxAreaHistogram.java
https://leetcode.com/problems/maximal-rectangle/submissions/
https://leetcode.com/submissions/detail/453163890/
/**

class Solution {
    
    public int maximalRectangle(char[][] matrix) {
    
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        int M[][] = new int[m][n];
                
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    M[i][j] = 1;
                }                
            }            
        }        
        
       for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(M[i][j] == 1){
                    M[i][j] = M[i][j] + M[i-1][j];
                }         
            }          
        }
    
        int maxArea = 0;
        for(int i=0;i<m;i++){
            int area = findAreaHistogram(M[i]);
            System.out.println(area);
            if(area > maxArea){
                maxArea = area;
            }
        }
    
        return maxArea;
    
    }
    
    private int findAreaHistogram(int hist[]){
        
        Stack<Integer> stack  = new Stack();
        int i=0;
        int maxArea = 0;
        while(i< hist.length){
            //push
            if(stack.empty() || hist[stack.peek()] <= hist[i]){
                stack.push(i++);
            }else{
                //discontinue area
                int top = stack.pop();
                int area = stack.empty() ? hist[top] * i 
                : hist[top] * (i-1 - stack.peek());
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        
        while(!stack.empty()){
            int top = stack.pop();
            int area = stack.empty() ? hist[top] * i 
                : hist[top] * (i-1 - stack.peek());
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
    }

}
