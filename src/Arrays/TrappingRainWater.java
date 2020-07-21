package Arrays;

public class TrappingRainWater {

    public static int findWaterUnitsWithTwoArrays(int [] arr) {
        int len = arr.length;
        int [] leftMax = new int [len];
        int [] rightMax = new int [len];

        int water = 0;
        int left_max = 0;
        int right_max = 0;

        for(int i = 0; i < len; i++) {
            if(left_max < arr[i])
                left_max = arr[i];
            leftMax[i] = left_max;
        }
        for(int i = len -1; i >= 0; i--) {
            if(right_max < arr[i])
                right_max = arr[i];
            rightMax[i] = right_max;
        }
        for(int i = 0; i < len; i++) {
            water = water + Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return water;
    }

    public static int findWaterWithoutTwoArrays(int [] arr) {
        int len = arr.length;
        int left_max = 0, right_max = 0;
        int low = 0, high = len - 1;
        int water = 0;

        while(low < high) {
            if(arr[low] < arr[high]) {
                if(left_max < arr[low])
                    left_max = arr[low];
                water = water + left_max - arr[low];
                low++;
            } else {
                if(right_max < arr[high]) {
                    right_max = arr[high];
                }
                water = water + right_max - arr[high];
                high--;
            }
        }

        return  water;

    }

    public static void main(String[] args) {
        int [] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(findWaterUnitsWithTwoArrays(arr));
        System.out.println(findWaterWithoutTwoArrays(arr));
    }
}
