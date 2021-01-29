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
  
public class Main 
{ 
   //My first Data Structure to perform all operations in O(1) Time
   ArrayList<Integer> array;   
   //My second Data Structure to perform all operations in O(1) Time
   HashMap<Integer, Integer>  hash; 
  
   public Main() 
   { 
       array = new ArrayList<Integer>(); 
       hash = new HashMap<Integer, Integer>(); 
   } 
  //Inserting value in data structure involve two operations
  //addition in the arraList and inserting entry in HashMap
   void insert(int num) 
   { 
      Integer index = hash.get(num);
      if(index != null){
          return ; //i.e element is already present in array list
      }
      
      array.add(num);
      hash.put(num, array.size()-1);
      
   } 
  //Removing element is Tricky and most imp 
   void remove(int num) 
   { 
      Integer index = hash.get(num);
      if(index == null){
          return ; //i.e element is not present
      }
      
      hash.remove(num);
      //swap num at index with last element, because we can delete last element in O(1) time
      int temp = array.get(index);
      int lastIndex = array.size() -1;
      array.add(index, array.get(lastIndex));
      array.add(lastIndex, temp);
      //remove lastIndex pos
      array.remove(lastIndex);
      
      //update index in map
      hash.put(array.get(index), index);
    } 
    //Returns the ransom element from array 
    int getRandom() 
    { 
     Random random = new Random();
     int index = random.nextInt(array.size());
     
     return array.get(index);
    } 
  
    Integer search(int num) 
    { 
      Integer index = hash.get(num);
      if(index == null){
          return -1; //i.e element is not present
      }
      
      return index;
    } 
    
    

  
public static void main (String[] args) 
{ 
    Main ds = new Main(); 
    ds.insert(12); 
    ds.insert(16); 
    ds.insert(14); 
    ds.insert(20);
    ds.insert(30);
    System.out.println(ds.search(30)); 
    ds.remove(14); 
    System.out.println(ds.search(20)); 
    System.out.println(ds.getRandom()); 
} 
} 
