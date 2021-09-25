package dynamic.programming;

/**
 ** Created by vishal on 22-Feb-18.
 ** https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3.
 ** Now, let us discuss the Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming. 
 ** The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the
 ** subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}. 
 ** Approach :
 ** Recusriion : we have two options either to include or exclude.
 */
public class LongestIncreasingSubSequence {
    
    //Time Complexity : O(2^n)
    private static int lis(int a[], int n, int previous, int sum) {
           if(n == 0){
               return sum;
           }
        int exclude = lis(a, n-1, previous, sum);
        int include = lis(a, n-1, a[n-1], sum+a[n-1]);
        return Math.max(include,exclude);
    }
    
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
