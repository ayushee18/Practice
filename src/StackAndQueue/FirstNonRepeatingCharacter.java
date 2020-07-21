package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/*Given a stream of characters and we have to find first non repeating character each time a character is inserted to the stream.
Input  : a a b c
Output : a -1 b b

Input  : a a c
Output : a -1 c
 */
public class FirstNonRepeatingCharacter {

    /*Create char array and char queue, keep count in char array and first non-repeating character remains in front of queue
    for each iteration check queue front frequency in char array, if greater than 1 remove otherwise print the character.
    If queue is empty no non-repeting character
    */
    public void printFirst(String str) {
        Queue<Character> queue = new LinkedList<>();
        int [] charCountArr = new int[26];
        for(int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            int index = (int)(Character.toLowerCase(x)) - 97;
            queue.add(x);
            charCountArr[index] += 1;
            while(!queue.isEmpty()) {
                char temp = queue.peek();
                int indx = Character.toLowerCase(temp) - 'a';
                if(charCountArr[indx] > 1)
                    queue.remove();
                else {
                    System.out.println(queue.peek());
                    break;
                }
            }
            if(queue.isEmpty())
                System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        firstNonRepeatingCharacter.printFirst("aabc");
    }
}
