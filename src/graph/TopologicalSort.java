/**
** https://www.geeksforgeeks.org/topological-sorting/
** https://www.youtube.com/watch?v=QaI45-uf6iE&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=11
** https://www.youtube.com/watch?v=59fUtYYz7ZU&t=9169s. Apna College Graph
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

** Approach2:
** Topological Sorting is print all the nodes such that u ->v
** That means if we do traversal and once we finish complete processing of a node i.e there no further edges to go from here.
** That means it is a V. We can store it in result. But we store v after u, so we can store in array from last index.
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
    
    /**
    ** 2nd Approach: 
    ** Simply apply DFS.
    ** Once the processing of a node is completely finished, add it to list
    ** List in reverse order gives us topo sort.
    **/
   public class Solution {

    private static int result[];
    private static int index;

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        result = new int[V];
        index = V - 1;
        boolean visited[] = new boolean[V];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
            }

        }

        return result;

    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int current, boolean visited[]) {

        visited[current] = true;
        for (int neighbour : adj.get(current)) {
            if (!visited[neighbour]) {
                dfs(adj, neighbour, visited);
            }
        }

        result[index--] = current;

    }

}

}
