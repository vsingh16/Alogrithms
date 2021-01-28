/**
Given a string of length N, find the length of the smallest sub-string consisting of maximum distinct characters. Note : Our output can have same character.
Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"

Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"

https://www.geeksforgeeks.org/length-smallest-sub-string-consisting-maximum-distinct-characters/
https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1#

This problem can be reduced to https://github.com/vsingh16/Alogrithms/blob/master/src/string/MinWindowSubString.java
What we need to do is populate ptr_hash i.e distinct charcters of Str
Time Complexity: O(n)
Space Complexity: O(1)
**/
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Compute obj = new Compute();
            System.out.println(obj.findSubString(str).length());
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Compute {
    public String findSubString( String str) {
        // populate ptr_hash i.e distinct characters only
        
        int ptr_hash[] = new int[256];
        int ptrLength = 0;
        for(int i=0;i<str.length();i++){
            //check so that count does not increase more than 1 
            //to cater distinct elements only
            if(ptr_hash[str.charAt(i)] < 1){
                ptr_hash[str.charAt(i)] = 1;
                ptrLength++;
            }
        }
        
        int str_hash[] = new int[256];
        int count =0;
        int start=0, startIndex=-1;
        int minLength = Integer.MAX_VALUE;
        for(int j=0;j<str.length();j++){
            
            str_hash[str.charAt(j)]++;
            if(str_hash[str.charAt(j)] <= ptr_hash[str.charAt(j)]){
                count++;
            }
            
            if(count == ptrLength){ //window found, now we need to minimize it
                
                while(ptr_hash[str.charAt(start)] == 0 || str_hash[str.charAt(start)] > ptr_hash[str.charAt(start)]){
                    if(str_hash[str.charAt(start)] > ptr_hash[str.charAt(start)]){
                        str_hash[str.charAt(start)]--;
                    }
                    start++;
                }
                
                int len = j - start + 1;
                if(len<minLength){
                    minLength = len;
                    startIndex = start;
                }
            }
        }
        
        if(startIndex == -1){//not found
            return "";
        }
        
        return str.substring(startIndex,startIndex+minLength);
    }
}
