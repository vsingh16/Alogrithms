/**
Trie Data Structure
1)Root node is always empty.
2)Every node will have 26 children. This will depend upon if we are only dealing with lower case. IN case of alphanumeric, this will increase.
3)BST is binary tree where every node have two children. Trie is Kth node tree.
4)Trie is best suited for finding all words starting with a prefix.
5)Below are the comparison of Trie vs BST.

Efficiency in Prefix Matching:
Trie: A Trie is specifically designed for prefix searching. Each level of the Trie corresponds to a character in the string, and traversing the Trie from the root to a particular node
corresponds to following the characters in the prefix. This means you can quickly locate all words with a given prefix by simply following the nodes that correspond to the prefix.
The time complexity for searching a prefix of length 𝑘 k in a Trie is O(k).

BST: A Binary Search Tree is not inherently optimized for prefix matching. You would need to perform a traversal that can involve multiple comparisons at each node,
making it less efficient. The time complexity for finding all words with a given prefix in a balanced BST is O(n), where n is the number of words, as you may need to examine each node.
As we have to store all the words separately on each node.

Space Utilization for Prefixes
Trie: Tries efficiently share common prefixes among different keys. This leads to a compact representation where common prefixes are only stored once. For example, words like "cat" and "car" would share the "ca" path in the Trie.
BST: Each word or string is treated as a completely separate entity in a BST, so even if many words share a common prefix, the BST does not optimize for this,
potentially leading to a lot of redundant storage.

Guaranteed Search Time
Trie: The search time in a Trie depends only on the length of the prefix and not on the number of keys stored in the Trie. This guarantees O(k) search time where 
k is the length of the prefix.
BST: The search time in a BST depends on the height of the tree, which can be O(logn) in a balanced BST but can degrade to O(n) in the worst case (if the BST becomes unbalanced).

Auto-Completion
Trie: Tries are ideal for implementing auto-completion features. After finding the node corresponding to the end of the prefix, all words that start with that prefix can be found by a simple traversal of the subtree rooted at that node.
BST: Implementing auto-completion in a BST is more complex and less efficient, as you would need to perform a potentially costly traversal of the tree to find all matching words.

Character by Character Comparison
Trie: Tries inherently work on a character-by-character basis, making them more intuitive and faster for prefix searches.
BST: In a BST, comparisons are made between whole strings, which is less direct and less efficient when working with prefixes.
Ref: https://www.youtube.com/watch?v=m9zawMC6QAI&pp=ygUgdHJpZSBkYXRhIHN0cnVjdHVyZSBhcG5hIGNvbGxlZ2U%3D
 */
public class Trie {

    Node root;

    Trie() {
        root = new Node();
    }

    class Node {

        private Node[] children;
        private Boolean isWordEnd;

        public Node() {
            this.children = new Node[26];
            this.isWordEnd = Boolean.FALSE;
        }
    }

    /**
    ** Time Complexity: O( maxLengthOfWord)
       Auxiliary Space: O(maxLengthOfWord)
    **/
    public void insert(String word) {

        Node pCrwal = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (pCrwal.children[index] == null) {
                pCrwal.children[index] = new Node();
            }
            pCrwal = pCrwal.children[index];
        }

        pCrwal.isWordEnd = Boolean.TRUE;

    }

     /**
    ** Time Complexity: O( maxLengthOfWord)
     **  Auxiliary Space: O(maxLengthOfWord)
    **/
    public Boolean search(String word) {

        Node pCrwal = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (pCrwal.children[index] == null) {
                return Boolean.FALSE;
            }
            pCrwal = pCrwal.children[index];
        }

        return pCrwal != null && pCrwal.isWordEnd;
    }

    public void searchWordsByPrefix(String prefix) {

        Node pCrwal = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (pCrwal.children[index] == null) {
                return;
            }
            pCrwal = pCrwal.children[index];
        }

        searchWordsByPrefixUtil(pCrwal, prefix);

    }

    public void searchWordsByPrefixUtil(Node root, String prefix) {

        if (root.isWordEnd) {
            System.out.println(prefix);
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                char ch = (char) (97 + i);
                searchWordsByPrefixUtil(root.children[i], prefix + ch);
            }
        }


    }

    /**
     * To delete a word from trie, simply set end of word flag to false,
     * so that this word cant ne seached
     */
    public Boolean delete(String word) {

        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            node = node.children[index];
        }

        if (node.isWordEnd) {
            node.isWordEnd = false;
            return true;
        }

        return false;
    }


    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("three");
        trie.insert("their");

        //System.out.println(trie.search("three"));
        //System.out.println(trie.search("their"));
        //System.out.println(trie.search("throw"));
        //System.out.println(trie.search("the"));

        //trie.searchWordsByPrefix("tha");
        //trie.searchWordsByPrefix("th");
        //trie.searchWordsByPrefix("thr");

        System.out.println("Deleting their");
        System.out.println(trie.delete("their"));
        System.out.println(trie.search("their"));
    }
}
