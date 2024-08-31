/**
** Ref: https://www.geeksforgeeks.org/longest-valid-word-with-all-prefixes/
** https://www.youtube.com/watch?v=m9zawMC6QAI Apna College
**  Given an array of N strings words[]. Find longest string in words[] such that such that every prefix of it is also in words[]. If there are multiple answers print the lexicographically shortest string.

Examples:

Input: words = {“a” , “banana” , “app” , “apply” , “ap” , “appl” , “apple”}
Output: apple
Explanation:

For the first string “a”, only prefix is “a” and it is present in the words[] array, so this is a valid string.
For the second string “banana”, prefixes are: “b”, “ba”, “ban”, “bana”, “banan” and “banana”, but no prefix other than “banana” is present in words[] array.
For the third string “app”, prefixes are: “a”, “aa” and “aap” and all the prefixes are present in words[] array, so this is a valid string.
For the fourth string “apply”, prefixes are: “a”, “ap”, “app”, “appl” and “apply” but prefix “apply” is not present in the words[] array.
For the fifth string “ap”, prefixes are: “a” and “ap” and both the prefixes are present in words[], so this is a valid string.
For the sixth string “appl”, prefixes are: “a”, “ap”, “app” and “appl” and all the prefixes are present in words[], so this is a valid string.
For the seventh string “apple”, prefixes are: “a”, “ap”, “app”, “appl” and “apple” and all the prefixes are present in words[], so this is a valid string.
Among all the valid strings, “apply” and “apple” are longest string having all the prefixes in words. Furthermore, “apple” is lexicographically smaller so “apple” is the answer.

** Approach: Since we need to populate prefix and then check, we know each node of trie represents Prefix.
** We can save all words in Trie.
** Since each prefix must exist in the dictionary, traverse Trie and find out nodes with EOW true.
** When we backtrack remove last char from temp ans.
**/


class Solution {
    
    private static String answer = "";
    
    public static String longestString(int n, String[] arr) {
        answer = "";
        Trie trie = new Trie();
        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        StringBuilder temp = new StringBuilder();
        longestString(trie.getRoot(), temp);

        return answer;
    }

    /**
    ** Time Complexity: for each word, we are doing a depth-first search in Trie.
    ** Trie Height will be the length of the max word.
    ** O(n * L), n = no of wrods in array. L = Length of max word.
    
    **/
     public static void longestString(TrieNode root, StringBuilder temp) {

        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.getChildren()[i] != null && root.getChildren()[i].isEndOfWord()) {

                char ch = (char) ('a' + i);
                temp.append(ch);
                if (temp.length() > answer.length()) {
                    answer = temp.toString();
                }
                longestString(root.getChildren()[i], temp);
                temp.deleteCharAt(temp.length() - 1); //Backtrack
            }
        }

    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
        this.root.setEndOfWord(true);
    }

    public TrieNode getRoot() {
        return root;
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

        
