/**
** https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/
** https://www.youtube.com/watch?v=gEK7eHce88g
** There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b]
represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.

Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between 
any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all
the computers connected. If it's not possible, return -1. 

** Approach : Basic Concpet: min No of edges required to connect n nodes = n-1
** eg 1-2-3 , 3 nodes, 2 edges
** Base Case : if given edges < nodes -1, not possible.
** Else make graph and apply DFS, we need to find no of connected components.
** Then to connect those indvidual connected components together is c-1
** Time Complexity: O(V+E)
** Space Complexity :O(V+E) : Adjaceny List for graph
**/

class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        int totalWires = connections.length;
        //Base Case
        if(totalWires<n-1){
            return -1;
        }
        
        List<List<Integer>> graph = new ArrayList();
        //initialising vetrices
        for(int i=0;i<n;i++){
            graph.add(new ArrayList());
        }
        //now populate neighbors list
        for(int i=0;i<connections.length;i++){      
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
        
        int c=0;// This counter for no of connected components
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                c++;
                DFS(i,visited,graph);
            }
        }
        
        return c-1;
        
    }
    
    private void DFS(int node,boolean visited[], List<List<Integer>> graph){
        
        visited[node] = true;
        for(Integer neighbour:graph.get(node)){
            if(!visited[neighbour]){
                DFS(neighbour,visited, graph);
            }
        }
    }
}
