/**

https://www.geeksforgeeks.org/sum-of-two-linked-lists/
https://www.youtube.com/watch?v=tK4eez3syAQ


Approach: we take pv1 & pv2 , representing size of linked lists.
if pv1 > pv2, it means there are at diff position and we can't add them, so pv1.next else pv2.next
If pv1 == pv2, we can add them so pv1.next, pv2.next
We use recursion to start adding from extreme right.
Time Complexity:O(n+m)

Another solution to this problem: https://github.com/vsingh16/Alogrithms/blob/master/src/linklist/AddTwoLinkedListStraight.java

**/

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    
    static Node result = null;
    
    //Insert Node in the start of linked list
    static Node addFirst(int data){
        
        Node newNode = new Node(data);
        if(result == null){
            result = newNode;
        }else{
            newNode.next = result;
            result = newNode;
        }
        //System.out.println("New node in result: "+ result.data);
        return result;
    }
    
    static int addHelper(Node first, int pv1, Node second, int pv2){
        if(first == null || second == null){
            return 0;
        }
        //System.out.println("First Node:"+ first.data + "First Node Pos:"+ pv1 + "Second Node:"+ second.data + "Second Node Pos:"+ pv2);
        
        int oc = 0;
        int sum = 0;
        if(pv1 > pv2){
            oc = addHelper(first.next, pv1-1, second, pv2);
            //System.out.println("Adding");
            //System.out.println("First :"+ first.data + "Carry:"+oc + "Sum:"+sum);
            sum = first.data + oc;
        }else if(pv2 > pv1){
            oc = addHelper(first, pv1, second.next, pv2-1);
            //System.out.println("Adding");
            //System.out.println("Second:"+ second.data+"Carry:"+oc + "Sum:"+sum);
            sum = second.data + oc;
        }else{
            oc = addHelper(first.next, pv1-1, second.next, pv2-1);
            //System.out.println("Adding");
            //System.out.println("First :"+ first.data + "Second:"+ second.data+"Carry:"+oc + "Sum:"+sum);
            sum = first.data + second.data + oc;
        }
        int nd = sum %10;
        int nc = sum / 10;
        addFirst(nd);
        return nc;
    }
    
    static int size(Node node){
        
        int counter = 0;
        while(node!=null){
            node = node.next;
            counter++;
        }
        
        return counter;
        
    }
    
    static void printList(Node node){
        
        while(node!=null){
            System.out.println("Node:--->"+node.data); 
            node = node.next;
        }
        
    }
    
    static Node addTwoLists(Node first, Node second){
        // code here
        int pv1 = size(first);
        int pv2 = size(second);
        //System.out.println("First list size :"+ pv1);
        //System.out.println("Second list size :"+ pv2);
        result = null;
        int oc = addHelper(first, pv1, second, pv2);
        
        if(oc > 0){
        addFirst(oc);    
        }
        
        // return head of sum list
        return result;
    }
}
