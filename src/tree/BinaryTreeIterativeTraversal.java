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
https://www.youtube.com/watch?v=12aMTS0L6WI&t=170s

Approach : We will maintain Pair(node, counter)
Case 1: counter == 1, Pre , counter ++, left
Case 2: counter == 2, Inorder, counter ++, right
Case 3: counter == 3, Post, poll
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
        
  public void postorderTraversal(TreeNode root) {
        
        Stack<Pair> stack = new Stack();
        List<Integer> pre = new ArrayList();
        List<Integer> in = new ArrayList();
        List<Integer> post = new ArrayList();
        if(root != null){
            stack.push(new Pair(root));
        }
        
        while(!stack.isEmpty()){
            
            Pair temp = stack.peek();
            if(temp.counter == 1){
                pre.add(temp.node.val);
                temp.counter++;
                if(temp.node.left != null){
                    stack.push(new Pair(temp.node.left));
                }
            }else if(temp.counter == 2){
                in.add(temp.node.val);
                temp.counter++;
                if(temp.node.right != null){
                    stack.push(new Pair(temp.node.right));
                }
            }else if(temp.counter == 3){
                post.add(temp.node.val);
                stack.pop();
            }
                        
        }
        // Print Result : pre list, in and post list                            
    }

    
}
