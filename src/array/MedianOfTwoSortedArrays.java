/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

https://leetcode.com/problems/median-of-two-sorted-arrays/
https://www.youtube.com/watch?v=LPFhl65R7ww&t=60s

Approach1: Merge the two sorted arrays as we do in Merge sort.
Median of odd length array = mid element
Median of even length array = ((mid-1) + (mid))/2;
Have counter as per above case.
Time Complexity: O(m+n)
Space Complexity: (m+n)

Approach2: 
Median of odd length array = mid element
Median of even length array = ((mid-1) + (mid))/2;
The approach is in our final merged array we will have (Min elements(some elements from x array and some of y)) < median < (Max elements(some elements from x array and some of y))
Take the smallest array.
Now start dividing smallest array from mid.
x= small array length
y= other array length
partitionx = l + (h-l)/2
paritionx + partitiony = (x+y)/2
partitiony = (x+y)/2 - partitionx

Now there will be four elements in centre
maxLeftX = x[partitionx-1]
maxLeftY = y[partitiony-1] 
minRightX = x[partitionx+1]
minRightY = y[partitiony+1] 

Now if case is maxLeftX<=minRightY && maxLeftY <= minRightX, it means we can say that elements on left side(some elements from x array and some of y) <= elements on right side(some elements from x array and some of y)
and this is our desired state, now we can return median based on even and odd length.

if maxLeftX>=minRightY, we need to move more towards left i.e h = partitionx-1 else l = partitionx+1
Result is in double as we may have cases like (2+3)/2 = 2.5 
** Time Complexity: O(min(log M, log N)), Since binary search is being applied on the smaller of the 2 arrays
** Space Complexity: O(1)
**/



public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
        int x = nums1.length;
        int y= nums2.length;
        
        if(y<x){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int l = 0, h = x;
        while(l<=h){            
            int partitionX = l + (h-l)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                
                //even length case
                if((x+y) %2 == 0){                    
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }else{
                    return (double)Math.max(maxLeftX,maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                h = partitionX - 1;
            }else{
                l = partitionX + 1;
            }
        }
         //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }
}
