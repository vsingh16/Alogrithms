/**
** https://www.geeksforgeeks.org/dsa/matrix-chain-multiplication-dp-8/
** Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum. When two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and the number of multiplications performed is m*n*p.
Ref: https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/
Examples:

Input: arr[] = [2, 1, 3, 4]
Output: 20
Explanation: There are 3 matrices of dimensions 2x1, 1x3, and 3x4, 
Let the input 3 matrices be M1, M2, and M3. There are two ways to multiply ((M1 x M2) x M3) and (M1 x (M2 x M3)), 
Please note that the result of M1 x M2 is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix.
((M1 x M2) x M3)  requires (2 x 1 x 3)  +  (2 x 3 x 4) = 30 
(M1 x (M2 x M3))  requires (1 x 3 x 4) +  (2 x 1 x 4) = 20 
The minimum of these two is 20.

Input: arr[] = [1, 2, 3, 4, 3]
Output: 30
Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3. Let the input 4 matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1M2)M3)M4. The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30

Input: arr[] = [3, 4]
Output: 0
Explanation: As there is only one matrix so, there is no cost of multiplication.

**/

/**
** Recursion(Top Down Approach,):: Explore all Possible Partitions in Array.
** Every Partitions has start and end index.
** Time Complexity: O(2^n) 
** Space Complexity: O(n)
**/
class Solution {

    public static int matrixMultiplication(int a[], int i, int j) {

        //Base Case, 2 elements in array or 1 matrix
        if (i + 1 == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int result = matrixMultiplication(a, i, k) + matrixMultiplication(a, k, j) + a[i] * a[k] * a[j];
            min = Math.min(min, result);
        }

        return min;

    }

    public static int matrixMultiplication(int a[]) {
        return matrixMultiplication(a, 0, a.length - 1);
    }

    public static void main(String[] args) {

        int arr[] = {2, 1, 3, 4};
        int res = matrixMultiplication(arr);
        System.out.println(res);


    }


}
==========================================================
/**
** Top Down(Since i is from 0) Memorization.
** Time Complexity: O(n^2)
** Space Complexity: O(n^2)
**/

class Solution {
    
     public static int matrixMultiplication(int a[], int dp[][], int i, int j) {

        //Base Case, 2 elements in array or 1 matrix
        if (i + 1 == j) {
            return 0;
        } else if (dp[i][j] != -1) { //Already Calculated
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int result = matrixMultiplication(a, dp, i, k) + matrixMultiplication(a, dp, k, j) + a[i] * a[k] * a[j];
            min = Math.min(min, result);
        }

        dp[i][j] = min;

        return dp[i][j];

    }
    
    static int matrixMultiplication(int a[]) {
        int dp[][] = new int[a.length + 1][a.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return matrixMultiplication(a, dp, 0, a.length - 1);
        
    }
}

==========================================================
/**
** Tabular(Since i is from n-1) Bottom Up Approach
** Time Complexity: O(n^2)
** Space Complexity: O(n^2)
**/

class Solution {
    
    public static int matrixMultiplication(int a[]) {
        int dp[][] = new int[a.length + 1][a.length + 1];

        for (int i = a.length - 1 - 1; i >= 0; i--) { //Recursion i=0 to n-1-1
            for (int j = i + 1; j <= a.length - 1; j++) { //Recursion j = n-1 to i

                //Base Case, 2 elements in array or 1 matrix
                if (i + 1 == j) {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        int result = dp[i][k] + dp[k][j] + a[i] * a[k] * a[j];
                        min = Math.min(min, result);
                    }

                    dp[i][j] = min;
                }
            }

        }


        return dp[0][a.length - 1];
    }

    public static void main(String[] args) {

        int arr[] = {2, 1, 3, 4};
        int res = matrixMultiplication(arr);
        System.out.println(res);


    }


}
=========================================================
