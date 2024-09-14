/**
** Ref: https://www.geeksforgeeks.org/merge-k-sorted-arrays/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Given K sorted arrays, merge them and print the sorted output.
** Input: K = 3, arr = { {1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}}
Output: 0 1 2 3 4 5 6 7 8 9 10 11 

Input: k = 4, arr = { {1}, {2, 4}, {3, 7, 9, 11}, {13} }
Output: 1 2 3 4 7 9 11 13

** Naive Approach: Put all array elements into the result array and sort.
** Time Complexity : O(n*k log(n*k))
** Space Complexity: O(1)

** Approach 2: Using Min Heap of Size K
** Idea is we will keep min heap of size k, which can return me min element in O(1) and heapfiy O(k)
** Insert 0th element from all k arrays.
** Until heap is empty, keep popping 1 element.
** The element which we have removed, place the next element of it in array.
**/

public class Solution {

    static class Node {

        private int value;
        private int i;
        private int j;

        public Node(int value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }

    /**
    ** Approach 2:
    ** Time Complexity: O(n*k log (k))
    ** Space Complexity: O(k) , heap of k size
   **/
    public static ArrayList<Integer> mergeKArrays(int[][] a, int k) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a2 -> a2.value));
        //insert first 0th element from k array
        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(a[i][0], i, 0));
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Node min = minHeap.poll();
            result.add(min.value);
            // check if next element exist and if exist add to heap
            if (min.j + 1 < a[min.i].length) {
                minHeap.add(new Node(a[min.i][min.j + 1], min.i, min.j + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int a[][] = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        int k = 3;
        mergeKArrays(a, k).forEach(System.out::println);


    }
}
