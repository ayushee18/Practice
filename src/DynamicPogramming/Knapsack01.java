package DynamicPogramming;

import java.util.Arrays;

public class Knapsack01 {

    public static int knapsackSolver(int[] val, int[] wt, int capacity) {
        int wtLen = wt.length;
        int[][] results =  new int[wtLen+1][capacity+1];
        for(int i = 0; i < wtLen+1; i++) {
            for(int j = 0; j < capacity+1; j++) {
                if(i == 0 || j == 0){
                    results[i][j] = 0;
                    continue;
                }
                if(wt[i - 1] > j)
                    results[i][j] = results[i - 1][j];
                else {
                    results[i][j] = Math.max(results[i - 1][j], results[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        for(int[] a : results) {
            System.out.println(Arrays.toString(a));
        }

        return results[wtLen][capacity];
    }

    public static void main(String[] args) {
        int[] wt = {2, 3, 4, 5};
        int[] val = {1, 2, 5, 6};
        System.out.println(knapsackSolver(val, wt,8));
    }
}
