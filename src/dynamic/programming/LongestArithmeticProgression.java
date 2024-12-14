/**
** Ref: https://www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/
** https://www.youtube.com/watch?v=YaMcX7sem70&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=24
** Given an array arr[] of sorted integers and distinct positive integers, find the length of the Longest Arithmetic Progression in it.
Note: A sequence seq is an arithmetic progression if seq[i + 1] – seq[i] are all the same value (for 0 <= i < seq.length – 1).

Examples: 

Input: arr[] = [1, 7, 10, 15, 27, 29]
Output: 3
Explanation: The longest arithmetic progression is [1, 15, 29] having common difference 14.


Input: arr []= [5, 10, 15, 20, 25, 30]
Output: 6
Explanation: The whole set is in AP having common difference 5.

** Approach: For airthemetic progression, we need a series a+d, a+2d, a+3d.....
** For this d, we need to check for all combinations of elements in an array.
** Once we get diff, we can further check in array strating from index i to left till o, and if any element has same diff, we can increase legth of AP
**/

/**
** Recursion(Top Down Approach, as starting from Left 0th Index):
** Time Complexity: O(n^3)
** Space Complexity: O(n)
**/
class Solution {
    
     static int solve(Integer[] a, int i, int diff) {

        if (i < 0) {
            return 0;
        }

        int ans = 0;
        for (int j = i - 1; j >= 0; j--) { // Checking backward
            if (a[i] - a[j] == diff) {
                ans = Math.max(ans, 1 + solve(a, j, diff));
            }
        }

        return ans;
    }

    int lengthOfLongestAP(Integer[] a) {
       int n = a.length;
        //Base Case
        if (n <= 2) {
            return n;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = a[j] - a[i];
                ans = Math.max(ans, 2 + solve(a, i, diff));

            }

        }

        return ans;
    }
}
==========================================================
/**
** Recursion(Bottom Up) + Memorization
** Time Complexity: O(n*n) Array length
** Space Complexity: O(n*n)
**/
import java.util.HashMap;
import java.util.Map;

class Solution {

    static int solve(Integer[] a, int i, int diff, Map<Integer, Integer> dp[]) {

        if (i < 0) {
            return 0;
        } else if (dp[i].containsKey(diff)) { //Already Calculated
            return dp[i].get(diff);
        }

        int ans = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (a[i] - a[j] == diff) {
                ans = Math.max(ans, 1 + solve(a, j, diff, dp));
            }
        }

        dp[i].put(diff, ans);
        return dp[i].get(diff);
    }

    static int lengthOfLongestAP(Integer[] a) {

        int n = a.length;
        //Base Case
        if (n <= 2) {
            return n;
        }

        //int dp[index][diff]. Because diff can be any value
        Map<Integer, Integer> dp[] = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = a[j] - a[i];
                ans = Math.max(ans, 2 + solve(a, i, diff, dp));
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        Integer nums1[] = {1, 7, 10, 13, 14, 19};
        System.out.println(lengthOfLongestAP(nums1));
    }
}
==========================================================
/**
** Bottom Up Approach(Because Starting from last index). Tabluar Approach is just opposite of recursion.
** This is opposite of recursion but we need to handle few scenarios.

** Time Complexity: O(n*n) Array length
** Space Complexity: O(n*n)
**/

class Solution {
    
    static int lengthOfLongestAP(Integer[] a) {

        int n = a.length;

        //int dp[index][diff]. Because diff can be any value
        Map<Integer, Integer> dp[] = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 0;
        for (int i = 1; i < n; i++) { // Since j is from 0, starting i from 1 , so that both does not be on same point
            for (int j = 0; j < i; j++) { //Since Bottom Up which is just opposite of recursion, travelling from 0 to i
                int diff = a[j] - a[i];

                int count = 1; //If diff doesn't exists only i is there
                if (dp[j].containsKey(diff)) {
                    count = dp[j].get(diff);
                }
                dp[i].put(diff, 1 + count);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Integer nums1[] = {1, 7, 10, 13, 14, 19};
        System.out.println(lengthOfLongestAP(nums1));
    }
}
