/**
** https://leetcode.com/problems/longest-palindromic-subsequence/submissions/
** Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

** Approach: First thing to note is this is subsequence i.e string is not necesarily continuous eg : in above string "bbbab", subseq = bbbb , we can skip a
** Recursive: i = 0, j = n-1, if len of string is 1, ans 1
** Case2: if ch[i] == ch[j] and len is 2 i.e i+1 == j, ans 2
** Case3: else if ch[i] == ch[j], fun(str, i+1,j-1)
** Case4: max(fun(ch,i+1,j), fun(ch,i,j-1))
**/

//Time Complexity : 2^n
public static int lps(String str, int i, int j) {
        if(j>i){
         return 0;
        }
        else if (i == j) {
            return 1;
        } else if (i + 1 == j && str.charAt(i) == str.charAt(j)) {
            return 2;
        } else if (str.charAt(i) == str.charAt(j)) {
            return 2 + lps(str, i + 1, j - 1);
        } else {
            return Math.max(lps(str, i, j - 1), lps(str, i + 1, j));
        }
    }

/**
** DP: Since in recursion, i is increasing and j is decreasing, therefore we are starting i=n-1
** & j = 0.
** we will only consider case where len =1 and len>=2
** Time Complexity : O(n*n)
** Space Complexity: O(n*n)
**/
 public static int lps(String str) {

        int n = str.length();
        int dp[][] = new int[n][n];
        for (int i = n - 1; i >= 0; i--) { //Recuraion: i=0 to n-1
            for (int j = 0; j < n; j++) { //Recuraion: j=n-1 to 0

                //one length
                if (i == j) {
                    dp[i][j] = 1;
                } else if (j > i) { // more than 1 length
                    if (str.charAt(i) == str.charAt(j) && i + 1 == j) {//2 length
                        dp[i][j] = 2;
                    }
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1]; //Recurtsion lps(String str, 0, int n-1) 
    }
