package dynamic.programming;

/**
 ** Created by vishal on 22-Feb-18.
 ** https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 ** https://leetcode.com/problems/longest-increasing-subsequence/
 ** https://www.youtube.com/watch?v=MYHajVcnXSA . Love Babbar
 ** Now, let us discuss the Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming. 
 ** The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the
 ** subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}. 
 ** Approach :
 ** Recusriion : we have two options either to include or exclude.
 */
/**
** Top Down(Becuase starting point is 0, start) + Recursion
** Time Complexity: O(2^n), Since we have two options either include or exclude
** Space Complexity: O(n)
**/


class Solution {
    
    static int longestSubsequence(int a[], int currentIndex, int indexOfLastElementInSubsequence) {

        int n = a.length;
        //Base Case
        if (currentIndex == n) {
            return 0;
        }

        int include = 0;
        if (indexOfLastElementInSubsequence == -1 || a[indexOfLastElementInSubsequence] < a[currentIndex]) {
            include = 1 + longestSubsequence(a, currentIndex + 1, currentIndex);
        }

        int exclude = longestSubsequence(a, currentIndex + 1, indexOfLastElementInSubsequence);

        return Math.max(include, exclude);


    }
    
    
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int a[]) {
          return longestSubsequence(a, 0, -1);
    }
}
==========================================================
/**
** Recursion(Top Down) + Memorization
** Time Complexity: O(n*n) 
** Space Complexity: O(n*n)
**/
class Solution {
    
    static int longestSubsequenceMem(int a[], int currentIndex, int indexOfLastElementInSubsequence, int dp[][]) {

     int n = a.length;
        //Base Case
        if (currentIndex == n) {
            return 0;
        } else if (dp[currentIndex][indexOfLastElementInSubsequence + 1] != -1) { //indexOfLastElementInSubsequence + 1 is representing element at indexOfLastElementInSubsequence in array
            return dp[currentIndex][indexOfLastElementInSubsequence + 1];
        }

        int include = 0;
        if (indexOfLastElementInSubsequence == -1 || a[indexOfLastElementInSubsequence] < a[currentIndex]) {
            include = 1 + longestSubsequenceMem(a, currentIndex + 1, currentIndex, dp);
        }

        int exclude = longestSubsequenceMem(a, currentIndex + 1, indexOfLastElementInSubsequence, dp);

        dp[currentIndex][indexOfLastElementInSubsequence + 1] = Math.max(include, exclude);


        return dp[currentIndex][indexOfLastElementInSubsequence + 1];


    }
    
    
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int a[]) {
        int n = a.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestSubsequenceMem(a, 0, -1, dp);
    }
}
==========================================================
/**
** Bottom Up(Because Starting form last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n*n)
** Space Complexity: O(n*n) 
**/

class Solution {
 
    public int lengthOfLIS(int[] a) {
     int n = a.length;
        int dp[][] = new int[n + 1][n + 1]; // required in dp[n][n] but wer have ref currentIndex + 1 or indexOfLastElementInSubsequence + 1. To Handle this dp[n+1][n+1]. Base case is already handle to be 0
        for (int currentIndex = n - 1; currentIndex >= 0; currentIndex--) {
            for (int indexOfLastElementInSubsequence = currentIndex - 1; indexOfLastElementInSubsequence >= -1; indexOfLastElementInSubsequence--) {

                int include = 0;
                if (indexOfLastElementInSubsequence == -1 || a[indexOfLastElementInSubsequence] < a[currentIndex]) {
                    include = 1 + dp[currentIndex + 1][currentIndex + 1]; //The dp[][] table's columns are indexed by indexOfLastElementInSubsequence + 1, Hence in dp column we need to + 1
                }

                int exclude = dp[currentIndex + 1][indexOfLastElementInSubsequence + 1]; //Since -1 is not a valid index , handled by +1

                dp[currentIndex][indexOfLastElementInSubsequence + 1] = Math.max(include, exclude);

            }

        }

         return dp[0][0]; //dp[0][-1] but -1 is not valid index hence -1 +1
    }
}
=================================================
/**
** Bottom-up and Space Optimized Approach. 
** Time Complexity: O(n*n)
** Space Complexity: O(n)
**/
class Solution {
 
