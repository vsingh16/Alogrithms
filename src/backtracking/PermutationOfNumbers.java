/**
** https://leetcode.com/problems/permutations/
** Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

** Approach : We will try to implement same permutation algorithm, which we learnt in https://github.com/vsingh16/Alogrithms/blob/master/src/backtracking/Permutation.java
** Time Complexity : npr = n!/(n-r)!
**/

class Solution {
            
    List<List<Integer>> result;
    
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList();
        Integer places[] = new Integer[nums.length];        
        permute(places,nums, 0,nums.length-1);
        return result;
    }
    
   // we have places [], ci = current index representing current element, ti = max index
    private void permute(Integer places[], int nums[], int ci, int ti) {
            
        if(ci > ti){
            List<Integer> currentResult = new ArrayList();
            for(int i=0;i<places.length;i++){
                currentResult.add(places[i]);    
            }
            result.add(currentResult);    
            return;
        }
                
        for(int i=0;i<places.length;i++){            
            if(places[i] == null){                      
                places[i] = nums[ci];                
                permute(places, nums, ci + 1, ti);                
                places[i] = null;   // Backtracking , so lets say at i there will be two cases, if we place at i and then go for next element or we don't place at i
                }                
            }                                    
    }
            
}
