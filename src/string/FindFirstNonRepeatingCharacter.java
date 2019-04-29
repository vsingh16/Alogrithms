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
