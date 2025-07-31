/**
** https://leetcode.com/problems/sort-colors/description/
** https://www.youtube.com/watch?v=J48aGjfjYTI&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&index=27 . Apna College
** Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Approach 1: Brtue Force: Sort Array . TC: O(nLogn), Space: O(1)
Approach 2: Keep and maintain count in map. Sort Array . TC: O(n), Space: O(1). Since we only need to have 0,1,2 as key. But this we will do in two passes.
Pass 1: Count array, Pass 2: Filling 0,1,2 as per count in original array.
Approach 3: Dutch National Flag Algorithm. 
Keep 3 pointers, l, mid, h
0 to l-1 : all 0's
l to mid-1 : all 1's
mid to h-1 : unsorted
h to n-1 : all 2's

We will keep mid, and l in starting, h at end.
Case 1:  if (a[mid] == 0)
Swap l and mid
 Since now we have processed mid, mid++
 0 is at l, so l++

Case 2:
 if (a[mid] == 1)
 1 is at right position, no need to do anything, simply move mid++ for next element            

Case 3:  if (a[mid] == 2)
Swap h and mid
mid got moved to correct position at h, so we can do h-- 
But we dont know what has come to mid now, so we dont do anything

TC: O(n) with Single Pass
Space: O(1)
**/

import java.util.Arrays;

class Solution {

    public static void sortColors(int[] a) {

        int l = 0, mid = 0, h = a.length - 1;
        while (mid <= h) {

            if (a[mid] == 0) {
                swap(a, l, mid);
                l++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else { //a[mid] == 2
                swap(a, h, mid);
                h--;
            }

        }

    }

    private static void swap(int a[], int index1, int index2) {

        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;

    }

    public static void main(String[] args) {
        int a[] = {2, 0, 2, 1, 1, 0};
        sortColors(a);
        Arrays.stream(a).forEach(System.out::println);

    }


}
