/**
** https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
** Given an unsorted array of size n. Array elements are in the range of 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.
** There are multiple approaches to solve this problem.
** Approach 1: Bit Manipulation.
** We know if we apply xor operations, it will remove duplicates becuase  xor of same bit  = 0. xor of odd bit(diff bit) = 1
** We will apply xor on all elements. This will result in xory.
** But till now we dont know separate value of x and y.
** We can find rsb of xory.  Then we can classify elements in two categories where either bit corresponding to rsb is 0 or 1.
** RSB of x = x & x 2s complement (2s complement = -x)
** With above approach we can find separate x and y but we dont know which one is missing and duplicate.
** we can traverse array one more time and put counter. If couter ==0 , then x is missing and y is duplicate else vice versa.
** Time Complexity: O(n) && Space Complexity: O(n)
** https://www.youtube.com/watch?v=XcSr6TIMl7w&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=3 : Prepcoding
** https://www.youtube.com/watch?v=pnx5JA9LNM4&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=9
** 
**/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int a[], int n) {
        // code here
        
        int xory = 0;
        for(int i=0;i<n;i++){
            xory = xory ^ a[i];
        }
        
        for(int i=1;i<=n;i++){
            xory = xory ^ i;
        }
        
        //find rsb.
        int rsb = xory & (-xory);
        
        int x = 0,y = 0;
        for(int i=0;i<n;i++){
            if((a[i] & rsb) == 0){
                x = x ^ a[i];
            }else{
                y = y ^ a[i];
            }
        }
        
        for(int i=1;i<=n;i++){
            if((i & rsb) == 0){
                x = x ^ i;
            }else{
                y = y ^ i;
            }
        }
        
        int c=0;
        for(int i=0;i<n;i++){
            if(a[i] == x){
                c++;
            }
        }
        int result[] = new int[2];
        if(c == 0){
            //x is missing && y is duplicate
            result[0] = y;
            result[1] = x;
        }else{
            //x is duplicate && y is missing
            result[0] = x;
            result[1] = y;
        }
        
        return result; 
    }
}
