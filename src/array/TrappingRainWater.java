/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Input: arr[]   = {2, 0, 2}
Output: 2

Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7

Approach:
Water can be trapped b/w two blocks only, so if n<3, return 0;

Water stored at ith poistion : first fine max possible value at its left
the find max value towards its right. then take min of them
water at ith = MIN(LeftMax[i], rightMax[i]) - a[i]
https://www.geeksforgeeks.org/trapping-rain-water/
https://www.youtube.com/watch?v=XqTBrQYYUcc


Method 1: Brute Force Approach
traverse array, at each index i, find leftmax and right max with one inner loop
Time Complexity : O(n^2)
Space Complexity : O(1)

Method 2: Maintain two array leftMax[] and rightMax[]
Time Complexity : O(n)
Space Complexity : O(n)

Method 3: if we plot fun : water[i] = Min(leftMax[i], rightMax[i]) - a[i]
Whenever we have min/max problem in left and right, either two pointer approach or binary serach will work.
l=0, r = n-1
case 1: if(lmax[l] < rmax[r]) // we have two index l : r
at l: value of lmax we know and value of rmax will be either rmax[r] or it can go high and hnce we can say that at l position, min = lmax
at r: value of rmax is rmax[r] and value of lmax will be either lmax[l] or it will go high and hence it can be less than, equal or greater than rmax[r], so we are not certain

case 2: if(lmax[l] > rmax[r]) // we have two index l : r
at r: value of rmax we know and value of lmax will be either lmax[r] or it can go high and hence we can say that at r position, min = rmax
at l: value of lmax is lmax[l] and value of rmax will be either rmax[l] or it will go high and hence it can be less than, equal or greater than lmax[l], so we are not certain

Time Complexity : O(n)
Space Complexity : O(n)

// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Trap obj = new Trap();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Trap{
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
	// Time Complexity : O(n)
	//Space Complexity: O(n)
    static int trappingWater(int arr[], int n) { 
        
        // find left max at each ith position
    int leftMax[] = new int [n];
    leftMax[0] = arr[0];
    for(int i=1;i<n;i++){
        leftMax[i] = Math.max(leftMax[i-1],arr[i]);
    }
    
    // find right max at each ith position
    int rightMax[] = new int [n];
    rightMax[n-1] = arr[n-1];
    for(int i=n-2;i>=0;i--){
        rightMax[i] = Math.max(rightMax[i+1],arr[i]);
    }
    
    int result = 0;
    for(int i=0;i<n;i++){
        result += (Math.min(leftMax[i],rightMax[i]) - arr[i]);
    }
    
    return result;
        
    } 
    
    //Method 3
    static int trappingWater3(int arr[], int n) { 
        
        //Warer can be hold b/w two blocks
        if(n<3){
            return 0;
        }        
        
        int l=0, r = n-1;
        int lmax = arr[l];
        int rmax = arr[r];
        int result =0;
        while(l <= r){
            lmax = Math.max(lmax,arr[l]);
            rmax = Math.max(rmax,arr[r]);
            int min;
            if(lmax < rmax){
                min = lmax;//hence we can calculate at l position
                result = result + (min - arr[l]);
                l++;
            }else{
                min = rmax;//hence we can calculate at l position
                result = result + (min - arr[r]);
                r--;
            }
        }
        
        return result;
        
    } 

}



**/
