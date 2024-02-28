/**
** Sort an array according to count of set bits
** Given an array of positive integers, sort the array in decreasing order of count of set bits in binary representations of array elements. For integers having the same number of set bits in their binary representation, sort according to their position in the original array i.e., a stable sort. For example, if the input array is {3, 5}, then the output array should also be {3, 5}. Note that both 3 and 5 have the same number set bits.

Examples:

Input: arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
Output: 15 7 5 3 9 6 2 4 32
Explanation:
The integers in their binary representation are:
    15 -1111
    7  -0111
    5  -0101
    3  -0011
    9  -1001
    6  -0110
    2  -0010
    4- -0100
    32 -10000
hence the non-increasing sorted order is:
{15}, {7}, {5, 3, 9, 6}, {2, 4, 32}

** Approach1: We can apply sort and use comparator to define sorting order by bit counts.
** Time Complexity: O(lLogn)
** Space Complexity: O(1)
**/

class Compute  
{ 
  //Approach 1: https://www.youtube.com/watch?v=RdQiA97A7XQ
    static void sortBySetBitCount(Integer a[], int n)
    { 
        Arrays.sort(a, Comparator.comparingInt(Integer::bitCount).reversed());
    } 
}
