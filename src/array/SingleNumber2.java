/**
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

Example 1:

Input: nums = [2,2,3,2]
Output: 3

Example 2:

Input: nums = [-2,-2,3,-2]
Output: 3

Ensure solution has Time complexity:O(n) and space : O(1)

Approach1:
if we sum up the bits at individual positions and if sum%3 == 0, then dont set bit as else 1.
Since Intger has 32 bits , so we need to iterate 32 times.

Approach2:
There are 3 types of numbers possible, while adding sum at any position.
3n = 0,3,6,9
3n+1 = 1,4,7,10
3n+2= 2,5,8,11

then once we do & with new element in an array. and if we get the 1 at same bit, it means its occurrence in array is increasing by 1.
so we can say, cn(3n & a[i]) will become 3n+1, so when we get cn, we need to on the bits at same position in 3n+1
and also we need to off the bits in 3n(3n & ~cn), because it no longer remained 3n and it has become 3n+1....

* Initially the bits count at all postion is 0, i.e 3n
* so we can write like 3n = 11111111111111111111111111111111 (32 bits) = -1
* Since intger also represent signed bit and all left bits are 1
* 2 = 10  
* -2 =  11111111111111111111111111111110 (in case of -, all left bits are set to 1) 
* https://www.youtube.com/watch?v=3gJxLkPPW6M
* Leetcode link: https://leetcode.com/problems/single-number-ii/discuss/1003180/Java-Detailed-Explanation-Best-Approach
**/

class Solution {
        
    public int singleNumber(int[] nums) {
        
      int tn = -1; //bec
      int tn1 = 0, tn2 = 0;
        
        for(int i=0;i<nums.length;i++){
            int cn = tn & nums[i];
            int cn1 = tn1 & nums[i];
            int cn2 = tn2 & nums[i];
            
            tn = tn & (~cn);
            tn1 = tn1 | cn;
            
            tn1 = tn1 & (~cn1);
            tn2 = tn2 | cn1;
            
            tn2 = tn2 & (~cn2);
            tn = tn | cn2;
            
        }
        
        return tn1;
    }
}
    
