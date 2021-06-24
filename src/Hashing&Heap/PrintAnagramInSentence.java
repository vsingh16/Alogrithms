/**
** https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/#
** https://www.youtube.com/watch?v=K3hlxOhxn9I
** https://practice.geeksforgeeks.org/problems/print-anagrams-together/1#
** https://leetcode.com/problems/group-anagrams/submissions/
** Approach:
** Anagram : Two words are anagram if they contain same characters with same frequency but they may differ in order.
** eg: cat, act, tac
** Map<SortedWord, List<Words>> : we will sort every word and add word corresposnding to it in map.
** Time Complexity: O(n * mlogm) : n = words, if length of one word is m, sort mlogm
** Space Complexity: n entries in map, list = m => o(n+m) 
**/

import java.util.*;

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap();
        for(int i=0;i< strs.length;i++){
            String word = strs[i];
            String sortedWord = sort(word);
            if(map.containsKey(sortedWord)){
                List<String> list = map.get(sortedWord);
                list.add(word);                
            }else{
                List<String> list = new ArrayList();
                list.add(word);
                map.put(sortedWord, list);
            }
        }
        
        return printResult(map);
        
    }
    
    private List<List<String>> printResult(Map<String, List<String>> map){
        
        List<List<String>> result = new ArrayList();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        
        return result;
    }
    
    private String sort(String str){
        
        char wordChar[] = str.toCharArray();
        Arrays.sort(wordChar);
        return new String(wordChar);
        
    }
}
