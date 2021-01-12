Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

Approach: We can apply Binary Search here.
Keep in mind, if we do mid = (l+h)/2; h= Integer.max , so adding even 1 will give us Integer.MIN
So right way to do mid, is no of elements b/w l & h = (h-l)
then it starts from l, so mid = l + (h-l)/2
Also, if mid = INTEGER.MAX, so mid * mid will result in overflow hence we are taking long.

class Solution {
    
    public int mySqrt(int x) {
     
     //Base Cases : 0,1
    if (x == 0 || x == 1) {
      return x;
    }

    int result = 1;
    int l = 1, h = x;
    while (l <= h) {

      long mid = l + (h - l) / 2;
      if (mid * mid == x) {
        return (int) mid;
      } else if (mid * mid < x) {
        l = (int) (mid + 1);
        result = (int) mid;
      } else {
        h = (int) mid - 1;
      }
    }

    return result;
    }
}
