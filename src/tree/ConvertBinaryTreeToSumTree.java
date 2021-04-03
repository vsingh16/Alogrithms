/**
** https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
** Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.

For example, the following tree

                  10
               /      \
             -2        6
           /   \      /  \ 
         8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \ 
         0      0    0    0
         
** Approach : Apply Pre Order search, for each node return left + root.data + right
** and update node data to left + right
** Time Complexity :O(n)
** Spach Complexity :O(h) , considering  recursive stack space
**/

class Tree{
    public void toSumTree(Node root){
         toSumTreeUtil(root);
    }
    
    private int toSumTreeUtil(Node root){
         if(root == null){
             return 0;
         }
         
         int left = toSumTreeUtil(root.left);
         int right = toSumTreeUtil(root.right);
         int temp = left + root.data + right;
         root.data = left + right;
         return temp;
    }
}
