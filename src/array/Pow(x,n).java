/**
** https://leetcode.com/problems/powx-n/submissions/
** Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Approach 1: We can solve this by multiplying x n times, O(n)

Approach 2: calculate result  = pow(x,n/2)
even ---> result * result
odd ---> result * result * x
eg : 2^6 = 2^3 * 2^3
2^7 = 2^3 * 2^3 * 2
To handle negative case, If n < 0, 1/ answer
Time Complexity : O(logn)
**/

class Solution {
    
    public double myPow(double x, int n) {
        
        double result = myPowUtil(x, n);
        // Handling -ve power
        return (n < 0) ? (1/result) : result;
        
    }
    
    public double myPowUtil(double x, int n) {
        
        if(x == 0){
            return 0;
        }
        
        if(n == 0){
            return 1;
        }
        
        double result = myPowUtil(x, n/2);
        
        if(n%2 == 0){
            return result * result;
        }else{
            return result * result * x;
        }
        
    }
}
