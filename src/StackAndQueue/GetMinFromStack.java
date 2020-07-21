package StackAndQueue;

import java.util.Stack;

/*Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(),
isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard
Stack data structure and no other data structure like arrays, list, .. etc. */
public class GetMinFromStack {
    Stack<Integer> stack;
    Integer minElem;

    public GetMinFromStack() {
        this.stack = new Stack<>();
    }

    public Integer getMinElem() {
        if(stack.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        } else {
            System.out.println("Minimum Element is: " + minElem);
            return minElem;
        }
    }

    public void push(Integer x) {
        if(stack.isEmpty()) {
            stack.push(x);
            minElem = x;
            System.out.println("Inserted: " + x);
            return;
        } else {
            if(x >= minElem) {
                stack.push(x);
                System.out.println("Inserted: " + x);
            }
            else {
                stack.push(2*x - minElem);//2*x - minElem < minElem always
                minElem = x;
                System.out.println("Inserted: " + (2*x - minElem));
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        int y = stack.pop();
        if(y < minElem) {
            //y = 2*x - prevMinElem; newMinElem = x; Using subsitution
            //prevMinElem = 2*newMinElem - y
            minElem = 2*minElem - y;
        }
        System.out.println("Removed: " + y);
    }

    public Integer peek() {
        if(stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        if(stack.peek() < minElem) {
            return minElem;
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        GetMinFromStack getMinFromStack = new GetMinFromStack();
        getMinFromStack.push(3); getMinFromStack.push(5); getMinFromStack.push(2);
        getMinFromStack.push(1); getMinFromStack.push(1); getMinFromStack.push(-1);

        getMinFromStack.getMinElem();
        System.out.println(getMinFromStack.peek());

        getMinFromStack.pop();

        System.out.println(getMinFromStack.peek());

        getMinFromStack.getMinElem();
    }

}
