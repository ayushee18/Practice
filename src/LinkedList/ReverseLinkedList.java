package LinkedList;

import java.util.Arrays;

public class ReverseLinkedList {

    public static Node revese(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
       // head = prev;
        return prev;
    }

    public static Node reverseThree(Node head) {
        Node curr = head;
        Node prev = null;
        Node next1 = null;
        Node next2 = head.next.next.next;
        while(curr != null) {
         next1 = curr.next;
         next2 = curr.next.next.next;
         prev = curr;
         curr.next.next = prev;
         curr.next = next2;
         curr.next.next.next = next1;
        }
        return prev;
    }

    public static Node reverseInParts(Node head, int k) {
        Node curr = head, prev = null, next = null;
        int count = 0;

        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(head != null)
            head.next = reverseInParts(curr,k);
//Use either condn works the same
//        if (next != null)
//            head.next = reverseInParts(curr, k);

        return prev;
    }


    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(11);
        llist.push(9);
        llist.push(23);
        llist.push(31);
        llist.push(44);
//        llist.push(4);
//        llist.push(3);
//        llist.push(2);
//        llist.push(1);

        System.out.println("Given Linked List");
        llist.printAll();

        llist.head = reverseInParts(llist.head, 2);

        System.out.println("Reversed list");
        llist.printAll();
    }
}
