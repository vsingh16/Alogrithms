/**
** https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
** Given an array arr[] of size n and an integer X. Find if there’s a triplet in the array which sums up to the given integer X.
** 
** Examples: 
**
** Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
** Output: 12, 3, 9 
** Explanation: There is a triplet (12, 3 and 9) present 
** in the array whose sum is 24. 
**
** Input: array = {1, 2, 3, 4, 5}, sum = 9 
** Output: 5, 3, 1 
** Explanation: There is a triplet (5, 3 and 1) present 
** in the array whose sum is 9.
**
** Approach 1: Brute Force Three Loops. Time Complexity :O(n^3), Space: O(1)
** Approach 2: Sorrt the array. Fix one pointer. Now find 2Sum().
** 2 Sum Ref: https://github.com/vsingh16/Alogrithms/blob/master/src/array/Search/TwoSum.java
** Time Complexity :O(n^2), Space: O(1)**
**/

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int a[], int n, int k) { 
    
    Arrays.sort(a);
       // Your code Here
       for(int i=0;i<n-2;i++){ //Because for triplet we should have 3 elements
           //int sum = a[i] + twoSum(a,i+1,n-1,k);
           int twoSumResult[] = twoSum(a,i+1,n-1,k-a[i]);
           if(twoSumResult.length == 2){
               int sum = a[i] + twoSumResult[0] + twoSumResult[1];
               if(sum == k){
                return true;
               }
            }
       }
       
       return false;
    
    }
    
    static int[] twoSum(int a[],int l, int h, int k) {
       
       //Arrays.sort(a);
       while(l<h){
           if(a[l]+a[h] == k){
               //return true;
               return new int[]{a[l],a[h]};
           }else if(a[l]+a[h] < k){ // Since the value is less, we need to increase move l
               l++;
           }else{
               h--; // Since higher, we need to decrease
           }
       }
       
       //return false;
       return new int[]{};
       
    }
}
