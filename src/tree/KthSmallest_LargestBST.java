/**
** https://leetcode.com/problems/kth-smallest-element-in-a-bst/
** https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
** https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
**  We need to find Kth Smallest/Largest element in Binary Tree
** 
** Approach : In Order Traversal gives us elements in sorted ascending order.
** For smallest kth, we can do in order traversal.
** For Largest Kth, we can do in order traversal but right element first.

** Time Complexity: O(n) : n = no of nodes in BST
** Space Complexity: O(1)
**/

class Solution
{
    
    int counter = 0;
    int result = -1;
    
    // Return the Kth smallest element in the given BST 
    public int KthSmallestElement(Node root, int K) 
    {
        if(root == null){
            return -1;
        }
        
        KthSmallestElement(root.left,K);
        counter++;
        if(counter == K){
            result = root.data;
        }
        KthSmallestElement(root.right,K);
        
        return result;
                  
    }
  
	public int kthLargest(Node root,int K)
    {
      
      if(root == null){
          return -1;
      }
      
      kthLargest(root.right,K);
      counter ++;
      if(counter == K){
          result = root.data;
      }
      kthLargest(root.left,K);
      
      return result;
    }
}
	
