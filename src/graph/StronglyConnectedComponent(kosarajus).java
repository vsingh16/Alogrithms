/**
** https://www.geeksforgeeks.org/strongly-connected-components/
** https://www.youtube.com/watch?v=RwkNLN5mBn8&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=19
** A directed graph is strongly connected if there is a path between all pairs of vertices. 
** A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph. For example, there are 3 SCCs in the following graph.
** 1----->0------->3
*  ^     ^           |
   |     |           to
** 2----            4
SC = 3
** 
** Approach : Kosaraju's Algorithm
** 1. Create reverse of given graph
** 2. Maintain order[] 
** 3. Apply DFS in given graph and fill order[]. Fill it when a node is completely processed.
** 4. Refer order[] in reverse order and apply DFS on reverse graph for node from order[].
** 5. keep counter when DFS is invoked.
**/

class Solution
{
    
    
    private void DFS(int node, ArrayList<ArrayList<Integer>> adj,
    boolean visited[],ArrayList<Integer> order){
        
        visited[node] = true;
        for(Integer neighbour : adj.get(node)){
            if(!visited[neighbour]){
                DFS(neighbour, adj, visited, order);
            }
        }
        order.add(node);
    }
    
    private void DFSForReverse(int node, ArrayList<ArrayList<Integer>> adj,
    boolean visited[]){
        
        visited[node] = true;
        for(Integer neighbour : adj.get(node)){
            if(!visited[neighbour]){
                DFSForReverse(neighbour, adj, visited);
            }
        }
    }
    
    
    //Function to find number of strongly connected components in the graph.
    // Time Complexity :O(V+E)
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //Create Reverse Graph
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            reverseAdj.add(new ArrayList<Integer>());
        }
        
        
        for(int i=0;i<V;i++){
            for(Integer neighbour :adj.get(i)){
                reverseAdj.get(neighbour).add(i);
            }
        }
        
        // Apply DFS on original graph & 
        // populate order array when we completely processed a node
        ArrayList<Integer> order = new ArrayList();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                DFS(i, adj, visited,order);
            }
        }
        
        
        //Refer order list from back and invoke DFS and maintain counter
        int counter = 0;
        boolean visitedForReverse[] = new boolean[V];
        for(int i = order.size()-1;i>=0;i--){
            int node = order.get(i);
            if(!visitedForReverse[node]){
                DFSForReverse(node, reverseAdj, visitedForReverse);
                counter++;
            }
        }
        
        return counter;
    }
}
