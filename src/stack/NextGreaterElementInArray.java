/**
https://www.geeksforgeeks.org/next-greater-element/

Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider next greater element as -1. 

Examples: 

For an array, the rightmost element always has the next greater element as -1.
For an array which is sorted in decreasing order, all elements have next greater element as -1.
For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
https://www.youtube.com/watch?v=rSf9vPtKcmI

Approach : Iterate array, if a[i] < stack.peek() push
but if it is greater print ans pop elements from stack until stack is empty or if this greater condition false.

But to print result in correct order, we should iterate array from right.
we need to do three things.
1) if stack.peek() <= a[i] , pop
2) print result i.e a[i] ---> stack.peek()
3) push a[i]

Time Complexity: O(n)
Please check youtube video link on time complexity analysis.
**/

// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


class solve{
    public static long[] nextLargerElement(long[] arr, int n) { 
    
     long result[] = new long[n];
     result[n-1] = -1;
     Stack<Long> stack = new Stack();
     stack.push(arr[n-1]);
     for(int i=n-2;i>=0;i--){
        
        //look for smaller elements and pop them
        while(!stack.empty() && stack.peek() <= arr[i] ){
            stack.pop();
        }
        
        if(stack.empty()){
            result[i] = -1;
        }else{
            result[i] = stack.peek();    
        }
        
         stack.push(arr[i]);
     }
    
     return result;
    } 
}
===================================================================
https://leetcode.com/problems/next-greater-element-i/description/
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

Approach : Just Keep a map and find next greater element using above way.
    
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = nextLargerElement(nums2);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

     public static Map<Integer, Integer> nextLargerElement(int[] a) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(a[a.length - 1], -1); //For the right most element
        Stack<Integer> stack = new Stack<>();
        stack.push(a[a.length - 1]);//For the right most element

        for (int i = a.length - 2; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                map.put(a[i], -1);
            } else {
                map.put(a[i], stack.peek());
            }

            stack.push(a[i]);
        }

        return map;
    }
}
