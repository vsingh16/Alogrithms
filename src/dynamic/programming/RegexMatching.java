package dynamic.programming;

/**
 * Created by vishal on 27-Mar-18.
 * ‘.’ Matches any single character.
 * ‘*’ Matches zero or more of the preceding element.
 * <p>
 * References : http://leetcode.com/2011/09/regular-expression-matching.html
 */
public class RegexMatching {

    /**
     * Time Complexity:2^n
     */
    public static boolean patternMatchingRec(String text, String pattern, int pos1, int pos2) {

        //base case
        //if pos2 has reached end of pattern means pos2 should also reach end of text for match
        //to happen
        if (pos2 == pattern.length()) {
            return pos1 == text.length();
        }

        if (pos1 == text.length() && pattern.charAt(pos2) == '*') {
            return true;
        }

        //if pattern is . or we have alphabet
        if (pattern.charAt(pos2) == '.' || text.charAt(pos1) == pattern.charAt(pos2)) {
            return patternMatchingRec(text, pattern, pos1 + 1, pos2 + 1);
        } else if (pattern.charAt(pos2) == '*') {

            return patternMatchingRec(text, pattern, pos1, pos2 + 1) || //zero occurrence eg a*b,text=b
                    ((pattern.charAt(pos2 - 1) == text.charAt(pos1) || pattern.charAt(pos2 - 1) == '.') && patternMatchingRec(text, pattern, pos1 + 1, pos2)); //multi occurrence eg a*b,text = aaab

        } else {
            return patternMatchingRec(text, pattern, pos1, pos2 + 1); //case eg text = aab, pattern = c*a*b
        }

    }

    /**
     * Time Complexity:O(text*pattern)
     * Space Complexity:O(text*pattern)
     */
    public static boolean patternMatchingDyn(String text, String pattern) {

        boolean dp[][] = new boolean[text.length() + 1][pattern.length() + 1];

        dp[0][0] = true;
        //empty text case
        for (int i = 1; i < dp[0].length; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];//zero occurrence
                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }

            }
        }

        return dp[text.length()][pattern.length()];
    }

    public static void main(String[] args) {

        System.out.println(patternMatchingRec("aa", "a", 0, 0));//false
        System.out.println(patternMatchingRec("aa", "aa", 0, 0));//true
        System.out.println(patternMatchingRec("aaa", "aa", 0, 0));//false
        System.out.println(patternMatchingRec("aaa", "a*", 0, 0));//true
        System.out.println(patternMatchingRec("aa", ".*", 0, 0));//true
        System.out.println(patternMatchingRec("ab", ".*", 0, 0));//true
        System.out.println(patternMatchingRec("aab", "c*a*b", 0, 0));//true*/

        System.out.println(patternMatchingDyn("aa", "a"));//false
        System.out.println(patternMatchingDyn("aa", "aa"));//true
        System.out.println(patternMatchingDyn("aaa", "aa"));//false
        System.out.println(patternMatchingDyn("aaa", "a*"));//true
        System.out.println(patternMatchingDyn("aa", ".*"));//true
        System.out.println(patternMatchingDyn("ab", ".*"));//true
        System.out.println(patternMatchingDyn("aab", "c*a*b"));//true

    }
}
