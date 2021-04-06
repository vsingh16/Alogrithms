package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vishal on 01-Jul-18.
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * Approach : Order Level Traversal or Breadth First Traversal requires us to print root first then its left and right children.
 * So we will take a queue and follows R P A (remove print add)
 * Time Complexity : O(n)
 * Space Complexity : O(n) // extra queue
 *
 Approach2: 
 https://leetcode.com/problems/binary-tree-level-order-traversal/
 https://www.youtube.com/watch?v=U7rLw0jXI0E
 * SOmetimes, we also need to track nodes at same level in Level Order Traversal
 * To do so, we need to  modify our approach1 a bit. At any time, elements in queue belongs to same level. So we will remove elements of a level together and then add.
 * Time Complexity : O(n)
 * Space Complexity : O(n) // extra queue
 */
public class LevelOrderTraversal {

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static class Tree {
        private Node root;

        public Tree(Node root) {
            this.root = root;
        }

        /**
         * Time Complexity : O(n)
         * As we will traverse all no nodes
         * <p>
         * Space Complexity : O(n)
         */
        public void levelTraversal() {

            Queue<Node> q = new LinkedList<>();
            //Root element
            if (root != null) {
                q.offer(root);
            }

            while (!q.isEmpty()) {
                Node node = q.poll();
                System.out.println(node.data);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            
        
        // Approach 2: Where we need to track elements at same level
        public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        
        if(root !=null){
            queue.add(root);
        }
        
        
        while(!queue.isEmpty()){
            // currently elements in queue are of same level
            List<Integer> levelResult = new ArrayList();
            //System.out.println("Size:" +queue.size());
            int children = queue.size(); // PS: loop will run as per children in a level
            for(int i= 0;i < children; i++){                
                TreeNode node = queue.poll();
                //System.out.println("Adding:" +node.val);
                levelResult.add(node.val);
                if(node.left != null){
                    queue.add(node.left);    
                }
                if(node.right != null){
                    queue.add(node.right);    
                }                                
            }
            result.add(levelResult);
        }
        
        return result;
    }

  }

        public static void main(String[] args) {
            Node root = new Node(1);
            Node second = new Node(2);
            Node third = new Node(3);
            Node fourth = new Node(4);
            Node five = new Node(5);
            Node six = new Node(6);
            Node seven = new Node(7);

            root.left = second;
            root.right = third;
            second.left = fourth;
            second.right = five;
            third.left = six;
            third.right = seven;

            Tree tree = new Tree(root);
            System.out.println("Level Order Traversal");
            tree.levelTraversal();

        }
    }
}
