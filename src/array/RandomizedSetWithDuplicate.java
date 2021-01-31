/**
This problem is similar to https://github.com/vsingh16/Alogrithms/blob/master/src/array/RandomizedArrayList.java
Only difference is that now we need to allo duplicates.

The naive approach is that we can have Map<Integer,List<Integer>> list to hold diff indexes of same no.
But the problem with list is that we won't be able to remove index which inserted first.
So with LinkedHasSet we can maintain order. and also to remove we can remove element but with list will remove by index but we need by element.

https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/submissions/
https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-getrandom-in-o1-with-duplicates/
http://buttercola.blogspot.com/2018/07/leetcode-381-insert-delete-getrandom-o1.html
**/

class RandomizedCollection {

    private List<Integer> arrayList;
    private Map<Integer,Set<Integer>> map;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
         arrayList = new ArrayList();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        boolean ans = false;
        arrayList.add(val);
        int newIndex = arrayList.size() - 1;
        Set<Integer> posSet = map.get(val);
        if(posSet == null){ //first time entry
            posSet = new LinkedHashSet();     
            ans = true;
        }
        posSet.add(newIndex);
        map.put(val,posSet);
    
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
         if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
         
        Set<Integer> posSet = map.get(val);
        int indexRemove = posSet.iterator().next();
        posSet.remove(indexRemove); 
        
        int tailPos = arrayList.size() - 1;        
        
        if(indexRemove < tailPos){ // when we have only one element
            int tail = arrayList.get(tailPos);
            swap(indexRemove, arrayList.size() - 1);      
                         
            //update map for tail element         
            map.get(tail).remove(tailPos);
            map.get(tail).add(indexRemove);
        }
        
        arrayList.remove(tailPos); 
                 
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
         if (arrayList.isEmpty()) {
            return 0;
        }
         
        int index = random.nextInt(arrayList.size());
         
        return arrayList.get(index);
    }
    
     private void swap(int i, int j) {
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
