/**
** https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
** Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

Examples: 

Input: arr[] = {1, 2, 3, 3}, X = 6 
Output: 3 
All the possible subsets are {1, 2, 3}, 
{1, 2, 3} and {3, 3}

** https://www.youtube.com/watch?v=MqYLmIzl8sQ
** Approach : This problem is same as knapsack and the problem where we need to check if subset exists or not.
** We wil start picking elements from last and there are two cases either we include or exclude
** Case1 : Include = fun(n-1, w - arr[n-1]) , this will reduce our target sum
** Case2: Exclude = fun(n-1, w ) , target sum will remain same
**/

//n = no of items
//w = target weight/sum
//Time Complexity in worst case: 2^n
int countSusbset(int n, int w){
  //i.e target sum achieved
  if(w == 0){
    return 1;
  }
  
  //if sum not achieved and no items left
  if(n == 0){
    return 0;
  }
  
  //if item is gretart than target weight, we have to exclude it
  if(arr[n-1] > w){
    return countSusbset(n-1, w)
  }else{                
    return countSusbset(n-1, w) + countSusbset(n-1, w - arr[n-1]);
  }
}

//DP solution
//Time & Space Complexity: O(n*w)
int countSusbset(int n, int w){
  int dp[][] = new int[n+1][w+1];
  for(int i=0;i<=n;i++){
    for(int j=0;j<=w;j++){
      //when no items are there and target sum is 0, only one empty subset is possible
      if(i == 0 && j == 0){
        dp[i][j] = 1;
      }
      //no items left and target sum is greater than 0, no set is possible
      else if(i == 0 && j > 0){
        dp[i][j] = 0;        
      }
      //if target sum is 0, no matter how many items we have , only one empty subset is possible
      else if(j == 0){
        dp[i][j] = 1;
      }
      //since item > target sum, so exclude
      else if(arr[i-1] > j){
        dp[i][j] = dp[i-1][j];
      }else{
         //two cases include and exclude
         dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
      }
    }
  }
  return dp[n][w];
}


