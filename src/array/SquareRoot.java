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
Ref: https://www.geeksforgeeks.org/square-root-of-an-integer/
https://leetcode.com/problems/sqrtx/
https://www.youtube.com/watch?v=6z2HK4o8qcU&t=2502 : Love Babbar


class Solution {
    
    public int mySqrt(int x) {
     
      long l = 0; long h=x;
        long result = 0;
        while(l<=h){
            long mid = l + (h-l)/2;
            long product = (mid * mid);
            if(product == x){
                return (int)mid;
            }else if(product < x){
                result = mid;
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        return (int)result;
    }
}
