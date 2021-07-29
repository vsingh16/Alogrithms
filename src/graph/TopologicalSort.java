/**
** https://www.geeksforgeeks.org/topological-sorting/
** https://www.youtube.com/watch?v=QaI45-uf6iE&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=11
** Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in 
** the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
** For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There can be more than one topological sorting for a graph. For example, another topological sorting of the following graph is “4 5 2 3 1 0”. The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no incoming edges).

** Approach: Step1 : Maintain and inCount[].
** inCount is no of edges coming towards any vertex.
** We wil iterate adj list and populate this array.
** Step 2: Apply BFS. Add all nodes with zero incount.
** Step 3: When u pop a node from queue add it to result, also decrement incount for its neighbours.
** Step4: Any neighbour with zero count add it to result.
** Time Complexity: O(V+E), Space Complexity: O(V)
**/
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        //Populate Incount Array
       int incount[] = new int[V];
       for(int i=0;i<V;i++){
        for(Integer neighbour : adj.get(i)){
            incount[neighbour]++;
        }    
       }
       
       Queue<Integer> queue = new LinkedList(); 
       //Add Nodes with zero in order to queue
       for(int i=0;i<V;i++){
           if(incount[i] == 0){
               queue.add(i);
           }
       }
       
       int result[] = new int[V];
       int counter = 0;
       while(!queue.isEmpty()){
           int node = queue.remove();
           result[counter++] = node;
           ArrayList<Integer> neighbours = adj.get(node);
           for(Integer neighbour:neighbours){
               incount[neighbour]--;
               if(incount[neighbour] == 0){
                   queue.add(neighbour);
               }
           }
       }
       
       return result;
    }
}
