/**
** https://thecodingsimplified.com/check-if-directed-graph-is-strongly-connected/
** Stronlgy Connected Graph : If we can reach from one vertex to any other vertext and it this is true for all vertexes.
** Approach : Do DFS and check if any node is unreachbale , then return false.
** Time Complexity: O(V)(V+E)
** Space Complexity : O(V)
**/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Graph {
  Map<List<Integer>> graph;  
  int nodes;

  Graph(int nodes) {
    graph = new HashMap<>();    
    this.nodes = nodes;

    for (int i = 0; i < nodes; i++) {
      graph.get(i, new ArrayList<>());
    }
  }

  public void addEdge(int a, int b) {
    graph.get(a).add(b);
  }
  
  public boolean ifDirectedGraphStronglyConnected() {

    for(int i = 0; i < nodes; i++) {
      dfs(i);  
      boolean visited [] = new boolean[nodes];      
      for(int j = 0; j < nodes; j++) {
        if(!visited[j]) {
          return false;
        }
      }            
    }
    
    return true;
  }

  public void dfs(int start) {
    visited[start] = true;

    List<Integer> neighboursList = graph.get(start);

    for (Integer neighbour : neighboursList) {
      if (!visited[neighbour]) {
        dfs(neighbour);
      }
    }
  }
}

public class GraphProblems {

  public static void main(String[] args) {
    int nodes = 4;
    
    Graph a = new Graph(nodes);
    
    a.addEdge(0, 1);
    a.addEdge(1, 2);
    a.addEdge(2, 0);
    a.addEdge(0, 3);
    a.addEdge(3, 2);

    System.out.println(a.ifDirectedGraphStronglyConnected());
  }

}
