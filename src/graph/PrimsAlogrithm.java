/**
** Ref: https://www.youtube.com/watch?v=59fUtYYz7ZU&t=17106s. Apna College
** https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
** Prims Algorithm:
** This is used to find Minimum Spanning Tree in a graph.
** This is a subset of graph which is connected and edges are min wegiht.
** This is only possible for undirected weighted connected graph.
** Approach: This is quite similar to Dijikstras where we pick the edge with min wegiht.
** Since graph is connected we can start from any one vertex, we are starting from 0.
** Time Complexity : O(V+E) (log V) . Log v to add/remove from Priotiy Queue
** Space Complexity :O(V)
** Since we connect E≈V
**/


// User function Template for Java

class Solution {
   static class Node implements Comparable<Node> {

        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        boolean visited[] = new boolean[V];
        int cost = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) { // O(V)

            Node current = queue.remove();
            if (!visited[current.node]) {
                visited[current.node] = true;
                cost +=current.weight;
                List<int[]> neighbours = adj.get(current.node);
                for (int i = 0; i < neighbours.size(); i++) { // O(E)
                    int v = neighbours.get(i)[0];
                    int weight = neighbours.get(i)[1];

                    queue.add(new Node(v, weight));
                }
            }
        }

        return cost;

    }

}
