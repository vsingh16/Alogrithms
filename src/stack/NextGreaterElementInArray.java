/**
https://www.geeksforgeeks.org/next-greater-element/

Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider next greater element as -1. 

Examples: 

For an array, the rightmost element always has the next greater element as -1.
For an array which is sorted in decreasing order, all elements have next greater element as -1.
For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
https://www.youtube.com/watch?v=rSf9vPtKcmI

Approach : Iterate array, if a[i] < stack.peek() push
but if it is greater print ans pop elements from stack until stack is empty or if this greater condition false.

But to print result in correct order, we should iterate array from right.
we need to do three things.
1) if stack.peek() <= a[i] , pop
2) print result i.e a[i] ---> stack.peek()
3) push a[i]

Time Complexity: O(n)
Please check youtube video link on time complexity analysis.
**/

// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new solve().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class solve{
    public static long[] nextLargerElement(long[] arr, int n) { 
    
     long result[] = new long[n];
     result[n-1] = -1;
     Stack<Long> stack = new Stack();
     stack.push(arr[n-1]);
     for(int i=n-2;i>=0;i--){
        
        //look for smaller elements and pop them
        while(!stack.empty() && stack.peek() <= arr[i] ){
            stack.pop();
        }
        
        if(stack.empty()){
            result[i] = -1;
        }else{
            result[i] = stack.peek();    
        }
        
         stack.push(arr[i]);
     }
    
     return result;
    } 
}
