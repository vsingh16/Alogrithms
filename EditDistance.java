package dynamic.programming;

/**
 * Created by vishal on 24-Mar-18.
 */
public class EditDistance {

    /**
     * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
     * *
     * Insert
     * Remove
     * Replace
     * All of the above operations are of equal cost.
     * <p>
     * Examples:
     * <p>
     * Input:   str1 = "geek", str2 = "gesek"
     * Output:  1
     * We can convert str1 into str2 by inserting a 's'.
     * <p>
     * Input:   str1 = "cat", str2 = "cut"
     * Output:  1
     * We can convert str1 into str2 by replacing 'a' with 'u'.
     * <p>
     * Input:   str1 = "sunday", str2 = "saturday"
     * Output:  3
     * Last three and first characters are same.  We basically
     * need to convert "un" to "atur".  This can be done using
     * below three operations.
     * Replace 'n' with 'r', insert t, insert a
     */

    /**
     * Time Complexity:exponential
     */
    private static int editDistanceRec(String s1, String s2, int m, int n) {

        //Base Case
        /**
         * if string 1 is empty insert all characters of string 2
         */
        if (m == 0) {
            return n;
        }
        /**
         * if string 2 is empty, remove all characters from string 1
         */
        if (n == 0) {
            return m;
        }

        //if last characters are same, don't do anything
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDistanceRec(s1, s2, m - 1, n - 1);
        } else {
            /**
             * if characters are not same , we need to do one operation
             * so cost  = 1+min(insert,remove,replace)
             * we will take min of all three operations
             */
            return Math.min(Math.min(editDistanceRec(s1, s2, m, n - 1),//insert
                    editDistanceRec(s1, s2, m - 1, n)),//remove
                    editDistanceRec(s1, s2, m - 1, n - 1));//replace

        }

    }

    /**
     * Time Complexity:O(m*n)
     * Time Complexity:O(m*n)
     */
    private static int editDistanceDyn(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];//m+1 to avoid -1 index error
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0)
                    dp[i][j] = j;  // Min. operations = j

                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    //if last characters are same, don't do anything
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);

                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistanceDyn(str1, str2));
    }

}