    public int lengthOfLIS(int[] a) {
     int n = a.length;
        //int dp[][] = new int[n + 1][n + 1]; // required in dp[n][n] but wer have ref currentIndex + 1 or indexOfLastElementInSubsequence + 1. To Handle this dp[n+1][n+1]. Base case is already handle to be 0

        int prevCurrentIndex[] = new int[n + 1];
        int currentCurrentIndex[] = new int[n + 1];
        for (int currentIndex = n - 1; currentIndex >= 0; currentIndex--) {
            for (int indexOfLastElementInSubsequence = currentIndex - 1; indexOfLastElementInSubsequence >= -1; indexOfLastElementInSubsequence--) {

                int include = 0;
                if (indexOfLastElementInSubsequence == -1 || a[indexOfLastElementInSubsequence] < a[currentIndex]) {
                    include = 1 + prevCurrentIndex[currentIndex + 1]; //The dp[][] table's columns are indexed by indexOfLastElementInSubsequence + 1, Hence in dp column we need to + 1
                }

                int exclude = prevCurrentIndex[indexOfLastElementInSubsequence + 1]; //Since -1 is not a valid index , handled by +1

                currentCurrentIndex[indexOfLastElementInSubsequence + 1] = Math.max(include, exclude);

            }

            prevCurrentIndex = Arrays.copyOf(currentCurrentIndex, n + 1);

        }

        return prevCurrentIndex[0]; //dp[0][-1] but -1 is not valid index hence -1 +1
    }
}
=================================================
    /**
** Using Binary Search
** We can take a list of subSeq.
** We can add first element to it.
** Now we can traverse array, if we find any element which is less than the last element in Sub Seq Array List, we can add element to list
** If not we can find a position for array element to be inserted in sub seq list.
** Why are we doing so because this is like we can have one more possible ans for sub seq whihc will be of same length which we have find so far but just need to replace.
** Ref video at 28:03
** Time Complexity: O(n*logn)
** Space Complexity: O(n)
**/

class Solution {
 
    public int lengthOfLIS(int[] a) {
     int n = a.length;
        List<Integer> subSeqList = new ArrayList<>();

        if (n == 0) {
            return 0;
        }

        subSeqList.add(a[0]);
        for (int i = 1; i < n; i++) {
            if (subSeqList.get(subSeqList.size() - 1) < a[i]) {
                subSeqList.add(a[i]);
            } else {

              //find index in subSeq List for which a[i] is smallest
                int index = Collections.binarySearch(subSeqList, a[i]);
                if (index < 0) {
                    index = Math.abs(index) - 1; //Handling of binarySearch fun return value
                }
                subSeqList.set(index, a[i]);
            }
        }

        return subSeqList.size();
    }
}
===================================================
/**
** Russian Doll Problme Leet Code:
** https://leetcode.com/problems/russian-doll-envelopes/submissions/1461737013/
** https://www.youtube.com/watch?v=MYHajVcnXSA : 40:16
** Time Complexity: O(n*logn)
** Space Complexity: O(n)
** Approach: Sort envelops by width and width are same, sort by height. Because if two envelopes has same width, we can't put them with one another inside.
** Then extract 1D Array by height and apply Longest Increasing SubSequence
 **/   
class Solution {

 static int longestSubsequence(int a[]) {

        int n = a.length;
        List<Integer> subSeqList = new ArrayList<>();

        if (n == 0) {
            return 0;
        }

        subSeqList.add(a[0]);
        for (int i = 1; i < n; i++) {
            if (subSeqList.get(subSeqList.size() - 1) < a[i]) {
                subSeqList.add(a[i]);
            } else {

                //find index in subSeq List for which a[i] is smallest
                int index = Collections.binarySearch(subSeqList, a[i]);
                if (index < 0) {
                    index = Math.abs(index) - 1; //Handling of binarySearch fun return value. CHeck implementation of this in built function
                }
                subSeqList.set(index, a[i]);
            }
        }

        return subSeqList.size();

    }

    public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return e1[0] - e2[0]; //asc by width
            } else {
                return e2[1] - e1[1]; //desc by height
            }
        });

        // Extract a 1D array with only height values (heights)
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return longestSubsequence(height);
    }
}
