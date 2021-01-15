/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Input: arr[]   = {2, 0, 2}
Output: 2

Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7

Approach:
Water can be trapped b/w two blocks only, so if n<3, return 0;

Water stored at ith poistion : first fine max possible value at its left
the find max value towards its right. then take min of them
water at ith = MIN(LeftMax[i], rightMax[i]) - a[i]
https://www.geeksforgeeks.org/trapping-rain-water/
https://www.youtube.com/watch?v=XqTBrQYYUcc


Method 1: Brute Force Approach
traverse array, at each index i, find leftmax and right max with one inner loop
Time Complexity : O(n^2)
Space Complexity : O(1)

Method 2: Maintain two array leftMax[] and rightMax[]
Time Complexity : O(n)
Space Complexity : O(n)

Method 3: if we plot fun : water[i] = Min(leftMax[i], rightMax[i]) - a[i]
Whenever we have min/max problem in left and right, either two pointer approach or binary serach will work.
l=0, r = n-1
case 1: if(lmax[l] < rmax[r]) // we have two index l : r
at l: value of lmax we know and value of rmax will be either rmax[r] or it can go high and hnce we can say that at l position, min = lmax
at r: value of rmax is rmax[r] and value of lmax will be either lmax[l] or it can go high 

Time Complexity : O(n)
Space Complexity : O(n)





**/
