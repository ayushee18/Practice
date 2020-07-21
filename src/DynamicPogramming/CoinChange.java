package DynamicPogramming;

import java.util.Arrays;

//Uses Integer Partition Alogorithm
public class CoinChange {

    public static int coinChangeSolver(int target, int coins[]) {
        int coinsNum = coins.length;
        int results[][] = new int[coinsNum + 1][target + 1];

        for(int i = 0; i < coinsNum + 1; i++) {
            //If we have zero change to make then one way to do that ie to dod nothing
            results[i][0] = 1;
        }

        for(int i = 1; i < coinsNum+1; i++) {
            for(int j = 1; j < target+1; j++) {
                if(coins[i - 1] > j){
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = results[i - 1][j] + results[i][j - coins[i - 1]];
                }
            }
        }

        for(int[] a : results) {
            System.out.println(Arrays.toString(a));
        }

        return results[coinsNum][target];
    }

    public static void main(String[] args) {
        int [] coins = {1, 2, 3};
        System.out.println(coinChangeSolver(5, coins));
    }
}
