/**
Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j 
Example: 

Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).

https://www.geeksforgeeks.org/counting-inversions/

Approach 1: Brute Force, form all possible pairs with (i,j) and then count if a[i]> a[j]
Time complexity : O(n^2)
Space Complexity: O(n)

Approach 2: We can use merge sort, and when while merging the elements when left[i] > right [j], 
we can do count = (mid - i) +1 because all  elements after i are in sorted order, so to place right element there we need to mid -i +1 inversions
Time complexity : O(n logn )
Space Complexity: O(n)
**/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Inversion_of_Array().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Inversion_of_Array
{
    
    private static long mergeSort(long arr[], int l, int h ){
        long inversionCount = 0;
        
        if(l<h){
        int mid = l + (h-l)/2;
        inversionCount += mergeSort(arr, l, mid);
        inversionCount += mergeSort(arr, mid+1, h);
        inversionCount += merge(arr, l, mid, h);
        }
       
        
        return inversionCount;
    }
    
    private static long merge(long arr[], int l, int mid, int h ){
        
        long count =0;
        int i=l, j = mid+1;
        int k = 0;
        //we can't put elements in original array as then we may loose original array elements
        long result[] = new long[h - l + 1];
        while(i<= mid && j <=h ){            
            if(arr[i] <= arr[j]){
               result[k++] = arr[i++];
            }else{
                result[k++] = arr[j++];
                count += ( mid - i +1); //i.e when a[j] > a[i], so we needed a shift
            }
        }
        
         while (i <= mid) {
            result[k++] = arr[i++];
        }
        while (j <= h) {
            result[k++] = arr[j++];
        }

        //copy sorted elements to original array staring from l index
        for (i = 0; i < result.length; i++) {
            arr[l++] = result[i];
        }
        
        return count;
    }
    
    
    
    // arr[]: Input Array
    // N : Size of the Array arr[]
    
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr,0, (int)N-1);
    }
}
