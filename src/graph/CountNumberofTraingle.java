/**
** https://www.youtube.com/watch?v=2Fb0kPngzMw&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=27
** https://www.geeksforgeeks.org/number-of-triangles-in-directed-and-undirected-graphs/
** https://www.geeksforgeeks.org/number-of-triangles-in-a-undirected-graph/
** Given a Graph, count number of triangles in it. The graph is can be directed or undirected.

Example: 

Input: digraph[V][V] = { {0, 0, 1, 0},
                        {1, 0, 0, 1},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0}
                      };
Output: 2
Give adjacency matrix represents following 
directed graph.

** Approach : For a triangle, we need 3 pointers i, j, k and it is triangle if edge exist b/w i,j & j,k & k,i
** For directed graph, we need to divide by 3
** For undirected graph, we need to divide by 6.
** as there will be few redundant graphs , i mean diff permuations of i,j,k forming same graoh.
** Time Complexity : O(v^3)
** Space Complexity: O(1)
**/

class Solution {

    public int countTriangle(int graph[][], int v,
                             boolean isDirected) {

        int counter = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                for (int k = 0; k < v; k++) {
                    if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1) {
                        counter++;
                    }
                }
            }
        }

        return isDirected ? counter / 3 : counter / 6;
    }

    public static void main(String[] args) {

        // Create adjacency matrix
        // of an undirected graph
        int graph[][] = {{0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        // Create adjacency matrix
        // of a directed graph
        int digraph[][] = {{0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        };

        Solution obj = new Solution();

        System.out.println("The Number of triangles " +
                "in undirected graph : " +
                obj.countTriangle(graph, graph.length, false));

        System.out.println("\n\nThe Number of triangles" +
                " in directed graph : " +
                obj.countTriangle(digraph, digraph.length, true));

    }

}
