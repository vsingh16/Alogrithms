package com.macquarie.shiner.batch.gcs.service;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
public class BinaryTreeLCA {

    static class Tree {
        private Node root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    //Time Complexity:O(n) as we traverse whole tree once
    public static int findLCA(Tree t, int n1, int n2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        //if n1 or n2 is not present in tree
        if (!getPathToRoot(t.root, n1, list1) || !getPathToRoot(t.root, n2, list2)) {
            return -1;
        }

        int i;
        for (i = 0; i < list1.size() && i < list2.size(); i++) {

            if (list1.get(i) != list2.get(i)) {
                return list1.get(i - 1);
            }
        }

        return list1.size()>list2.size() ? list1.get(i-1) : list2.get(i-1);
    }

    private static Boolean getPathToRoot(Node root, int n, List<Integer> path) {

        if (root == null) {
            return false;
        }
        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (root.left != null && getPathToRoot(root.left, n, path)) {
            return true;
        }

        if (root.right != null && getPathToRoot(root.right, n, path)) {
            return true;
        }

        //if not found on left or right side it means this is not the path,so remove node from path
        path.remove(path.size() - 1);

        return false;

    }

    public static Tree createTree1() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Tree t = new Tree();
        t.root = node1;

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        return t;
    }

    public static void main(String[] args) {

        Tree t1 = createTree1();
        /**System.out.println(findLCA(t1,4,5));
        System.out.println(findLCA(t1,4,6));
        System.out.println(findLCA(t1,3,4));**/
        System.out.println(findLCA(t1,2,4));
    }
}


