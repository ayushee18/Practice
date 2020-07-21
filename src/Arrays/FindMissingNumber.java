package Arrays;

public class FindMissingNumber {

    //you can also subtract sum of array elements from n(n+1)/2 but meeh XOR approach is more efficient and faster
    public static int getMissing(int [] arr, int len) {
        //XOR all the elements of the array
        int x1 = 0;
        int x2 = 0;
        for( int i = 0; i < len; i++) {
            x1 = x1 ^ arr[i];
        }
        //XOR all the numbers uptill len+1
        for( int i = 1; i <= len + 1; i++) {
            x2 = x2 ^ i;
        }
        //XOR two results to find the missing number
        return x1 ^ x2;
    }

    public static void main(String[] args) {
        int [] arr = { 1, 2, 4, 5, 6 };
        System.out.println(getMissing(arr, arr.length));
    }
}
