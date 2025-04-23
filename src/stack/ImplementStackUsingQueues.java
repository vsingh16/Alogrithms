/**
** Ref: https://leetcode.com/problems/implement-stack-using-queues/description/
** https://www.youtube.com/watch?v=sFvP5Ois0CE&t=165s
** https://takeuforward.org/data-structure/implement-stack-using-single-queue/

** Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.

** Approach: Since Stack and queue are just opposite of each other, we have to do push() or pop() in O(n)
** push(): insert element in queue. Since in stakc it should be at first position, remove all elements before it from queue and insert back in queue.
** This way the element iserted in last will come first.
**/

class MyStack {

   private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }


  //O(n)
    public void push(int x) {

        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }

    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
