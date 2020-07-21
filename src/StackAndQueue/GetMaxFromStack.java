package StackAndQueue;

import java.util.Stack;

public class GetMaxFromStack {

    Stack<Integer> stack;
    int maxElem;

    public GetMaxFromStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            maxElem = x;
            System.out.println("Pushed: " + x);
            return;
        } else if(x > maxElem) {
            stack.push(2*x - maxElem);
            maxElem = x;
            System.out.println("Pushed: " + (2*x - maxElem));
            return;
        } else {
            stack.push(x);
            System.out.println("Pushed: " + x);
        }
    }

    public Integer getMaxElem(){
        if(stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        System.out.println("Max elem is: " + maxElem);
        return maxElem;
    }

    public Integer peek(){
        if(stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else if(stack.peek() > maxElem) {
            System.out.println("Element: " + maxElem);
            return maxElem;
        } else {
            System.out.println("Element: " + stack.peek());
            return stack.peek();
        }
    }

    public Integer pop() {
        if(stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            int y = stack.pop();
            System.out.println("Popped: " + y);
            if(maxElem < y) {
                maxElem = 2*maxElem - y;
            }
            return y;
        }
    }

    public static void main(String[] args) {
        GetMaxFromStack s = new GetMaxFromStack();
        s.push(3);
        s.push(5);
        s.getMaxElem();
        s.push(7);
        s.push(19);
        s.getMaxElem();
        s.pop();
        s.getMaxElem();
        s.pop();
        s.peek();
    }
}
