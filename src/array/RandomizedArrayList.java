/**
https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/

Design a data structure that supports the following operations in Θ(1) time.

insert(x): Inserts an item x to the data structure if not already present.

remove(x): Removes an item x from the data structure if present.
search(x): Searches an item x in the data structure.

getRandom(): Returns a random element from current set of elements

https://leetcode.com/problems/insert-delete-getrandom-o1/

Approach: We can do insert, delete and search in hashmap in O(1) time
The only challenge is that we can't apply random fun in hash map becuase its size is not fixed and for random index = size()% ranom()
Hence we take array list(size) and in map we maintain element ---> index

insert, do map lookup if element found then return false else insert element in arraylist and add entry to map
remove: do map lookup, if element not found then return, else get index from map and swap this element with array list last element.
Swapping is done because we can remove last element in O(1) time. remove entry from map and update last index entry
search: simply get index from map and return.
getRandom() : find random index wiht array list size and return element at that position.

**/



import java.util.*; 
import java.lang.*;
  
import java.util.*;

class RandomizedSet {

    private List<Integer> arrayList;
    private Map<Integer,Integer> map;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        arrayList = new ArrayList();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if (map.containsKey(val)) {
            return false;
        }
         
        int index = arrayList.size();
        arrayList.add(val);
        map.put(val, index);
         
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if (!map.containsKey(val)) {
            return false;
        }
         
        map.remove(val);
        
        int indexRemove = map.get(val);
        int tail = arrayList.get(arrayList.size() - 1);
         
        swap(indexRemove, arrayList.size() - 1);      
        arrayList.remove(arrayList.size() - 1); 
         map.put(tail, indexRemove);
         
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
         if (arrayList.isEmpty()) {
            return 0;
        }
         
        int index = random.nextInt(arrayList.size());
         
        return arrayList.get(index);
    }
    
    private void swap(int i, int j) {
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j)); //keep in mind while set() is used to place elment at index . add() is used to add element.
        arrayList.set(j, temp);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
