package dynamic.programming;

/**
 * Created by vishal on 23-Apr-18.
 * https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 * https://leetcode.com/problems/maximal-rectangle/
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
class Solution {

    /**
    ** https://www.youtube.com/watch?v=lJLcqDsmYfg&t=222s. Love Babbar
    ** Approach: Either we don brute force.
    ** To Optimize Time, we will use stack, trvaer from right side of array
    ** if stack top has smallest element than current array element, that is answer
    ** else keep popping stack elements unitl we find the smallest element.
    ** Push Every Element in stack
    ** Time Complexity: O(n)
    ** Space Complexity : O(n)
    **/
    public static int[] nextSmallerIndex(int[] a) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (stack.peek() != -1 && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            // Since in histogram if we cant find next smaller on right side, we will take one index next to array end
            result[i] = stack.peek() == -1 ? a.length : stack.peek();
            stack.push(i);
        }


        return result;
    }

    
    /**
    ** https://www.youtube.com/watch?v=lJLcqDsmYfg&t=222s. Love Babbar
    ** Approach: This is opposite of above.
    ** Just traverse array from Left.
    ** Time Complexity: O(n)
    ** Space Complexity : O(n)
    **/
    public static int[] prevSmallerIndex(int[] a) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (stack.peek() != -1 && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            result[i] = stack.peek();
            stack.push(i);
        }


        return result;
    }

    /**
    ** This method finds largest area in a histogram.
    ** Approach : Find PrevSmallestElementIndex
    ** Find NextSmallestElementIndex
    ** width = nextSmallerIndexes[i] - prevSmallerIndexes[i] - 1;
    ** Area = length * width
    ** Time Complexity: O(n) 
    ** Space Complexity : O(n)
    **/
    public static int largestRectangleArea(int[] heights) {

        //For each height, find max possible length
        //Length = nextSmallerIndex - prevSmallerIndex - 1;
        int prevSmallerIndexes[] = prevSmallerIndex(heights);
        int nextSmallerIndexes[] = nextSmallerIndex(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmallerIndexes[i] - prevSmallerIndexes[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;

    }

    /**
    ** https://www.youtube.com/watch?v=IPT6emqnxg8&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=37&t=14s
    ** This method finds largest rectangle in Matrix 
    ** Approach: Traverse Array by row.
    ** Add prev row if it has 1
    ** This problem then converted to find max area in histogram.
    ** Time COmplexity: O(m*n *n) //Matrix Traverse and then for each row finding Histogram area
    ** Space Complexity : O(n) //Additional space for area in histogram
    **/
    
    public static int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        int M[][] = new int[m][n];

        //Formatting from character to Numeric
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    M[i][j] = 1;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && M[i][j] == 1) { //Skipping for 0th row
                    M[i][j] = M[i - 1][j] + M[i][j]; //Add Prev Row
                }
            }

            //Find Area of Histogram for each row
            int area = largestRectangleArea(M[i]); //O(n)
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;

    }

    public static void main(String[] args) {
        char a[][] = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(a));
    }
}
