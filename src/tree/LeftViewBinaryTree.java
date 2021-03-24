/**
** https://www.geeksforgeeks.org/print-left-view-binary-tree/
** Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
**          4
**       5      2 
**            3   1
**          6   7
** Left View = at each level the very first node i.e 4, 5,3,6
**
** Approach1 : Do pre order traversal. Have a global variable which wil be initially o , maxLevel < level.
** Only for very first node this maxLevel < level will be true as for later ones it will be height of tree., hence false
** Time Complexity : O(n)
** Space Complexity : O(h), recursive calls

** Approach 2: Do level order traversal and print element when i == 0
** Time Complexity : O(n)
** Space Complexity : O(n)
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
    
   //Approach 2: 
   ArrayList<Integer> leftView2(Node root)
    {
    
      ArrayList<Integer> result = new ArrayList();
      Queue<Node> queue = new LinkedList();
        
        if(root !=null){
            queue.add(root);
        }
        
        
        while(!queue.isEmpty()){
            //System.out.println("Size:" +queue.size());
            int children = queue.size(); // PS: loop will run as per children in a level
            for(int i= 0;i < children; i++){                
                Node node = queue.poll();
                if(i == 0){
                    result.add(node.data); // add first child element only
                }
                if(node.left != null){
                    queue.add(node.left);    
                }
                if(node.right != null){
                    queue.add(node.right);    
                }                                
            }
        }
        
        return result;
    }
     
    
    
    
}

