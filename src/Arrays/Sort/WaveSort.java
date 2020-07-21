package Arrays.Sort;

//You can also first sort the array and then swap adjacent elements this will take O(nlogn) time complexity,
//By below method it will take O(n) time complexity
public class WaveSort {

    public static int[] waveSortArray(int arr[]) {
        int temp = 0;
        for(int i = 1; i < arr.length; i = i + 2) {
            //Swap elements if previous element is smaller
            if(arr[i - 1] < arr[i]) {
                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            //Swap elements if next element is smaller
            if((i < arr.length - 1) && (arr[i + 1] < arr[i])) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int arr1 [] = {-90, 10, 49, 2, 1, 5, -23, 43};
        int [] arr2 = waveSortArray(arr1);
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
    }
}
