package com.macquarie.shiner.batch.gcs.tasklet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vsingh16
 */
public class StackUsingQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(Integer element) {
        q1.offer(element);
    }

    public Integer poll() {
        if (q1.isEmpty()) {
            return null;
        } else {
            int q1Size = q1.size();
            while (q1Size > 1) {
                q2.offer(q1.poll());
                q1Size--;
            }

            Integer element = q1.poll();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return element;
        }
    }

    public static void main(String[] args) {
        StackUsingQueues sq = new StackUsingQueues();
        sq.push(1);
        sq.push(2);
        sq.push(3);

        System.out.println(sq.poll());
        System.out.println(sq.poll());
        System.out.println(sq.poll());
        System.out.println(sq.poll());
    }
}


