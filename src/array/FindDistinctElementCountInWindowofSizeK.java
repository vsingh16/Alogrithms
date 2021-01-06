import java.util.*;

/**
* https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
*
* Time Complexity : O(n) , Since we traversed array of size n only one time.
* Space Complexity :O(n), We need hashmap to maintain count.
*
**/
public class Main 
{ 
    // Counts distinct elements in array window of size k 
    static void distinctElement(int a[], int k) 
    { 
      Map<Integer,Integer> map = new HashMap();
      
      int distinctCount = 0;
        //first window of size k
        for(int i=0;i<k;i++){
          if(map.get(a[i]) == null){
              map.put(a[i],1);
              distinctCount++;
          } else {
            map.put(a[i],map.get(a[i])+1);
          }
        }
        
        System.out.print(distinctCount);
        //for others window
        for(int i=k;i<a.length;i++){
           //on sliding window, there will be two things

           //New element in window : a[k]
           //when it is not there
           if(map.get(a[i]) == null){
              map.put(a[i],1);
              distinctCount++;
          } else {//when it is already present
            map.put(a[i],map.get(a[i])+1);
          }

          //We need to remove element a[i-k]
          //if its count = 1
           if(map.get(a[i-k]) == 1){            
              map.remove(a[i-k]);
              distinctCount--;
          } else {//when count > 1
            map.put(a[i-k],map.get(a[i-k])-1);
          }
          System.out.print(" "+distinctCount);           
        }
        
    } 
      
    public static void main(String args[]) 
    { 
         int array[] = {1, 2,1, 3, 4, 2, 3};
         int k = 4; 
            
         distinctElement(array, k); 
    } 
} 
