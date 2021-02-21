/**
https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
1->2->34->5, n = 2, output = 4

Approach: we know with recursion we can move till end and then while returning we can just have counter.
Time Complexity : O(n)
**/

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class GfG
{
    
    int counter = 0;
    int result = -1;
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
        if(head == null){
            return -1;
        }
        return getNthFromLastHelper(head, n);
        
    }
    
    int getNthFromLastHelper(Node node, int n)
    {
        
        if(node == null){
            return 0;
        }
         
       getNthFromLastHelper(node.next, n);
       counter++;
       //System.out.println("Counter : "+ counter +"Node : "+ node.data);
       if(counter == n){
           result = node.data;
       }
    
      return result;
    }
}
