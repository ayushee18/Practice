package String;

public class CountRepeatedCharacterInAString {

    public static String stringWithCharCount(String s) {
        String str = "";
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else{
                str = str + s.charAt(i) + count;
                count = 1;
            }
            if(i == s.length() - 2)
                str = str + s.charAt(i + 1) + count;
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(stringWithCharCount("aaabbbbbccccaaa"));
    }
}
