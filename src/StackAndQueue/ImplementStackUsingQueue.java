package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    static class Stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        public int size;

        public Stack() {
            this.size = 0;
        }

        public void push(int data) {
            q1.add(data);
            size++;
        }

        public void pop() {
            while(q1.size() != 1) {
                q2.add(q1.remove());
            }
            q1.remove();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            size--;
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size);
        stack.pop();
        System.out.println(stack.size);
    }
}
