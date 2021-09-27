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
    private static int lis(int a[], int n, int previous,lis) {
           if(n == 0){
               return lis;
           }
        int exclude = lis(a, n-1, previous, lis);
        int include = lis(a, n-1, a[n-1], lis + 1);
        return Math.max(include,exclude);
    }
    
    /**
    ** DP: dp[n]
    ** for all elements dp[i] = 1; becuase if we only include each element, LIS = 1
    ** j =0 ; j<i : this will give us all elements in combination
    ** 1 condition = a[j] < a[i] , increasing subsequence
    ** 2 condition , dp[i]<=dp[j], because we will need max value for dp[i]
    ** Then dp[i] = 1+dp[j]
    ** Time Complexity : O(n*n)
    ** SPace Complexity : O(n)
    **/
    private static int lis(int a[]) {
        int n = a.length;

        if (n == 0) {
            return 0;
        }

        int lis[] = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        int max = Intger.MIN_VALUE:
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && lis[i]<=lis[j]) {
                    lis[i] = lis[j] + 1;
                    max = Math.max(max,lis[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = {3};
        System.out.println(lis(a));
    }
}
