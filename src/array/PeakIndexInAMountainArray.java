/**
** https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
** https://www.youtube.com/watch?v=RjxD6UXGlhc&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&index=20&t=838s
** You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

 

Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1
** Approach 1: Traverse array and find an index where a[i - 1] < a[i] && a[i] > a[i + 1] return i
** Time Complexlity: O(n), Space Complexity: O(1)
** Approach 2:
** Binary Search
** Case 1:if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) , return mid
** Case 2: else if (a[mid] < a[mid + 1]) { //Increasing Slope,  l = mid + 1;
** else we are on decreaing sloe, h=mid-1
** ** Time Complexlity: O(logn), Space Complexity: O(1)
**/
class Solution {

    public static int peakIndexInMountainArray(int[] a) {
        int l = 1, h = a.length - 2; //Since starting and End Index cant be an answer
        while (l <= h) {

            int mid = l + (h - l) / 2;
            if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[mid] < a[mid + 1]) { //Increasing Slope
                l = mid + 1;
            } else {
                h = mid - 1; //Decreasing Slope
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        //int a[] = {0, 1, 0};
        //int a[] = {0, 2,1, 0};
        int a[] = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(a));

    }

}
