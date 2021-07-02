/**
** https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
** https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
** BFS Traversal of graph is same as tree. The only difference is that we need to keep visited[], so that
** we don't visit same node again.
** Approach : Simimlar to tree, we will keep queue and add start node to it. also mark this as visited.
** Now until queue is empty, we will remove first node and add it to result .
** Add neighbour to queue, if it is already not visited.
** Time Complexity : O(V + E)
** Since we are first going to one vertex and then its adjacent |E|
** Space complexity: O(V) queue & visited array
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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> result = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        boolean visited[] = new boolean[V];
        
        //add starting vertex to queue
        if(V > 0){
         queue.add(0); 
         visited[0] = true;
        }
        
        while(!queue.isEmpty()){
            
          int vertex = queue.remove();
          result.add(vertex);
          ArrayList<Integer> neighbours = adj.get(vertex);
          for(int neighbour :neighbours){
              if(!visited[neighbour]){
                 visited[neighbour] = true;
                 queue.add(neighbour);
              }
          }
        }
        
        return result;
    }
}
