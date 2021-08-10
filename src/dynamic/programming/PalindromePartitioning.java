/**
** https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
** Given a string s, partition s such that every substring of the partition is a palindrome. Find min cut required to represent this as palindormic
partion i.e after partinion all substring should be palindorme.

A palindrome string is a string that reads the same backward as forward.


Example 1:

Input: s = "aab"
cut = 1, aa|b
Example 2:

Input: s = "a"
cut = 0, because string is palindorme

**/

/**
** Recursive Approach: check if given string is palindrome(string of length 1 is palindrome, return 0, as no cut is required)
** Else try to partion it at k = 0 <str.length
** Time complexity : (n-1) * 2^n
** As for a given string we can partion it in two substrings.
** and we can create such (n-1) partions
**/
class Solution {
  
  public boolean isPalindrome(String s){
    int i=0,j=s.length-1;
    while(i<j){
      if(s.charAt(i)!=str.charAt(j)){
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
     
    public int partition(String s, int i, int j) {
        
      if(i>=j && isPalindrome(s)){
        return 0;
      }
      
      int min = Integer.MAX_VALUE;
      for(int k=0;k<j;k++){
        min = Maths.min(min,partition(s,0,k) + partition(s,k+1,j) );
      }
      
      return min;
    }
}

/**
** Approach2: DP :
** We will build palindrome[][] matrix, bottom up approach
** Similarly, we will build dp[][] for min cuts, where dp[i][j] =
** First check if Str(i,j) is palindrome , if yes dp[i][j] = 0 else dp[i][j] = Min(min, dp[i][k]+dp[k+1][j]), k=i <j
** Time Complexity : O(n^3)
** Space Complexity : O(n^2)
**/
class Solution {
  
    int palindromicPartition(String str)
    {
      int n = str.length();
        boolean palindrome[][] = new boolean[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = (n - 1) - (l - 1); i >= 0; i--) {
                int j = i + (l - 1);//j is based on length from i
                if (l == 1) {
                    palindrome[i][j] = true;
                } else if (l == 2 && str.charAt(i) == str.charAt(j)) {
                    palindrome[i][j] = true;
                } else {
                    palindrome[i][j] = (str.charAt(i) == str.charAt(j)) && palindrome[i + 1][j - 1];
                }
            }
        }

        int dp[][] = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = (n - 1) - (l - 1); i >= 0; i--) {
                int j = i + (l - 1);//j is based on length from i
                if (palindrome[i][j]) {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j] + 1);
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][n - 1];
    }
}

/** Approach3: DP :
** We will build palindrome[][] matrix, bottom up approach.
** Now we will dp[n] , so dp[i] is string starting from 0 to i.
** First check if dp(i,j) is palindrome , if yes dp[i] = 0 else dp[i] = palindrome[k+1][i] && Min(min, dp[k]+1), k=i <j
** i.e only vaild Kth partion is if string from(k+1,i) is palindrome.
** Time Complexity : O(n^2)
** Space Complexity : O(n^2)
**/
class Solution {
  
    int palindromicPartition(String str)
    {
      int n = str.length();
        boolean palindrome[][] = new boolean[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = (n - 1) - (l - 1); i >= 0; i--) {
                int j = i + (l - 1);//j is based on length from i
                if (l == 1) {
                    palindrome[i][j] = true;
                } else if (l == 2 && str.charAt(i) == str.charAt(j)) {
                    palindrome[i][j] = true;
                } else {
                    palindrome[i][j] = (str.charAt(i) == str.charAt(j)) && palindrome[i + 1][j - 1];
                }
            }
        }

        int dp[][] = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = (n - 1) - (l - 1); i >= 0; i--) {
                int j = i + (l - 1);//j is based on length from i
                if (palindrome[i][j]) {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j] + 1);
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][n - 1];
    }
