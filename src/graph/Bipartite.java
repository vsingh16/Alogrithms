/**
** https://www.geeksforgeeks.org/bipartite-graph/
** https://www.youtube.com/watch?v=szDk4q4nHF4&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=19
** Check whether a given graph is Bipartite or not
** A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge (u, v) either
** connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u belongs to U and v to V, or 
** u belongs to V and v to U. We can also say that there is no edge that connects vertices of same set.
** Approach:
** If we start traversing each node and color it(either 1 & 2), so if two adjacent nodes get same color, its not bipartite else it is bipartite.
**/

public class Abc {

    private boolean isNotBipartite;

    //Time Complexity : O(V+E)
    private void isBipartite(ArrayList<ArrayList<Integer>> list, int node, int color, int visited[]) {

        visited[node] = color;
        for (Integer neighbour : list.get(node)) {
            if (visited[neighbour] == 0) { // not color
                isBipartite(list, neighbour, node, 3 - color, visited); //doing minus from 3 as we have only two colors 1 & 2, 0 = no color
            } else {
                if (visited[neighbour] == color) { 
                    isNotBipartite = true;
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        //list1.add(2);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        //list3.add(0);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        list4.add(2);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        Abc abc = new Abc();
        int visited[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                abc.isBipartite(list, i, 1, visited);
            }
        }
        System.out.println("Printing Colors");
        Arrays.stream(visited).forEach(System.out::println);
        System.out.println(abc.isNotBipartite ? "Not Bipartie" : "Bipartite");
    }
}
