/**
** https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
** Given a string s, partition s such that every substring of the partition is a palindrome. Find min cut required to represent this as palindormic
partion i.e after partinion all substring should be palindorme.

A palindrome string is a string that reads the same backward as forward.


Example 1:

Input: s = "aab"
cut = 1, aa|b
Example 2:

Input: s = "a"
cut = 0, because string is palindorme

**/

/**
** Recursive Approach: check if given string is palindrome(string of length 1 is palindrome, return 0, as no cut is required)
** Else try to partion it at k = 0 <str.length
** Time complexity : (n-1) * 2^n
** As for a given string we can partion it in two substrings.
** and we can create such (n-1) partions
**/
class Solution {
  
  public boolean isPalindrome(String s){
    int i=0,j=s.length-1;
    while(i<j){
      if(s.charAt(i)!=str.charAt(j)){
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
     
    public int partition(String s, int i, int j) {
        
      if(i>=j && isPalindrome(s)){
        return 0;
      }
      
      int min = Integer.MAX_VALUE;
      for(int k=0;k<j;k++){
        min = Maths.min(min,partition(s,0,k) + partition(s,k+1,j) );
      }
      
      return min;
    }
}
