/**
** https://www.geeksforgeeks.org/check-mirror-n-ary-tree/
** Since it is not binary tree, we will have n no of children.
** Approach : We can push elements of first tree in stack
** and second tree in queue, then we will compare if elements match,
** then it is mirror else not.
** Time Complexity :O(n)
** Space Complexity :O(n)
**/

Class TreeNode{
	private int data;
	List<TreeNode> children;
	
}

class Soltuion{

Stack<Integer> stack = new Stack();
Queue<Integer> queue = new LinkedList();
boolean isMirror(Node a, Node b){

  pushToStack(a,n1);
  addToQueue(b,n2);
  
  return isEqual(stack,queue);  
}

void pushToStack(Node root){

	if(root == null){
	   return; 
	}
	
	st.push(root.data);
	for(int i=0;i<root.children.size();i++){
		pushToStack(root.children[i])
	}
} 


void addToQueue(Node root){

	if(root == null){
	   return; 
	}
	
	queue.add(root.data);
	for(int i=0;i<root.children.size();i++){
		addToQueue(root.children[i])
	}
} 


boolean isEqual(stack,queue){
 
  While(!stack.isEmpty() && queue.isEmpty()){
      if(!stack.pop().equals(queue.dequeu())){
	    return false;
	  }
  }   
   
  if(!stack.isEmpty()){
  return false;
  } 
  
  if(!queue.isEmpty()){
  return false;
  } 
  
  return true;
}

}
