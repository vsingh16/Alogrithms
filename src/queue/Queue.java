/**
Like Stack, Queue is a linear structure which follows a particular order in which the operations are performed. The order is First In First Out (FIFO).  A good example of queue is any queue of consumers for a resource where the consumer that came first is served first.
The difference between stacks and queues is in removing. In a stack we remove the item the most recently added; in a queue, we remove the item the least recently added.

Operations on Queue:
Mainly the following four basic operations are performed on queue:

Enqueue: Adds an item to the queue. If the queue is full, then it is said to be an Overflow condition.
Dequeue: Removes an item from the queue. The items are popped in the same order in which they are pushed. If the queue is empty, then it is said to be an Underflow condition.
Front: Get the front item from queue.
Rear: Get the last item from queue.

Time Complexities of all operation is O(1).
https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/

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


class MyQueue {

    int front, rear;
	int size;
	int arr[];

    MyQueue(s)
	{
		size = s;
		arr[] = new int[size];
		front= -1;
		rear=-1;
	}
	
	 boolean isFull() 
    { 
        return (rear == size -1); 
    } 
	
	// Queue is empty when size is 0 
    boolean isEmpty() 
    { 
        return (front == -1) || front > rear; 
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
		rear ++;
		arr[rear] = x;			
	    
	} 

    /* The method pop which return the 
       element poped out of the queue*/
	int deQueue()
	{
		if(isEmpty()){
			return ;
		}
		int x = arr[front];
		front --;
		return x;		
	} 
}
