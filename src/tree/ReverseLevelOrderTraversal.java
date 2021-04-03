/**
** https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/
** https://www.geeksforgeeks.org/reverse-level-order-traversal/
** Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
**                     3
**              9               20
**                          15      7
** Input: root = [3,9,20,null,null,15,7]
** Output: [[15,7],[9,20],[3]]
** Approach : We will do level order traversal and will take Stack along with queue.
** So we will remove elements from queue and put them in stack. Also note that since we need to prent from left to right, so put right element before left in stack.
** Time Complexity : O(n)
** SPace Complexity : O(n)
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList();
        Stack<Stack<Integer>> finalStack = new Stack();
        
        if(root != null){
            queue.add(root);
        }
        
        
        while(!queue.isEmpty()){
            
            int n = queue.size();
            Stack stack = new Stack();
            
            for(int i = 0;i<n;i++){
               TreeNode node = queue.poll();
               stack.push(node.val); 
               
                if(node.right != null){
                    queue.add(node.right);    
                }
                if(node.left != null){
                    queue.add(node.left);    
                }
                                                
            }
            finalStack.push(stack);            
        }
        
        return printResult(finalStack);
        
    }
    
    
    private List<List<Integer>> printResult(Stack<Stack<Integer>> finalStack){
        
        List<List<Integer>> finalList = new ArrayList();
        while(!finalStack.isEmpty()){
            
          Stack<Integer> stack = finalStack.pop();
          List<Integer> list = new ArrayList();
          while(!stack.isEmpty()){
              list.add(stack.pop());
          }  
          
          finalList.add(list);  
        }
        
        return finalList;
        
    }
    
    //Approach 2: Stack<List> because we only need to print level wise result in reverse order
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList();
        Stack<List<Integer>> finalStack = new Stack();
        
        if(root != null){
            queue.add(root);
        }
        
        
        while(!queue.isEmpty()){
            
            int n = queue.size();
            List list = new ArrayList();
            
            for(int i = 0;i<n;i++){
               TreeNode node = queue.poll();
               lsit.push(node.val); 
               
                if(node.left != null){
                    queue.add(node.left);    
                }
                
                if(node.right != null){
                    queue.add(node.right);    
                }
                                                                
            }
            finalStack.push(list);            
        }
        
        return printResult2(finalStack);
        
    }
    
    
    private List<List<Integer>> printResult2(Stack<List<Integer>> finalStack){
        
        List<List<Integer>> finalList = new ArrayList();
        while(!finalStack.isEmpty()){            
          List<Integer> list = finalStack.pop();                    
          finalList.add(list);  
        }
        
        return finalList;
        
    }
}
