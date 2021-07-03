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
  static int lcs(int x, int y, String s1, String s2)
    {
       if(x == 0 || y == 0){
         return 0;
       }
      
      if(s1.charAt(x) == s2.charAt(y)){
        return 1 + lcs(x-1, y-1, s1, s2);
      }else{
      return Math.max(lcs(x, y-1, s1, s2),lcs(x-1, y, s1, s2));
      }
    
    }
      
  //Approach 2
  static int lcs(int x, int y, String s1, String s2)
    {
        int result[][] = new int[x][y+1];
        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){                                
                if(i == 0 || j == 0){
                    result[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    result[i][j] = 1 + result[i][j-1];
                }else{
                    result[i][j] = Math.max(result[i][j],result[i][j-1]);
                }
            }
        }
        
        return result[x][y];
    }
  
    //Function to find the length of longest common subsequence in two strings.
    //Approach 3
    static int lcs(int x, int y, String s1, String s2)
    {
        int result[][] = new int[2][y+1];
        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                
                int iFill = (i%2 == 0) ? 0 : 1;
                int iRefer = (i%2 == 0)? 1 : 0;
                
                if(i == 0 || j == 0){
                    result[iFill][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    result[iFill][j] = 1 + result[iRefer][j-1];
                }else{
                    result[iFill][j] = Math.max(result[iRefer][j],result[iFill][j-1]);
                }
            }
        }
        
        return result[x%2==0 ? 0 : 1][y];
    }
    
}
