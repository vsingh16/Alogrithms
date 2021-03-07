/**
** Leetcode : 863. All Nodes Distance K in Binary Tree
** We are given a binary tree (with root node root), a target node, and an integer value K.

** Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.

https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

Approach : Search for target Node. Note Since it is not BST but only binary tree, we ave to recurively call both side left and right.
** Once the target node is found, we can print all downside nodes at  k distance from target node.
** We also need to print all upwards(ancestor node at k distance). 
** Recurive call will help us to back track to ancesotrs.
** if distance is not -1, it means this is back track call of serach node path
** so if this is happeing on left call , so we will find nodes at k distnace in right direction becuase in left we have target node and its down nodes are alreayd covered. and vice versa.
** Now in ancestor case, there will be two cases:
** Case 1)if its immeddiate parent node i.e drt(distance b.w target and root node) + 1 == k, print else
** Case 2) findDownNodes(root.left/root.right, k - drt -2); // -2 because we are excluding target and immediate parent node
** Time Complexity : Since each node is called only once, O(n)
** For more, refer logicmojo
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private List<Integer> result ;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        result = new ArrayList();
        find(root,target,k);
                 
        return result;
    }
    
    //returning distance b/w root and target node
    public int find(TreeNode root, TreeNode target , int k)
    {
        
        if(root == null){
            return -1;
        }else if(root == target){ //  when target and root node are same, distance  = 0 
            findDownNodes(root, k);
            return 0;
        }
        
        //left recur    
        int drt = find(root.left, target , k);
            
        if(drt != -1){ // target node found
           
            if(drt + 1 == k){ //immediate parent
                result.add(root.val);
            }else{ //
                findDownNodes(root.right, k - drt - 2); // -2 becuase target node and immeditae parent && since target node is on left side, now we need to go on right side
            }    
            
            return 1 + drt; // if we are on found root backtrack, increase distance by 1
        }
        
        //right recur    
        drt = find(root.right, target , k);
            
        if(drt != -1){ // target node found
            if(drt + 1 == k){ //immediate parent
                result.add(root.val);
            }else{ //
                findDownNodes(root.left, k - drt - 2); // -2 becuase target node and immeditae parent
            }    
            
            return 1 + drt;
        }
         
        return -1; //target node not found    
    }
    
    private void findDownNodes(TreeNode root, int k){
        
        if(root == null || k < 0 ){
            return;
        }
        
        if(k == 0){ // i.e level reached, print
            result.add(root.val);
        }
        
        findDownNodes(root.left, k-1);
        findDownNodes(root.right, k-1);
    }
    

}
