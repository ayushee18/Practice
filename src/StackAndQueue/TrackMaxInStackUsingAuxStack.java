package StackAndQueue;

import java.util.Stack;

/*Given a Stack, keep track of the maximum value in it. The maximum value may be the top element of the stack,
but once a new element is pushed or an element is popped from the stack, the maximum element will be now from
the rest of the elements.*/
public class TrackMaxInStackUsingAuxStack {

    Stack<Integer> originalStack;
    Stack<Integer> trackStack;

    public TrackMaxInStackUsingAuxStack() {
        this.originalStack = new Stack<>();
        this.trackStack = new Stack<>();
    }

    public int push(int x) {
        if(trackStack.isEmpty())
            trackStack.push(x);
        else if(trackStack.peek() > x)
            trackStack.push(trackStack.peek());
        else
            trackStack.push(x);
        return originalStack.push(x);
    }

    public int getMax() {
        return trackStack.peek();
    }

    public int pop() {
        trackStack.pop();
        return originalStack.pop();
    }

    public static void main(String[] args) {
        TrackMaxInStackUsingAuxStack track = new TrackMaxInStackUsingAuxStack();
        System.out.println("Pushed: " + track.push(20)); System.out.println("Pushed: " + track.push(30));
        System.out.println("Pushed: " + track.push(50));
        System.out.println("Max: " + track.getMax());
        System.out.println("Pop: " + track.pop());
        System.out.println("Max: " + track.getMax());
    }
}
