/**
** https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
** Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers
** in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 
** should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
** https://www.techiedelight.com/maximum-sum-of-subsequence-with-no-adjacent-elements/
** https://www.youtube.com/watch?v=m9-H6AUBLgY&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&t=17s

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
** Space Complexity: O(n)
**/
class Solution
{
     public int findMaxSum(int a[], int index) {
        if (index < 0) {
            return 0;
        } else if (index == 0) { //Only Single Element
            return a[index];
        }

        int include = a[index] + findMaxSum(a, index - 2);
        int exclude = findMaxSum(a, index - 1);
        return Math.max(include, exclude);
    }
    
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        return findMaxSum(arr, n - 1);
    }
}
=====================================================================================
Recursion + Memorisation 

/**
** Time Complexity: O(n)
** Space Complexity: O(n)
**/
class Solution
{
 public int findMaxSum(int a[], int index, int results[]) {
        if (index < 0) {
            return 0;
        } else if (index == 0) { //Only Single Element
            return a[index];
        } else if (results[index] != -1) { //Already Calculated
            return results[index];
        }

        int include = a[index] + findMaxSum(a, index - 2, results);
        int exclude = findMaxSum(a, index - 1, results);
        results[index] = Math.max(include, exclude);
        return results[index];
    }
    
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int a[], int n)
    {
        int results[] = new int[n];
        Arrays.fill(results, -1);
        return findMaxSum(a, n - 1, results);
    }
}
==========================================================================================

Top Down

/**
** Time Complexity: O(n)
** Space Complexity: O(n)
**/
class Solution
{

    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int a[], int n)
    {
         int dp[] = new int[n + 1];
        dp[1] = a[0]; //Single Element
        for (int i = 2; i < dp.length; i++) {
            int include = a[i-1] + dp[i - 2];
            int exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[n];
    }
}
==========================================================================================
Space Optimized

/**
** Time Complexity: O(n)
** Space Complexity: O(1)
**/
class Solution
{

    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int a[], int n)
    {
       int prev2 = 0;
        int prev1 = a[0];
        int result = 0;
        for (int i = 2; i <= n; i++) {
            int include = a[i - 1] + prev2;
            int exclude = prev1;
            result = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = result;
        }

        return result;
    }
}
