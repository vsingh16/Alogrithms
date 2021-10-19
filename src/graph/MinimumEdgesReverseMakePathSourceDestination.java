/**
** https://www.youtube.com/watch?v=porShXfpPqA&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=26
** https://www.geeksforgeeks.org/minimum-edges-reverse-make-path-source-destination/
** Minimum edges to reverse to make path from a source to a destination
** Given a directed graph and a source node and destination node, we need to find how many edges we need to
** reverse in order to make at least 1 path from source node to destination node.
** Approach: We can create adjList.Path which are given in graph will have weight 0 and we will create reverse link with 1.
** Then we just need to apply Dijikstras Algo to find shortest distance b/w source and destination.
** Keep in mind since 0 < 1, so if path alreayd exists we will use it else other one(1)
** Time Complexity: O (V*(V+E))
** To tarverse graph , since adj list O(V+E)
** and to find next element to process , O(V)
** Space Complexity : O(V), distance[]
**/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    class Node {

        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private List<List<Node>> createGraph(int[][] edge, int vCount) {

        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < vCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            adjList.get(u).add(new Node(v, 0));
            adjList.get(v).add(new Node(u, 1));// reverse edge with 1 weight
        }

        return adjList;
    }

    private int findNextNode(Set<Integer> set, int dist[]) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!set.contains(i) && min >= dist[i]) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private int dijikstras(List<List<Node>> adjList, int VCount, int source, int destination) {

        int dist[] = new int[VCount];
        for (int i = 0; i < VCount; i++) {
            dist[i] = (i == source) ? 0 : Integer.MAX_VALUE;
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < VCount - 1; i++) {
            int u = findNextNode(set, dist);
            for (Node neighbour : adjList.get(u)) {
                int v = neighbour.node;
                int w = neighbour.weight;
                dist[v] = Math.min(dist[v], dist[u] + w);
            }
            set.add(u);
        }

        for (int i = 0; i < VCount; i++) {
            if (i == destination) {
                return dist[i];
            }
        }

        return -1;
    }

    public int getMinEdgeReversal(
            int[][] edge, int v, int source, int destination) {

        List<List<Node>> adjList = createGraph(edge, v);
        int count = dijikstras(adjList, v, source, destination);
        return count;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int V = 7;
        int edge[][] = {{0, 1}, {2, 1},
                {2, 3}, {5, 1},
                {4, 5}, {6, 4},
                {6, 3}};

        System.out.println(solution.getMinEdgeReversal(edge, V, 0, 6));
    }

}
