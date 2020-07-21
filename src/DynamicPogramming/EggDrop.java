package DynamicPogramming;

import java.util.Arrays;

public class EggDrop {

    public static int eggSolverDynamic(int floors, int eggs) {
        int results[][] = new int[floors + 1][eggs + 1];
        for (int i = 0; i < floors + 1; i++) {
            results[i][1] = i;
        }
        for (int i = 0; i < eggs + 1; i++) {
            results[1][i] = 1;
        }

        for(int i = 2; i < floors+1; i++) {
            for(int j = 2; j < eggs+1; j++) {
                results[i][j] = Integer.MAX_VALUE;
                //filling the table for each floor for x to floors.
                //n is total number of floors, x = min(1, n-1)
                //equation: min(max(f(n-x, e), f(x-1, e-1)) + 1)
                for(int x = 1; x < i; x++) {
                    int brokenEggResult = results[x - 1][j - 1];
                    int eggSurvivedResult = results[i - x][j];
                    int temp = Math.max(brokenEggResult, eggSurvivedResult) + 1;
                    if(temp < results[i][j])
                        results[i][j] = temp;
                }
            }
        }

        for(int[] a : results)
            System.out.println(Arrays.toString(a));
        return results[floors][eggs];
    }

    public static int eggSolverRecursive(int floors, int eggs) {
        if(eggs == 1)
            return  floors;

        if(floors == 0)
            return 0;

        int min = 1000;

        for(int i = 1; i <= floors; i++) {
            int temp = 1 + Math.max(eggSolverRecursive(floors - i, eggs), eggSolverRecursive(i - 1, eggs - 1));
            if(temp < min)
                min = temp;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(eggSolverDynamic(8, 4));
        System.out.println(eggSolverRecursive(8, 4));
    }
}
