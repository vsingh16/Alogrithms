/**
** Ref Link: https://www.youtube.com/watch?v=5h1JYjin_4o&list=PLDdcY4olLQk066ysRibhoGd3UzGr0XSQG&index=24&t=2s
** https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/oliver-and-the-game-3/
** Oliver and Bob are best friends. They have spent their entire childhood in the beautiful city of Byteland. The people of Byteland live happily along with the King.
The city has a unique architecture with total N houses. The King's Mansion is a very big and beautiful bungalow having address = 1. Rest of the houses in Byteland have some unique address, (say A), are connected by roads and there is always a unique path between any two houses in the city. Note that the King's Mansion is also included in these houses.

Oliver and Bob have decided to play Hide and Seek taking the entire city as their arena. In the given scenario of the game, it's Oliver's turn to hide and Bob is supposed to find him.
Oliver can hide in any of the houses in the city including the King's Mansion. As Bob is a very lazy person, for finding Oliver, he either goes towards the King's Mansion (he stops when he reaches there), or he moves away from the Mansion in any possible path till the last house on that path.

Oliver runs and hides in some house (say X) and Bob is starting the game from his house (say Y). If Bob reaches house X, then he surely finds Oliver.

Given Q queries, you need to tell Bob if it is possible for him to find Oliver or not.

The queries can be of the following two types:
0 X Y : Bob moves towards the King's Mansion.
1 X Y : Bob moves away from the King's Mansion

INPUT :
The first line of the input contains a single integer N, total number of houses in the city. Next N-1 lines contain two space separated integers A and B denoting a road between the houses at address A and B.
Next line contains a single integer Q denoting the number of queries.
Following Q lines contain three space separated integers representing each query as explained above.

OUTPUT :
Print "YES" or "NO" for each query depending on the answer to that query.

CONSTRAINTS :
1 ≤ N ≤ 10^5
1 ≤ A,B ≤ N
1 ≤ Q ≤ 5*10^5
1 ≤ X,Y ≤ N

NOTE :
Large Input size. Use printf scanf or other fast I/O methods.

Sample Input
9
1 2
1 3
2 6
2 7
6 9
7 8
3 4
3 5
5
0 2 8
1 2 8
1 6 5
0 6 5
1 9 1
Sample Output
YES
NO
NO
NO
YES
Time Limit: 1
Memory Limit: 256
Source Limit:
**/

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TestClass {

    static int counter = 1;

    static class Edge {
        private int u;
        private int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class Query {
        private int dir;
        private int x;
        private int y;

        public Query(int dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }


    private static void DFS(int node, List<List<Integer>> adjList, boolean[] visited, int[] inTime, int[] outTime) {

        visited[node] = true;
        inTime[node] = counter++;
        for (Integer neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                DFS(neighbour, adjList, visited, inTime, outTime);
            }
        }
        outTime[node] = counter++;

    }

    //This fun check if x is in subtree of y
    private static boolean isSubTree(int x, int y, int[] inTime, int[] outTime) {

        return inTime[y] <= inTime[x] && outTime[x] <= outTime[y];

    }

    /**
    ** Approach : Here we need to check if x is in subtree of y or not.
    ** To do so, we apply DFS and maintain inTime[](when we start processing node) and outTime[](when we finish processing a node)
    ** Time Complexity : O(V+E)
    ** Space Complexity: O(V)
    **/

    public static List<Boolean> solveQuery(List<List<Integer>> adjList, List<Query> queryList) {

        int n = adjList.size() - 1;
        //Apply DFS
        boolean visited[] = new boolean[n + 1];
        int inTime[] = new int[n + 1];
        int outTime[] = new int[n + 1];
        // Apply DFS and prepare inTime[] and outTime[]
        DFS(1, adjList, visited, inTime, outTime);

        List<Boolean> answers = new ArrayList<>();
        for (Query query : queryList) {
            if (query.dir == 0) { //inwards
                answers.add(isSubTree(query.y, query.x, inTime, outTime));
            } else { //outwards
                answers.add(isSubTree(query.x, query.y, inTime, outTime));
            }
        }

        return answers;
    }

    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        //Scanner
        Scanner s = new Scanner(System.in);
        int nodes = Integer.parseInt(s.nextLine());                 // Reading input from STDIN
        //Create Adj List
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < nodes - 1; i++) {
            String input[] = s.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int queries = Integer.parseInt(s.nextLine());
        List<Query> queryList = new ArrayList<>();
        for (int i = 0; i < queries; i++) {
            String input[] = s.nextLine().split(" ");
            int direction = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);
            queryList.add(new Query(direction, x, y));
        }

        List<Boolean> answers = solveQuery(adjList, queryList);
        answers.stream().map(ans -> ans ? "YES" : "NO").forEach(System.out::println);
    }
}
