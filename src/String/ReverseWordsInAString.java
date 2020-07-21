package String;

public class ReverseWordsInAString {

    public static String reverseWords(String strInput) {
        String [] strArray = strInput.split(" ");
        String str = "";
        for(int i = strArray.length - 1; i >= 0; i--) {
            str  = str + strArray[i]+ " ";
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("i like this program very much"));
    }
}
