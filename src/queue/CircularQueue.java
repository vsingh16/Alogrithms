/**
Circular Queue: The disadvantage with queue is that when after inserting elements we dequeue, front pointer increases and some
spaces remain vacant.
Circular Queue is a linear data structure in which the operations are performed based on FIFO (First In First Out)
principle and the last position is connected 
back to the first position to make a circle. It is also called ‘Ring Buffer’. 

Time Complexities of all operation is O(1).
https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/

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


// { Driver Code Starts
import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
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


class MyCircularQueue {

    int front, rear;
	int size;
	int count; //count will keep count of elements in queue
	int arr[];

    MyCircularQueue(s)
	{
		size = s;
		arr[] = new int[size];
		front= -1;
		rear=-1;
		count = 0;
	}
	
	 boolean isFull() 
    { 
        return (count == size); 
    } 
	
	// Queue is empty when size is 0 
    boolean isEmpty() 
    { 
        return count<1 ; 
    } 
	
	/* The method push to push element
	   into the queue */
	void enQueue(int x)	
	{		
		if(isFull()){
			return ;
		}
		//first time insertion
		if(rear  == -1){			
			front ++;			
		}
		rear  = (rear + 1) % size;
		arr[rear] = x;	
		count ++;		
	    
	} 

    /* The method pop which return the 
       element poped out of the queue*/
	int deQueue()
	{
		if(isEmpty()){
			return ;
		}
		int x = arr[front];
		front = (front+1) % size; 
		count --;
		return x;		
	} 
}
