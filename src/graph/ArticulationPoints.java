/**
** Ref: https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
** https://www.youtube.com/watch?v=fqkqx6OBRDE&t=707s . Love Babbar
** https://www.youtube.com/watch?v=59fUtYYz7ZU&t=23251s - Apna College
** Articulation Point: This is a vertex in a graph if removed(i.e removing vertex and all its edges) will givces us more than 1 connected componenets
** Appraoch1: Naive Approach
** Iterate over all the vertex and remove vertexes 1 by 1
** Apply DFS to check if more than 1 component. eg
**  for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, discovery, low, 0, adj);
                count++ //Here comes only after complete traversal
            }
        }

        if(counter > 1){
        Articulation
        }
** Time Complexity: O(E* (V+E))
** Approach 2:
** Apply Tarjan Algortihm, same as Bridge but there are few catches
** for Bridge, we check discovery[current] < low[neighbour] .i.e there is only 1 path exists. No Backedge
** But for Articulation point, if current is connected to neighbour(Bridge) but there is also an edge connecting current to neighbours of neighbours. and cycle is formed discovery[current] = low[neighbour]
** For root node/starting node, it can be articulation only if it has more than 1 disconnetced children
** Time Complexity: O((V+E))
**/

class Solution {

    static ArrayList<Integer> articulationPoints;

    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[V];
        int discovery[] = new int[V];
        int low[] = new int[V];

        articulationPoints = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, discovery, low, 0, adj);
            }
        }

        if (articulationPoints.isEmpty()) {
            articulationPoints.add(-1);
            return articulationPoints;
        } else {

            Set<Integer> set = new TreeSet<>(articulationPoints);
            // Convert the sorted set back to an ArrayList
            return new ArrayList<>(set);
        }
        
    }


    static void dfs(int current, int parent, boolean visited[], int discovery[], int low[], int cost, ArrayList<ArrayList<Integer>> adj) {

        visited[current] = true;
        discovery[current] = low[current] = cost++;
        int children = 0;
        for (Integer neighbour : adj.get(current)) {
            if (neighbour == parent) { //if neighbour is same as parent , skip
                continue;
            } else if (!visited[neighbour]) { // is neighbour is not visisted, visist it
                dfs(neighbour, current, visited, discovery, low, cost, adj);
                children++; // This counter will only increase for disconnected children, as if child is already connected, it will already visited 
                low[current] = Math.min(low[current], low[neighbour]); //update low of current with low neighbour while backtracking, This helps us to update low if any of my neighbour low is updated.
                if (parent != -1 && discovery[current] <= low[neighbour]) { //non root/starting case
                    articulationPoints.add(current);
                }
            } else {
                low[current] = Math.min(low[current], discovery[neighbour]); // if neighbour is already visited, Backedge case, update low with discopvery of neighbour
            }
        }

        if (parent == -1 && children > 1) { // Root can be articulation point , if it has more than 1 disconnected children
            articulationPoints.add(current);
        }

    }
}


