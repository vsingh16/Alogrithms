package dynamic.programming;

/**
 * Created by vishal on 25-Mar-18.
 * <p>
 * Count distinct occurrences as a subsequence
 * Given a two strings S and T, find count of distinct occurrences of T in S as a subsequence.
 * <p>
 * Input  : S = banana, T = ban
 * Output : 3
 * T appears in S as below three subsequences.
 * [ban], [ba  n], [b   an]
 * <p>
 * Input  : S = geeksforgeeks, T = ge
 * Output : 6
 * T appears in S as below three subsequences.
 * [ge], [     ge], [g e], [g    e] [g     e]
 * and [     g e]
 */
public class CountDistinctOccurencesAsSubSequences {

    /**
     * Time Complexity:O(m*n)
     * Space Complexity:O(m*n)
     */
    public static int findSubSequenceCountDyn(String s, String t) {

        int m = s.length(), n = t.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int j = 1; j <= n; j++)
            dp[0][j] = 0;

        // Initializing first row with all 1s.
        //  An empty string is subsequence of all.
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[m][n];

    }


    /**
     * Time Complexity:O(exponential)
     */
    public static int findSubSequenceCountRec(String s, String t, int m, int n) {

        /**
         * Base Case if T is empty String,then it is subsequence of String s
         */
        if (n == 0) {
            return 1;
        }

        /**
         * Base Case:If S is empty,then no subsequnce can be formed
         */
        if (m == 0) {
            return 0;
        }

        if (s.charAt(m - 1) != t.charAt(n - 1)) {
            return findSubSequenceCountRec(s, t, m - 1, n);
        } else {
            return findSubSequenceCountRec(s, t, m - 1, n - 1) +
                    findSubSequenceCountRec(s, t, m - 1, n);//eg BANANA,BAN and we are checking for A of t n S, then it
            //is there at two place just before N and also just after B
        }

    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String t = "ge";
        System.out.println(findSubSequenceCountRec(s, t, s.length(), t.length()));//6
        System.out.println(findSubSequenceCountDyn("banana", "ban"));//3
        System.out.println(findSubSequenceCountDyn("geeksforgeeks", "ge"));//6
    }
}
