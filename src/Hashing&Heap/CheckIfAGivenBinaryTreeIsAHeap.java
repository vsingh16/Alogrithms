/**
** Ref: https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/
** Love Babbar Lecture 75 Code Help https://www.youtube.com/watch?v=_9F2VgZcvdw
Given a binary tree, check if it has heap property or not, Binary tree needs to fulfill the following two conditions for being a heap – 

It should be a complete tree (i.e. all levels except the last should be full).
Every node’s value should be greater than or equal to its child node (considering max-heap).
Examples:

Input: 

yes

Output: Given binary tree is a heap 

Input: 

no

Output: Given binary tree is not a heap

Approach : For Max Heap
It has to be Complete Binary Tree
It also satisfies Max Node property

CBT: We can count nodes and if at any point index > CorrectlastIndex, return false
Time Complexity : O(n)
Space Complexity : O(1), not considreing recursive calls space
**/

import java.util.Arrays;

public class Solution {

    static int index = 0;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    int countNode(Node node) {

        if (node == null) {
            return 0;
        }

        return 1 + countNode(node.left) + countNode(node.right);

    }

    boolean isCBT(Node node, int index, int correctLastIndex) {

        if (node == null) {
            return true;
        }

        if (index > correctLastIndex) {
            return false;
        }

        return isCBT(node.left, 2 * index + 1, correctLastIndex)
                &&
                isCBT(node.left, 2 * index + 2, correctLastIndex);
    }

    boolean isMax(Node node) {

        //Leaf Node
        if (node.left == null && node.right == null) {
            return true;
        }

        //Since CBT, and node is not leaf node it will surely have left node but right node can be null
        if (node.right == null) {
            return node.data > node.left.data;
        }

        return node.left.data < node.data
                && node.right.data < node.data
                && isMax(node.left)
                && isMax(node.right);

    }


    boolean isHeap(Node node) {

        int countNode = countNode(node);

        return isCBT(node, 0, countNode - 1) && isMax(node);
    }

  
}


