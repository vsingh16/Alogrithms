/**
** Ref: https://leetcode.com/problems/implement-queue-using-stacks/description/
** https://www.youtube.com/watch?v=sFvP5Ois0CE&t=165s. Apna College
** 
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Approach:
Push(): Simply insert
Pop(): We have to reverse all elements in stack1. check is stack2 has element pop from stack2. if not copy form stack1 to stack2
peek(): check is stack2 has element peek from stack2. if not copy form stack1 to stack2
**/

  private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public int peek() {

        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        return stack2.peek();
    }

    public boolean empty() {

        return stack1.empty() && stack2.empty();
    }
