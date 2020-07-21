package String;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static char firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int leastIndex = Integer.MAX_VALUE;
        int temp = 0;

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), -1);
            } else {
                map.put(str.charAt(i), i);
            }
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() != -1) {
                if(leastIndex > entry.getValue())
                    leastIndex = entry.getValue();
            }
        }

        return str.charAt(leastIndex);
    }
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("msasmt"));
    }
}