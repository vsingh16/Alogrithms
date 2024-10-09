/**
** Ref: https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
** https://www.youtube.com/watch?v=59fUtYYz7ZU Apna College
** https://www.youtube.com/watch?v=ijpVpsmpJtQ&list=PLDzeHZWIZsTobi35C3I-tKB3tRDX6YxuA&index=17 Love Babbar
** Dijikstra Algorithm is used to find shortest path in graph.
** Dijikstra is a greedy algorithm in which we explore path with shortest distance but dont explore path with higher distance.
** This will work for graph with +ve edges but not for -ve egdes. Because when we sum a -ve edge with higher weight its value will reduce and highger weight path can turn a shortest path.
** eg A-> B, 8
** A -> C, 3
** B -> C, -6
** As per Dijikstra, we will pick A->C (3) over A-> B but becuiase of -ve edge A->B -> C(2) is shortest
** Bellman Ford Algo can be used to find shortest path in -ve edge graph.
** In this algo, we performa relaxation V-1 times to find shortest path.
** V-1 This is because the shortest path in a graph without a negative cycle can have at most V-1 edges.
** Relaxation: distance[u] + weight < distance[v]
** -ve Cycle Graph : If there is a cycle in  graph and it has -ve edge, the more no of times we visit cycle, distance will reduce.
** This is the case where even Bellman Ford fails. 
** To Detect -ve cycle , we can traverse graph one more time and if distance is further relaxed, that means -ve cycle exists.
** eg: A->B : 8
** B-> C : -2
** C-> A : -5

** Time Complexity: O(E) + O(V*E)
** Space Complexity : O(V)
**/

class Solution
{
    public int isNegativeWeightCycle(int V, int[][] edges)
    {
        int distance[] = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = 0; // In case if graph is not starting from 0, then any node can be a starting point hence initializing all nodes with 0 distance
        }


        for (int i = 0; i < V - 1; i++) { //O(V)
            for (int j = 0; j < edges.length; j++) { //O(Edges)
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) { //distance[u] != Integer.MAX_VALUE. Adding a weight to max value in java leads to cycle shorter value
                    distance[v] = distance[u] + weight ;
                }
            }
        }

        for (int j = 0; j < edges.length; j++) { //O(Edge)
            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                return 1;
            }
        }

        return 0;
    }
}
