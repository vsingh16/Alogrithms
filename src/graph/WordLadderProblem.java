/**
** https://leetcode.com/problems/word-ladder/submissions/
** https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target
** https://www.youtube.com/watch?v=jvTa0t3-GQo&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=11
** https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
** A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

** Approach: This problem can be seen as to find shortest path in Graph, hence BFS can be applied.
** We have a soruce and a target.
** Adjacent for a node will be all possible characters(i.e a-z char try at all indexes in String). 
**/
class Solution {
    /**
    ** Time Complexity: O(n*m*26), n= no of wrods in dictionary, m=word length, 26 charcaters(a-z)
    ** Space Complexity: O(n), queue
    **/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(beginWord.equals(endWord)){
            return 0;
        }
        //Take Set else few test cases will fail with time limit exceed
        //O(1) reteieval
        Set<String> wordSet = new HashSet();
        for(String word:wordList){
           wordSet.add(word); 
        }
        if(!wordSet.contains(endWord)){
            return 0;
        }
        
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        wordSet.remove(beginWord);//In few test cases, begin word is there in dictionary,
        //so remove it to avoid processing it again.
        
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            //we take q size , as size gets updated when we add new elements,
            //and we need to process level by level
            int qSize = queue.size();
            for(int i=0;i<qSize;i++){
               char word[] = queue.peek().toCharArray();
               queue.remove();    
               for(int j=0;j<word.length;j++){
                   char originalCh = word[j];// We need to restore original char
                   //else String will be like z..., zz..., zzz
                   for(char ch='a';ch<='z';ch++){                       
                       word[j] = ch;
                       String wordStr = String.valueOf(word);                       
                       if(wordStr.equals(endWord)){
                           return level+1;
                       }else if(wordSet.contains(wordStr)){
                           queue.add(wordStr);
                           wordSet.remove(wordStr);
                       }else{
                           continue;
                       }                       
                   }
                   word[j] = originalCh;//restore orignal char before junping to next index in String
               } 
            }
        }
        
        return 0;        
    }
}
