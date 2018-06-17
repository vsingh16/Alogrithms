package dynamic.programming;

/**
 * Created by vishal on 23-Apr-18.
 * https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 * <p>
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s
 * Input :   0 1 1 0
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 0 0
 * <p>
 * Output :  1 1 1 1
 * 1 1 1 1
 * <p>
 * Approach:
 * Traverse matrix row by row and if a[i][j] ==1 , add previous row value
 * Then find the max area histogram at that level.
 * <p>
 * Time Complexity:O(m*n)
 * Space Complexity:O(1),utilised the given matrix
 */
public class MaxAreaRectangle {

    public static Integer maxArea(Integer a[][]) {

        Integer maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] != 0) {
                        a[i][j] += a[i - 1][j];
                    }
                }
            }
            maxArea = Math.max(HistogramArea.area(a[i]), maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Integer a[][] = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1,}, {1, 1, 0, 0}};
        System.out.println(maxArea(a));
    }
}
