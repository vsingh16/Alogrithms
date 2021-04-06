/**
https://leetcode.com/problems/reverse-words-in-a-string/

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

Approach: In order to do it in O(1), we will take two pointers l = starting , h =end
swap(char at l, char at h)
First we will swap individual words
Then swap whole sentence
eg: hey ram
Individual Word Reversal: yeh mar
Whole Sentence Reversal: ram hey

trim(): trim will remove leading and trailing space
replaceAll() : \\s+ extra space, is replaced with one space
**/

class Solution {
    
    public String reverseWords(String s) {
        
        s = s.trim().replaceAll("\\s+"," "); // trim will remove leading and trailing space
        char str[] = s.toCharArray();
            
        int l=0,h=0;
        for(int i=0;i<str.length;i++){
            
             if(str[i] == ' '){
                reverse(str,l,h-1);
                l = i+1;
                h = l;
            }else{
             h++;    
            }
            
        }
        
        //last word
        reverse(str,l,h-1);        
        reverse(str,0,str.length-1);
        
        return String.valueOf(str);
    }
    
    private void reverse(char str[], int l, int h){
        
        while(l<h){
            swap(str,l++,h--);
        }
    }
    
    private void swap(char str[], int l, int h){

        char temp = str[l];
        str[l] = str[h];
        str[h] = temp;
        
    }
}
