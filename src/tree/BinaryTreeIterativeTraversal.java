/**
** There are three traversals:
1) Pre: root, lef, right
2)Post: left, right, root
3)In: left, root , right
eg:        1
        2    3
      4   5
      
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
**/

// { Driver Code Starts
//Initial Template for Java

/* A Binary Tree node 
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

//Time Complexity: O(n)
//Space Complexity: O(h)
class Tree
{
        
    // Return a list containing the inorder traversal of the given tree
  public List<Integer> inorderTraversal(TreeNode root) {
    
        Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList();
        while(root!= null || !stack.isEmpty()){ // root!=null for first time
                        
            if(root !=null ){
                 stack.push(root);
                 root = root.left;
            }else{
                TreeNode temp = stack.pop();
                result.add(temp.val);
                root = temp.right;
            }
            
        }
        
        return result;
        
    }
        
    ArrayList<Integer> preOrder(Node root)
    {
      Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList();
        
        if(root != null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();            
            result.add(temp.val);            
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null ){
                stack.push(temp.left);
            }
        }
        
        return result;
    }
        
    ArrayList<Integer> postOrder(Node root)
    {
      Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList();
        
        if(root != null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();            
            result.add(temp.val);                        
            if(temp.left != null ){
                stack.push(temp.left);
            }
          if(temp.right != null){
                stack.push(temp.right);
            }
        }
        
        return result;
    }    
    
    
}
