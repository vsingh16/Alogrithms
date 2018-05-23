package dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 25-Apr-18.
 * <p>
 * https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
 * <p>
 * Approach: we need to traverse from Node 1 to N
 * and for ith node, left = count(1 to i-1)
 * right = count(i+1,n)
 * <p>
 * if we want to calculate the count, we can see this if forming catalan number pattern
 * &
 * if we want to print them, Hold a list to store nodes in it.
 */
public class AllPossibleBSTs {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public int numTrees(int A) {
        return catalanDyn(A);
    }

    private static int catalanDyn(int n) {
        //int res = 0;
        int res[] = new int[n + 1];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            res[i] = 0;
            for (int j = 0; j < i; j++)
                res[i] += res[j] * res[i - j - 1];
        }

        return (int) (res[n] % (Math.pow(10, 9) + 7));
    }

    public static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static List<Node> constructTrees(int m, int n) {
        List<Node> result = new ArrayList<>();
        if (m > n) {
            //adding null is necessary else the ith element will not be added in the result list
            result.add(null);
            return result;
        }

        for (int i = m; i <= n; i++) {
            List<Node> ls = constructTrees(m, i - 1);
            List<Node> rs = constructTrees(i + 1, n);
            for (Node l : ls) {
                for (Node r : rs) {
                    Node curr = new Node();
                    curr.data = i;
                    curr.left = l;
                    curr.right = r;
                    result.add(curr);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Node> totalTrees = constructTrees(1, 3);
        totalTrees.forEach(node -> {
            preOrder(node);
            System.out.println();
        });
    }
}
