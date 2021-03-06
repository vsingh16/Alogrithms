/**
** https://www.geeksforgeeks.org/bottom-view-binary-tree/
** https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1#
** Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in output if x is the bottommost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1. 

Examples: 

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \      
                  10    14
For the above tree the output should be 5, 10, 3, 14, 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4. 

                   
                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \      
                  10    14
For the above tree the output should be 5, 10, 4, 14, 25. 

Approach : we will do pre order traversal and keep a treemap(because result is required in left to right order, so cant take hashmap)
Idea is ditance = when u go to left , it decreases by 1 and on right  +1
Level : at one level down , +1
In map, we will check if there is any node at same distance, and the level of new node is greater or equal to existing, we will update.

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
    public ArrayList <Integer> bottomView(Node root)
    { 
       result = new ArrayList();    
       bottomView(root,0,0);
       return printResult();
    }
    
    public void bottomView(Node root,int distance, int level)
    {
    
        if(root == null){
            return ;
        }
        
        
        if(map.containsKey(distance)){
            
          NodeLevel  nodeLevel = map.get(distance);
          if(level >= nodeLevel.level){ //greater and equal to because if two nodes at same distaance we want right most or latest one
              nodeLevel.data = root.data;
              nodeLevel.level = level;
          }
          
        }else{
            
            NodeLevel nodeLevel = new NodeLevel(root.data,level);
            map.put(distance,nodeLevel);
        }
        
        bottomView(root.left,distance-1, level+1);
        bottomView(root.right,distance+1, level+1);
        
    }
    
    private ArrayList<Integer> printResult(){
        ArrayList<Integer> result = new ArrayList();
        
        for (Map.Entry<Integer, NodeLevel> entry : map.entrySet()){
          result.add(entry.getValue().data);      
        }
          
           
        return result;
    }
    
}
