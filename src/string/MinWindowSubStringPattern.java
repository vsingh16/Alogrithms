/**
Find the smallest window in a string containing all characters of another string
Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently. 
Examples: 

Input: string = “this is a test string”, pattern = “tist” 
Output: Minimum window is “t stri” 
Explanation: “t stri” contains all the characters of pattern.
Input: string = “geeksforgeeks”, pattern = “ork” 
Output: Minimum window is “ksfor”

https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
https://leetcode.com/problems/minimum-window-substring/submissions/

Approach1: Brute Force Approach. Generate all possible substrings with two loop
Time Complexity: O(n^2)

Approach2:
Maintain two ptr_hash to have count of characters in pattern.
Now traverse String S and keep updating str_hash, also maintain count variable.
Count we will only increse when pattern also has same character and also if its count is less than or equal i.e what is required in pattern string
When count == ptr.length, we have found substring with pattern, now we need to minimize substring length.
Minimize substring: 1. ignore character which is not there in pattern
                 2. ignore if its count is more than required in pattern.(i.e redcue count of such character)

Time Complexity: O(n)
Space Compexity: O(1)(Though we have two extra arrays of space 256 but its going to be fixed no matter how lenghty string is there)
**/

class Solution {
    public String minWindow(String s, String p) {
        int ptr_hash [] = new int[256];
        int str_hash [] = new int[256];
        int count = 0 ;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        
        //update prt_hash as per pattern string
        for(int i=0;i<p.length();i++){
            ptr_hash[p.charAt(i)]++;
        }
        
        for(int j=0;j<s.length();j++){
            //update str_hash as per string S
             str_hash[s.charAt(j)]++;
             
             //we will increase count when pattern also has same character
             //and also if its count is less than or equal i.e what is required in pattern string
             if(str_hash[s.charAt(j)] <= ptr_hash[s.charAt(j)]){
                 count++;
             }
             
             if(count == p.length()){ //substring with pattern found, now we need to minimize its length
                 
                 //Minimize substring: 1. ignore character which is not there in pattern
                 //2. ignore if its count is more than required in pattern
                 while(ptr_hash[s.charAt(start)]==0 || str_hash[s.charAt(start)] > ptr_hash[s.charAt(start)]){
                     if(str_hash[s.charAt(start)] > ptr_hash[s.charAt(start)]){
                         str_hash[s.charAt(start)] --;
                     }
                     start++;
                 }
                 
                 int length = j - start + 1;
                 if(length < minLength){
                     minLength = length;
                     startIndex = start;
                     
                 }
                 
             }
        }
        
        //when no such window found
        if(startIndex == -1){
            return "";
        }
        
        return s.substring(startIndex,startIndex+minLength);
    }
}
