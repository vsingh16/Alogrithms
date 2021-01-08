/**
* Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
* Find the two elements that appear only once. You can return the answer in any order.
* Time Complexity : O(n)
* Space Complexity : O(1)
* Follow up: Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
* Input: nums = [1,2,1,3,2,5]
* Output: [3,5]
* Explanation:  [5, 3] is also a valid answer.
* 
* Input: nums = [-1,0]
* Output: [-1,0]
**/

class Solution {
    public int[] singleNumber(int[] nums) {
        
        //apply xor on all numbers
        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        
        // in result, we can say at right most place if bit is 1, then in one of numerbs 
        // bit is 1 and in other bit is 0
        //apply bit masking to set only right most bit, this is also subtraction
        int rightMostBit = xor & ~ (xor -1);
            
        //now segregate array elements in two parts 
        //one with right most bit set and other not set    
                 
            int result [] = new int[2];
            for(int i=0;i<nums.length;i++){
                if((nums[i] & rightMostBit) == 0){
                    result[0] = result[0] ^ nums[i];
                }else{
                   result[1] = result[1] ^ nums[i];
                }
            }  
        return result;
    }
}
