package dynamic.programming;

/**
 * Created by vishal on 24-Mar-18.
 ** https://www.geeksforgeeks.org/edit-distance-dp-5/
 ** https://leetcode.com/problems/edit-distance/description/
 ** https://www.youtube.com/watch?v=8HEjwf28LyE&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=36 . Love Babbar
 */
public class EditDistance {

    /**
     * Given two strings str1 and str2 and below operations that can performed on str1. Find the minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
     * *
     * Insert
     * Remove
     * Replace
     * All of the above operations are of equal cost.
     * <p>
     * Examples:
     * <p>
     * Input:   str1 = "geek", str2 = "gesek"
     * Output:  1
     * We can convert str1 into str2 by inserting a 's'.
     * <p>
     * Input:   str1 = "cat", str2 = "cut"
     * Output:  1
     * We can convert str1 into str2 by replacing 'a' with 'u'.
     * <p>
     * Input:   str1 = "sunday", str2 = "saturday"
     * Output:  3
     * Last three and first characters are same.  We basically
     * need to convert "un" to "atur".  This can be done using
     * below three operations.
     * Replace 'n' with 'r', insert t, insert a     
     */

    /**
    ** Approach: start traversing from fthe irst characters.
    ** Case 1: if they are the same, no operation is required, simply move to next i.e i+1, j+1
    ** Case 2: If not same, there can be 3 possibility, insert, replace or remove, so 1(1 operation either insert,remove,replace) + 
    ** insert in string 1, i, j+1
    ** replace i+1, j+1
    ** remove/ignore in String 1 i+1, j
     */
   /**
** Recursion(Top Down Approach, as starting from Left 0th Index):
** Time Complexity: O(3^n)
** Space Complexity: O(n)
**/
class Solution {

    public static int minDistance(String word1, String word2, int i, int j) {

        //Base Case : If Word1 is short and word 2 remains, we can insert remaining of word 2 in word 1
        if (i == word1.length()) {
            return word2.length() - j;
        }

        //Base Case : If Word1 is longer and word 2 ends, we can delete remaining of word 1
        if (j == word2.length()) {
            return word1.length() - i;
        }

        //If Both character are same, no operation
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistance(word1, word2, i + 1, j + 1);
        } else {
            //We have 3 choices and we will take min of all 3
            int insert = 1 + minDistance(word1, word2, i, j + 1);
            int replace = 1 + minDistance(word1, word2, i + 1, j + 1);
            int delete = 1 + minDistance(word1, word2, i + 1, j);

            return Math.min(Math.min(insert, replace), delete);
        }

    }

    public static int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
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

    public static int minDistance(String word1, String word2, int i, int j, int[][] dp) {

        //Base Case : If Word1 is short and word 2 remains, we can insert remaining of word 2 in word 1
        if (i == word1.length()) {
            return word2.length() - j;
        }

        //Base Case : If Word1 is longer and word 2 ends, we can delete remaining of word 1
        if (j == word2.length()) {
            return word1.length() - i;
        } else if (dp[i][j] != -1) { //Already Calculated
            return dp[i][j];
        }


        //If Both character are same, no operation
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = minDistance(word1, word2, i + 1, j + 1, dp);
        } else {
            //We have 3 choices and we will take min of all 3
            int insert = 1 + minDistance(word1, word2, i, j + 1, dp);
            int replace = 1 + minDistance(word1, word2, i + 1, j + 1, dp);
            int delete = 1 + minDistance(word1, word2, i + 1, j, dp);

            dp[i][j] = Math.min(Math.min(insert, replace), delete);
        }

        return dp[i][j];

    }

    public static int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minDistance(word1, word2, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
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
    
    public static int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1]; //+1 to handle array out of bound index

        for (int i = word1.length(); i >= 0; i--) { //Recursion : i = 0 to word1.length() , tabular opposite
            for (int j = word2.length(); j >= 0; j--) { //Recursion : i = 0 to word2.length() , tabular opposite

                //Base Case : If Word1 is short and word 2 remains, we can insert remaining of word 2 in word 1
                if (i == word1.length()) {
                    dp[i][j] = word2.length() - j;
                } else if (j == word2.length()) {  //Base Case : If Word1 is longer and word 2 ends, we can delete remaining of word 1
                    dp[i][j] = word1.length() - i;
                } else if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    //We have 3 choices and we will take min of all 3
                    int insert = 1 + dp[i][j + 1];
                    int replace = 1 + dp[i + 1][j + 1];
                    int delete = 1 + dp[i + 1][j];

                    dp[i][j] = Math.min(Math.min(insert, replace), delete);
                }
            }

        }

        return dp[0][0]; // Recursion : minDistance(word1, word2, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
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

    public static int minDistance(String word1, String word2) {
        //+1 to handle array out of bound index
        int prevDp[] = new int[word2.length() + 1];
        int currentDp[] = new int[word2.length() + 1];

        for (int i = word1.length(); i >= 0; i--) { //Recursion : i = 0 to word1.length() , tabular opposite
            for (int j = word2.length(); j >= 0; j--) { //Recursion : i = 0 to word2.length() , tabular opposite

                //Base Case : If Word1 is short and word 2 remains, we can insert remaining of word 2 in word 1
                if (i == word1.length()) {
                    currentDp[j] = word2.length() - j;
                } else if (j == word2.length()) {  //Base Case : If Word1 is longer and word 2 ends, we can delete remaining of word 1
                    currentDp[j] = word1.length() - i;
                } else if (word1.charAt(i) == word2.charAt(j)) {
                    currentDp[j] = prevDp[j + 1];
                } else {
                    //We have 3 choices and we will take min of all 3
                    int insert = 1 + currentDp[j + 1];
                    int replace = 1 + prevDp[j + 1];
                    int delete = 1 + prevDp[j];

                    currentDp[j] = Math.min(Math.min(insert, replace), delete);
                }
            }

            //Copy current to prev
            prevDp = Arrays.copyOf(currentDp, currentDp.length);
        }

        return prevDp[0]; // Recursion : minDistance(word1, word2, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
