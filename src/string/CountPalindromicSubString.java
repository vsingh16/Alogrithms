package com.macquarie.shiner.batch.gcs.config;

/**
 * https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
 */
public class CountPalindromicSubString {

    //Time Complexity : O(n^2)
    public static int count(String str) {

        int len = str.length();
        boolean dp[][] = new boolean[len][len];

        //for len = 1
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int counter = 0;
        for (int l = 2; l <= len; l++) {
            int i = 0, j = i + (l - 1);
            while (j < len) {

                if (l == 2) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? true : false;
                } else {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? dp[i + 1][j - 1] : false;
                }

                if (dp[i][j]) {
                    counter++;
                }
                i++;
                j++;
            }

        }

        return counter;
    }

    public static void main(String[] args) {

        System.out.println(count("geek"));
        System.out.println(count("abaab"));
        System.out.println(count("abbaeae"));

    }
}
