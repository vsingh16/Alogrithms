/**
** https://leetcode.com/problems/lru-cache/submissions/
** https://nehajirafe.medium.com/implementing-lru-cache-leetcode-82e90ce63c3f
** LRU : Leat recently used. Cache means key, value, so Map is a good choice.
** Here we will be having a capcity of cache/map and once that capacity reaches,
** we need to remove LRU element in O(1) time. We know that doubly linked list provides 
** insetion and deletion in O(1) time. Map<key, Node> : Node will be reference of element
** in DLL. 
** Every time we get element from map, we need to remove element and add it to end of list.
** When capacity excceds , we need to remove element from begining of list.
** 
**/

class LRUCache {
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node front;
    private Node rear;
    
    class Node{
        
        private int key;
        private int value;
        private Node previous;
        private Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public void insertAtLast(Node node){
        
        node.previous = rear;              
        //PS: its necessary to set null to right of node as it is same node which we there in the mid
        //of list and pointing to some element.
        node.next = null;
        if(rear!=null){
            rear.next = node;           
         }         
         rear = node; 
        
        //single elemetn after insertion
        if(front == null){
            front = node;
        }    
    }
    
    public void remove(Node node){
        
      //list  is empty  
      if(front == null){
          return;
      }  
              
      //front element  
      if(front == node){
          front = front.next;          
      }
        
      //last element
      if(rear == node){
          rear = rear.previous;
      }  
       
      //mid element
      if(node.previous!=null){
         node.previous.next = node.next;  
      }
      if(node.next!=null){
         node.next.previous = node.previous;                            
      }        
    }
        
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            //remove and insert at last
            remove(node); 
            insertAtLast(node);  
            return node.value;
        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
          Node node = map.get(key);
          node.value = value;
          remove(node);           
          insertAtLast(node);    
        }else if(map.size() == capacity){        
             //evict from front
                map.remove(front.key);    
                remove(front);           
                Node node = new Node(key,value); 
                map.put(key,node);  
                insertAtLast(node);  
        }else{
           Node node = new Node(key,value);  
           map.put(key,node);              
           insertAtLast(node);  
        }
    }
} 


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
