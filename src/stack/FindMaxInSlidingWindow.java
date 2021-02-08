/**

https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
Examples : 

Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
Output: 3 3 4 5 5 5 6
Explanation: 
Maximum of 1, 2, 3 is 3
Maximum of 2, 3, 1 is 3
Maximum of 3, 1, 4 is 4
Maximum of 1, 4, 5 is 5
Maximum of 4, 5, 2 is 5 
Maximum of 5, 2, 3 is 5
Maximum of 2, 3, 6 is 6

Approach:
Step 1: Calculate Next greater element.
https://github.com/vsingh16/Alogrithms/blob/master/src/stack/NextGreaterElementInArray.java
In the result rather than number , store indexes and for case where we don't find any nge , store array length(infinite index)

Step 2: 
now i=0 to n-k, j=i
if nge[j] lies in window range i.e nge[j] < i+k
update j = nge [j] i.e we are jumping from one nge to other because we need to find max
but if nge[j] is out of sliding window, we can say that j index is max, so arr[j] add to result

https://leetcode.com/problems/sliding-window-maximum/submissions/
https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1#
https://www.youtube.com/watch?v=tCVOQX3lWeI&t=1s

Time Complexity: O(n) // Similar explaination as in NGE solution
**/

class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int result [] = new int[n-k + 1];
        int nge [] = findNGE(nums,n);
        //System.out.println(nge[i]);
        //Arrays.stream(nge).forEach(System.out::println);
        for(int i=0;i<=n-k;i++){
            int j = i;
            
            while(nge[j] < i+k){ //i.e next greater index is within window
                j = nge[j];
            }
                        
            result[i] = nums[j];
                        
        }
        
        return result;
        
    }
    
     private static int[] findNGE(int arr[], int n){
        
        Stack<Integer> stack = new Stack();
        int result[] = new int[n];
        stack.push(n-1);
        result[n-1] = n; // store indexes in result
        
        for(int i=n-2;i>=0;i--){
            //pop result push
            
            while(!stack.empty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            
            if(stack.empty()){
             result[i] = n;
            }else{
            result[i] = stack.peek();    
            }
            
            stack.push(i);
        }
        
        
        return result;
    }
   
}
