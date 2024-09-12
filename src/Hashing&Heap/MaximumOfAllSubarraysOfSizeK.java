/**
** Ref: https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s&pp=ygUPbG92ZSBiYWJhciBoZWFw. Love Babbar DSA, Lecture 74,75,76
** Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.
** Input: arr[] = {1, 2, 3, 1, 4, 5}, K = 3 
Output: 3 3 4 5
Explanation: Maximum of 1, 2, 3 is 3
                       Maximum of 2, 3, 1 is 3
                       Maximum of 3, 1, 4 is 4
                       Maximum of 1, 4, 5 is 5

Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 
Output: 10 10 10 15 15 90 90          
Explanation: Maximum of first 4 elements is 10, similarly for next 4 
                       elements (i.e from index 1 to 4) is 10, So the sequence 
                       generated is 10 10 10 15 15 90 90

Input: arr[] = {20, 10, 30}, K = 1 
Output: 20 10 30
**/

public class Solution {

    /** Naive Approach Form all continuous Sub Arrays
    ** Find Max.
     * Time Complexity : O(n*k)
     * Space Complexity: O(1)
     */

    static ArrayList<Integer> max_of_subarrays_naive(int a[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            int max = a[i];
            for (int j = i; j < i + k; j++) {
                if (a[j] > max) {
                    max = a[j];
                }
            }
            result.add(max);
        }

        return result;
    }

    static class Node {
        private int value;
        private int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

  /**
  ** Approach 2: We know Max Heap can return max element in O(1)
  ** and heapify complexity is O(logn)
  ** We will put initial k elements in Max Heap.
  ** Now we can get max of first k.
  ** Now we can add next element in Max Heap. and poll any element which is not falling in range of i-k, as subbaray size is of K.
  ** Later get max.
  ** Time Complexity: O(NlogN), Where N is the size of the array.
  ** Auxiliary Space: O(N), where N is the size of the array, this method requires O(N) space in the worst case when the input array is an increasing array
  **/
    static ArrayList<Integer> max_of_subarrays(int a[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Node> priorityQueue = new PriorityQueue<>((a1, a2) -> a2.value - a1.value);
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new Node(a[i], i));
        }

        result.add(priorityQueue.peek().value);

        for (int i = k; i < n; i++) {

            priorityQueue.add(new Node(a[i], i));
            while (priorityQueue.peek().index <= i - k) {
                priorityQueue.poll();
            }
            result.add(priorityQueue.peek().value);
        }

        return result;
    }

    public static void main(String[] args) {

        int a[] = {1, 2, 3, 1, 4, 5};
        int k = 3;
        System.out.println(max_of_subarrays(a, a.length, k));


    }
}
