/**
** https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
** Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative. 
Examples: 
 

  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3 

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0 


  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point

  Method 1: Do Linear search, a[i] == i, Time Complexity: O(n), Space: O(1)
  Method 2: Binary Search,
        if(a[mid] == mid), return mid
        else if(a[mid] > mid) h = mid - 1; //Because we are looking for equal but if this value is greater, no point going right as array is increading order
        else if(a[mid] < mid) l = mid + 1;
  
**/

class Solution {
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(arr[i] == i+1){
                result.add(arr[i]);
            }
        }
        
        return result;
    }
}
