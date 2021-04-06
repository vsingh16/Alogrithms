/**
** https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
** https://leetcode.com/problems/binary-tree-maximum-path-sum/
** A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
** The path sum of a path is the sum of the node's values in the path.
** Given the root of a binary tree, return the maximum path sum of any path.

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
** Approach : There are 4 possible combinations for each node.
** max( root, root + left, root + right, left + root + right)
** Here point to note that we will return ans with any one of child or node itself becuase left + root + right means path itself.
** Time Complexity :O(n)
**/

class Solution {
    
    Integer maxResult = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxResult;
    }
    
    private int maxPathSumUtil(TreeNode root) {
        
        if(root == null){
            return 0;
        }
            int left = maxPathSumUtil(root.left);        
            int right = maxPathSumUtil(root.right);  
            int max_single = Math.max(Math.max(left, right) + root.val,
                                  root.val);         
            int max_top = Math.max(max_single, left + right + root.val);            
            maxResult = Math.max(maxResult, max_top);
        
        return max_single;
                                       
    }        
}
