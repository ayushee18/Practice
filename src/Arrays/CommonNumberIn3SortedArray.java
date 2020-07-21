package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CommonNumberIn3SortedArray {

    public static  List<Integer> commonNumbers(int [] arr1, int [] arr2, int [] arr3) {
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        int len = Math.max(arr1.length, Math.max(arr2.length, arr3.length));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            if(l1 < arr1.length && l2 < arr2.length && l3 < arr3.length) {
                if(arr1[l1] == arr2[l2] && arr2[l2] == arr3[l3] && arr1[l1] == arr3[l3]) {
                    list.add(arr1[l1]);
                    l1++; l2++; l3++;
                } else {
                    if (arr1[l1] < arr2[l2])
                        l1++;
                    if (arr1[l1] < arr3[l3])
                        l1++;
                    if (arr2[l2] < arr3[l3])
                        l2++;
                    if (arr2[l2] < arr1[l1])
                        l2++;
                    if (arr3[l3] < arr1[l1])
                        l3++;
                    if (arr3[l3] < arr2[l2])
                        l3++;
                }

            }

        }
        return list;
    }

    public static void main(String[] args) {
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        List<Integer> list = commonNumbers(ar1, ar2, ar3);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
