/**
** https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
** Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers
** in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 
** should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
** https://www.techiedelight.com/maximum-sum-of-subsequence-with-no-adjacent-elements/

Examples : 

Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20
Approach : There will be two case either include or exclude element.
**/

 /**
 ** Time Complexity: O(2^n)
 **/
 public static int findMaxSumSubsequence(int[] arr, int i, int n, int prev)
    {
        // base case: all elements are processed
        if (i == n) {
            return 0;
        }
 
        // recur by excluding the current element
        int excl = findMaxSumSubsequence(arr, i + 1, n, prev);
 
        int incl = 0;
 
        // include current element only if it's not adjacent to
        // the previous element
        if (prev + 1 != i) {
            incl = findMaxSumSubsequence(arr, i + 1, n, i) + arr[i];
        }
 
        // return maximum sum we get by including or excluding
        // current item
        return Integer.max(incl, excl);
    }
}

/**
DP:
Time Complexity :O(n)
Space COmplexity :O(n)
** PS: note this problem is bit different from Longest increasing subsequence / max increasing sub seq
** Since in case of increasing subseq, we need to check if a[j]<a[i]
** we iterate from j to i, but in this case we dont need to worry about subsequence order
** Therefore, we can simply do dp[i] = Math.max(a[i], Max(include,exclude));//element at i idex, inlcude, exclude case
** include = a[i]+dp[i-2] // because non adjacent
** exlcude = dp[i-1]
**/
public int FindMaxSum(int a[], int n)
    {
       int dp[] = new int[n];
       dp[0] = a[0];
       if(n >= 2){
       dp[1] = Math.max(a[0],a[1]);    
       }
       for(int i=2;i<n;i++){
           int exclude = dp[i-1];
           int include = a[i]+ dp[i-2];
           dp[i] = Math.max(a[i],Math.max(exclude,include));
       }
       
       return dp[n-1];
    }

 /**
 ** We can further reduce space complexity.
 ** If we observe, there is only two variables required.
 ** dp[i-1] : previous
 ** dp[i-2] : previous_previous
 ** Time Complexity: O(n)
 ** Space Complexity :O(1)
 **/
 public int FindMaxSum(int a[], int n)
    {
       int previous_previous = a[0];
       if(n == 1){
           return previous_previous;
       }
       int previous=0;
       if(n >= 2){
       previous = Math.max(a[0],a[1]);    
       }
       for(int i=2;i<n;i++){
           int exclude = previous;
           int include = a[i]+ previous_previous;
           previous_previous = previous;
           previous = Math.max(a[i],Math.max(exclude,include));
       }
       
       return previous;
    }


/**
** One More DP Way:https://www.youtube.com/watch?v=VT4bZV24QNo PrepCoding
**/
    public int FindMaxSum(int a[], int n)
    {
         // Your code here
        int include = a[0];
        int exclude = 0;

        for(int i=1;i<n;i++){

            int newInclude = a[i]+ exclude; //Becuase we cant take adjacent
            int newExclude = Math.max(include,exclude);
            include = newInclude;
            exclude = newExclude;
        }

        return Math.max(include,exclude);
    }
