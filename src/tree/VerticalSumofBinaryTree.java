/**
** https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
** Given a Binary Tree, find the vertical sum of the nodes that are in the same vertical line. Print all sums through different vertical lines.
**            1
**         2           3
**     4      5     6     7
**      The tree has 5 vertical lines
Vertical-Line-1 has only one node
4 => vertical sum is 4
Vertical-Line-2: has only one node
2=> vertical sum is 2
Vertical-Line-3: has three nodes:
1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3
=> vertical sum is 3
Vertical-Line-5: has only one node 7
=> vertical sum is 7

** Approach1 : We can take a treemap where distance will be key, on left, d-1, on right, d +1
** Time Complecity :O(n)
** Space Complexity : O(vertical lines)

** Approach 2: This can further optimized if we take, doubly linked list, on left, previous on right, next
** Since map has more buckets than required internally,  Doubly linked list will only have nodes O(n)
** https://www.geeksforgeeks.org/vertical-sum-in-binary-tree-set-space-optimized/
**/

class Solution{
    
     Map<Integer,Integer> map;
    public ArrayList <Integer> verticalSum(Node root) {
        map = new TreeMap();
        return verticalSumUtil(root,0);
    }
    
    public ArrayList <Integer> verticalSumUtil(Node root,Integer distance) {
        
        if(root == null){
            return new ArrayList();
        }
        
        if(map.containsKey(distance)){
            int sum = map.get(distance) + root.data;
            //System.out.println("Updating Distance :"+ distance + " Value:" + sum);    
            map.put(distance, sum);
        }else{
            //System.out.println("Inserting Distance :"+ distance + " Value:" + root.data);    
            map.put(distance, root.data);
        }
        
        verticalSumUtil(root.left,distance - 1);
        verticalSumUtil(root.right,distance + 1);
        
        return printResult();
    }
    
    private ArrayList<Integer> printResult(){
        ArrayList<Integer> result = new ArrayList();
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
          result.add(entry.getValue());      
        }
          
           
        return result;
    }
}
