/**
** https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
** https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/
** Approach 1: We can go with level order traversal, and with queue and loop where we process nodes at same level,
** we can set next.
** Refer : https://github.com/vsingh16/Alogrithms/blob/master/src/tree/LevelOrderTraversal.java // Approach 2
** Time Complexity : O(n), Space Complexity : O(n)
**
** Approach 2: We can do inorder traversal , start processing from right to left. 
** Remember : Its kind of inorder but we will handle cases in start and then right, left (Reason because we are working on parent)
** There are 3 cases:
** case 1 if node is null or child node, no processing
** Case 2: If parent has two chilren: parent.left.next = parent.right.next, parent.right.next = findNextChildren
** Case 3: If parent has one child, parent.left.next or parent.right.next = findNextChildren
** 
** Find Next Children: if node is not null, Pick not null (node.left and then node.right) , if bth chilren null, move to next node
** Time Complexity: O(n)
** Spac Complexity: O(1)
**/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connect(Node root){
        
        if(root != null ){
            inOrder(root);
        }
        
        return root;
    }
    
    private void inOrder(Node p) {
        
          //Case 1: no processing for leaf nodes
           if(p == null || (p.left == null && p.right == null)){
               return ;
           }
                                                   
           //Case 1: Node has two children
           if(p.left != null && p.right != null){
               p.left.next = p.right;                              
               p.right.next = findRight(p.next);               
           }
           //Case 2: Node has only left child
           else if(p.left != null){
               p.left.next = findRight(p.next);
           }else if(p.right != null){
               p.right.next = findRight(p.next);
           }
           inOrder(p.right);
           inOrder(p.left);
           
           return ;
    }
    
    private Node findRight(Node node){
            
            if(node == null){
                return null;
            }
            Node current = node;
            while(current != null){
                if(current.left!=null){
		            return current.left;
	            }else if(current.right!=null){
		            return current.right;
	            }
                current = current.next;
            }
            
            return null;
        }
    
}
