package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/*Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
Output: 3 3 4 5 5 5 6*/
public class MaximumOfSubarrayOfSizek {

    public static void printMax(int[] arr, int len, int k) {
        //save only max elements from k range in queue
        Deque<Integer> deque = new LinkedList<>();

        int i;
        //find max for 1st k elements and add in queue
        for(i = 0; i < k; i++) {
            while(!deque.isEmpty() && arr[i] >= arr[deque.getLast()])
                deque.removeLast();
            deque.addLast(i);
        }

        //check for further elements
        for(; i < len; i++) {
            System.out.println(arr[deque.getFirst()]);

            //Remove element not in range
            while(!deque.isEmpty() && deque.getFirst() <= i - k)
                deque.removeFirst();

            while(!deque.isEmpty() && arr[deque.getLast()] <= arr[i])
                deque.removeLast();

            deque.addLast(i);
        }

        //first element of the queue will be largest
        System.out.println(arr[deque.getFirst()]);

    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
