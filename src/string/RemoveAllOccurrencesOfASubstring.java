/**
** https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
** https://www.youtube.com/watch?v=dSRFgEs3a6A&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&t=823s
** Remove All Occurrences of a Substring
** Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
Example 2:

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".
**/

class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int partIndex = s.indexOf(part);
            s = s.substring(0, partIndex) + s.substring(partIndex + part.length());
        }

        return s;

    }
}
