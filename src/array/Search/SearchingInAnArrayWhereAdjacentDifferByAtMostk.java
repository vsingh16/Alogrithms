/**
** https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/
** A step array is an array of integers where each element has a difference of at most k with its neighbor.
** Given a key x, we need to find the index value of x if multiple-element exist to return the first occurrence of the key.
** Input : arr[] = {4, 5, 6, 7, 6}
           k = 1
           x = 6
Output : 2
The first index of 6 is 2.

Input : arr[] = {20, 40, 50, 70, 70, 60}  
          k = 20
          x = 60
Output : 5
The index of 60 is 5
** Approach 1: Traverse and check if(a[i] == x). Time Complexity: O(n)
** Approach 2: Since array has a special property adj = a[i] + k, we can find (x-a[i])/k and move steps else min take 1 step. Time Complexity: O(n), Space: O(1)
** https://www.youtube.com/watch?v=KtrAWsfyBaA&t=252s
**/

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int search (int a[], int n, int x, int k) {
        //Complete the function
        
        int i=0;
        while(i<n){
            
            if(a[i] == x){
                return i;
            }
            
            
            i = i + Math.max(1, Math.abs(a[i] - x) / k);
            
        }
        
        return -1;
        
    }
    
    
}
  
