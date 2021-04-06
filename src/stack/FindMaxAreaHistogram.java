/**

Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have same width and the width is 1 unit.
For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible rectangle possible is 12

https://www.youtube.com/watch?v=ZmnqCZp9bBs
https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

Apporoach: Stack gives us access to most recent element.
So just iterate, and store the index of elements.
push: stack.empty() || hist[stack.peek()] <= hist[i] and i++ //this means since the new element is greater than we can extend the area of elements in stack
else top = pop because we can't extend area . Note that we will calulate the area of top of stack becuase we know the elments below it are less, so this top can't contribute in area
of elemnts below it in stack.
if stack is empty:
area = hist[top] * i //becuase if stack is empty it means this element cant contribute in arae of all elements
else
area = hist[top] * (i- 1 - stack.peek()) // i - 1 becuase value of i is greate so exclude this in area and stack.peek() becuase this element is less so we will incude it in area 
calculation.


Time Complexity: O(n)

**/

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new solve().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class solve{
    
    // Function to calculate max rectangular area histogram
    // hist[]: input array
    // n: size of array
    public static long getMaxArea(long hist[], long n)  {
        // your code here
        Stack<Long> stack = new Stack<Long>();
        long maxArea = -1;
        long i=0;
        while(i<n){
            
            //push condition
            if(stack.empty() || hist[stack.peek().intValue()] <= hist[(int)i]){
                stack.push(i++);
            }else{
                
                //pop & calculate area
                long top = stack.pop();
                long area = stack.empty() ? (hist[(int)top] * i) : hist[(int)top] * (i - stack.peek() - 1);  
                maxArea = max(maxArea,area);
                
            }
            
        }
        
        while(!stack.empty()){
              long top = stack.pop();
              long area = stack.empty() ? (hist[(int)top] * i) : hist[(int)top] * (i - stack.peek() - 1);  
              maxArea = max(maxArea,area);
        }
        
        
        return maxArea;
    }
    
    private static long max(long a, long b){
        return a >b ? a:b;
    }
        
}
