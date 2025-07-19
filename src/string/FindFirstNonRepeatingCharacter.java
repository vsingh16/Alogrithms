package string;

/**
 * @author Vishal Singh
 *         <p>
 *         https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 */
public class FindFirstNonRepeatingCharacter {

    /**
     * Method 1: Traverse the string, and maintain the count
     * Time complexity : O(n)
     * @param str
     * @return
     */
    public static char findFirstNonRepeating(String str) {

        int count[] = new int[256];
        for (char ch : str.toCharArray()) {
            count[ch - 'a'] += 1;
        }

        for (char ch : str.toCharArray()) {
            if (count[ch - 'a'] == 1) {
                return ch;
            }
        }

        return '-';
    }

    static class Info {

        private int count;
        private int pos;

        Info(int count, int pos) {
            this.count = count;
            this.pos = pos;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }

    /**
     * Method 2:We will store characters position alos along with count.
     * so that we dont need to again traverse string as input string may be lengthy that
     * fixed size count array.
     * <p>
     * Time Complexity : O(n)
     *
     * @param str
     * @return
     */
    public static char findFirstNonRepeatingInOneStringTraverse(String str) {

        Info info[] = new Info[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (info[ch - 'a'] == null) {
                info[ch - 'a'] = new Info(1, i);
            } else {
                info[ch - 'a'].setCount(1 + info[ch - 'a'].getCount());
            }
        }

        int pos = Integer.MAX_VALUE;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getCount() == 1 && info[i].getPos() < pos) {
                pos = info[i].getPos();
            }
        }

        return pos < str.length() ? str.charAt(pos) : '-';
    }

    public static void main(String[] args) {

        //System.out.println(findFirstNonRepeatingInOneStringTraverse("geeksforgeeks"));
        System.out.println(findFirstNonRepeatingInOneStringTraverse("geeks"));
        //System.out.println(findFirstNonRepeating("geeksforgeeks"));
        //System.out.println(findFirstNonRepeating("geeks"));
    }
}
=====================================================================================================================================
    /**
    ** Leetocde: https://leetcode.com/problems/first-unique-character-in-a-string/description/
    ** Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.


Approach: LinkedHashMap ensures insertion order.
This will only have entries as per String's character only.
Time Complexity: O(n)
Space Complexity: O(1)  Since string is alphanumeric and we are storing key in map. No matter how legnthy string is max key will be 26 ONly. O(1)
    **/
    class Solution {
    public int firstUniqChar(String s) {
    Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            if (!frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, 1);
            } else {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            }
        }

        Optional<Map.Entry<Character, Integer>> optionalEntry = frequencyMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
        if (optionalEntry.isPresent()) {
            char ch = optionalEntry.get().getKey();
            return s.indexOf(ch);
        } else {
            return -1;
        }
    }
}
