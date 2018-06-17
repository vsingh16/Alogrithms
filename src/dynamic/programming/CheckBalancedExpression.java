package dynamic.programming;

import java.util.Stack;

/**
 * Created by vishal on 13-Mar-18.
 * <p>
 * Check for balanced parentheses in an expression
 * Given an expression string exp , write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 *
 * Method : Traverse the expression.
 * If opening brace, push to stack
 * If closing brace,pop from stack and compare with closing brace, if they match return true else false
 *
 * Time Complexity:O(n)
 * Space Complexity:O(n)
 */
public class CheckBalancedExpression {

    private static boolean areBracesMatched(char openingBrace, char closingBrace) {

        switch (openingBrace) {
            case '{':
                return '}' == closingBrace;

            case '[':
                return ']' == closingBrace;

            case '(':
                return ')' == closingBrace;
            default:
                return false;

        }
    }


    public static Boolean areParenthesisBalanced(char exp[]) {

        Stack stack = new Stack();

        for (int i = 0; i < exp.length; i++) {

            //if opening braces, push to stack
            if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') {
                stack.push(exp[i]);
            }

            //if closing braces, pop from stack and compare with closing braces
            if (exp[i] == '}' || exp[i] == ')' || exp[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char closingBrace = (char) stack.pop();
                return areBracesMatched(closingBrace, exp[i]);
            }

        }

        return stack.isEmpty() ? true : false;

    }

    public static void main(String[] args) {
        char exp1[] = {'{', '(', ')', '}', '[', ']'};
        System.out.println(areParenthesisBalanced(exp1));

        char exp2[] = {'{'};
        System.out.println(areParenthesisBalanced(exp2));

        char exp3[] = {'}'};
        System.out.println(areParenthesisBalanced(exp3));
    }


}

