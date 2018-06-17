package dynamic.programming;

/**
 * Created by vishal on 29-Apr-18.
 * <p>
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * <p>
 * Approach1:
 * find all substring , then find longest len palindrome among it.
 * Time Complexity:O(n^3)
 * <p>
 * Approach2:
 * Using DP:palindomre(i,j) = if(str[i] == str[j]) and substring(i+1,j-1) is palindrome
 * then substring(i,j) is also palindorme
 */
public class LongestPalindromeString {

    public static int longestPalindromeSubString(String s) {

        int palindrome[][] = new int[s.length()][s.length()];
        int max = Integer.MIN_VALUE;

        for (int i = palindrome.length - 1; i >= 0; i--) {
            for (int j = i; j < palindrome[0].length; j++) {
                if (i == j) {
                    palindrome[i][i] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1] > 0) {
                        palindrome[i][j] = palindrome[i + 1][j - 1] + 2;
                    } else {
                        palindrome[i][j] = 0;
                    }
                }
                max = Math.max(palindrome[i][j], max);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubString("TALAT"));//5
        System.out.println(longestPalindromeSubString("TAL"));//0
        System.out.println(longestPalindromeSubString("VTALATI"));//5
    }
}
