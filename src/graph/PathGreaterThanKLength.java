/**
** https://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/
** Ref Link: https://www.youtube.com/watch?v=oZYMOJHWI9w&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=25
** Given a graph, a source vertex in the graph and a number k, find if there is a simple path (without any cycle) starting from given 
** source and ending at any other vertex such that the distance from source to that vertex is atleast ‘k’ length.
Example:
Input  : Source s = 0, k = 58
Output : True
There exists a simple path 0 -> 7 -> 1
-> 2 -> 8 -> 6 -> 5 -> 3 -> 4
Which has a total distance of 60 km which
is more than 58.

Input  : Source s = 0, k = 62
Output : False

In the above graph, the longest simple
path has distance 61 (0 -> 7 -> 1-> 2
 -> 3 -> 4 -> 5-> 6 -> 8, so output 
should be false for any input greater 
than 61.
** Approach : We will apply DFS. Only thing to keep is that we will also do backtrack, as same node can come in different paths.
** So if k <= 0 path found else we will backtrack.
** Time Complexity : O(V+E)
**/

import java.util.ArrayList;
import java.util.List;

class Solution {

    class Node {

        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private boolean DFS(Node node, int k, List<List<Node>> adjList, boolean visited[]) {

        visited[node.node] = true;
        if (k <= 0) {
            return true;
        }

        for (Node neighbour : adjList.get(node.node)) {

            if (!visited[neighbour.node]) {
                if (DFS(neighbour, k - neighbour.weight, adjList, visited)) { // if we get a path, return true
                    return true;
                }
            }

        }

        visited[node.node] = false; //else backtrack
        return false;

    }

    boolean pathMoreThanK(int V, int E, int K, int[] A) {

        List<List<Node>> adjList = new ArrayList();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < A.length - 3; i += 3) {
            int u = A[i];
            int v = A[i + 1];
            int w = A[i + 2];
            adjList.get(u).add(new Node(v, w));
            adjList.get(v).add(new Node(u, w));
        }

        boolean visited[] = new boolean[V];
        Node source = new Node(0, 0);
        return DFS(source, K, adjList, visited);

    }

}
