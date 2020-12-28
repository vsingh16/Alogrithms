package com.vishal.hackerrank;

/**
 * Created by vishal on 28-Dec-20.
 * <p>
 * Rotate Square Matrix by 90 degree.
 * <p>
 * [[1,2,3,4]
 * [5,6,7,8]
 * [9,10,11,12]
 * [13,14,15,16]]
 * <p>
 * After Rotation
 * [[13,9,5,1]
 * [14,10,6,2]
 * [15,11,7,3]
 * [16,12,8,4]]
 * <p>
 * Note: 90 degree rotation is only possible if matrix is square.
 */
public class RotateArray90 {

    /**
     * Method 1: Take extra array [m][n]
     * i = n-1-j
     * j = i
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n)
     *
     * @param a
     * @return
     */
    public static int[][] rotate(int a[][]) {

        int rotatedArr[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                rotatedArr[i][j] = a[a.length - 1 - j][i];
            }
        }

        return rotatedArr;
    }

    public static void printMatrix(int a[][]) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * Method 2: Sometimes, it is asked to not take extra space.
     * Traverse array layer by layer i.e Spiral Matrix
     * In Each layer traversal, begin with swapping all four corner elements and so.
     * temp = (0,0) i,j
     * (0,0) = (3,0) n-1-j,i
     * (3,0) = (3,3) n-1-i,n-1-j
     * (3,3) = (0,3) j,n-1-i
     * (0,3) = temp
     * Time Complexity : O(1) //In Place
     * Space Complexity : O(m*n)
     *
     * @param a
     * @return
     */
    public static int[][] inPlaceRotate(int a[][]) {

        int n = a.length;
        for (int i = 0; i < n / 2; i++) { //no of layers n/2
            for (int j = i; j < n - i - 1; j++) { // minus 1 because if there are 4 elements in a row, we need to shift 3 times
                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][i];
                a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                a[j][n - 1 - i] = temp;
            }
        }

        return a;
    }


    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        //printMatrix(rotate(a));
        System.out.println("======================");
        printMatrix(inPlaceRotate(a));

    }
}
