package Arrays.Sort;

public class MergeSort {

  public static void mergeSort(int[] arr, int left, int right) {
    int mid = (left + right) / 2;
    if (left < right) {
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  public static void merge(int[] arr, int left, int mid, int right) {
    int l1 = mid - left + 1;
    int l2 = right - mid;

    int[] Left = new int[l1];
    int[] Right = new int[l2];

    for (int i = 0; i < l1; i++) {
      Left[i] = arr[left + i];
    }
    for (int i = 0; i < l2; i++) {
      Right[i] = arr[mid + 1 + i];
    }

    int k = left, i = 0, j = 0;
    while (i < l1 && j < l2) {
      if (Left[i] < Right[j]) {
        arr[k] = Left[i];
        i++;
      } else {
        arr[k] = Right[j];
        j++;
      }
      k++;
    }

    while (i < l1) {
      arr[k] = Left[i];
      i++;
      k++;
    }

    while (j < l2) {
      arr[k] = Right[j];
      k++;
      j++;
    }
  }

  public static void printArray(int[] arr) {
    for (int a : arr) {
      System.out.print(a + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = {3, 7, 2, 8, 9, 1, 6};
    printArray(arr);
    mergeSort(arr, 0, arr.length - 1);
    printArray(arr);
  }
}
