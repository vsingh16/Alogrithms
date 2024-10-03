/**
** https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
** https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
** Ref: https://www.youtube.com/watch?v=59fUtYYz7ZU&t=9169s. Apna College Graph
** Approach :
** Apply DFS and see if a node is already visited.
** Since undirected graph a node can be visted twice eg 1 -- 2 , when we visit 1, visited[1] = true and then again we can visit 1 from 2
** That means while exploring neigbours, we need to skip a neighbour if it is same as parent, eg in this case from 2 to 1 , parent is 1 and neighbour for 2 is also 1.
** We can skip it.
** Else 
** Simply check is neighbour is already visited true, then it is a cycle.
** https://www.youtube.com/watch?v=6PSczvPWGak&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=5
** Time Complexity : O(V+E)
** Space Complexity :O(V), V size visited array
**/

class Solution
{
    
    public boolean isCycleUtil(int V, int parent, ArrayList<ArrayList<Integer>> adj, boolean visited[]){
        
        visited[current] = true;

        for (Integer neighbour : adj.get(current)) {
            if (neighbour != parent) {
                if (visited[neighbour]) {
                    return true;
                } else {
                    if (isCyclic(adj, current, neighbour, visited)) {
                        return true;
                    }
                }
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
