import java.util.HashMap;
import java.util.Map;

public class Xyz123 {
    static String compressed (String str) {
        char[] chars= str.toCharArray();
        char c = chars[0];
        String result = "";
        int count = 1;
        for(int i = 1; i< chars.length;i++){
            if(c == chars[i])
                count++;
            else {
                result = result + c + (count > 1 ?  count : "");
                count = 1;
                c = chars[i];
            }
            if(i == chars.length - 1) result = result + c + (count > 1 ?  count : "");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(compressed("aaabbbbbccccdaa"));
    }
}
