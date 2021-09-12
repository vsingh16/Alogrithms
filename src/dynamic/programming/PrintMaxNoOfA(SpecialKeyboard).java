/**
** https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/#
** This is a famous interview question asked in Google, Paytm and many other company interviews. 
Below is the problem statement.

Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it
                 after what has already been printed. 

If you can only press the keyboard for N times (with the above four
keys), write a program to produce maximum numbers of A's. That is to
say, the input parameter is N (No. of keys that you can press), the 
output is M (No. of As that you can produce).
** Approach : 
** N = 1, We can only press A, result = 1
** N = 2, We can only press A, result = 2
** N = 3, We can only press A, result = 3
** N = 4, We can press A 4 times or A + (Ctrl A, C,V) = 2, result = 4
** N = 5, We can press A 5 times or AA + (Ctrl A, C,V) = 4 or A + (Ctrl A, C,V,V) = 3, result = 5
** N = 6, We can press A 6 times or AAA + (Ctrl A, C,V) = 6 or AA + (Ctrl A, C,V,V) = 6 or A + (Ctrl A, C,V,V,V) = 4, result = 6
** We can conculde till N = 6 ,max A we can get is N
** Now lets take N = 10
** 7(A) + (CTRL A, C, V) * 2= 14
** 6(A) + (CTRL A, C, V,V) * 3= 18
** 5(A) + (CTRL A, C, V,V,V) * 4= 20
** 4(A) + (CTRL A, C, V,V,V,V) * 5= 20
** 3(A) + (CTRL A, C, V,V,V,V,V) * 6= 18
** 2(A) + (CTRL A, C, V,V,V,V,V,V) * 7= 14
** 1(A) + (CTRL A, C, V,V,V,V,V,V,V) * 8= 8
** We can conculde that f(n) when n >6, Max(f(x) * (n-1-x)), x = n-3 to 1
**/

//Time Complexity: O(N^N)
 int optimalKeys(int N){
   
   if(N<=6){
     return N;
   }
        
   for(int x=1;x<=N-3;x++){
     result = Math.max(result,optimalKeys(x) * (n-1-x));
   }
   
   return result;     
 }


/**
** Dynamic Programming, store already calculated results.
** Time Complexity: O(N*N)
** Space Complexity: O(N)
**/
 int optimalKeys(int N){
        
        int dp[] = new int[N+1];  
        for(int i=1;i<=N;i++){
            if(i<=6){
                dp[i] = i;    
            }else{
            for(int x=1;x<=N-3;x++){
                dp[i] = Math.max(dp[i], dp[x]*(i-x-1));
            }      
            }
        }
        
        return dp[N];
    }
