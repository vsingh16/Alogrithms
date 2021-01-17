/**
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

Approach1: Brute Force, form all possible pairs with i, j two loops
Time Complexity : O(n^2)
Space Complexity : O(1)

Approach2: First Sort array, and then in array maintain indices of sorted elements.
Now this problem becomes of finding max diff i.e maxdiff = max - min
Time Complexity : O(nlogn)
Space Complexity : O(n)
https://www.youtube.com/watch?v=yKITDmQm0D4

Approach3:
Maintain two array. 
Left[] = storing index of min element on the left side of arr[i]
right[] = storing index of max element on the right side of arr[i]
Now find the diff b/w right[] - left[]
Time Complexity : O(n)
Space Complexity : O(n)
**/
// { Driver Code Starts
import java.io.*;
import java.util.*;

class Difference {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    MaxDifference obj = new MaxDifference();
		    
		    System.out.println(obj.maxIndexDiff(arr, n)); // print the result
		}
	}
}// } Driver Code Ends

class MaxDifference{
    
    // Function to find maximum difference of j-1
    // arr[]: input array
    // n: size of array
    static int maxIndexDiff3(int arr[], int n) { 
        
        //Base Case: We must have two elemengts atleast
        if(n<2){
            return -1;
        }
        
        // small element on left side
        int left [] = new int[n];
        left[0] = 0;
        for(int i=1;i<n;i++){
            if(arr[left[i-1]] > arr[i]){
                 left[i] = i ;
            }else{
                 left[i] = left[i-1] ;
            }
           
        }
        
        // big element om right side
        int right [] = new int[n];
        right[n-1] = n-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] > arr[right[i+1]]){
                 right[i] = i;
            }else{
                right[i] = right[i+1];
            }
        }
        
       int i=0,j=0;
       int maxDiff = -1;
       while(i < n && j<n){
           if(arr[left[i]] <= arr[right[j]]){
               if(right[j]-left[i] > maxDiff){
                   maxDiff = right[j]-left[i];
               }
               j++;
           }else{
               i++;
           }
       }
       
       return maxDiff;
    }
}

