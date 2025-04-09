/**
** Ref: https://leetcode.com/problems/valid-palindrome/description/
**
** A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

** Approach: Convert String to lower case and ake character array
** Take two pointers apporach to find palindrome
** Time Complexity: O(n)
** Space Complexity: O(n)
**/

class Solution {

    //O(1)
     private static boolean isAlphanumeric(char ch) {
       return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome(String s) {
        char ch[] = s.toLowerCase().toCharArray(); //Time: O(n), Space: O(n)

        int l = 0, r = ch.length - 1;
        while (l <= r) { //O(n), The while (l <= r) loop runs at most n times — in each step, at least one of l or r moves inward.

            if (!isAlphanumeric(ch[l])) {
                l++;
                continue;
            }
            if (!isAlphanumeric(ch[r])) {
                r--;
                continue;
            }

            if (ch[l] != ch[r]) {
                return false;
            } else {
                l++;
                r--;
            }


        }

        return true;
    }
}
