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
    
    public long kthElement( int nums1[], int nums2[],int n ,int m, int k) {
        
        int x = nums1.length;
        int y= nums2.length;
        
        //traverse in small array
        if(y<x){
      		return kthElement(nums2,nums1,n,m,k);
		    }
        
       if(k == 1){
          
          if(x > 1 && y >1){
               return min(nums1[0],nums2[0]); 
           }else if(x > 1){
               return nums1[0];
           }else if(y > 1){
                return nums2[0];
           }
        }else if(x+y == k){
            return max(nums1[x-1],nums2[y-1]);
        }else if(k<1){
            return 0;
        }else if(k>x+y){
            return 0;
        }
        
        
        // if y is less than k, and then if we take all elements of second array
        // we have to take at least k - y elements from first array
		int l= y < k ? (k-y) : 0;
		//Since we can't have elements more than x so either k or x
		int h = min(k,x);
		
		
		while(l <=h ){
		    
		    int partitionX = l + (h-l)/2;
		    int partitionY = k - partitionX;
		    
		        int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX<=minRightY && maxLeftY <= minRightX){
                return max(maxLeftX,maxLeftY);
            }else if(maxLeftX > minRightY){
                h = partitionX - 1;
            }else{
                l = partitionX + 1;
            }
		}
            
        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
	}
        
    int max(int a, int b){
        return a>=b? a:b;
    }
    
    int min(int a, int b){
        return a<=b? a:b;
    }
    
}
