/**
** https://www.geeksforgeeks.org/check-mirror-n-ary-tree/
** Since it is not binary tree, we will have n no of children.
** Approach : We can enhance mirror tree queue method.
** Time Complexity :O(n)
** Space Complexity :O(n)
**/

Class TreeNode{
	private int data;
	List<TreeNode> children;
	
}

class Soltuion{

//Time Complexity : O(n),Space Complexity : O(n)
    public Boolean isMirrorIterative(Node root1, Node root2) {

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {

            Node node1 = q1.poll();
            Node node2 = q2.poll();

            if (node1 == null && node2 == null) {
                return true;
            } else if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.data != node2.data) {
                return false;
            } else {
		for(int i=0;i<node1.children.size();i++){
			q1.offer(node1.children.get(i));
		}		

                for(int i=node2.children.size-1;i>=0;i--){
			q2.offer(node2.children.get(i));
		}
            }
        }

        return true;

    }
