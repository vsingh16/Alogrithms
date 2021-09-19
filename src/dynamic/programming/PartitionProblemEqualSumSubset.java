/**
** https://www.geeksforgeeks.org/partition-problem-dp-18/
** Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same. 

Examples: 

arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.
** Approach : Find Sum of array.
** If sum is odd, we can't divide them equally return false.
** else find if subset is possible for sum/2 in given array. : https://github.com/vsingh16/Alogrithms/blob/master/src/dynamic/programming/CountSubsetWithGivenSum.java
**/

class Solution{
  
  // Time Complexity :O(2^n)
  boolean isSusbset(int n, int w){
  //i.e target sum achieved
  if(w == 0){
    return true;
  }
  
  //if sum not achieved and no items left
  if(n == 0){
    return false;
  }
  
  //if item is gretart than target weight, we have to exclude it
  if(arr[n-1] > w){
    return isSusbset(n-1, w)
  }else{                
    return isSusbset(n-1, w)  || countSusbset(n-1, w - arr[n-1]);
  }
}

  // Time Complexity :O(2^n)
  static boolean equalPartition(int n, int arr[]){
    
    int sum = 0;
    for(int i=0;i<n;i++){
      sum = sum + arr[i];
    }
    
    //odd
    if(sum %2 != 0){
      return false;
    }
    
    return IsSusbset(n, sum/2); // // Time Complexity :O(2^n)
  }
  
  // Time Complexity : n * sum/2
    static int equalPartition(int n, int arr[])
    {
        int sum =0;
        for(int i=0;i<n;i++){
            sum = sum + arr[i];
        }
        
        //Odd, can't be equal partition, return false
        if(sum%2!=0){
            return 0;
        }
        
        int halfSum = sum/2;
        boolean dp[][] = new boolean[n+1][halfSum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=halfSum;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0 && j != 0){
                    dp[i][j] = false;
                }else if(i !=0 && j == 0){
                    dp[i][j] = false;
                }else if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j]; //exclude
                }else{
                    dp[i][j] = dp[i-1][j] ||
                    dp[i-1][j - arr[i-1]]; //exclude & include
                }
            }
        }
        
        return dp[n][halfSum] ? 1 : 0;
    }
