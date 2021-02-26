/**
** https://www.geeksforgeeks.org/binary-tree-data-structure/
** https://leetcode.com/explore/learn/card/data-structure-tree/
** Binary Tree : A root node in tree can have max 2 nodes (i.e 0,1,2)
** Root: The very first parent node
** Parent: It will have some child nodes
** Leaf Nodes : Nodes which don't have any child
** Internal Nodes: Nodes other than leaf nodes
** Binary Search Tree: BST follows a special property where all left child nodes will be less than or equal to parent node
** and right nodes will be greater.
**/

BinaryTree{
  
  class Node{
    int data;
    Node left;
    Node right;
    
    Node(int data){
      this.data = data;
      left = null;
      right = null;
  }
    
  void print(Node root){
    
    if(root == null){
      return;
    }
    System.out.println(root.data);
    print(root.left);
    print(root.right);
  }
    
}
