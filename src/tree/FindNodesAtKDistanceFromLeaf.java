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

   // { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currrNode = q.remove();
        
              // Get the currrent node's value from the string
              String currrVal = s[i];
        
              // If the left child is not null
              if(!currrVal.equals("N")) 
              {
        
                  // Create the left child for the currrent node
                  currrNode.left = new Node(Integer.parseInt(currrVal));
        
                  // Push it to the queue
                  q.add(currrNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currrVal = s[i];
        
              // If the right child is not null
              if(!currrVal.equals("N")) 
              {
        
                  // Create the right child for the currrent node
                  currrNode.right = new Node(Integer.parseInt(currrVal));
        
                  // Push it to the queue
                  q.add(currrNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int k = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.printKDistantfromLeaf(root,k));
            t--;
        }
    }
}


// } Driver Code Ends


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
