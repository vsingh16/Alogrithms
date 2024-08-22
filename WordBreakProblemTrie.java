/**
** https://www.geeksforgeeks.org/word-break-problem-trie-solution/
** Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details. 

This is a famous Google interview question, also being asked by many other companies now a days.

Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}
Input:  ilike
Output: Yes 
The string can be segmented as "i like".
Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" or 
"i like sam sung".
** Ref: https://www.youtube.com/watch?v=m9zawMC6QAI
** Approach: We can use trie to solve this problme, as Trie is best for prefix search.
** Pseudocode:
** Iterate over String
** Check if prefix is found in Trie and word break is true for suffix. Ams is true else false.
** Time Complexity: 
** Space Complexity:
**/


public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
        this.root.setEndOfWord(true);
    }

    void insert(String word) {

        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {

            int pos = word.charAt(i) - 'a';
            if (ptr.getChildren()[pos] != null) { //word already exists
                ptr = ptr.getChildren()[pos];
            } else { //doesn't exist
                ptr.getChildren()[pos] = new TrieNode();
                ptr = ptr.getChildren()[pos];
            }
        }

        ptr.setEndOfWord(true);

    }

    boolean search(String word) {

        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {

            int pos = word.charAt(i) - 'a';
            if (ptr.getChildren()[pos] == null) {
                return false;
            }
            ptr = ptr.getChildren()[pos];
        }

        return ptr.isEndOfWord();

    }

}

class TrieNode {

    private TrieNode children[];
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}

import java.util.List;

public class Solution {

  /**
  ** Time Complexity: No of Substrings = 2^n
  ** Searching in Trie for prefix of legth n is O(n)
  ** Overall Time Complexity: O(2^n * n)
  ** Space Complexity: for a prefix of length n , n recurive calls.
  ** Overall Space Complexity: O(2^n * n)
  **/
    public static boolean wordBreak(String word, List<String> dictionary, Trie trie) {

        if (word.isEmpty()) {
            return true;
        }

        for (int i = 1; i <= word.length(); i++) {

            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (trie.search(prefix) && wordBreak(suffix, dictionary, trie)) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int n = 12;
        List<String> dictionary = List.of("i", "like", "sam", "sung", "samsung",
                "mobile", "ice", "cream", "icecream", "man",
                "go", "mango");
        String word = "ilike";
        Trie trie = new Trie();
        dictionary.stream().forEach(dictionaryWord -> trie.insert(dictionaryWord));
        System.out.println(wordBreak(word, dictionary, trie));
    }
}
