/**
** Ref Link: https://www.hackerearth.com/problem/algorithm/bishu-and-soldiers-227/?purpose=login&source=problem-page&update=google
** Bishu went to fight for Coding Club. There were N soldiers with various powers. There will be Q rounds to fight and in each round, Bishu's power will be varied. With power M, Bishu can kill all the soldiers whose power is less than or equal to M(<=M). After each round, All the soldiers who are dead in the previous round will reborn. Such that in each round there will be N soldiers to fight. As Bishu is weak in mathematics, help him to count the number of soldiers that he can kill in each round and the total sum of their powers.

INPUT:

The first line of the input contains N, the number of soldiers.

The second line contains an array of N numbers denoting the power of each soldier

This third line contains Q, which denotes the number of rounds.

Q lines follow, each line having one number denoting the power of Bishu.

OUTPUT:

For each round, the output should be an array of two numbers. The first number should be the number of soldiers that Bishu can beat, and the second number denotes the cumulative strength of all the soldiers that Bishu can beat.

CONSTRAINTS:

1<=N<=10000

1<=power of each soldier<=100

1<=Q<=10000

1<=power of bishu<=100

Sample Input
7
1 2 3 4 5 6 7
3
3
10
2
Sample Output
3 6
7 28
2 3
** Approach: We can sort input array.
** We can take sum[] which will keep sum of elements so far. We can return anserws from here.
** Ref Link: https://www.youtube.com/watch?v=hT1sOIcenBA
** Time Complexity: O(nlogn)
** Space Complexity: O(n)
**/

import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Sample code to perform I/O:
         * Use either of these methods for input
         **/

        //Scanner
        Scanner s = new Scanner(System.in);
        int size = Integer.valueOf(s.nextLine());
        int inputArray[] = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int noOfQueries = Integer.valueOf(s.nextLine());

        // Write your code here
        Arrays.sort(inputArray);
        int sum[] = new int[size];
        sum[0] = inputArray[0];
        for (int i = 1; i < size; i++) {
            sum[i] = sum[i] + inputArray[i];
        }

        for (int i = 0; i < noOfQueries; i++) {
            //print ans
            int query = Integer.valueOf(s.nextLine());
            int index = Math.min(query, size) - 1;
            System.out.println(index + 1 + " " + sum[index]);
        }


    }
}
