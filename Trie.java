/**
 * @author vsingh16
 *         <p>
 *         Trie data structre is best to implement retrieval serach.
 *         Best example is Phone Directory implementation.
 *         <p>
 *         If we use BST for inserting words , then time complexity will be O(m*logn)
 *         where m is the length of largest word.
 *         <p>
 *         But with Trie we, tiem complexit becomes O(m) thoguh at each level we have array[26]
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
