/**
** https://leetcode.com/problems/valid-parentheses/description/
** Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

Time : O(n)
Space :O(n)
**/

import java.util.Stack;

class Solution {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {

            if (isOpening(ch)) {
                stack.push(ch);
            } else { //closing
                if (!stack.isEmpty()) {
                    if (!isMatchingClose(stack.peek(), ch)) {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else { //Closing and Stack is empty
                    return false;
                }
            }

        }

        return stack.isEmpty() ? true : false;

    }

    private static boolean isOpening(Character ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }


    private static boolean isMatchingClose(Character stackTopCharacter, Character ch) {

        if (ch == ')' && stackTopCharacter == '(') {
            return true;
        } else if (ch == '}' && stackTopCharacter == '{') {
            return true;
        } else if (ch == ']' && stackTopCharacter == '[') {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        String input = "]";
        System.out.println(isValid(input));

    }


}
