import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OnidPizzaProblem {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().split(" ");
        int len = Integer.parseInt(line1[0]);
        int cost = Integer.parseInt(line1[1]);
        String[] input = reader.readLine().split(" ");
        int[] students = new int[len];
        for (int i = 0; i < len; i++) {
            students[i] = Integer.parseInt(input[i]) - cost;
        }
        System.out.println(maxSubArraySum(students, len));
    }

    static int maxSubArraySum(int students[], int len) {
        int currentMax = Integer.MIN_VALUE, max = 0;
        for (int i = 0; i < len; i++) {
            max = max + students[i];
            if (currentMax < max)
                currentMax = max;
            if (max < 0)
                max = 0;
        }
        return currentMax;
    }
} 