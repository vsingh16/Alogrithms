/**
** https://www.youtube.com/watch?v=IM1xOjamHA8&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=21
** https://www.hackerrank.com/challenges/journey-to-the-moon/problem
** The member states of the UN are planning to send  people to the moon. 
** They want them to be from different countries. You will be given a list of pairs of astronaut ID's.
** Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.

** Example

** There are  astronauts numbered  through . Astronauts grouped by country are  and . There are  pairs to choose from:  and .

** Function Description

** Complete the journeyToMoon function in the editor below.

** journeyToMoon has the following parameter(s):

** int n: the number of astronauts
** int astronaut[p][2]: each element  is a  element array that represents the ID's of two astronauts from the same country
** Returns
** - int: the number of valid pairs

** Input Format

The first line contains two integers  and , the number of astronauts and the number of pairs.
Each of the next  lines contains  space-separated integers denoting astronaut ID's of two who share the same nationality.

Constraints

Sample Input 0

5 3
0 1
2 3
0 4
Sample Output 0

6


Approach:
1)We have n astronauts and we need to make pairs.
2)Total Possible Pairs nc2 = n!/(n-r)!*r! , 
3)Since astronauts from same country can't make pair, we will convert given list to graph adjaceny list.
4)Apply DFS and find astronauts in a component(same country)
5)Final Ans = Total possible Pairs - (nc2, for astronauts in same country)
6)Time Complexity : O(V+E)
7)Space Complexity: O(V+E)
**/

class Result {

    static  int counter = 0;
    static void DFS(int node, List<List<Integer>> graph, boolean visited[]) {
        visited[node] = true;
        counter++;
        for (Integer neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                DFS(neighbour, graph, visited);
            }
        }
    }

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < astronaut.size(); i++) {
            int x = astronaut.get(i).get(0);
            int y = astronaut.get(i).get(1);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }


        boolean visited[] = new boolean[n];
        List<Integer> component = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                counter = 0;
                DFS(i, graph, visited);
                component.add(counter);
            }
        }

        int total = (n * (n - 1)) / 2;
        for (int c : component) {
            int x = (c * (c - 1)) / 2;
            total = total - x;
        }

        return total;
    }

}



