import java.util.List;

class Solution {

    static int MAX = 100;

    static int countPositional(List<List<Integer>> matrix, int m, int n)
    {
        // rwomax[i] is going to store maximum of 
        // i-th row and other arrays have similar 
        // meaning
        m = matrix.size();

        n = matrix.get(0).size();

        int maxOfRow[] = new int[m];
        int minOfRow[] = new int[m];
        int maxOfCol[] = new int[n];
        int minOfCol[] = new int[n];

        // Find rminn and rmaxx for every row 
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if(matrix.get(i).get(j) == max || matrix.get(i).get(j) == min)
                    return -1;
                if (matrix.get(i).get(j) > max)
                    max = matrix.get(i).get(j);
                if (matrix.get(i).get(j) < min)
                    min = matrix.get(i).get(j);
            }
            maxOfRow[i] = max;
            minOfRow[i] = min;
        }

        // Find cminn and cmaxx for every column 
        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if(matrix.get(i).get(j) == max || matrix.get(i).get(j) == min)
                    return -1;
                if (matrix.get(i).get(j) > max)
                    max = matrix.get(i).get(j);
                if (matrix.get(i).get(j) < min)
                    min = matrix.get(i).get(j);
            }

            maxOfCol[j] = max;
            minOfCol[j] = min;
        }

        // Check for optimal element 
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix.get(i).get(j) == maxOfRow[i])
                        || (matrix.get(i).get(j) == minOfRow[i])
                        || (matrix.get(i).get(j) == maxOfCol[j])
                        || (matrix.get(i).get(j) == minOfCol[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int a[][] = new int[][] { { 1, 3, 4 }, { 5, 2, 9 }, { 8, 7, 6 } };
        int m = 3, n = 3;
//        System.out.println(countPositional(a, m, n));
    }
} 