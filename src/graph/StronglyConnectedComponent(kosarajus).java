/**
** https://www.geeksforgeeks.org/strongly-connected-components/
** https://www.youtube.com/watch?v=59fUtYYz7ZU&t=155s. Apna College
** Note: To find components in undirected graph, we can simply apply DFS. Count when DFS is applied.
** For directed , we will apply Kosaraju's Algorithm
** A directed graph is strongly connected if there is a path between all pairs of vertices. 
** A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph. For example, there are 3 SCCs in the following graph.
** 1----->0------->3
*  ^     ^           |
   |     |           to
** 2----            4
SC = 3
** 
** Approach: Kosaraju's Algorithm
** Intuition: If we apply topological sorting, we can get U -> V in the graph.
** Transpose of a graph tells if U -> V, then V -> U
** 1. Topological Sort
** 2. Graph Transpose
** 3. Start from Topological Nodes and see how much we can travel
** 4. keep counter when DFS is invoked.
**/

public class Solution {

    private Stack<Integer> stack;

    public void dfs(int current, boolean visited[], ArrayList<ArrayList<Integer>> adj) {

        visited[current] = true;
        for (Integer neighbour : adj.get(current)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj);
            }
        }
        stack.push(current);
    }


    //Function to find number of strongly connected components in the graph.
    // Time Complexity :O(V+E)
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        //Topological Sort
        boolean visited[] = new boolean[V];
        stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
            }
        }

        //Graph Transpose
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (Integer neighbour : adj.get(i)) {
                reverseAdj.get(neighbour).add(i);
            }
        }

        //Start from Topological Nodes and see how much we can travel
        visited = new boolean[V];
        int count = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                dfs(current, visited, reverseAdj);
                count++;
            }
        }

        return count;

    }

}

