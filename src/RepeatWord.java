import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RepeatWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        hasRepeatedWords(data);
    }

    private static void hasRepeatedWords(final String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = input.split(" ");
        for (String word : words) {
            if (map.containsKey(word)) {
                System.out.println("no");
                return;
            } else {
                map.put(word, 1);
            }
        }
        System.out.println("yes");
    }
}
