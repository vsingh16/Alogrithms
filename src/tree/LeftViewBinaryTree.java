/**
** https://www.geeksforgeeks.org/print-left-view-binary-tree/
** Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
**          4
**       5      2 
**            3   1
**          6   7
** Left View = at each level the very first node i.e 4, 5,3,6
**
** Approach : Do pre order traversal. Have a global variable which wil be initially o , maxLevel < level.
** Only for very first node this maxLevel < level will be true as for later ones it will be height of tree., hence false
** Time Complexity : O(n)
** Space Complexity : O(h), recursive calls
**/

class Tree
{
    ArrayList<Integer> result;
    int maxLevel = 0;
    
    ArrayList<Integer> leftView(Node root)
    {
      result = new ArrayList<Integer>();
      leftViewUtil(root, 1);
      return result;
      
    }
    
    private void leftViewUtil(Node root, int level){
        
        if(root == null){
            return ;
        }
        
        if(maxLevel < level){
            result.add(root.data);
            maxLevel++;
        }
        
        leftViewUtil(root.left, level + 1);
        leftViewUtil(root.right, level + 1);
    }
}

