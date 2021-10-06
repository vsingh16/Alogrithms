/**
** Ref Link :https://medium.com/swlh/graph-dynamic-programming-heap-cheapest-flights-within-k-stops-e622ce956479
** https://www.youtube.com/watch?v=YmnwiYKe6g8&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=23&t=498s
** Dijikstras: https://github.com/vsingh16/Alogrithms/blob/master/src/graph/DijikstrasAlgo.java
** https://leetcode.com/problems/cheapest-flights-within-k-stops/
** There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there 
** is a flight from city fromi to city toi with cost pricei.
** You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
** Approach :
** There are many approach to solve this, as mentioned in the medium link.
**/

/**
** Dijikstras Approach:
** Here we will take PriorityQueue(Min Heap)
** queue.remove will always give me node with min value
** if node == destination, return the cost
** if node.stops > K, skip
** else update distance and add to queue
** Time Complexity : O(log v * (V+E)), log v  = min heap, (V+E): graph traversal
** Space Complexity :O(V), min heap
**/
class Solution {
    
    class Node implements Comparable<Node>{
        
        private Integer node;
        private Integer cost;
        private Integer stops;
        public Node(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
        
        @Override
        public int compareTo(Node o) {
            return cost.compareTo(o.cost);
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        //Create Graph, Adj List
        List<List<List<Integer>>> adjList = new ArrayList();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList());
        }
        
        for(int i=0;i<flights.length;i++){
            int flight[] = flights[i];
            int u = flight[0];
            int v  = flight[1];
            int w = flight[2];
            adjList.get(u).add(List.of(v,w));
        }
                
        Queue<Node> queue = new PriorityQueue();
        queue.add(new Node(src,0,0));
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.node == dst){
                return node.cost;
            }else if(node.stops > k){
                continue;
            }else{
                for(List<Integer> edge:adjList.get(node.node)){
                    int v = edge.get(0);
                    int w = edge.get(1);
                    queue.add(new Node(v,node.cost+w,node.stops+1));
                }
            }
        }
        
        return -1;
    }
}
