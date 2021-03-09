/**
** https://practice.geeksforgeeks.org/problems/node-at-distance/1#
** https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
** Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node. 
** Here the meaning of distance is different from previous post. Here k distance from a leaf means k levels higher than a leaf node. 
** For example if k is more than height of Binary Tree, then nothing should be printed. Expected time complexity is O(n) where n is the number nodes in the given Binary Tree.
**
** Approach: We will maintain two arrays, ancestor[], and visited[]
** At evry node, we will add node to both array.
** On leaf node, after adding node to above arrays, we check if it is not in visited array, print result.
** Time Complexity : O(n)
** Space Complexity : O(h) // height of tree becuase we can have max h no. of elements at max in arrays.
**/

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution{
    
    int ancestor[] = new int[1000]; // we can calculate height of tree first and then initialize it.
    boolean visited[] = new boolean[1000];
    int result = 0;
    int counter = 0;
    
    int printKDistantfromLeaf(Node root, int k){
             
        return 
        printKDistantfromLeaf(root, k, ancestor, visited, counter);
    }
    
    int printKDistantfromLeaf(Node root, int k, int ancestor[], boolean visited[], int counter){
             
             if(root == null){
                 return 0;
             }
             
             ancestor[counter] = root.data;
             visited[counter] = false;
             
             //if leaf node & not in result
             if(root.left == null && root.right == null && (counter - k) >=0 && !visited[counter - k]){
                   result ++;
                   visited[counter - k] = true;
             }
             
             printKDistantfromLeaf(root.left, k, ancestor, visited, counter + 1);
             printKDistantfromLeaf(root.right, k, ancestor, visited, counter + 1);
             
             return result;
    }
    

}
