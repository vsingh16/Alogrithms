/**
** https://www.geeksforgeeks.org/longest-common-substring-dp-29/
** Diff b/w substring and subsequence : susbtring is always continuous where as subsequence can be discontinuous
** eg ABCD , ADCD
** LCS = 2 , CD
** Approach 1:
** Recursive or brute force approach is:
** Keep a pointer at last char of both Strings, if both are equal 1+ LCS(s1,s2,x-1,y-1)
** else LCS(s1,s2,x-1,y-1) 
** when x<0 || y <0 , return result
** Time Complexity : O(2^n) stack calls in worst case
**
** Approach 2: since its longest, we can relate and see they are some overlapping fun calls, so we can use DP.
** Time Complexity : O(xy), Space Complexity : O(xy)
** Approach 3: we can further space optimized DP, as it is always looking at previous one only, so if i is even , fill at even and refer odd and vice versa.
** Time Complexity : O(xy), Space Complexity : we will need to 2 arrays of size y = 2y = O(y)
**/

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends





class Solution
{
  
  
  //Approach 1
   int longestCommonSubstr(String s1, String s2, int n, int m, int count){
        
        if(n ==0 || m==0){
	  return count;	
	}else if(s1.charAt(n-1) == s2.charAt(m-1)){
		count = longestCommonSubstr(s1, s2, n-1, m-1, count+1);
	}else{
		return max(count, longestCommonSubstr(s1, s2, n-1, m, 0), longestCommonSubstr(s1, s2, n, m-1, 0));
	}
		   
    }
	
  //Approach 2
  int longestCommonSubstr(String s1, String s2, int n, int m){
        
        int dp[][] = new int[n+1][m+1];
        int result = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    result = Math.max(result, dp[i][j]);
                }else{
                    dp[i][j] = 0; //discontinue
                }
            }
        }
        
        return result;
    }
  
    //Function to find the length of longest common subsequence in two strings.
    //Approach 3
   int longestCommonSubstr(String s1, String s2, int n, int m){
        
        int dp[][] = new int[2][m+1];
        int result = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                
                if(i == 0 || j == 0){
                    dp[i%2][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i%2][j] = 1 + dp[(i+1)%2][j-1];
                    result = Math.max(result, dp[i%2][j]);
                }else{
                    dp[i%2][j] = 0;
                }
            }
        }
        
        return result;
    }
	
}
