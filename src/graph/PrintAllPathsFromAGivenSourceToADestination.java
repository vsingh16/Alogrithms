/**
** Ref: https://www.youtube.com/watch?v=59fUtYYz7ZU&t=84s
** All Path Q's
** Print all paths from a given source to a destination
** Given a directed graph, a source vertex ‘s’ and a destination vertex ‘d’, print all paths from given ‘s’ to ‘d’. 
** Consider the following directed graph. Let the s be 2 and d be 3. There are 3 different paths from 2 to 3.
** Approach: We can use DFS for traversal.
** The only thing is we need to unmark visted as same node can come on other paths as well.
** Time Complexity: O(V+E)
** Space Complexity: O(V+E)
**/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> paths;

    public int possible_paths(int[][] edges, int n, int start, int destination) {
        // Code here

        paths = new ArrayList<>();
        possible_paths(edges, n, start, destination, new boolean[n], new ArrayList<>());

        return paths.size();

    }

    public void possible_paths(int[][] edges, int n, int start, int destination, boolean visited[], List<Integer> path) {

        path.add(start);
        if (start == destination) {
            paths.add(path);
            return;
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == start) {
                int neighbour = edges[i][1];
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    possible_paths(edges, n, start, destination, visited, path);
                    visited[neighbour] = false; //when backtracking, we are marking visited false, as same node can come 
                  //on other paths
                }
            }
        }
    }
}


