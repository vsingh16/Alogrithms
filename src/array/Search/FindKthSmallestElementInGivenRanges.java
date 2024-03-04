/**
** Ref Link: https://www.geeksforgeeks.org/find-k-th-smallest-element-in-given-n-ranges/
** Given n and q, i.e, the number of ranges and number of queries, find the kth smallest element for each query (assume k>1).Print the value of kth smallest element if it exists, else print -1.

Examples : 

Input : arr[] = {{1, 4}, {6, 8}}
        queries[] = {2, 6, 10};
Output : 2
         7
        -1
After combining the given ranges, the numbers
become 1 2 3 4 6 7 8. As here 2nd element is 2,
so we print 2. As 6th element is 7, so we print
7 and as 10th element doesn't exist, so we
print -1.

Input : arr[] = {{2, 6}, {5, 7}}
        queries[] = {5, 8};
Output : 6
        -1
After combining the given ranges, the numbers 
become 2 3 4 5 6 7. As here 5th element is 6, 
so we print 6 and as 8th element doesn't exist, 
so we print -1.
** Approach: Merge Ranges
** Now Look for kth element in merged ranges.
** If k lies in range, kth = ranges.get(j).start + k - 1
** else look in next range but also minus previous range elements i.e k = k - Math.abs(ranges.get(j).end - ranges.get(j).start + 1);
** Time Complexity : O(nlog(n) + qn) 
** Auxiliary Space: O(n)
** Ref Link: https://www.youtube.com/watch?v=SvM5Y1PDiiA&t=28s
** 
**/

//{ Driver Code Starts

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    static class Range {

        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        //merge ranges
        List<Range> ranges = mergeRanges(range);
        ArrayList<Integer> results = new ArrayList();
        //find k
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];
            int result = -1;
            for (int j = 0; j < ranges.size(); j++) {
                if (k <= Math.abs(ranges.get(j).end - ranges.get(j).start + 1)) {
                    result = ranges.get(j).start + k - 1;
                    break;
                } else {
                    k = k - Math.abs(ranges.get(j).end - ranges.get(j).start + 1);
                }
            }
            results.add(result);
        }

        return results;
    }

    public static List<Range> mergeRanges(int[][] range) {
        Arrays.sort(range, Comparator.comparingInt(p -> p[0]));
        List<Range> ranges = new ArrayList();
        ranges.add(new Range(range[0][0], range[0][1]));
        for (int i = 1; i < range.length; i++) {
            if (ranges.get(ranges.size() - 1).end >= range[i][0]) {
                ranges.get(ranges.size() - 1).end = Math.max(ranges.get(ranges.size() - 1).end, range[i][1]);
            } else {
                ranges.add(new Range(range[i][0], range[i][1]));
            }
        }

        return ranges;

    }

    public static void main(String[] args) {
        int range[][] = {{1, 4}, {1, 3}, {5, 11}};
        int queries[] = {2, 6, 10};
        ArrayList<Integer> result = kthSmallestNum(2, range, 3, queries);
        result.forEach(System.out::println);
    }
}
