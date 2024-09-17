/**
** Ref: https://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Given K sorted lists of integers of size N each, find the smallest range that includes at least one element from each of the K lists. If more than one smallest range is found, print any one of them.

Examples: 

Input: K = 3
arr1[] : {4, 7, 9, 12, 15}
arr2[] : {0, 8, 10, 14, 20}
arr3[] : {6, 12, 16, 30, 50}

Output: The smallest range is [6 8]
Explanation: Smallest range is formed by  number 7 from the first list, 8 from second list and 6 from the third list.

Input: k = 3
arr1[] : {4, 7}
arr2[] : {1, 2}
arr3[] : {20, 40}

Output: The smallest range is [2 20]
Explanation:The range [2, 20] contains 2, 4, 7, 20 which contains element from all the three arrays.

Approach 1: Its same as approach 2.
Its that rather than taking min heap, we will keep array of size k and iterate over it to find min and max.
Time Complexity: O(n*k*k)
Space Complexity: O(k)


Approach 2: Range = Max - Min
To reduce range, either we can increase min or decrease max.
But we can't decrease max, as doing so we will go out of an array. The condition is that we need to have elements from all array.

Step: We can add 0th element from all k array into min heap.
Take min from minheap , and add next of min element to minheap.
Calculate and update range.

Time Complexity: O(n*k*log k)
Space Complexity: O(k)
**/

 static class Node {
        int data;
        int i;
        int j;

        public Node(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }

    // Function to merge K sorted linked list.
    static int[] findSmallestRange(int[][] a, int n, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        int ansMin = -1;
        int ansMax = -1;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a1, a2) -> a1.data - a2.data);
      //Adding 0th to minheap and finding max
        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(a[i][0], i, 0));
            max = Math.max(max, a[i][0]);
        }


        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();
            min = minNode.data;        
            //Updating ans if we find less range
            if ((max - min) < range) {
                range = (max - min);
                ansMin = min;
                ansMax = max;
            }

          // Adding next of min to heap and also updating max
            if (minNode.j + 1 < a[minNode.i].length) {
                max = Math.max(max, a[minNode.i][minNode.j + 1]);
                minHeap.add(new Node(a[minNode.i][minNode.j + 1], minNode.i, minNode.j + 1));
            } else {
                break;
            }
        }

        return new int[]{ansMin, ansMax};

    }
**/
