/**
** https://www.geeksforgeeks.org/bridge-in-a-graph/
** https://www.youtube.com/watch?v=CiDPT1xMKI0&list=PLDzeHZWIZsTobi35C3I-tKB3tRDX6YxuA&index=14&t=440s . Love Babbar
** Appraoch 1:
** Brute Force. We can start removing edges one by one and see if graph has muplitple comonents.
** Time Complexity: O(E*(V+E))

** Approach2:
** Tarjans Algoorithm
** We can start from a node and apply DFS.
** Also track visited[], discovery[] and low[] distance cost
** distance/discover[] array tracks cost of the path
** low[] tracks min cost of any exitsing path. Rest refer comments.
**/

class Solution {

    static int isBridge;

    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        // code here
        boolean visited[] = new boolean[V];
        int distance[] = new int[V];
        int low[] = new int[V];

        isBridge = 0;//false

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, distance, low, 0, c, d, adj);
            }
        }

        return isBridge;
    }

    static void dfs(int current, int parent, boolean visited[], int distance[], int low[], int cost, int c, int d, ArrayList<ArrayList<Integer>> adj) {

        visited[current] = true;
        distance[current] = low[current] = cost++; //Every time we come to a node , increase its discovery and low cost.
        for (Integer neighbour : adj.get(current)) {
            if (neighbour == parent) { //As ususal in DFS if graph is undirected and neighbour is parent , we skip this.
                continue;
            } else if (!visited[neighbour]) {
                dfs(neighbour, current, visited, distance, low, cost, c, d, adj);
                low[current] = Math.min(low[current], low[neighbour]); // This is when we are backtracking. If any of my neighbour got the low updated, we also need to update the same.
                if (((c == current && d == neighbour) || (c == neighbour && d == current)) && distance[current] < low[neighbour]) { //Becuase graph is undirected, we need to check from source to destination and vice vers as well
                    isBridge = 1;
                }
            } else {
                low[current] = Math.min(low[current], distance[neighbour]); // if neighbour is already visited, it means there is backedge. We can come to current node from this neighbour as well.
              //Hence compare discovery of neightbour with low of current
            }
        }

    }
}
