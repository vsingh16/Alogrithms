package dynamic.programming;

/**
 * Created by vishal on 29-Apr-18.
 * <p>
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 * <p>
 * Approach1:
 * find all substring , then find longest len palindrome among it.
 * Time Complexity:O(n^3)
 * <p>
 * Approach2:
 * Since this is substring, it has to be continuous,
 * Case 1: if String is of length = 1, i.e i == j =>  dp[i][j] =1
 * Case 2: if len is 2, i+1 ==j , str[i] == str[j], dp[i][j] = 2 
 * Case 3: if len > 2 and str[i] == str[j] & str[i+1] == str[j-1], dp[i][j] = 2+dp[i+1][j-1] else 0.
 * We will keep max variable
 * Using DP:palindomre(i,j) = if(str[i] == str[j]) and substring(i+1,j-1) is palindrome
 * then substring(i,j) is also palindorme
 */
public class LongestPalindromeString {

    // Time Complexity: O(n^2)
    //Space Complexity: O(n^2)
      public String longestPalindrome(String str) {
        int n = str.length();
        int dp[][] = new int[n][n];        
        int max=-1;        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                //one length
                if (i == j) {
                    dp[i][j] = 1;                    
                    max = Math.max(max, dp[i][j]);                    
                } else if (j > i) { // more than 1 length
                    if (str.charAt(i) == str.charAt(j) && i+1 == j) {//len = 2
                        dp[i][j] = 2;
                        max = Math.max(max, dp[i][j]);
                    } else if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] > 0){ //len >2
                        dp[i][j] = 2+ dp[i+1][j-1];
                        max = Math.max(max, dp[i][j]);
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
                
        int posi=-1,posj=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
     
                if(dp[i][j] == max){                    
                    posi=i;
                    posj=j;
                }
            }
     
        }
        
        return str.substring(posi,posj+1);
    }
}
