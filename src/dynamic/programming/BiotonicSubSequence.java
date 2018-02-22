package dynamic.programming;

/**
 * Biotonic Subsequence is the sequence which first increases and then decreases
 * <p>
 * Approach:
 * Find LIS[]
 * <p>
 * LIS[i] = Longest increasing subsequence length having a[i] as the last element of increasing subsequence
 * Then, L(i) can be recursively written as:
 * LIS(i) = 1 + max( LIS(j) ) where 0 < j < i and arr[j] < arr[i]; or
 * LIS(i) = 1, if no such j exists.
 * <p>
 * Find DIS[] = Longest decreasing subsequence length having a[i] as the last element of decreasing subsequence
 * Then, DIS(i) can be recursively written as:
 * DIS(i) = 1 + max( DIS(j) ) where 0 < j < i and arr[j] < arr[i]; or
 * DIS(i) = 1, if no such j exists.
 * Biotonic[i] = LIS[i]+DIS[i]-1
 * <p>
 * Time Complexity:o(n^2)
 * Space Complexity:o(n)
 */
public class BiotonicSubSequence {

    private static int[] lis(int a[]) {

        int n = a.length;
        int lis[] = new int[n];

        //if LIS has only single number i.e a[i] itself, lis[i]=1
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        return lis;

    }

    private static int[] dis(int a[]) {

        int n = a.length;
        int dis[] = new int[n];

        //if LIS has only single number i.e a[i] itself, lis[i]=1
        for (int i = 0; i < n; i++) {
            dis[i] = 1;
        }

        //Right to left
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i]) {
                    dis[i] = Math.max(dis[i], dis[j] + 1);
                }
            }
        }

        return dis;

    }

    public static int longestSubsequenceLength(final int a[]) {

        int n = a.length;
        if (n == 0) {
            return 0;
        }

        //populate LIS[]
        int lis[] = lis(a);
        int dis[] = dis(a);
        int biotonic[] = new int[n];

        for (int i = 0; i < n; i++) {
            biotonic[i] = lis[i] + dis[i] - 1;//-1 becuase element[i] is added twice
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (biotonic[i] > max) {
                max = biotonic[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int a[] = {12, 11, 40, 5, 3, 1};
        System.out.println(longestSubsequenceLength(a));

    }
}
