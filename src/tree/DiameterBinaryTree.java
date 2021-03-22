/**
** https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
** https://leetcode.com/problems/diameter-of-binary-tree/submissions/
** The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. 
** The diagram below shows two trees each with diameter nine, the leaves that form the ends of the longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes). 
** Approach : Diameter of a node is distance b/w its left leaf node to right leaf noe.
** so Diameter = left height + 1 + right height
** and each node will return its height which will help other nodes to calculate diameter.
** height = 1 + max(left,right)
** Time Complexity : O(n)
** Space Complexity :O(h) , recursive stack one side elements
**/

class Solution {
    /* Complete the function to get diameter of a binary tree */
    int maxDiameter = -1;
    
    int diameter(Node root) {
        
        diameterUtil(root);
        return maxDiameter;
    }
    
    int diameterUtil(Node root) {
        
        if(root == null){
            return 0;
        }
        
        int left = diameterUtil(root.left);
        int right = diameterUtil(root.right);
        
        int diameter = left + right + 1;
        maxDiameter = max(maxDiameter,diameter);
        
        return max(left,right) + 1;
    }
    
    private int max(int a , int b){
        
        return a > b ? a : b;
    }
}
