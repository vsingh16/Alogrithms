/**
** Ref: https://leetcode.com/problems/longest-common-prefix/description/
** http://youtube.com/watch?v=VTr3Nh7BadI
** Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
Approach1 :We can do brute force.
Pick Shortest string
Generate prefix of Shortes String by reducing its length every time
Check if prefix exists in other strings

Approach2: We know Trie is best for prefix lookup.
Insert words in trie and then do trie search the moment we reach a node 
which is end of word/no charcters(Empty String)/More than 1 non null nodes we can exist
as for prefix we will have ony one node at every level.
**/

public class Trie {

    public class TrieNode {

        private TrieNode childrens[] = new TrieNode[26];
        private boolean isEndOfWord = false;

    }

    //Node root
    private TrieNode root = new TrieNode();

    public void insert(String word) {

        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) { //Time: O(n) where n is the length of the word.
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (ptr.childrens[index] == null) {
                ptr.childrens[index] = new TrieNode();
            }
            ptr = ptr.childrens[index];
        }

        ptr.isEndOfWord = true;
    }

    public String findCommonPrefix() { //Time O(L), where L is the length of the common prefix.

        StringBuffer prefix = new StringBuffer();
        TrieNode ptr = root;
        while (true) {

            int childrenCount = 0;
            int prefixCharIndex = -1;
            for (int i = 0; i < 26; i++) {
                if (ptr.childrens[i] != null) {
                    childrenCount++;
                    prefixCharIndex = i;
                }
            }

            if (childrenCount != 1 || ptr.isEndOfWord) { //childrenCount =0 means empty string, childrenCount > 1 more strings
                break;
            }

            char ch = (char) (prefixCharIndex + 'a');
            prefix.append(ch);
            ptr = ptr.childrens[prefixCharIndex];


        }

        return prefix.toString(); //O(L) for storing ans

    }

}
