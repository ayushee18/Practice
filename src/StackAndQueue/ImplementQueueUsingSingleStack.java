package StackAndQueue;

import java.util.Stack;

public class ImplementQueueUsingSingleStack {

    static class Queue {
        Stack<Integer> stack = new Stack<>();
        int size = 0;

        public void enqueue(int data) {
            stack.push(data);
            size++;
        }

        public int dequeue() {
            int res = 0, x = 0;

            if(stack.size() == 1) {
                x = stack.pop();
                size--;
            }
            else {
                res = stack.pop();
                x = dequeue();
                stack.push(res);
            }
           return x;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.size);
        int result1 = queue.dequeue();
        int result2 = queue.dequeue();
        System.out.println(queue.size+" "+result1+" "+result2);
    }
}
