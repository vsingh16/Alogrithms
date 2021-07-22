/**
** https://leetcode.com/problems/clone-graph/submissions/
** Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

** Few Considerations:
** 1. Graph is connected, so we can start with any of node.
** Nodes values are unique
** Approach : We will apply DFS. As in DFS we need to keep track of visisted nodes, so that we dont process them again.
** Also, we need cloned node corresponding to original nodes. TO do so we will use map<node.value, Cloned>
** Time Complexity : O(V+E)
** Space Complexity: O(V)
**/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        
        if(node == null){
            return node;
        }else{
            Node copy = new Node(node.val);            
            Map<Integer,Node> visitedMap = new HashMap();
            DFS(node,copy,visitedMap);
            return copy;
        }
            
    }
    
    private void DFS(Node node, Node copy,Map<Integer,Node> visitedMap){
                        
        visitedMap.put(node.val,copy);
        for(Node neighbor : node.neighbors){
            if(!visitedMap.containsKey(neighbor.val)){
                Node newCopy = new Node(neighbor.val);
                copy.neighbors.add(newCopy);    
                DFS(neighbor, newCopy,visitedMap);
            }else{ 
                //If node is laready visted, dont process it again but still add it ti neighbour list
                copy.neighbors.add(visitedMap.get(neighbor.val));    
            }            
        }        
    }
}
