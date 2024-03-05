/**
** https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
** Find the Minimum element in a Sorted and Rotated Array.
** Given a sorted array arr[] (may be distinct or may contain duplicates) of size N that is rotated at some unknown point, the task is to find the minimum element in it. 

Examples: 

Input: arr[] = {5, 6, 1, 2, 3, 4}
Output: 1
Explanation: 1 is the minimum element present in the array.

Input: arr[] = {1, 2, 3, 4}
Output: 1

Input: arr[] = {2, 1}
Output: 1

** Approach 1: Take min variable with first element.Traverse whole array, compare with this min.
** Time Complexity : O(n)

** Approach 2: With Binady Search
** if(a[l] < a[h]) , Array is not roatated, return a[l]
** Find Mid, if(a[mid-1] > a[mid]), this is rotation point, return a[mid]
** if(a[mid] < a[h]), Since I need to search for min element and a[h] is greater, h = mid - 1;
** else l =  mid + 1;
** Time Complexity: O(logn)
**/

class Solution
{
    int findMin(int a[], int n)
    {
        int l=0, h = n-1;
        
        //Case 1: If array is not roated
        if(a[l] <= a[h]){
            return a[l];
        }
        
        while(l<=h){
            int mid = l + ((h-l)/2);
            if(mid > 0 && a[mid-1] > a[mid]){
                return a[mid];
            }else if(a[mid] < a[h]){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return -1;
    }
}
