/**
** Find min and max in an array
** eg : {10,4,1,2,80}.
** min = 1, max = 80
** Appraoch 1: Sort, min = a[0] and max = a[n-1] , Time Complexity : O(nlogn)
** Approach 2: Min = a[0], Max = a[0], iterate afterwards in array, if a[i] < min, min = a[i]
** a[i] > max, max = a[i]
** Time Complexity: O(n)
** https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
**/

class Solution
{ 
  //Time Complexity: 1 + 2*(n-2)
    public static int findSum(int a[],int n) 
    {
       
       int min, max;
       if(n == 1){
           min = a[0];
           max = a[0];
       }else {
           
           if(a[0]<a[1]){
               min = a[0];
               max = a[1];
           }else{
               min = a[1];
               max = a[0];
           }
        
        for(int i=2;i<n;i++){
            if(min>a[i]){
                min = a[i];
            }
            
            if(max<a[i]){
                max = a[i];
            }
            
        }
           
       }   
           
       
       
       return min + max;
       
       
    }
}

