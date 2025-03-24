package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 *         <p>
 *         https://www.geeksforgeeks.org/a-product-array-puzzle/
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * https://www.youtube.com/watch?v=TW2m8m_FNJE&list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt&t=1293s. Apna College
 * Given an array arr[] of n integers, construct a Product Array prod[] (of the same size) such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. 

Note: Solve it without the division operator in O(n) time.

Example : 

Input: arr[]  = {10, 3, 5, 6, 2}
Output: prod[]  = {180, 600, 360, 300, 900}
3 * 5 * 6 * 2 product of other array 
elements except 10 is 180
10 * 5 * 6 * 2 product of other array 
elements except 3 is 600
10 * 3 * 6 * 2 product of other array 
elements except 5 is 360
10 * 3 * 5 * 2 product of other array 
elements except 6 is 300
10 * 3 * 6 * 5 product of other array 
elements except 2 is 900
* Approach 1 : Multiply all, and then result[i] = prod/a[I]
** Approach 2: https://www.youtube.com/watch?v=UBkpyXgx0g0
** a[i] = left[i] * right[I]
** Take 2 arrays, left and right.
** Populate left and right.
** Approach 3: We can reduce the extra array
** First Store Prefixes in the result array.
** Secondly calculate and store suffixes in the same array.
 */

Approach 2:
public class ProductArrayPuzzle {

    public static void main(String[] args) {

        int a[] = {10, 3, 5, 6, 2};
        int left[] = new int[a.length];
        int right[] = new int[a.length];

        left[0] = 1;
        right[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(left[i] * right[i] + " ");
        }
    }
}
========================================================================
Approach 3: We can reduce the extra array    
class Solution {
    public int[] productExceptSelf(int[] nums) {
          int result[] = new int[nums.length];

        //Prefix
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        //Suffix
        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1];
            result[i] = result[i] * suffix;
        }

        return result;
    }
}
