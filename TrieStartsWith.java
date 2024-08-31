/**
** Ref: https://www.youtube.com/watch?v=m9zawMC6QAI
** Given a prefix and a word of dictionary. Find if prefix exists
** eg: dictionary = {"i", "like", "sam", "sung", "samsung",
                "mobile", "ice", "cream", "icecream", "man",
                "go", "mango"}
** Prefix = mob -> true 
** goo -> false
** ma -> false
** Appraoch: We can use Trie and apply search. Only diff with search() is that we dont need to check for end of word.
** Time Complexity: O(n) . length of prefix
**/

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
public class Solution {

    public static boolean startsWith(String word, List<String> dictionary, Trie trie) {

        TrieNode ptr = trie.getRoot();
        for (int i = 0; i < word.length(); i++) {

            int pos = word.charAt(i) - 'a';
            if (ptr.getChildren()[pos] == null) {
                return false;
            }

            ptr = ptr.getChildren()[pos];

        }

        return true;
    }

    public static void main(String[] args) {
        int n = 12;
        List<String> dictionary = List.of("i", "like", "sam", "sung", "samsung",
                "mobile", "ice", "cream", "icecream", "man",
                "go", "mango");
        String word = "mobl1";
        Trie trie = new Trie();
        dictionary.stream().forEach(dictionaryWord -> trie.insert(dictionaryWord));
        System.out.println(startsWith(word, dictionary, trie));
    }
