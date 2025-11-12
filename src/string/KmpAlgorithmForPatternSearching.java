/**
** Ref: https://www.geeksforgeeks.org/dsa/kmp-algorithm-for-pattern-searchi
** KMP uses Longest Prefix Suffix String to decide in case of mismatch from which index we can start in pattern.
** LPS: https://github.com/vsingh16/Alogrithms/blob/master/src/string/LongestPrefixSuffix.java
** Time Complexity: O(n) //Given String
**/

import java.util.ArrayList;

class Solution {

    public static int[] lps(String s) {

        int lps[] = new int[s.length()];

        //lps[0] = 0. Since no proper or empty string at index 0

        int len = 0; //This is representing prefix
        int i = 1;
        while (i < s.length()) { //i is representing suffix

            if (s.charAt(len) == s.charAt(i)) { //if prefix is same as suffix
                len++;
                lps[i] = len;
                i++;
            } else { //if prefix suffix not same

                if (len == 0) { //if no prefix
                    lps[i] = 0;
                    i++;
                } else {
                    //Fallback on previous prefix and recheck
                    len = lps[len - 1];
                }

            }

        }


        return lps;

    }

    static ArrayList<Integer> search(String pat, String txt) {

        //Construct lps of pat. This will help us to decide in case of mismatch how much back we can go in pattern to avoid again matching from starting .
        int lps[] = lps(pat);

        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < txt.length()) {

            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                //Complete pattern found in txt
                if (j == pat.length()) {
                    result.add(i - j);
                    j = lps[j - 1];         // allow overlapping matches
                }
            } else {

                if (j == 0) { //if first char of pattern mismatch, we can simply start from next char in txt
                    i++;
                } else {
                    j = lps[j - 1]; // Rather than starting from begining in pattern, start from any suffix in pattern which exists which is also suffix
                }

            }


        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println(search("bba", "abcab"));          // []
        System.out.println(search("aba", "ababa"));         // [0, 2] (overlapping)
        System.out.println(search("a", "aaaa"));            // [0,1,2,3]
        System.out.println(search("", "abc"));

    }


}
