/**
** https://www.spoj.com/problems/AGGRCOW/
** https://www.youtube.com/watch?v=7wOzDqsfXy0 . Apna College
** https://www.youtube.com/watch?v=YTTdLgyqOLY&t=3394s
** Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1 ... xN (0 <= xi <= 1,000,000,000).

** His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
** Input
** t – the number of test cases, then t test cases follows.
** Line 1: Two space-separated integers: N and C
** Lines 2..N+1: Line i+1 contains an integer stall location, xi
** Output
** For each test case output one integer: the largest minimum distance.
** Example
** Input:
** 
** 1
** 5 3
** 1
** 2
** 8
** 4
** 9
** Output:
**
** 3
** Output details:
**
** FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
** resulting in a minimum distance of 3.
** Approach:
** The largest minimum distance. This gives a hint on solving it using search space.
** Since we can ignore one part as if a cow is fighting at x distance, they will fight at all x-1 distances, so we can ignore it.
** We can apply binary search.
** Time Complexity: Max of (O(nlogn), O(n * log search space))
** Space Complexity: O(1)
**/

class Solution {

  /**
  ** If can be allocated, assign and increase count.
  ** Last Pos also get updated as now Cow is at this place.
  **/
    public static boolean isPossibleSol(int stalls[], int k, int mid) { 

        int cowCount = 1;
        int lastPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) { //o(log stalls length)
            if (stalls[i] - posOfLastCow >= mid) {
                cowCount++;
                lastPos = stalls[i];
                if (cowCount == k) {
                    return true;
                }
            }
        }

        return false;
    }

    
    public static int aggressiveCows(int stalls[], int k) {
        Arrays.sort(stalls); //nlogn
        int l = 0; //We can use 1 min possible distance or 0 will also work
        int h = Arrays.stream(stalls).max().getAsInt(); // we can use Arrays.stream(stalls).max().getAsInt() or to be precise
        // int h = Arrays.stream(stalls).max().getAsInt() - Arrays.stream(stalls).min().getAsInt();
        int ans = -1;
        while (l <= h) { //o(log search space)
            int mid = l + (h - l) / 2;
            if (isPossibleSol(stalls, k, mid)) {
                ans = mid;
                l = mid + 1; //Since we need to find largest distance
            } else {
                h = mid - 1;
            }
        }

        return ans;
    }
}
