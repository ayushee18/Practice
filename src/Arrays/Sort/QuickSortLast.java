package Arrays.Sort;

//Pivot is the last element of the array
public class QuickSortLast {

  public static void quicksort(int[] arr, int left, int right) {
    if (left < right) {
      //find next partition index
      int p = partition(arr, left, right);
      quicksort(arr, left, p - 1);
      quicksort(arr, p + 1, right);
    }
  }

  public static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int index = left - 1;
    for (int i = left; i < right; i++) {
      if (arr[i] < pivot) {
        index++;
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
      }
    }
    int temp = arr[index + 1];
    arr[index + 1] = arr[right];
    arr[right] = temp;
    return index + 1;
  }

  public static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
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
    quicksort(arr, 0, arr.length - 1);
    printArray(arr);
  }
}
