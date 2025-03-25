/**
* Ref: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
       https://www.youtube.com/watch?v=qsbCBduIs40&t=774s. Apna College
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 
*
* 
*
* Example 1:
*
* Input: nums = [2,2,1]
* Output: 1
* Example 2:
*
* Input: nums = [4,1,2,1,2]
* Output: 4
* Approach 1: Traverse and check if (a[i - 1] != a[i] && a[mid] != a[i + 1]), return a[I]
** Approach 2: Since Array is sorted we can use Binary Search
**/

class Solution {

    public static int singleNonDuplicate(int[] a) {

       //Edge Case : 1 number only
        if (a.length == 1) {
            return a[0];
        }

        int l = 0, h = a.length - 1;
        while (l <= h) {

            int mid = l + (h - l) / 2;
            if (mid == 0 && a[mid] != a[mid + 1]) { //1st Element
                return a[mid];
            } else if (mid == h && a[mid - 1] != a[mid]) { //Last Element
                return a[mid];
            } else if (a[mid - 1] != a[mid] && a[mid] != a[mid + 1]) {
                return a[mid];
            } else {

                /**
                 * Full Array is Odd because every number appears twice and 1 number only once
                 * Odd = Even+1+Even
                 * Odd = Odd+1+Odd
                 */

                if (mid % 2 == 0) { //Even+1+Even
                    if (a[mid] == a[mid + 1]) {
                        l = mid + 1;
                    } else {
                        h = mid - 1;
                    }

                } else {
                    //Odd+1+Odd
                    if (a[mid] == a[mid + 1]) {
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }

            }

        }


        return -1;
    }

    public static void main(String[] args) {
        int a[] = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(a));

    }


}
