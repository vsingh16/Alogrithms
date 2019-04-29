package com.macquarie.shiner.batch.gcs.config;

/**
 * https://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
 */
public class DistinctPalindromeSubString {

    /**
     * Time Complexity : O(n^3)
     */
    public static void findAllPalindromicSubstring(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                if (isPalindrome(subString)) {
                    System.out.println(subString);
                }
            }
        }
    }

    private static Boolean isPalindrome(String str) {

        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        //findAllPalindromicSubstring("geek");
        findAllPalindromicSubstring("hellolle");
    }
}
