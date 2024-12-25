/**
** https://www.geeksforgeeks.org/wildcard-pattern-matching/
** https://leetcode.com/problems/wildcard-matching/submissions/1487979066/
** https://www.youtube.com/watch?v=OgovJ9CB0hI&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=39. Love Babbar
** Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if wildcard pattern is matched with text.
** The matching should cover the entire text (not partial text).
The wildcard pattern can include the characters ‘?’ and ‘*’ 
‘?’ – matches any single character 
‘*’ – Matches any sequence of characters (including the empty sequence)

For example,

Text = "baaabab",
Pattern = “*****ba*****ab", output : true
Pattern = "baaa?ab", output : true
Pattern = "ba*a?", output : true
Pattern = "a*ab", output : false 
** 
Approach : There are couple of cases to consider:
n = str, m = pattern
1) if n == 0 && m == 0, true
2) if n == 0 && m !=0 , if empty char but pattern is non empty only valid case is if pattern is *
pattern[m-1] == '*', [0][m-1]
3) if n != 0 && m == 0: false
4) if (m-1) == '*', [n][m-1](if non empty string, skip *) || [n-1][m] (if empty string, skip string)
5) if(m-1) == ? [n-1][m-1]
6) else str.charAt(n-1) == pattern.charAt(m-1) && (n-1)(m-1)
**/

/**
** Recursion(Top Down Approach, as starting from Left 0th Index):
** Time Complexity: O(2^(n+m)) //Since in case of * we have 2 cases
** Space Complexity: O(n+m)
**/
class Solution {

    public static boolean isMatch(String s, String p, int i, int j) {

        //Base Case
        if (i == s.length() && j == p.length()) { //String and Pattern Both Empty
            return true;
        } else if (i == s.length()) { //Empty String But Not Pattern
            for (int z = j; z < p.length(); z++) { //We should only have * in pattern, if we have any other character, return false eg: ***** = true but *?=false , *a = false
                if (p.charAt(z) != '*') {
                    return false;
                }
            }
            return true;
        } else if (j == p.length()) { //Non Empty String but Empty Pattern
            return false;
        }


        if (p.charAt(j) == '*') {
            //Either Empty Seq or can fill with multiple characters
            //For Empty Seq, we can skip pattern and keep string pointer same
            //For Multiple characters, we will keep pattern pointer same but keep moving string pointer
            return isMatch(s, p, i, j + 1) || isMatch(s, p, i + 1, j);
        } else if (p.charAt(j) == '?') { //Can Be Any Single Character
            return isMatch(s, p, i + 1, j + 1);
        } else {
            //Not a Wild Character
            return s.charAt(i) == p.charAt(j) && isMatch(s, p, i + 1, j + 1);
        }

    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);

    }

    public static void main(String[] args) {
        String string = "cb";
        String pattern = "?a";
        System.out.println(isMatch(string, pattern));
    }
}
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*m)  //n = String Length
** Space Complexity: O(n*m)  //m = Pattern Length
**/
import java.util.Arrays;

class Solution {

    private static boolean convertToBoolean(int a) {
        return a == 1 ? true : false;
    }

    private static int convertToInt(boolean a) {
        return a == true ? 1 : 0;
    }

    public static int isMatch(String s, String p, int i, int j, int dp[][]) {

        //Base Case
        if (i == s.length() && j == p.length()) { //String and Pattern Both Empty
            return 1;
        } else if (i == s.length()) { //Empty String But Not Pattern
            for (int z = j; z < p.length(); z++) { //We should only have * in pattern, if we have any other character, return false eg: ***** = true but *?=false , *a = false
                if (p.charAt(z) != '*') {
                    return 0;
                }
            }
            return 1;
        } else if (j == p.length()) { //Non Empty String but Empty Pattern
            return 0;
        } else if (dp[i][j] != -1) { //Result is Already Calculated
            return dp[i][j];
        }


        if (p.charAt(j) == '*') {
            //Either Empty Seq or can fill with multiple characters
            //For Empty Seq, we can skip pattern and keep string pointer same
            //For Multiple characters, we will keep pattern pointer same but keep moving string pointer
            dp[i][j] = convertToInt(convertToBoolean(isMatch(s, p, i, j + 1, dp)) || convertToBoolean(isMatch(s, p, i + 1, j, dp)));
        } else if (p.charAt(j) == '?') { //Can Be Any Single Character
            return isMatch(s, p, i + 1, j + 1, dp);
        } else {
            //Not a Wild Character
            boolean result = (s.charAt(i) == p.charAt(j)) && (convertToBoolean(isMatch(s, p, i + 1, j + 1, dp)));
            dp[i][j] = convertToInt(result);
        }

        return dp[i][j];

    }

