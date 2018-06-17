package dynamic.programming;

/**
 * Created by vishal on 22-Feb-18.
 */
public class LongestIncreasingSubSequence {
    
    private static int lis(int a[]) {
        int n = a.length;

        if (n == 0) {
            return 0;
        }

        int lis[] = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
        }

        //find max in LIS[i]
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
            System.out.print(lis[i] + " ");
        }

        System.out.println();

        return max;
    }

    public static void main(String[] args) {
        int a[] = {3};
        System.out.println(lis(a));
    }
}
