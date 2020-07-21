public class Fibonacci {

    int arr[] = new int[10];

    public int fibMemoizationDP(int n){
        if(arr[n]==0){
            if(n<=1)
                arr[n] = n;
            else {
                arr[n] = fibMemoizationDP(n - 1) + fibMemoizationDP(n - 2);
            }
        }
        return arr[n];
    }

    public int fibTabulationDP(int n){
        int arr[] = new int [n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String args[]){
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fibMemoizationDP(9));
        System.out.println(fib.fibTabulationDP(1));
    }
}
