package StackAndQueue;

import java.util.Stack;

public class ImplementQueueUsingStack {

    static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int size;

        public Queue() {
            this.size = 0;
        }

        public void push(int data) {
            s1.push(data);
            size++;
        }

        public void pop() {
            if(!s2.empty())
                s2.pop();
            else {
                while(!s1.empty())
                    s2.add(s1.pop());
                s2.pop();
            }
            size--;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.size);
        queue.pop();
        queue.pop();
        System.out.println(queue.size);
    }
}
