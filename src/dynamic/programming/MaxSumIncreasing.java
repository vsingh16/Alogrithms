/**
** https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
** Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
** if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
** This is similar to https://github.com/vsingh16/Alogrithms/blob/master/src/dynamic/programming/LongestIncreasingSubSequence.java
** Only Diff is that here we need sum of elements.
**/

class Solution
{
  /**
  ** Approach: By default dp[i] = a[i] i.e single element subseq
  ** j =0 to i
  ** First Condition : a[j] < a[i]
  ** Second Condition : dp[i] < dp[j] + a[i] i.e dp[j] (Sum of subseq from 0 to j and a[i])
  ** Time Complexity: O(n^2)
  ** Space Complexity : O(n)
  **/
	public int maxSumIS(int arr[], int n)  
	{  
	   int dp[] = new int[n];
	   int max = Integer.MIN_VALUE;
	   for(int i=0;i<n;i++){
	       dp[i] = arr[i];
	       max = Math.max(max, dp[i]);
	   }
	   
	  
	   for(int i=1;i<n;i++){
	       for(int j=0;j<i;j++){
	           if(arr[j] < arr[i] && dp[i]< arr[i] + dp[j]){
	            dp[i] = arr[i] + dp[j];   
	           }
	       }
	       max = Math.max(max, dp[i]);
	   }
	   
	   
	   return max;
	}  
}
