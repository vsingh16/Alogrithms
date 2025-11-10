/**
** https://leetcode.com/problems/longest-happy-prefix/description/
** https://www.geeksforgeeks.org/dsa/kmp-algorithm-for-pattern-searching/
** https://www.youtube.com/watch?v=GTJr8OvyEVQ

Approach 1: We can do brute force to check if Prefix is same as Suffix
Approach 2: Generate LPS Array
Time Complexity: O(n)
Space Complexity: O(n)
**/


import java.util.Arrays;

class Solution {

    public static String longestPrefix(String s) {

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

        Arrays.stream(lps).forEach(System.out::println);
        //Since it is asking for a complete string , we can check last index of lps
        return s.substring(0, lps[lps.length - 1]);

    }

    public static void main(String[] args) {

        System.out.println(longestPrefix("bba"));

    }


}
