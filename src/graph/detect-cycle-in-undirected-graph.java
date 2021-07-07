/**
** https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
** https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
** Approach :
** Apply DFS and see if a node is already visited.
** Since undirected graph a node can be visted twice eg 1 -- 2 , when we visit 1, visited[1] = true and then again we can visite 1 from 2
** if a node is alreayd visited but this visit is not from its parent node i.e for a vertex V, negihbour of V ! = parent, then we can say its cycle.
** https://www.youtube.com/watch?v=6PSczvPWGak&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=5
** Time Complexity : O(V+E)
** Space Complexity :O(V), V size visited array
**/

class Solution
{
    
    public boolean isCycleUtil(int V, int parent, ArrayList<ArrayList<Integer>> adj, boolean visited[]){
        
        visited[V] = true;
        ArrayList<Integer> neighbours = adj.get(V);
        for(Integer neighbour : neighbours){
            if(!visited[neighbour]){
                boolean result = isCycleUtil(neighbour, V, adj, visited);
                if(result){
                    return true;
                }
            }else if(parent != neighbour){
                return true;
            }
        }
        
        return false;
    }
    
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
             boolean result = isCycleUtil(i,-1,adj,visited);   
             if(result){
                return true;
              }
            }
        }
        
        return false;
    }
}
