package Arrays.TwoArrays;

import java.util.HashMap;
import java.util.Map;

public class IfTwoArraysAreEqual {

    public static boolean equalArrays(int [] arr1, int arr2[]) {
        if (arr1.length != arr2.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        //Adding values of array as key to hashmap and storing their number of occurances
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                temp = map.get(arr1[i]) + 1;
                map.put(arr1[i], temp);
            } else {
                map.put(arr1[i], 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {

            //return false if value not found as key in hashmap
            if (!map.containsKey(arr2[i]))
                return false;

            //Step 2: If number occurs one more time in array then it occurs more times in arr2 than arr1
            if (map.get(arr2[i]) == 0)
                return false;

            //Step 1: add the value to hashmap and reduce count
            //count = 0 for numbers occuring once as they will not pass above condition
            //count > 0 if number occurs unequal number of times in arr2
            temp = map.get(arr2[i]) - 1;
            map.put(arr2[i], temp);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 2, 5, 2, 2};
        int[] arr2 = {2, 3, 5, 5, 2, 5};
        System.out.println(equalArrays(arr1, arr2));
    }
}
