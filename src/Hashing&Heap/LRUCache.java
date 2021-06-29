/**
** https://leetcode.com/problems/lru-cache/submissions/
** https://nehajirafe.medium.com/implementing-lru-cache-leetcode-82e90ce63c3f
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
                
         if(rear!=null){
            rear.next = node;
            node.previous = rear;                 
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
