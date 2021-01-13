/**
https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
We have a matrix where in each row we have 0 and 1
Each row is sorted. Find row with maximum 1.

Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2

Approach 1: Brute Force. Traverse all matrix maintain count of 1 in each row. 
Time Complexity: O(m*n)

Approach 2: Since each row is sorted, we can apply binary search and find index of 1st one, from there we can calculate no of 1 in a row.
Time Complexity: O(m logn)

Approach3: First count no. of 1 from right in 1st row.
Then only look for 1 in next row from previous row index of 1.
Time Complexity : O(m + n)
First row col traversal n, then in each ro we need to have 1 or few 

**/


// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java : Approach 3 

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        
        //find first 1 index in first row
        int pos = m-1;
        while(pos>=0 && arr[0][pos] == 1){
            pos--;
        }
        
        int row = 0;
        int j = pos ;
        for(int i = 1;i<n;i++){
            while(j>=0 && arr[i][j] == 1){
                row = i;
                j--;
            }
        }
        
        return (pos==m-1 && row ==0) ? -1: row;
    }
}

int findIndexWithBinarySearch(int arr[][], int row, int m){
        
        int l =0, h=m-1;
        while(l <= h){
            
            int mid = l + (h-l)/2;
            if(mid >0 && arr[row][mid -1] == 0 && arr[row][mid] == 1){ //when no is 1 and its left element is zero, it means we have all 1 on its right
                return mid;
            }else if (arr[row][mid] == 0){ //when no is zero, it  means on left side we have all zero
                l = mid+1;
            }else{ //when no. is 1 and its left no is also 1
                h = mid-1;
            }            
        }
        
        //left side crossing means, its all 1 
        //right side crossing means, its all 0
        return h == -1 ? 0 : -1;
    }
    
    //Approach 2:
    int rowWithMax1sWithBinarySearch(int arr[][], int n, int m) {
        
        int minIndex = Integer.MAX_VALUE;
        int row = -1;
     for(int i=0;i<n;i++){
         int index = findIndexWithBinarySearch(arr, i, m);
         if(index>=0){
             if(index < minIndex){ //lesser index means more 1 starting from left
                 minIndex = index;
                 row = i;
             }
         }
     }
     
     return row;
    }
