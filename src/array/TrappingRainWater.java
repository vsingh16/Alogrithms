/**
Ref: https://www.geeksforgeeks.org/trapping-rain-water/
https://leetcode.com/problems/container-with-most-water/description/
https://www.youtube.com/watch?v=EbkMABpP52U&t=432s

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Input: arr[]   = {2, 0, 2}
Output: 2

Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7

Approach 1: Brute Force
	Area of Container = width * height
	width = (r-l)
	height = Math.min(height[l], height[r]) . Because Min height controls how much water goes in a container.
        Explore all combinations
	l = 0 to n
	r = l+1 to n
        Time Complexity: O(n^2)
	Space Complexity: O(1)

Approach 2: We see we have two variables l and r.
	We can use the two pointers approach.
	Traverse from l<r. Because if l==r, width =0. 
	Since min height controls the area, we need to increase the pointer with min Height.
	If we change to pinter with max height and min-height pointer remains the same, the area will remain the same.
	Time Complexity: O(n)
	Space Complexity: O(1)

class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int width = r - l;
            int h = Math.min(height[l], height[r]);
            int area = width * h;
            maxArea = Math.max(area, maxArea);

            //Pointers Update
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}	
	

