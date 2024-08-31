/**
** Ref: https://www.geeksforgeeks.org/count-distinct-substrings-string-using-suffix-trie/
** https://www.youtube.com/watch?v=m9zawMC6QAI&t=6225s
** Count of distinct substrings of a string using Suffix Trie
** Given a string of length n of lowercase alphabet characters, we need to count total number of distinct substrings of this string. Examples:

Input  : str = “ababa”
Output : 10
Total number of distinct substring are 10, which are,
"", "a", "b", "ab", "ba", "aba", "bab", "abab", "baba"
and "ababa"
** Approach: Substring = Prefix of Suffix or Suffix of Prefix. Since we are using Trie, we can go with Prefix of Suffix
** Word -> “ababa”
** Suffix -> 
** ababa(Suffix) -> a, ab, aba, abab, ababa (Prefix)
** baba -> b, ba, baba
** aba -> b, ba
** ba -> b, ba
** a -> a
** We can insert suffix in Trie and then count no of nodes. Since Trie doesnt duplicate prefix, no of node will give us count of prefix of suffix = no of unique substring.
**/

import java.util.List;

public class Solution {

 Counting Trie Nodes:

The method countTrieNode performs a depth-first search (DFS) over the Trie. The time complexity of DFS is proportional to the number of nodes in the Trie.
Since each node in the Trie corresponds to a unique prefix of a substring, there are at most O(n^2) nodes (one for each distinct substring).
Thus, the time complexity of counting the nodes is O(n^2).
Therefore, the overall time complexity of countDistinctSubstring is:

Time Complexity
=
𝑂
(
𝑛
2
)
Time Complexity=O(n 
2
 )
Space Complexity
Space for the Trie:

In the worst case, each substring of st is unique, and the Trie will store all these substrings. The total number of nodes in the Trie is proportional to the sum of the lengths of all suffixes.
The total space required to store all suffixes is O(n^2).
Space for Recursive Calls (Stack Space):

The countTrieNode function is recursive and uses stack space for the DFS traversal. The depth of the Trie (which corresponds to the maximum length of any string in the Trie) is at most O(n).
Therefore, the stack space required is O(n).
Given that the Trie dominates the space complexity, the overall space complexity is:

Space Complexity
=
𝑂
(
𝑛
2
)
Space Complexity=O(n 
2
 )
    public static int countDistinctSubstring(String st) {
        Trie trie = new Trie();
        for (int i = 0; i < st.length(); i++) {
            trie.insert(st.substring(i));
        }

        return countTrieNode(trie.getRoot());
    }

    public static int countTrieNode(TrieNode root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (root.getChildren()[i] != null) {
                sum = sum + countTrieNode(root.getChildren()[i]);
            }
        }

        return sum + 1;

    }

    public static void main(String[] args) {
        System.out.println(countDistinctSubstring("ababa"));
    }
}


public class Trie {

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
