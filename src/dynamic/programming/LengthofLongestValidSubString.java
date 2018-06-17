package dynamic.programming;

import java.util.Stack;

/**
 * Created by vishal on 13-Mar-18.
 * Length of the longest valid substring
 * *
 * Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.
 * <p>
 * *
 * Examples:
 * <p>
 * *
 * Input : ((()
 * *
 * Output : 2
 * *
 * Explanation : ()
 * <p>
 * *
 * Input: )()())
 * *
 * Output : 4
 * *
 * Explanation: ()()
 * <p>
 * *
 * Input:  ()(()))))
 * *
 * Output: 6
 * *
 * Explanation:  ()(())
 * Method 1:Find all substrings , then apply CheckBalancedExpression algo to see if it balanced, if balanaced
 * return length of string
 * <p>
 * Time Complexity:O(n*n)
 * Space Complexity:O(n)
 * <p>
 * <p>
 * Method 2;
 * Create an empty stack and push -1 to it. The first element
 * of stack is used to provide base for next valid string.
 * <p>
 * Initialize result as 0.
 * <p>
 * 3) If the character is '(' i.e. str[i] == '('), push index
 * 'i' to the stack.
 * <p>
 * 2) Else (if the character is ')')
 * a) Pop an item from stack (Most of the time an opening bracket)
 * b) If stack is not empty, then find length of current valid
 * substring by taking difference between current index and
 * top of the stack. If current length is more than result,
 * then update the result.
 * c) If stack is empty, push current index as base for next
 * valid substring.
 * <p>
 * Time Complexity:O(n)
 * Space Complexity:O(n)
 */
public class LengthofLongestValidSubString {

    public static int findMaxLen(String str) {

        int n = str.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//initial index consider case like ()

        int maxLen = 0;
        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                // Pop the previous opening bracket's index
                stack.pop();
                // Check if this length formed with base of
                // current valid substring is more than max
                // so far
                if (!stack.isEmpty()) {
                    maxLen = Integer.max(maxLen, i - stack.peek());

                }// If stack is empty. push current index as
                // base for next valid substring (if any)
                else {
                    stack.push(i);
                }

            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLen(")()())"));
        System.out.println(findMaxLen("(())"));
        System.out.println(findMaxLen(""));
    }

}
