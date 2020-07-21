package Arrays;

import java.util.HashSet;

public class SwapMaxElementFromRight {

    public static void swapFromRight(int arr []) {
        int len = arr.length;
        int temp;
        int max_from_right = arr[len - 1];
        arr[len - 1] = -1;
        for(int i = len - 2; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max_from_right;
            if(max_from_right < temp)
                max_from_right = temp;

        }
    }

    public static void main(String[] args) {
        int [] arr = {16, 17, 4, 3, 5, 2};
        swapFromRight(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
