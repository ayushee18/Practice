package StackAndQueue;

import java.util.Stack;

public class NextGreatestElement {

    public void printNGE(int [] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > stack.peek())
                System.out.println(stack.pop() + " ------> " + arr[i]);

            stack.push(arr[i]);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop() + " ------> -1");
        }
    }

    public static void main(String[] args) {
        NextGreatestElement next = new NextGreatestElement();
        int [] arr = {13, 6, 7, 12};
        next.printNGE(arr);
    }
}
/*Time Complexity: O(n).
The worst case occurs when all elements are sorted in decreasing order. If elements are sorted in decreasing order, then every element is processed at most 4 times.

    Initially pushed to the stack.
    Popped from the stack when next element is being processed.
    Pushed back to the stack because the next element is smaller.
    Popped from the stack in step 3 of algorithm.
*/
