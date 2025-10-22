/**
https://leetcode.com/problems/reverse-words-in-a-string/
https://www.youtube.com/watch?v=RitppzIdMCo&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&index=34

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
Example 4:

Input: s = "  Bob    Loves  Alice   "
Output: "Alice Loves Bob"
Example 5:

Input: s = "Alice does not even like bob"
Output: "bob like even not does Alice"
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow up:

Could you solve it in-place with O(1) extra space?

Approach:
We will reverse the given String. This way, we will have words in the expected places.
Then we can reverse individual words.
trim(): trim will remove leading and trailing space
replaceAll() : \\s+ extra space, is replaced with one space
**/

class Solution {

    private static void reverse(char s[], int l, int h) {

        while (l < h) {

            //Swap chart at l and h
            char temp = s[l];
            s[l] = s[h];
            s[h] = temp;
            l++;
            h--;

        }

    }

    public static String reverseWords(String s) {

        s = s.trim().replaceAll("\\s+", " "); // trim(): trim will remove leading and trailing space . replaceAll(): \\s+ extra space, is replaced with one space
        char ch[] = s.toCharArray();
        reverse(ch, 0, s.length() - 1); //Reverse given string this way we will have words at expected places but they are reversed which we need to correct

        //Now we will reverse individual words
        int l = 0, h = 0;
        while (h < ch.length) {

            if (ch[h] == ' ') { //When encountered a space
                reverse(ch, l, h - 1);
                l = h + 1; //h is at space
                h++;
            } else {
                h++;
            }

        }

        //Reversing last word
        reverse(ch, l, h - 1);

        return String.valueOf(ch);
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));


    }
}
