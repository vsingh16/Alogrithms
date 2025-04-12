/**
** Ref: https://leetcode.com/problems/valid-anagram/description/
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

Approach 1: Sort Both String and Compare. 
Time Complexity: (Ologn)
Space Complexity: O(1)

Approach 2: 
Compare their length, both should be of same length
Compare frequency


Follow Up
If String has unicode charcaters, we can take map
**/

class Solution {

  //Aprpoach2: 
  //Time Complexity: O(n), n = Stirng length
 // Space Complexity: O(26), O(1)
  public static boolean isAnagram(String s, String t) {

         if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26]; // 26 lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
  }

  //Follow Up
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int count : countMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

}
