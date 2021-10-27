/**
** https://www.geeksforgeeks.org/two-clique-problem-check-graph-can-divided-two-cliques/
** https://www.youtube.com/watch?v=cA8-mdRJuCI&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=27&t=668s
** Two Clique Problem (Check if Graph can be divided in two Cliques)
** A Clique is a subgraph of graph such that all vertices in subgraph are completely connected with each other.
** Given a Graph, find if it can be divided into two Cliques.
** Approach:
** Bipartite graph tells us if we can have two sets U(colro 1) & V(color 2).
** such that all nodes in same set is not connected to each other.
** Two Clique is just opposite of this where we need to find if we can divide it in two sets U & V, such that all nodes in same set are connected. 
** So we will make complementary adjList of give adjList i.e connect nodes which are not originally connected.
** Then apply Bipartite.
** Time Complexity :O(V^2)
** Space Complexity :O(V+E): Since we have created complementary adj list.
**/

import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean isBipartite = true;

    public void isBipartite(List<List<Integer>> adj,
                            int node, int color, int visited[]) {
        visited[node] = color;
        for (Integer neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                isBipartite(adj, neighbour, 3 - color, visited);
            } else {
                if (visited[neighbour] == color) {
                    isBipartite = false;
                }
            }
        }

    }

    public boolean isTwoClique(int V, List<List<Integer>> adj) {

        //Create complementary graph
        List<List<Integer>> complementaryAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            complementaryAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (j != i && !adj.get(i).contains(j)) {
                    complementaryAdj.get(i).add(j);
                }
            }
        }

        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {//not color
                isBipartite(complementaryAdj, i, 1, visited);
            }

        }


        return isBipartite ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(1, 2, 3));
        adj.add(List.of(0, 2));
        adj.add(List.of(0, 1));
        adj.add(List.of(0, 4));
        adj.add(List.of(3));
        System.out.println(solution.isTwoClique(5, adj));
    }
}
