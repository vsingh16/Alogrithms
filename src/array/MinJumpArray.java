package com.vishal.hackerrank;

/**
 * Created by vishal on 22-Dec-20.
 * <p>
 * Given an array of integers where each element represents the max number of steps
 * that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of
 * the array (starting from the first element).
 * If an element is 0, they cannot move through that element.
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 -> 9)
 */
public class MinJumpArray {

    /**
     * Method : Though we can solve it with DP, there is one more way to find in O(n)
     * Take two variable a & b.
     * a is ur walking pointer, so when a =0, it means u have arrived at one of stop. so jump ++.
     * <p>
     * B is when u have different options to go for jump, u will select the option with max. steps.
     * <p>
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param arr
     * @return
     */
    public static int minJump(int arr[]) {

        int jump = 1; //because last move is always a jump
        int a = arr[0];
        int b = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) { //reached, since we already have default jump = 1, no need to increase simply return
                return jump;
            }
            a--;
            b--;
            if (arr[i] > b) {
                b = arr[i];
            }
            if (a == 0) { //jump
                jump++;
                a = b;
            }
        }

        return jump;
    }

    public static void main(String[] args) {
        int a1[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJump(a1));

        int a2[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minJump(a2));

        int a3[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        System.out.println(minJump(a3));


    }
}
