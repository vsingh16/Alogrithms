/**
** https://www.educative.io/m/serialize-deserialize-binary-tree
** https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
** Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

** Approach : We can construct binary tree from pre order and inoder. Here also we can create these two arrays first and then serialise arrays.
** We can further optimise this by only taking pre order but in pre order insert -1, or some invalid node value to represent null.
** So while serialising , there will be 2 cases.
** node will be null , -1 else push node.data in array

** WHile Deserialising: case 1, -1, null node
else create node with data

Time Complexity :O(n)
Space Complexity :O(n)
**/

public class Codec {
        
    List<Integer> list;
    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       list = new ArrayList();
       serializeUtil(root);
       StringBuilder sb =  new StringBuilder(); 
       for(int data :list){
           sb.append(data);
           sb.append(",");
       } 
       //System.out.println("Pre:"+ sb.toString());   
       return sb.toString(); 
    }
    
    private void serializeUtil(TreeNode root) {
      
        if(root == null){
            list.add(-99999);
        }else{
            list.add(root.val);
            serializeUtil(root.left);
            serializeUtil(root.right);
        }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String pre[] = data.split(",");        
        index = 0;
        return deserializeUtil(pre);
    }
    
    private TreeNode deserializeUtil(String[] pre) {
        
        String str = pre[index++];
        int  data = Integer.parseInt(str);
        if(data == -99999){
            return null;
        }
        TreeNode node = new TreeNode(data);        
        node.left = deserializeUtil(pre);
        node.right = deserializeUtil(pre);       
        return node;
                
    }
}
