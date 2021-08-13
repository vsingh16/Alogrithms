/**
** https://www.geeksforgeeks.org/minimum-time-taken-by-each-job-to-be-completed-given-by-a-directed-acyclic-graph/
** https://www.youtube.com/watch?v=zvOIjamNGSw&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=13
** Given a Directed Acyclic Graph having V vertices and E edges, where each edge {U, V} represents the Jobs U and V 
** such that Job V can only be started only after completion of Job U. The task is to determine the minimum time taken by each job to be completed where 
** each Job takes unit time to get completed.
** Approach : We can apply Topological Sorting.
** Since we can only process a job if all its parent is completed i.e when its in dgree is 0.
**/


public class Solution {

    /**
    ** Time Complexity : O(V+E)
    ** Space Complexity : O(V)
    **/
    public void printOrder(List<List<Integer>> graph) {

        int inDegree[] = new int[graph.size()];
        int n = inDegree.length;
        for (int i = 0; i < n; i++) {
            for (Integer neighbour : graph.get(i)) {
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int time[] = new int[graph.size()];
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                time[i] = 1;// there is no parent, so they can be directly completed in 1 time
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbour : graph.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) { // if indgree is 0 , we can process a job
                    queue.add(neighbour);
                    time[neighbour] = 1 + node;
                }
            }
        }

        for (int i = 0; i < time.length; i++) {
            System.out.println("Node " + i + " Time Taken :" + time[i]);

        }

    }
