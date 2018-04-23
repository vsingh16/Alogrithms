package dynamic.programming;

import java.util.Stack;

/**
 * Created by vishal on 23-Apr-18.
 *
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 *
 * Find max area of a histogram.
 *
 * The maximum area of histogram is the area of largest rectangle with continuous bars.
 *
 * Inorder to find this we will calculate are for each bar, and then find the max among it.
 *
 * 1)If stack is empty or a[i] > a[stack.peek()]
 *   push the index i into stack and increment.
 *
 * 2)else,find are for top element of stack.
 * which will be a[stack.pop()] * (right(i-1)-left(stack.peek()))
 *
 * Time Complexity:O(n) since we traversed element in one go
 * Space Complexity: O(n) because of Stack
 */
public class HistogramArea {

    public static int area(Integer a[]) {
        Stack<Integer> stack = new Stack();
        int i = 0, n = a.length;
        Integer maxArea = Integer.MIN_VALUE;
        while (i < n) {
            if (stack.isEmpty() || a[i] > a[stack.peek()]) {
                stack.push(i++);
            } else {
                Integer topElement = a[stack.pop()];
                Integer area = topElement * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
                maxArea = Integer.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            Integer topElement = a[stack.pop()];
            Integer area = topElement * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
            maxArea = Integer.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Integer a[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(area(a));
    }
}
