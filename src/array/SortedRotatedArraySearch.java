package com.macquarie.shiner.batch.gcs.processor;
/**
** https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
** Given a sorted and rotated array arr[] of size N and a key, the task is to find the key in the array.
** Note: Find the element in O(logN) time and assume that all the elements are distinct.
**  Example:  
**
** Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
** Output : Found at index 8

** Approach:
** We can apply binary search, the only case we need to handle is array is rotated also. i.e we can only search in sorted array part
** find mid
** Case 1: a[mid] == search, return mid
** Case 2: check if array is sorted and not rotated.(search space) if(a[l] <= a[mid])
** if yes, we can check the element in this search space. a[l] <= search <= a[mid], return h = mid - 1, if no l = mid + 1
** Case 3: if case 2 fails, that means a[mid] is where array is rotated, we should check is right part.
** if(a[mid] <= s <= a[h]), l = mid +1 else h = mid - 1;
** Time Complexity : O(logn)
** Ref: https://www.youtube.com/watch?v=e8RueNh2CRg
**/


class Solution
{
    int search(int a[], int l, int h, int search)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        while(l<=h){
            int mid = l + ((h-l)/2);
            if(a[mid] == search){
             return mid;
            }else if(a[l] <= a[mid]){
                if(a[l] <= search && search <= a[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(a[mid] <= search && search <= a[h]){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }    
        }
        return -1;
    }
}
