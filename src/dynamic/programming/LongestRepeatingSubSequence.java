package dynamic.programming;

/**
 * Created by vishal on 24-Mar-18.
 * Given a string, find length of the longest repeating subseequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 *
 * 
 */
public class LongestRepeatingSubSequence {

    private static Boolean isPalindrome(String str) {
        int l = 0, h = str.length() - 1;
        while (l < h) {

            if (str.charAt(l++) != str.charAt(h--)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Time Complexity:O(n)
     * Space Complexity:O(26)
     *
     * Remove non repeating characters from string
     * if resultant is palindrome, then it is not subsequence else yes
     * For cases where all characters are same 'BBBB', string is palidrome and it should return true
     * @param str
     * @return
     */
    public static Boolean findLongestRepeatingSubSeq(String str) {

        int n = str.length();
        //count character occurrence
        int freq[] = new int[26];
        for (int i = 0; i < n; i++) {
            freq[str.charAt(i) - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (freq[str.charAt(i) - 'A'] == n && freq[str.charAt(i) - 'A'] > 1) {
                return true;
            }
            //remove non repeating characters
            if (freq[str.charAt(i) - 'A'] >= 2) {
                sb = sb.append(str.charAt(i));
            }
        }

        // return true if string is not a palindrome
        return !isPalindrome(sb.toString());


    }

    /**
     * Time Complexity:O(n^2)
     * Space Complexity:O(n^2)
     */
    private static int findLongestRepeatingSubSeqDyn(String str) {
        int n = str.length();

        // Create and initialize DP table
        int[][] dp = new int[n + 1][n + 1];

        // Fill dp table (similar to LCS loops)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match and indexes are not same
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // If characters do not match
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        /*System.out.println(findLongestRepeatingSubSeq("aabb"));//2
        System.out.println(findLongestRepeatingSubSeq("abc"));//0
        System.out.println(findLongestRepeatingSubSeq("aab"));//1
        System.out.println(findLongestRepeatingSubSeq("axxxy"));//2*/
        //System.out.println(findLongestRepeatingSubSeqDyn("aabb"));
        //System.out.println(findLongestRepeatingSubSeqDyn("abba"));
        //System.out.println(findLongestRepeatingSubSeq("ABCABD"));
        //System.out.println(findLongestRepeatingSubSeq("ABCCAB"));
        System.out.println(findLongestRepeatingSubSeq("A"));
        System.out.println(findLongestRepeatingSubSeq("AA"));
        System.out.println(findLongestRepeatingSubSeq("AAA"));
        System.out.println(findLongestRepeatingSubSeq("AAAA"));
    }
}
