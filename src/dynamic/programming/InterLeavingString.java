package dynamic.programming;

/**
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 * <p>
 * Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.
 * For example A = “XXY”, string B = “XXZ” and string C = “XXZXXXY”.
 * <p>
 * Approach:
 * <p>
 * if(char of A matches with char of C, A++ and C++)
 * if(char of B matches with char of C, B++ and C++)
 */
public class InterLeavingString {

    /**
     * A
     * Time Complexity:O(2^n)
     */
    public static boolean isInterleaving(String s1, String s2, String s3, int pos1, int pos2, int pos3) {

        //if all string traversal is completed
        if (pos1 == s1.length() && pos2 == s2.length() && pos3 == s3.length()) {
            return true;
        } else if (pos3 == s3.length()) {
            return false;//string 3 is completed and we still have characters left in either s1 or s2
        }

        return (pos1 < s1.length() && s1.charAt(pos1) == s3.charAt(pos3) && isInterleaving(s1, s2, s3, pos1 + 1, pos2, pos3 + 1))
                || (pos2 < s2.length() && s2.charAt(pos2) == s3.charAt(pos3) && isInterleaving(s1, s2, s3, pos1, pos2 + 1, pos3 + 1));
    }

    /**
     * Time Complexity:O(S1*S2)
     * Space Complexity:O(S1*S2)
     */
    public static boolean isInterleavingDyn(String s1, String s2, String s3) {

        int m = s1.length(), n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean dp[][] = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        //if s1 is empty compare  s2 and s3
        for (int j = 1; j < dp.length; j++) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) ? true : false;
        }

        //if s2 is empty compare  s1 and s3
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int l = i + j - 1;
                dp[i][j] = s1.charAt(i - 1) == s3.charAt(l) ? dp[i - 1][j] : false ||
                        s2.charAt(j - 1) == s3.charAt(l) ? dp[i][j - 1] : false;
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        System.out.println(isInterleaving("xxy", "xxz", "xxzxxy", 0, 0, 0));//true
        System.out.println(isInterleavingDyn("xxy", "xxz", "xxzxxy"));//true
        System.out.println(isInterleavingDyn("xxy", "xxz", "xxzxyx"));//false
    }
}
