/**
** https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
** Ref: https://www.youtube.com/watch?v=59fUtYYz7ZU&t=14228s. Apna College Graph
** This algo is used to find the shortest vertex distance from the Source.
** Approach: 
** This is a greedy algorithm.
** That Means, we will go to the node that is unvisited and which has less distance.
** Initially we will initialize distance[] with the source as 0 and the rest as infinite.
** Also maintain a visited Array.
** For Graph Traversal do BFS.
** But rather than a simple queue we will have a priority queue which will sort nodes based on their distance calculated.
** This will help us to go to the path/node that has a low cost, eventually resulting in the shortest path.
** At every node, we will update the distance for its neighbor.
** Lets say if we are at Source(U) and destination/Neighbour(V)
** distance[v] = Math.min(distance[v], distance[u] + weight of edge)
** PS: Note this will not work for -ve value edges as we consider edges with less value.
** Time Complexity: O((E+V)logV)
** BFS Time Complexity: O(V+E) and for each node we are inserting/removing from the priority queue. 
** Insertion and Removal Time Complexity: O(logV)
** Space Complexity: O(V+E)
**/


public class Solution {

    static class Node implements Comparable<Node> {
        private int node;
        private Integer weight;

        public Node(int node, Integer weight) {
            this.node = node;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return weight.compareTo(o.weight);
        }
    }

    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        int distance[] = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = (i == S) ? 0 : Integer.MAX_VALUE;
        }

        boolean visited[] = new boolean[V];
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(S, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (!visited[current.node]) {
                visited[current.node] = true;
                for (List<Integer> neighbour : adj.get(current.node)) {
                    int v = neighbour.get(0);
                    int weight = neighbour.get(1);
                    int u = current.node;
                    distance[v] = Math.min(distance[v], distance[u] + weight);
                    queue.add(new Node(v, distance[v]));
                }
            }
        }

        return distance;
    }

}








