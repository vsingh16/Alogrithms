/**
** https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree
** Find the distance between two keys in a binary tree, no parent pointers are given.
** The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.
** Approach : Find LCA first and then find distance b/w LCA and Node A.
** Then b/w LCA and Node B.
** x + y - 2 becuase root node is repated and x includes source root.
** Time Complexity : O(n)
** Space Complexity: O(h) , stack recurive call
**/

class GfG {
    
    int findDist(Node root, int a, int b) {
        Node lca = LCA(root, a, b);
        int x = findDistance(lca, a);
        int y = findDistance(lca, b);
        return x + y - 2;
    }
    
    int findDistance(Node source, int destination){
        
        if(source == null){
            return 0;
        }
        
        if(source.data == destination){
            return 1;
        }
        
        int left = findDistance(source.left, destination);
        int right = findDistance(source.right, destination);
        if(left != 0){
            return 1 + left;
        }else if(right != 0){
            return right + 1;
        }
        
        return 0;
    }
    
    Node LCA(Node root, int n1, int n2)
	{
       if(root == null){
           return null;
       }
       
       if(root.data == n1 || root.data == n2){
        return root;   
       }
       
       Node left = LCA(root.left, n1, n2);
       Node right = LCA(root.right, n1, n2);
       if((left!= null && right !=null)){
           return root;
       }
       
       if(left != null){
           return left;
       }else if(right != null){
           return right;
       }
        
        return null;
    }
}
