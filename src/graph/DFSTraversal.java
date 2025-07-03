/**
** https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
** https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#
** DFS Traversal of graph is same as tree. The only difference is that we need to keep visited[], so that
** we don't visit same node again.
** Approach : Similar to tree, we will use recursion to go to depth of a node and also mark this as visited.
** We will only consider nodes which are not visited.
** Time Complexity : O(V + E)
** Since we are first going to one vertex and then its adjacent |E|
** Space complexity: O(V) v stack frame calls due to recursion and since we are only doing fun call on not visited nodes
**/

class Solution {
    
    ArrayList<Integer> result;
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> result = new ArrayList<>();
        int v = adj.size();
        boolean visited[] = new boolean[v];
        /**
        ** If a graph is connected, we can start from the first node i.e 0
        ** Since disconnected, we need to do a traversal from each node
        **/
        for (int i = 0; i < v; i++) { 
            if (!visited[i]) {//Before fun call
                visited[i] = true; //Marking of visisted has to be in sync as in recursive fun call
                dfs(i, visited, result, adj);
            }
        }

        return result;
    }
    
    public ArrayList<Integer> dfs(int vertice, boolean visited[], ArrayList<Integer> result, ArrayList<ArrayList<Integer>> adj) {

    result.add(vertice);

        ArrayList<Integer> neighbours = adj.get(vertice);
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) { //Since here I am checking and after that marking node visisted, same we have to do for 1st node i.e from main fun.
                visited[neighbour] = true;
                dfs(neighbour, visited, result, adj);
            }
        }

        return result;
    }
}
