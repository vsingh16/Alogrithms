/**
** https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
** https://www.youtube.com/watch?v=1u2VLzBhJZU&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=4
** Given a directed graph, check whether the graph contains a cycle or not. 
Your function should return true if the given graph contains at least one cycle, else return false.
Example, 
 
Input: n = 4, e = 6
0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
Output: Yes
Explanation:
Diagram:

The diagram clearly shows a cycle 0 -> 2 -> 0

Approach: 
We keep two arrays one is visited[] and order[].
We apply DFS. The extra array order[] is needed and we may visit same node again but that is not loop.
Loop is considered when node is visted on same path i.e on a order.

Time Complexity : O(V+E). DFS
Space Complexity: O(V), visited and order array
**/

 //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        boolean order[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
             boolean result = isCyclicUtil(i, adj, visited, order);   
             if(result){
                 return result;
             }
            }
        }    
        return false;
    }
    
    private boolean isCyclicUtil(int V, ArrayList<ArrayList<Integer>> adj, 
    boolean visited[], boolean order[]){
        
        visited[V] = true;
        order[V] = true;
        
        ArrayList<Integer> neighbours = adj.get(V);
        for(Integer neighbour:neighbours){
            if(!visited[neighbour]){
                boolean isCycle = isCyclicUtil(neighbour, adj, visited,order);
                if(isCycle){
                    return true;
                }
            }else if(order[neighbour]){
                return true;
            }
        }
        
        order[V] = false;
        return false;
    }
}
