/**
** https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
** This algo is used to find shortest distance of all vertex from Source.
** Approach: 
** This is a greedy algorithm.
** distance[] , only source will be 0 and rest infinite.
** Have a set which will keep track of elements for which we have found the shortest distance.
** find next element to process. This will element with shortest distance and not yet part of set.
** For all its adjacent, update distance if min and move current element to set.
** PS: Note this will not work for -ve value edges as we consider edges with less value.
**/


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    // adj.get(u).get(0) = V
    // adj.get(u).get(1) = w
    /**
    ** Time Complexity: O (V*(V+E))
    ** To tarverse graph , since adj list O(V+E)
    ** and to find next element to process , O(V)
    ** Space Complexity : O(V), distance[]
    **/
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
    
       int distance[] = new int[V];
       Set<Integer> spt = new HashSet();
      //Only soruce = 0, rest infinite
       for(int i=0;i<V;i++){
            distance[i] = (i == S) ? 0 : Integer.MAX_VALUE;
       }
    
       //Now we have distance for 1 vertex and need to find V-1
        for(int i=0;i<V-1;i++){
            
            //find node with min distance
            int u = findNodeWithMinDistance(V,spt,distance);
            //update distance for  adj list
            for(List<Integer> edge:adj.get(u)){
                int v = edge.get(0);
                int w = edge.get(1);
                distance[v] = Math.min(distance[v], distance[u]+ w);  // only update distance if new distance is less.
            }
            //move the current node to spt
            spt.add(u);
            
        }
        
        return distance;
    }
    
    static int findNodeWithMinDistance(int V, Set<Integer> spt,int distance[]){
        
        int min  = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<V;i++){
            //node with min distance and whose processing is not yet completed
            if(!spt.contains(i) && distance[i] <= min){
                min  = distance[i];
                minIndex = i;
            }
        }
        
        return minIndex; // return index
    }
}


