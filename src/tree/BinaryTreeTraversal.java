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
//Space Complexity: O(1)
class Tree
{
    
    ArrayList<Integer> result = new ArrayList();
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        if(root == null){
            return new ArrayList();
        }
        inOrder(root.left);
        result.add(root.data);
        inOrder(root.right);
        
        return result;
    }
        
    ArrayList<Integer> preOrder(Node root)
    {
       if(root == null){
            return new ArrayList();
        }
        
        result.add(root.data);
        preOrder(root.left);
        preOrder(root.right);        
        
        return result;
    }
        
    ArrayList<Integer> postOrder(Node root)
    {
       if(root == null){
            return new ArrayList();
        }
        
        postOrder(root.left);
        postOrder(root.right);
        result.add(root.data);
        
        return result;
    }    
    
    
}
