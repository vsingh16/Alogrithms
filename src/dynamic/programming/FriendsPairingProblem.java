/**
** Ref: https://www.geeksforgeeks.org/dsa/friends-pairing-problem/
** Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up. 

Examples: 

Input  : n = 3
Output : 4
Explanation:
{1}, {2}, {3} : all single
{1}, {2, 3} : 2 and 3 paired but 1 is single.
{1, 2}, {3} : 1 and 2 are paired but 3 is single.
{1, 3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1, 2} and {2, 1} are considered same.


Approach: We can either keep the nth element single, in that case we need to further solve for f(n-1)
or we can pair nth element, and this pairing can be done with (n-1) elements. In this case we need to further solve for f(n-2)
f(n) = f(n-1)+(n-1)*f(n-2)
**/

/**
** Recursion(Bottom Up Approach, SInce stating from n)
** Time Complexity: O(2^n) 
** Space Complexity: O(n)
**/
class Solution {
    public static long countFriendsPairings(int n) {

        //Base Case
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        long single = countFriendsPairings(n - 1);
        long paired = (n - 1) * countFriendsPairings(n - 2);
        return single + paired;
    }
}
==========================================================================================
/**
** Bottom Up Approach Down(Since i is from n) Recurson + Memorization.
** Time Complexity: O(n)
** Space Complexity: O(n)
**/

class Solution {
    
     public static long countFriendsPairings(int n, long dp[]) {

        //Base Case
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (dp[n] != -1) { //Already Calculated
            return dp[n];
        }

        long single = countFriendsPairings(n - 1);
        long paired = (n - 1) * countFriendsPairings(n - 2);
        dp[n] = single + paired;
        return dp[n];
    }


    public static long countFriendsPairings(int n) {
        long dp[] = new long[n + 1];
        Arrays.fill(dp, -1);
        return countFriendsPairings(n, dp);
    }
}
==========================================================================================
/**
** Top Down Approach Down(Since i is from 1) DP
** Time Complexity: O(n)
** Space Complexity: O(n)
**/

class Solution {

    public static long countFriendsPairings(int number) {

        long dp[] = new long[number + 1];
        for (int n = 1; n <= number; n++) { //Recursion n is from n to 1, so here opposite

            //Base Case
            if (n == 1) {
                dp[n] = 1;
            } else if (n == 2) {
                dp[n] = 2;
            } else {
                long single = dp[n - 1];
                long paired = (n - 1) * dp[n - 2];
                dp[n] = single + paired;
            }

        }

        return dp[number];
    }
}
