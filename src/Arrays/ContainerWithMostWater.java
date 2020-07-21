package Arrays;

public class ContainerWithMostWater {

    public static int maxArea(int [] arr) {
        int max = Integer.MIN_VALUE;
        int low = 0;
        int high = arr.length - 1;
        int height = 0;
        while(low < high) {
            height = Math.min(arr[low], arr[high]);
            max = Math.max(max, height*(high - low));
            if(arr[low] < arr[high])
                low++;
            else
                high--;
        }

        return max;
    }

    public static void main(String[] args) {
        //given are y-axis coordinates in an array, x-axis increases linearly by one. Something like below
        /*
        *     |
        *     |   |
        *     | | |
        *     |_|_|_|  * */
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};

        int len1 = 4;
        System.out.print( maxArea(a)+"\n" );

        int len2 = 5;
        System.out.print( maxArea(b) );
    }
}
