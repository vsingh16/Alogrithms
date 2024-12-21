/**
** Ref: https://leetcode.com/problems/longest-common-subsequence/description/
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
https://www.youtube.com/watch?v=y1b8pObvndA&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=144. Love Babbar

** Diff b/w substring and subsequence : susbtring is always continuous where as subsequence can be discontinuous
** eg ABC , ADB
** LCS = 2 , AB
** Approach:
** Recursive or brute force approach is:
** Keep a pointer at 0 index char of both Strings, if both are equal 1+ LCS(s1,s2,x-1,y-1)
** else MAX(LCS(s1,s2,x,y-1) , LCS(s1,s2,x-1,y))
** Time Complexity : O(2^n) stack calls in worst case
**
**/

/**
** Recursion(Top Down Approach, as starting from Left 0th Index):
** Time Complexity: O(2^n)
** Space Complexity: O(n)
**/
class Solution {

    public static int longestCommonSubsequence(String text1, String text2, int text1Index, int text2Index) {

        //Base Case
        if (text1Index == text1.length() || text2Index == text2.length()) {
            return 0;
        }

        if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
            return 1 + longestCommonSubsequence(text1, text2, text1Index + 1, text2Index + 1);
        } else {
            //When char is not same we have two choices either increase text1 pointer or tex2 pointer
            return Math.max(longestCommonSubsequence(text1, text2, text1Index + 1, text2Index), longestCommonSubsequence(text1, text2, text1Index, text2Index + 1));
        }

    }

    public static int longestCommonSubsequence(String text1, String text2) {

        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n1*n2)  //n1,n2 string length
** Space Complexity: O(n1*n2) //n1,n2 string length
**/
import java.util.Arrays;

class Solution {

    public static int longestCommonSubsequence(String text1, String text2, int text1Index, int text2Index, int dp[][]) {

        //Base Case
        if (text1Index == text1.length() || text2Index == text2.length()) {
            return 0;
        } else if (dp[text1Index][text2Index] != -1) { //Already Calculated
            return dp[text1Index][text2Index];
        }

        if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
            dp[text1Index][text2Index] = 1 + longestCommonSubsequence(text1, text2, text1Index + 1, text2Index + 1, dp);
        } else {
            //When char is not same we have two choices either increase text1 pointer or tex2 pointer
            dp[text1Index][text2Index] = Math.max(longestCommonSubsequence(text1, text2, text1Index + 1, text2Index, dp), longestCommonSubsequence(text1, text2, text1Index, text2Index + 1, dp));
        }

        return dp[text1Index][text2Index];
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int dp[][] = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestCommonSubsequence(text1, text2, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n1*n2)  //n1,n2 string length
** Space Complexity: O(n1*n2) //n1,n2 string length
**/

class Solution {

    public static int longestCommonSubsequence(String text1, String text2) {

        int dp[][] = new int[text1.length() + 1][text2.length() + 1]; // +1 to handle array out of bound index

        for (int text1Index = text1.length() - 1; text1Index >= 0; text1Index--) { //Recursion : text1Index = 0 to text1.length()-1, tabular opposite
            for (int text2Index = text2.length() - 1; text2Index >= 0; text2Index--) {  //Recursion : text2Index = 0 to text2.length()-1, tabular opposite

                if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
                    dp[text1Index][text2Index] = 1 + dp[text1Index + 1][text2Index + 1];
                } else {
                    //When char is not same we have two choices either increase text1 pointer or tex2 pointer
                    dp[text1Index][text2Index] = Math.max(dp[text1Index + 1][text2Index], dp[text1Index][text2Index + 1]);
                }


            }

        }

        return dp[0][0]; //final ans longestCommonSubsequence(text1, text2, 0, 0, dp) i.e dp[0][0]

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
=================================================
/**
** Space Optimized DP
** Time Complexity: O(n1*n2)  //n1,n2 string length
** Space Complexity: O(n2) //n2 string length
**/

import java.util.Arrays;

class Solution {
    
    public static int longestCommonSubsequence(String text1, String text2) {

        int prevDp[] = new int[text2.length() + 1];
        int currentDp[] = new int[text2.length() + 1];

        for (int text1Index = text1.length() - 1; text1Index >= 0; text1Index--) { //Recursion : text1Index = 0 to text1.length()-1, tabular opposite
            for (int text2Index = text2.length() - 1; text2Index >= 0; text2Index--) {  //Recursion : text2Index = 0 to text2.length()-1, tabular opposite

                if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
                    currentDp[text2Index] = 1 + prevDp[text2Index + 1];
                } else {
                    //When char is not same we have two choices either increase text1 pointer or tex2 pointer
                    currentDp[text2Index] = Math.max(prevDp[text2Index], currentDp[text2Index + 1]);
                }
            }

            //Copy current to prev
            prevDp = Arrays.copyOf(currentDp, currentDp.length);
        }

        return prevDp[0]; //final ans longestCommonSubsequence(text1, text2, 0, 0, dp) i.e dp[0][0]

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
