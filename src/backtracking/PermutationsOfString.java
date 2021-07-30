/**
** https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
** A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation. 

** Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

** Below are the permutations of string ABC. 
** ABC ACB BAC BCA CBA CAB
**
** Approach : iterate throguh give string
** Current string = chart at i
** new string= (0,i-1) + (i)
** Time complexity : O(n * n!) // permutations of a string n!, so for n no of strings = n * n!
** https://medium.com/@akshitgrover_/why-do-i-think-time-complexity-of-generating-all-permutations-of-a-string-is-o-n-e68c0ecde5c5
**/

class Solution {
    
    List<String> result;
    
    public List<String> find_permutation(String S) {
        result = new ArrayList();
        find_permutation("",S);
        return result;
    }
    
    private void find_permutation(String currentResult, String s) {
        
        if(s.length() == 0 && !currentResult.isEmpty()){
            result.add(currentResult);
        }else{
            for(int i=0;i<s.length();i++){
                String newString = s.substring(0,i) + s.substring(i+1);
                find_permutation(currentResult + s.substring(i,i+1),
                newString);
            }
        }
    }
}
