/**
Find kth smallest element in two sorted array.
https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays
https://www.baeldung.com/java-kth-smallest-element-in-sorted-arrays 

Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array.
Input : Array 1 - 2 3 6 7 9
        Array 2 - 1 4 8 10
        k = 5
Output : 6
Explanation: The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Input : Array 1 - 100 112 256 349 770
        Array 2 - 72 86 113 119 265 445 892
        k = 7
Output : 256
Explanation: Final sorted array is -
72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Appraoch 1: We can follow merging as we do in Merge sort i.e mergint two sorted arrrays with two pointers and put them in an array of size m+n
Time Complexity: O(m+n)
Space Complexity: O(m+n)

Approach 2: Do what we did in https://github.com/vsingh16/Alogrithms/blob/master/src/array/MedianOfTwoSortedArrays.java
Just take array of size K. i.e partition x+ partion y = k
Also handle some edge cases i.e 
h = min(k,x); i.e if we have elements less than k in arrayv x, we will take whataver elements are there.
l = if we have elements < k in array y and we take all elements from them, then we have to take at least k-y elements in array x to form x+y = k

Also k can't be less than 1 and if k = 1, then min(x[0],y[0])

k == x+y, max(x,y)
k can't be greater than x+y
Time Complexity: O(log smallest array)
Space Complexity: O(1)
**/
class Solution {
    
   public long kthElement( int a[], int b[], int x, int y, int k) {
        
            if(y<x){
                return kthElement(b, a, y, x, k);
            }        

        //if any array size is less than k, we can take all elements of it
	//case if x<k, we can take all elements of x. l=0, h=x
	//case if y<k, we can take all elements of y. Then we have to take y-k elements from x. l= (y-k)
        int l = y<k ? (k-y) : 0, h= Math.min(x,k);
        while(l<=h){
            int mid = l + (h-l)/2;
            int partitionx = mid;
            int partitiony = k - partitionx;
            
            int maxLeftx= partitionx <= 0 ? Integer.MIN_VALUE : a[partitionx-1];
            int maxLefty= partitiony <= 0 ? Integer.MIN_VALUE : b[partitiony-1];
            
            int minRightx= partitionx == x ? Integer.MAX_VALUE : a[partitionx];
            int minRighty= partitiony == y ? Integer.MAX_VALUE : b[partitiony];
            
            if(maxLeftx<=minRighty && maxLefty<= minRightx){
                return Math.max(maxLeftx,maxLefty);
            }else if(maxLeftx > minRighty){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return -1;
    }
    
}
