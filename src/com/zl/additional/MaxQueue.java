package com.zl.additional;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQueue {

    Deque<Integer> d = new ArrayDeque<>();
    Deque<Integer> q = new ArrayDeque<>();
    public MaxQueue() {

    }

    public int max_value() {
        if(d.isEmpty()){
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value){
            d.pollLast();
        }
        d.offerLast(value);
        q.offerLast(value);
    }

    public int pop_front() {
        if(q.isEmpty()){
            return -1;
        }
        if(q.peekFirst().intValue() == d.peekFirst().intValue()){
            d.poll();
        }
        return q.poll();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(868);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(525);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());

    }
}
