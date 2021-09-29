/**
** https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
** https://www.youtube.com/watch?v=jdTnoCBSOVM&t=493s
** Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it, find the longest distances from s to all other vertices in the given graph.
** 0------> 1(5)
** 1------> 4(2),5(5)
** 3------> 2(50), 3(7) 
** 4------> 2(10)
** 5------> 2(50),3(7)
Above adj list shows neighbours and distance b/w.
LongestPath for source 1 is : 55 (1 -> 5 -> 2)

Approach :
Here one thing we can understand is we can start from source and its neighbours.
But we need an order , so that we dont visit a node if path from source is not possible.
We wil apply topological sort.
That wil give me order of nodes
We will keep a distance[], initianlly all nodes except source will be -Min, source = 0. Since distance b/w source and source is 0.
We will start processing nodes from order list(topo sort)
we will only process a node which has distance[node]!= -Min
In this way first node to be processed will be source and then we update its neighbours distance and visite them.
Time complexity :O(V+E)
**/

public class Abc {

    static class Edge {

        private int distance;
        private int target;

        public Edge(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }
    }

    private static void topologicalSort(int node, List<List<Edge>> graph, boolean visited[], List<Integer> order) {

        visited[node] = true;
        for (Edge neighbour : graph.get(node)) {
            if (!visited[neighbour.target]) {
                topologicalSort(neighbour.target, graph, visited, order);
            }
        }
        order.add(node); //add element when its processing is completely finished.
    }

    public static void printLongestDistance(List<List<Edge>> graph, int source) {

        //1.Apply Topological sort and get an order[].
        boolean visited[] = new boolean[graph.size()];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                topologicalSort(i, graph, visited, order);
            }
        }

        //Print Topological Sort Order
        System.out.println("Printing Topological Sort");
        order.stream().forEach(System.out::println);
        System.out.println("Printing Topological Sort End");

        //Distance [] initialize with -Min;
        int distance[] = new int[graph.size()];
        for (int i = 0; i < distance.length; i++) {
            if (i == source) {
                distance[i] = 0;
            } else {
                distance[i] = Integer.MIN_VALUE;
            }
        }

        for (int i = order.size() - 1; i >= 0; i--) { //process node as per topo order
            int node = order.get(i);
            if (distance[node] != Integer.MIN_VALUE) { // only process those nodes which are reachable(!=-Min)
                for (Edge edge : graph.get(node)) {
                    distance[edge.target] = Math.max(distance[edge.target], distance[node] + edge.distance);//Update distance
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println("source " + source + "target " + i + "distance " + distance[i]);
        }
    }

    public static void main(String[] args) {

        Edge edge01 = new Edge(1, 5);
        Edge edge15 = new Edge(5, 5);
        Edge edge14 = new Edge(4, 2);
        Edge edge53 = new Edge(3, 2);
        Edge edge52 = new Edge(2, 50);
        Edge edge42 = new Edge(2, 10);
        Edge edge32 = new Edge(2, 20);

        List<Edge> list0 = List.of(edge01);
        List<Edge> list1 = List.of(edge14, edge15);
        List<Edge> list2 = List.of();
        List<Edge> list3 = List.of(edge32);
        List<Edge> list4 = List.of(edge42);
        List<Edge> list5 = List.of(edge52, edge53);

        List<List<Edge>> graph = List.of(list0, list1, list2, list3, list4, list5);
        System.out.println("Printing Graph");
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i);
            for (Edge edge : graph.get(i)) {
                System.out.print("Edge " + edge.target + " " + edge.distance);
            }
            System.out.println("==============");
        }
        printLongestDistance(graph, 1);
    }
}
