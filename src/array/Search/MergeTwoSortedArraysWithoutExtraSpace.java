/**
** https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
** We are given two sorted arrays. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array

Examples: 

Input: ar1[] = {10}, ar2[] = {2, 3}
Output: ar1[] = {2}, ar2[] = {3, 10}  

Input: ar1[] = {1, 5, 9, 10, 15, 20}, ar2[] = {2, 3, 8, 13}
Output: ar1[] = {1, 2, 3, 5, 8, 9}, ar2[] = {10, 13, 15, 20}

** Approach 1: for merging and storing into 3rd array.
** https://github.com/vsingh16/Alogrithms/blob/master/src/array/Sorting/MergeSort.java
**
** Approach 2: Since array is already sortd.
** We can keep i pointer at the last index of array 1.
** j pointer at the first index of array 2.
** Now compare, if (a2[j] < a1[i]), then we can move a2[j] to last index in array 1.
** if at any point this condition fails, we dont need to do anything as array is already sorted.
** Ref: https://www.youtube.com/watch?v=n7uwj04E0I4&t=1019s : take u forward
** Time Complexity: O(Min(n,m)) + nlogn + mlogm
**/


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long a1[], long a2[], int n, int m) 
    {
        // code here 
        int i=n-1;
        int j=0;
        while(i>=0 && j<m){ //Time Complexity O(Min(n,m))
            if(a2[j] < a1[i]){
                //swap(a2[j] < a1[i]);
                long temp = a2[j];
                a2[j] = a1[i];
                a1[i] = temp;
                j++;
                i--;
            }else{
                break;
            }
        }
        
        Arrays.sort(a1); //nlogn
        Arrays.sort(a2); //mlogm
    }
}
