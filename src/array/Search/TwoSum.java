/**
** https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/
** Given an array A[] of n numbers and another number x, the task is to check whether or not there exist two elements in A[] whose sum is exactly x. 
** Input: arr[] = {0, -1, 2, -3, 1}, x= -2
** Output: Yes
** Explanation:  If we calculate the sum of the output,1 + (-3) = -2
** Input: arr[] = {1, -2, 1, 0, 5}, x = 0
** Output: No
** Approach 1: Brute Force Two Loops. Time Complexity :O(n^2), Space: O(1)
** Approach 2: Pointers. This is similar to diff question a[j]-a[i] == k find.
** Ref: https://www.youtube.com/watch?v=weENywNKxVA
** a[i] + a[j] == k
** Here we will sort array.
** Keep pointers on left and right, so that we ca decide if we need to increse or decrease pointer.
** Time Complexity :O(n), Space: O(1)
**/

class Solution {
    boolean hasArrayTwoCandidates(int a[], int n, int k) {
       
       Arrays.sort(a);
       int l=0, h = n -1;
       while(l<h){
           if(a[l]+a[h] == k){
               return true;
           }else if(a[l]+a[h] < k){ // Since value is less, we need to increase move l
               l++;
           }else{
               h--; // Since higher, we need to decrease
           }
       }
       
       return false;
       
    }
}
