package com.macquarie.shiner.batch.gcs.tasklet;

import java.util.Stack;

/**
 * @author vsingh16
 */
public class QueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack();
        stack2 = new Stack<>();
    }

    public void enQueue(Integer element) {
        stack1.push(element);
    }

    public Integer dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            int stack1Size = stack1.size();
            while (stack1Size > 1) {
                stack2.push(stack1.pop());
                stack1Size--;
            }

            return stack1.pop();
        }

    }

    public static void main(String[] args) {
        QueueUsingStack qs = new QueueUsingStack();
        qs.enQueue(1);
        qs.enQueue(2);
        qs.enQueue(3);

        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());

    }

}
