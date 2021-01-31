/**
Stack is a linear data structure which follows a particular order in which the operations are performed. The order may be LIFO(Last In First Out) or FILO(First In Last Out).

Mainly the following three basic operations are performed in the stack:

Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.
Peek or Top: Returns top element of stack.
isEmpty: Returns true if stack is empty, else false.

Time Complexities of all operation is O(1).
https://www.geeksforgeeks.org/stack-data-structure-introduction-program/

**/

// { Driver Code Starts
import java.util.*;

import java.io.*;
import java.lang.*;

class GfG {

	public static void main(String args[])throws IOException
	{
// 		 Scanner sc = new Scanner(System.in);
// 		 int t=sc.nextInt();
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(read.readLine());
         
		 while(t>0)
		 {
			MyStack obj = new MyStack();
			int Q = Integer.parseInt(read.readLine());
			int k = 0;
			String str[] = read.readLine().trim().split(" ");
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = Integer.parseInt(str[k++]);
				if(QueryType == 1)
				{
					int a = Integer.parseInt(str[k++]);
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}



// } Driver Code Ends


/* You need to add code for functions 
   push() and pop() */
class MyStack{

    int top;
	int size;
	int arr[];

    MyStack(int s)
	{
		top = -1;
		size = s;
		arr = new int[size];
	}
	
	/* The method push to push element
	    into the stack */
    void push(int a)
	{
		//if stack is full throw overflow exception
		if(top == size){
			throw new RuntimeException("Oveflow");
		}
		top++;		
	    arr[top] = a;
	} 
	
    /* The method pop which return 
      the element poped out of the stack*/
	int pop()
	{   
	    //stack is empty
	    if(top == -1){
	        throw new RuntimeException("undeflow exception");
	    }
	    return arr[top--];
	}
	
	boolean isEmpty(){
		return top <0;
	}
	
	
	int peek(){
		
		if(isEmpty()){
	        throw new RuntimeException("undeflow exception");
	    }
	
	return	arr[top];
	}

}