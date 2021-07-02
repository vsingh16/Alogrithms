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

// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.dfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends





class Solution
{
    
    ArrayList<Integer> result;
    
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        result = new ArrayList();
        boolean visited[] = new boolean[V];
        dfsUtil(0, visited, adj);
        
        return result;
    }
    
    private void dfsUtil(int V, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        
        result.add(V);
        visited[V] = true;
        ArrayList<Integer> neighbours = adj.get(V);
        for(Integer neighbour:neighbours){
            if(!visited[neighbour]){
              dfsUtil(neighbour, visited,adj);
            }
        }
    }
}
