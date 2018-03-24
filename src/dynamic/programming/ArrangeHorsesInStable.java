package dynamic.programming;

/**
 * Created by vishal on 22-Mar-18.
 */
public class ArrangeHorsesInStable {

    /*public static int arrange(String horses, int stableCount) {

        int n = horses.length();
        int dp[][] = new int[n][stableCount];

        if (n < stableCount) {
            return -1;
        }

        //stable ==1
        int wt = 0, bl = 0;
        for (int i = 0; i < n; i++) {
            if (horses.charAt(i) == 'W') {
                wt++;
            } else {
                bl++;
            }
            dp[i][0] = wt * bl;
        }

        for (int j = 1; j < stableCount; j++) {
            for (int i = 0; i < n; i++) {
                wt = 0;
                bl = 0;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    if (horses.charAt(i) == 'W') {
                        wt++;
                    } else {
                        bl++;
                    }
                    dp[i][j] = Math.min(dp[i][j], wt * bl + k - 1 > 0 ? dp[k - 1][j - 1] : 0);
                }
            }
        }

        return dp[n - 1][stableCount - 1];

    }*/

    public static int arrange(String A, int B) {
        int n = A.length();
        if (n < B) return -1;
        else if (n == B) return 0;

        int dp[][] = new int[n][B];
        // filling first column
        int wt = 0, bk = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'B') bk++;
            else wt++;
            dp[i][0] = bk * wt;
        }

        for (int j = 1; j < B; j++) {
            for (int i = 0; i < n; i++) {
                wt = 0;
                bk = 0;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    if (A.charAt(k) == 'B') bk++;
                    else wt++;
                    dp[i][j] = Math.min(dp[i][j], bk * wt + ((k - 1 >= 0) ? dp[k - 1][j - 1] : 0));
                }
            }
        }

        return dp[n - 1][B - 1];
    }

    public static void main(String[] args) {
        System.out.println(arrange("WWWB", 2));
    }
}
