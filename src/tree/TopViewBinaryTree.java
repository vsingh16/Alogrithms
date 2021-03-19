 /**
** https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
** https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1#
** Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order.

A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1. 

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
Approach : we will do pre order traversal and keep a treemap(because result is required in left to right order, so cant take hashmap)
Idea is ditance = when u go to left , it decreases by 1 and on right  +1
Level : at one level down , +1
In map, we will check if there is any node at same distance, and the level of new node is less than to existing, we will update.
Time Complexity : O(nlogn) // n nodes trversal and tree map insertion is logn becuase it is sorted so either left or right
Space Complexity : O(n) Here n is not the total no of nodes but no of possible distance which will be somehow proportional to no of nodes.
**/

class Tree
{
 
    class NodeLevel{
        int data;
        int level;
        
        NodeLevel(int data, int level){
            this.data = data;
            this.level = level;
        }
    }
    
    Map<Integer,NodeLevel> map = new TreeMap();
    ArrayList<Integer> result = new ArrayList();
    // Method that returns the bottom view.
    public ArrayList <Integer> topView(Node root)
    { 
       result = new ArrayList();    
       topView(root,0,0);
       return printResult();
    }
    
    public void topView(Node root,int distance, int level)
    {
    
        if(root == null){
            return ;
        }
        
        
        if(map.containsKey(distance)){
            
          NodeLevel  nodeLevel = map.get(distance);
          if(level < nodeLevel.level){ 
              nodeLevel.data = root.data;
              nodeLevel.level = level;
          }
          
        }else{
            
            NodeLevel nodeLevel = new NodeLevel(root.data,level);
            map.put(distance,nodeLevel);
        }
        
        topView(root.left,distance-1, level+1);
        topView(root.right,distance+1, level+1);
        
    }
    
    private ArrayList<Integer> printResult(){
        ArrayList<Integer> result = new ArrayList();
        
        for (Map.Entry<Integer, NodeLevel> entry : map.entrySet()){
          result.add(entry.getValue().data);      
        }
          
           
        return result;
    }
    
}
