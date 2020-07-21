package LinkedList;

public class LinkedListPalindrome {

    public static Node findMidPrevious(Node head) {
        Node slow = head;
        Node fast = head;
        Node slow_prev = head;

        while(slow != null && fast != null && fast.next != null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow_prev;
    }

    public static Node reverseLinkedList(Node mid) {
        Node curr = mid, next = null, prev = null;
        while(curr != null) {
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
        }
        return prev;
    }

    public static boolean compare(Node node1, Node node2) {

        Node curr1 = node1, curr2 = node2;

        while(curr1 != null && curr2 != null) {
            if(curr1.data != curr2.data)
                return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return  true;
    }

    public static boolean checkIfPalindrome(Node head) {
        Node mid_prev = findMidPrevious(head);
        Node mid = mid_prev.next;
        System.out.println("mid " + mid_prev.data+" "+ mid.data+" "+mid.next.data);
        Node head2 = reverseLinkedList(mid);
        Boolean result = compare(head, head2);
        reverseLinkedList(head2);

        return result;
    }
////////////////////////////////////////////Using Recursion////////////////////////////////////////////

    public static  boolean checkPalin(Node left, Node right) {
        if(right == null)
            return true;
        boolean result = checkPalin(left, right.next) && left.data == right.data;

        left = left.next;

        return  result;
    }

    public static boolean checkIfPalindromRecursion(Node head) {
       return checkPalin(head, head);
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.head = new Node(30);
        list1.head.next = new Node(20);
        list1.head.next.next = new Node(10);
       // list1.head.next.next.next = new Node(10);
        list1.head.next.next.next = new Node(20);
        list1.head.next.next.next.next = new Node(30);
        System.out.println(checkIfPalindrome(list1.head));
        list1.printAll();
        System.out.println();
        System.out.println(checkIfPalindromRecursion(list1.head));
    }
}
