/**
** https://www.geeksforgeeks.org/graph-coloring-applications/
** Graph coloring problem is to assign colors to certain elements of a graph subject to certain constraints. 
** Vertex coloring is the most common graph coloring problem. The problem is, given m colors, find a way of coloring the vertices of a graph 
** such that no two adjacent vertices are colored using same color. The other graph coloring problems like Edge
** Coloring (No vertex is incident to two edges of same color) and Face Coloring (Geographical Map Coloring) can be transformed into vertex coloring. 

** Chromatic Number: The smallest number of colors needed to color a graph G is called its chromatic number. For example, the following can be colored minimum 2 colors. 

0---------1
|         |
2---------4

0 - 0 color
1 - 1 color
2 - 1 color
4 - 0 color
Chromatic Number: 2
Approach : We will follow greedy approach.
1)Assign 0 color to 0th node.
2)Take two arrays: color[](color availability), result[] (overall color assignment to nodes)
3) Iterate all nodes and their neighbours
4) see if any neigbour has color, mark that color unavailable in color[]
5) After this iterate over color[] to find available color.
6)Assing that color into result[]
7)Reset color[]
**/

// This class represents an undirected graph using adjacency list
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
 
    //Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    //Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v); //Graph is undirected
    }
 
    // Assigns colors (starting from 0) to all vertices and
    // prints the assignment of colors
    void greedyColoring()
    {
        boolean color[] = new boolean[V];
        int result[] = new int[V];
         // Initialize all vertices as unassigned
        Arrays.fill(result, -1);
        // Mark all colors available
        Arrays.fill(color, true);
        //Assing 0th node 0 color
        result[0] = 0;
        for(int i=1;i<V;i++){
           // Process all adjacent vertices and flag their colors
            // as unavailable
            Iterator<Integer> it = adj[u].iterator() ;
            while (it.hasNext())
            {
                int neighbour = it.next();
                if (result[neighbour] != -1)
                    available[result[i]] = false;
            }
          
          for(int i){
          }
        }
    }
 
    // Driver method
    public static void main(String args[])
    {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();
 
        System.out.println();
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2 ");
        g2.greedyColoring();
    }
}
// This code is contributed by Aakash Hasija
