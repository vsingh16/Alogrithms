/**
** Ref: https://www.geeksforgeeks.org/convert-bst-min-heap/
** https://www.geeksforgeeks.org/problems/bst-to-max-heap/1
** https://www.youtube.com/watch?v=NKJnHewiGdc&t=2454s , Love Babbar Heap Code Help Lecture 74,75,76
** Approach: Binary Search Tree i.e left < node < right
** if we do inorder traversal of BST, this will give us a sorted array
** Now if we need Min heap i.e node left right as the top node will be min
** Max Heap left right node as the top node will be max
** We can do pre order to convert in Min heap
** Post Order to convert to Max Heap
** Time Complexity : O(n)
** Space Complexity : O(n)
**/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void inorder(Node root, List<Integer> a) {

        if (root == null) {
            return;
        }

        inorder(root.left, a);
        a.add(root.data);
        inorder(root.right, a);
    }

    public static void postOrder(Node root, List<Integer> a) {

        if (root == null) {
            return;
        }

        postOrder(root.left, a);
        postOrder(root.right, a);
        root.data = a.get(index++);
    }


    public static void convertToMaxHeapUtil(Node root) {

        //Inorder traversal and store in array
        List<Integer> a = new ArrayList<>();
        inorder(root, a);
        //do post order traversal and copy elements from array
        postOrder(root, a);


    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        index = 0;
        convertToMaxHeapUtil(a.length, a);
        Arrays.stream(a).forEach(System.out::println);
    }
}


