/**
** https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
** Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.
** Appraoch 
** We need to maintain order of characters.
** Now we can use Arraylist or LinkedList. But Linkedlist is a good choice as deletion can be done in LL in O(1) time.
** We will maintain repeating[26] array.
** If any chacter comes two times, repeating[ch] = true;
** We will only process chacr if it is repeating[ch] = false
** For its first occurence, we will append Node in LL.
** For second occurecne, we remove node form LL and repeating[ch] = true;
** Result i.e first non repeating char is always obtained from head of LL.
**/
class Solution
{
    private Node head;
    private Node tail;
    class Node{
        
        char ch;
        Node previous;
        Node next;
        
        public Node(char ch){
            this.ch = ch;
        }
    }    
        
    public Node insertAtLast(char ch){
            
            Node node = new Node(ch);
            //if list is empty
            if(head == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                node.previous = tail;
                tail = node;
            }
        return node;    
    }
        
        
    public void remove(Node node){
            
            if(head == null){
                return;
            }
            if(head == node){
                head = head.next;
            }if(tail == node){
                tail = tail.previous;
            }if(node.previous!=null){
                 node.previous.next = node.next;   
            }
            if(node.next != null){
                 node.next.previous = node.previous;   
            }
            
    }
    
    public String FirstNonRepeating(String A)
    {
        Node nodeArr [] = new Node[26];
        boolean repeated [] = new boolean[26];
        String result = new String();
        char charArr[] = A.toCharArray();
        for(int i =0;i<charArr.length;i++){
            
            int nodePos = charArr[i] - 'a';
            if(!repeated[nodePos]){
             
             if(nodeArr[nodePos] == null){
                nodeArr[nodePos] = insertAtLast(charArr[i]);
             }else{
                remove(nodeArr[nodePos]);
                nodeArr[nodePos] = null;
                repeated[nodePos] = true;
            }
               
            }
            if(head!=null){
                result += head.ch;
            }else{
                result += '#';
            }
        }
        
        return result;
    }
    
}
