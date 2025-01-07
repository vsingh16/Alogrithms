/**
** Ref: https://www.geeksforgeeks.org/longest-repeating-subsequence/
** Given a string s, the task is to find the length of the longest repeating subsequence, such that the two subsequences don’t have the same string character at the same position, i.e. any ith character in the two subsequences shouldn’t have the same index in the original string. 

Examples:

Input: s= “abc”
Output: 0
Explanation: There is no repeating subsequence

Input: s= “aab”
Output: 1
Explanation: The two subsequence are ‘a'(0th index) and ‘a'(1th index). Note that ‘b’ cannot be considered as part of subsequence as it would be at same index in both. 

** Approach:
This is same as Longest common subsequence.
Only difference is we can consider given string as S2 and for the case when both characters are same we need to ensure their index
is different as we are checking for recurrence.
**/

/**
** Recursion(Top Down Approach, as starting from Left 0th Index):
** Time Complexity: O(2^n) //As we have 2 choices
** Space Complexity: O(n)
**/
class Solution {

    public static int longestRepeatingSubsequence(String s1, String s2, int i, int j) {

        //Base Case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        //Character should match but at different index as we are checking in same string
        if (i != j && s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestRepeatingSubsequence(s1, s2, i + 1, j + 1);
        }

        return Math.max(longestRepeatingSubsequence(s1, s2, i + 1, j), longestRepeatingSubsequence(s1, s2, i, j + 1));
    }

    public static int longestRepeatingSubsequence(String s) {
        return longestRepeatingSubsequence(s, s, 0, 0);
    }

    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(longestRepeatingSubsequence(str));
    }


}
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*n)  //n = String Length
** Space Complexity: O(n*n)  
**/
import java.util.Arrays;

class Solution {

    public static int longestRepeatingSubsequence(String s1, String s2, int i, int j, int dp[][]) {

        //Base Case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        } else if (dp[i][j] != -1) { //Already Calculated
            return dp[i][j];
        }

        //Character should match but at different index as we are checking in same string
        if (i != j && s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + longestRepeatingSubsequence(s1, s2, i + 1, j + 1, dp);
        } else {
            dp[i][j] = Math.max(longestRepeatingSubsequence(s1, s2, i + 1, j, dp), longestRepeatingSubsequence(s1, s2, i, j + 1, dp));
        }

        return dp[i][j];
    }

    public static int longestRepeatingSubsequence(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestRepeatingSubsequence(s, s, 0, 0, dp);
    }

    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(longestRepeatingSubsequence(str));
    }


}
==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n*n)  //n = String Length
** Space Complexity: O(n*n)  
**/

class Solution {
    
    public static int longestRepeatingSubsequence(String s) {
        int dp[][] = new int[s.length() + 1][s.length() + 1]; //+1 to handle Array out of Bound Index

        //Base Case is already handled, s.length =0;
        for (int i = s.length() - 1; i >= 0; i--) { // Recursion: i = 0 to s.length
            for (int j = s.length() - 1; j >= 0; j--) { // Recursion: j = 0 to s.length

                //Character should match but at different index as we are checking in same string
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(longestRepeatingSubsequence(str));
    }


}
=================================================
/**
** Space Optimized DP
** Time Complexity: O(n*n)  //n string length
** Space Complexity: O(n) //n string length
**/
import java.util.Arrays;

class Solution {

    public static int longestRepeatingSubsequence(String s) {
        int currentDp[] = new int[s.length() + 1]; //+1 to handle Array out of Bound Index
        int prevDp[] = new int[s.length() + 1]; //+1 to handle Array out of Bound Index

        //Base Case is already handled, s.length =0;
        for (int i = s.length() - 1; i >= 0; i--) { // Recursion: i = 0 to s.length
            for (int j = s.length() - 1; j >= 0; j--) { // Recursion: j = 0 to s.length

                //Character should match but at different index as we are checking in same string
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    currentDp[j] = 1 + prevDp[j + 1];
                } else {
                    currentDp[j] = Math.max(prevDp[j], currentDp[j + 1]);
                }
            }
            //Copy current dp to prev dp
            prevDp = Arrays.copyOf(currentDp, currentDp.length);
        }

        return prevDp[0];
    }

    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(longestRepeatingSubsequence(str));
    }


}
