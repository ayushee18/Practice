import java.util.Scanner;
import java.util.TreeMap;

public class GridProblem {
    static boolean[][] current, changed;
    static TreeMap<Matrix, Integer> moves;
    static int currentMoves;

    public static void main(String[] args) {
        current = new boolean[3][3];
        changed = new boolean[3][3];
        moves = new TreeMap<Matrix, Integer>();
        currentMoves = 0;
        depthFirst();
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < tests; i++) {
            boolean[][] in = new boolean[3][3];
            for (int j = 0; j < 3; j++) {
                String line = sc.nextLine();
                for (int k = 0; k < 3; k++) {
                    if (line.charAt(k) == '*') {
                        in[j][k] = true;
                    }
                }
            }
            Matrix currentMatrix = new Matrix(in);
            System.out.println(moves.get(currentMatrix));
        }
    }

    static void toggle(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) return;
        current[x][y] = !current[x][y];
    }

    static void toggleAll(int x, int y) {
        toggle(x - 1, y);
        toggle(x + 1, y);
        toggle(x, y - 1);
        toggle(x, y + 1);
        toggle(x, y);
    }

    static void depthFirst() {
        Matrix temp = new Matrix(current);
        if (!moves.containsKey(temp)) moves.put(temp, currentMoves);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (changed[i][j]) continue;
                toggleAll(i, j);
                changed[i][j] = true;
                currentMoves++;
                depthFirst();
                toggleAll(i, j);
                changed[i][j] = false;
                currentMoves--;
            }
        }
    }
}

class Matrix implements Comparable<Matrix> {
    boolean[][] matrix;
    int index;

    Matrix(boolean[][] input) {
        matrix = new boolean[3][3];
        index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input[i][j]) {
                    matrix[i][j] = true;
                    int temp = (3 * i) + j;
                    index += Math.pow(2, temp);
                }
            }
        }
    }

    public int compareTo(Matrix in) {
        if (index < in.index) return -1;
        if (index > in.index) return 1;
        return 0;
    }
}
