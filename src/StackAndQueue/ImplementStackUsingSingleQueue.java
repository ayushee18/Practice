package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingSingleQueue {

    static class Stack {

        Queue<Integer> queue = new LinkedList();
        int size = 0;

        public void push(int data) {
            queue.add(data);
            size++;
        }

        public int pop() {
            for(int i = 0; i < queue.size() - 1; i++) {
                int temp = queue.remove();
                queue.add(temp);
            }
            int result = queue.remove();
            size--;
            return result;
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size);
        int result1 = stack.pop();
        int result2 = stack.pop();
        System.out.println(stack.size+" "+result1+" "+result2);
    }
}
