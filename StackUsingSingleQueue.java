package com.macquarie.shiner.batch.gcs.tasklet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vsingh16
 */
public class StackUsingSingleQueue {

    private Queue<Integer> q;

    public StackUsingSingleQueue() {
        this.q = new LinkedList<>();
    }

    public void push(int x) {

        int s = q.size();
        q.offer(x);
        for (int i = 0; i < s; i++) {
            q.offer(q.poll());
        }

    }

    public int pop(){

        return q.poll();
    }

    public static void main(String[] args) {

        StackUsingSingleQueue stack = new StackUsingSingleQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());

        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