    public static boolean isMatch(String s, String p) {
        
        int dp[][] = new int[s.length()][p.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return convertToBoolean(isMatch(s, p, 0, 0, dp));

    }

    public static void main(String[] args) {
        String string = "cb";
        String pattern = "?a";
        System.out.println(isMatch(string, pattern));
    }
}
==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n*m)  //n = String Length
** Space Complexity: O(n*m)  //m = Pattern Length
**/

class Solution {

    public static boolean isMatch(String s, String p) {

        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1]; //+1 to handle Array out of Bound Index
        //Tab is just opposite of Recursion
        for (int i = s.length(); i >= 0; i--) {  //i = 0 to s.length()
            for (int j = p.length(); j >= 0; j--) {  //j = 0 to p.length()

                //Base Case
                if (i == s.length() && j == p.length()) { //String and Pattern Both Empty
                    dp[i][j] = true;
                } else if (i == s.length()) { //Empty String But Not Pattern
                    boolean result = true; //This I have handled as in recursion return statement was there.
                    for (int z = j; z < p.length(); z++) { //We should only have * in pattern, if we have any other character, return false eg: ***** = true but *?=false , *a = false
                        if (p.charAt(z) != '*') {
                            result = false;
                        }
                    }
                    dp[i][j] = result;
                } else if (j == p.length()) { //Non Empty String but Empty Pattern
                    dp[i][j] = false;
                } else {

                    if (p.charAt(j) == '*') {
                        //Either Empty Seq or can fill with multiple characters
                        //For Empty Seq, we can skip pattern and keep string pointer same
                        //For Multiple characters, we will keep pattern pointer same but keep moving string pointer
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    } else if (p.charAt(j) == '?') { //Can Be Any Single Character
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        //Not a Wild Character
                        dp[i][j] = (s.charAt(i) == p.charAt(j)) && dp[i + 1][j + 1];
                    }

                }

            }

        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        String string = "acdcb";
        String pattern = "a*c?b";
        System.out.println(isMatch(string, pattern));
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

    public static boolean isMatch(String s, String p) {

        boolean prevDp[] = new boolean[p.length() + 1]; //+1 to handle Array out of Bound Index
        boolean currentDp[] = new boolean[p.length() + 1]; //+1 to handle Array out of Bound Index

        //Tab is just opposite of Recursion
        for (int i = s.length(); i >= 0; i--) {  //i = 0 to s.length()
            for (int j = p.length(); j >= 0; j--) {  //j = 0 to p.length()

                //Base Case
                if (i == s.length() && j == p.length()) { //String and Pattern Both Empty
                    currentDp[j] = true;
                } else if (i == s.length()) { //Empty String But Not Pattern
                    boolean result = true; //This I have handled as in recursion return statement was there.
                    for (int z = j; z < p.length(); z++) { //We should only have * in pattern, if we have any other character, return false eg: ***** = true but *?=false , *a = false
                        if (p.charAt(z) != '*') {
                            result = false;
                        }
                    }
                    currentDp[j] = result;
                } else if (j == p.length()) { //Non Empty String but Empty Pattern
                    currentDp[j] = false;
                } else {

                    if (p.charAt(j) == '*') {
                        //Either Empty Seq or can fill with multiple characters
                        //For Empty Seq, we can skip pattern and keep string pointer same
                        //For Multiple characters, we will keep pattern pointer same but keep moving string pointer
                        currentDp[j] = currentDp[j + 1] || prevDp[j];
                    } else if (p.charAt(j) == '?') { //Can Be Any Single Character
                        currentDp[j] = prevDp[j + 1];
                    } else {
                        //Not a Wild Character
                        currentDp[j] = (s.charAt(i) == p.charAt(j)) && prevDp[j + 1];
                    }

                }

            }

            prevDp = Arrays.copyOf(currentDp, currentDp.length);

        }

        return prevDp[0];

    }

    public static void main(String[] args) {
        String string = "acdcb";
        String pattern = "a*c?b";
        System.out.println(isMatch(string, pattern));
    }
}
