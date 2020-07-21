package Arrays.SubArraySum;

import java.util.Arrays;

public class SubArrayAndSubsequenceMaximumSum {

    public static int kandaneAlgorithm(int[] arr, int n) {
        int curr_max = arr[0];
        int max_so_far = arr[0];
        int sum = 0;
        int start = 0;
        int end = -1;
        for(int i = 0; i < n; i++) {
            sum = curr_max + arr[i];
            if(i == 0) {
                sum = curr_max;
            }
            curr_max = Math.max(arr[i], sum);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    public static int[] kandaneAlgothimArray(int arr[], int n) {
        int curr_max = arr[0];
        int max_so_far = arr[0];
        int sum = 0;
        int start = 0;
        int end = -1;
        for(int i = 0; i < n; i++) {
            sum = curr_max + arr[i];
            if(i == 0) {
                sum = curr_max;
            }
            curr_max = Math.max(arr[i], sum);
            if(arr[i] == curr_max) {
                start = i;
                end = i;
            }
            if(max_so_far < curr_max) {
                max_so_far = curr_max;
                end = i;
            }
        }
        int subArray [] = new int[end-start+1];
        System.out.println(max_so_far);
        for(int i = 0; i < subArray.length; i++) {
            subArray[i] = arr[start];
            start++;
        }
        return subArray;
    }

    public static int kandaneAlgorithmMaxSubSequence(int [] arr, int n){
        Arrays.sort(arr);
        int curr_max = arr[0];
        int max_so_far = arr[0];
        int sum = 0;
        int start = 0;
        int end = -1;
        for(int i = 0; i < n; i++) {
            sum = curr_max + arr[i];
            if(i == 0) {
                sum = curr_max;
            }
            curr_max = Math.max(arr[i], sum);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    public static void main(String[] args) {
        //int arr [] = {-2, -3, -4, 1, -2, -1, -5, -3};
       int arr [] = {-2, -3, 4, -1, -2, 1, 5, -3};
//       int [] subArray = kandaneAlgothimArray(arr, arr.length);
//        for(int i = 0; i < subArray.length; i++) {
//            System.out.print(subArray[i] + " ");
//        }
        System.out.println(kandaneAlgorithmMaxSubSequence(arr, arr.length));
    }
}
