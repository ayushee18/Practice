package DynamicPogramming;

import java.util.Arrays;

public class MinimumCoinsReqToMakeChange {

    public static int minCoins(int target, int[] coins) {
        int coinsNum = coins.length;
        int results[][] = new int[coinsNum + 1][target + 1];

        for(int i = 0; i < target+1; i++) {
            results[0][i] = i;
        }

//        for(int i = 1; i < coinsNum+1; i++) {
//            for(int j = 1; j < target+1; j++) {
//                if(coins[i - 1] < j)
//                    results[i][j] = results[i - 1][j];
//                else{
//                    results[i][j] = Math.min(results[i - 1][j], results[i][j - coins[i - 1]] + 1);
//                }
//            }
//        }

        for(int i = 1; i < coinsNum+1; i++) {
            for(int j = 1; j < target+1; j++) {
                if(coins[i - 1] > j){
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = Math.min(results[i - 1][j], results[i][j - coins[i - 1]] + 1);
                }
            }
        }

        for(int[] a: results) {
            System.out.println(Arrays.toString(a));
        }

        return results[coinsNum][target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 8};
        System.out.println(minCoins(11, coins));
    }
}
