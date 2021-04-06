/**
** https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
** Write a function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7. 
**                               1
**                      2                 3
**                7          6        4       5
** Ouput: 1, 2, 3, 4, 5, 6, 7
** Time Complexity : O(n)
** Space Complexity : O(n)
** Approach : Take two stack. Stack 1-> push right,left . Stack 2-> push left,right
**/
class Spiral
{
      ArrayList<Integer> findSpiral(Node root) 
      {
           Stack<Node> stack1 = new Stack();
           Stack<Node> stack2 = new Stack();
           ArrayList<Integer> result = new ArrayList();
           
           if(root != null){
               stack1.push(root);
           }
           
           while(!stack1.isEmpty() || !stack2.isEmpty()){
               
               while(!stack1.isEmpty()){
                   Node temp = stack1.pop();
                   result.add(temp.data);
                   if(temp.right!=null){
                       stack2.push(temp.right);
                   }
                   
                   if(temp.left!=null){
                       stack2.push(temp.left);
                   }
               }
               
               while(!stack2.isEmpty()){
                   Node temp = stack2.pop();
                   result.add(temp.data);
                   if(temp.left!=null){
                       stack1.push(temp.left);
                   }
                   
                   if(temp.right!=null){
                       stack1.push(temp.right);
                   }
                   
               }
           }
           
           return result;
      }
}

