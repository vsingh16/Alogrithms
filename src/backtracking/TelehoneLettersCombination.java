/**
** https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
** Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

** A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
** Approach : Base case : if digits are empty.
** Else consdier first character of digits.
** Get all letters for digit
** Iterate through letters and for individual letter concanate it to currentResult ie leters formed from previous call
** Time Complexity : O(n^2 * k^n) , n = dgits size, k = letters mapped to dgit.
** Firts think how many output strings are there.
** Suppose k = 3, n =2
** for n = 1, r1, r2, r3
** for n = 2, r1, r2, r3 and these will be lined up for each indivisual n =1, k^n
**
** for every input,we have loop where we are buiding substring.
** Time complexity to append letter at end of string, 
** if string size is 1, 1
** if string size is n, n
** n^2
** Total Time Complexity : O(k^n * n^2)
**/
class Solution {
    
    List<String> result;
    Map<String,String> map; 
    public List<String> letterCombinations(String digits) {
        result = new ArrayList();
        map = new HashMap();   
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        letterCombinations("",digits);
        return result;
    }
    
     private void letterCombinations(String currentResult,String digits) {
         
         if(digits.length() == 0){
             if(!currentResult.isEmpty()){ // only add if we have some letters in currentResult
                result.add(currentResult); 
             }             
         }else{
             
             String digit = digits.substring(0,1); // Always take first digit
             String letters = map.get(digit);
             for(int i=0;i<letters.length();i++){ // Iterate through letters
                 String letter = letters.substring(i,i+1); //Take letter of length 1 , starting from diff position
                 letterCombinations(currentResult+letter,digits.substring(1)); // now find for next digit
             }             
         }
                
    }
}
