package Arrays.SubArraySum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubArrayWithGivenSum {
    //Leave this logic use the one which handles negative, did not remove it because it still works for positive integer array
    public static int[] subArraySumNonNegative(int[] arr, int sum) {
        int curSum = arr[0], start = 0;
        for(int i = 1; i < arr.length; i++) {
            while (sum < curSum && start < i-1) {
              curSum = curSum - arr[start];
              start++;
            }
            if(curSum == sum) {
                int subArray[] = new int[i-start];
                for(int j = 0; j < subArray.length; j++) {
                    subArray[j] = arr[start];
                    start++;
                }
                return subArray;
            }
            if(i == arr.length - 1 && curSum != sum && sum == arr[i]) {
                int subArray[] = {arr[i]};
                return subArray;
            }
                curSum = curSum+arr[i];
        }
        System.out.println("No subarray found");
        return null;
    }

    public static int[] subArraySumNegativeHandled(int[] arr, int n, int sum){
        int curSum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            //Sum uptil index i
            curSum = curSum + arr[i];
            //if current = sum index starts fro 0
            if(curSum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //finding the diifference to remove the indexes that caused it :P
            if(map.containsKey(curSum - sum)) {
                start = map.get(curSum - sum) + 1;
                end = i;
                break;
            }
            //adding current sum in hashmap to store indexes and ofcourse relative sum uptil that index
            map.put(curSum,i);
        }
        if(end == -1) {
            System.out.println("Sum not Found");
            return null;
        } else {
            int subArray [] = new int[end - start + 1];
            for(int i = 0; i < subArray.length; i++) {
                subArray[i] = arr[start];
                start++;
            }
            return  subArray;
        }
    }

    public static int [] longestSubArrayWithGivenSum(int [] arr, int n, int sum) {
        //Refer above method for basic working explanation explaing the add-ons here
        int curSum = 0;
        int start = 0;
        int end = -1;
        //to save maximum length
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            curSum = curSum + arr[i];
            if(curSum - sum == 0) {
                start = 0;
                end = i;
                //if maxLen is small update it and update the start and end indexex also
                if(maxLen < end - start + 1) {
                    maxLen = end - start + 1;
                }
            }
            if(map.containsKey(curSum - sum)) {
                //if maxLen is small update it and update the start and end indexex also
               if(maxLen < (i - map.get(curSum - sum))) {
                   maxLen = i - map.get(curSum - sum);
                   start = map.get(curSum - sum)+1;
                   end = i;
            }
        }
            map.put(curSum,i);
        }
        if(end == -1) {
            System.out.println(" No sum found");
            return null;
        } else {
            int subArray [] = new int [end - start + 1];
            for(int i = 0; i < subArray.length; i++) {
                subArray[i] = arr[start];
                start++;
            }
            return subArray;
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 0, 1, 0};
     //   int subArray[] = subArraySumNonNegative(arr,-10);
//        int subArray [] = subArraySumNegativeHandled(arr, arr.length, -10);
       // int [] subArray = longestSubArrayWithGivenSum(arr, arr.length, 4);
       int [] subArray = longestSubArrayWithGivenSum(arr, arr.length,4);
        for(int i = 0; i < subArray.length; i++)
           System.out.print(subArray[i]+" ");
    }
}
