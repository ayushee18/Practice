package LinkedList;

import java.util.HashSet;

public class DetectIntersectionInTwoLinkedList {

    public static Node detectLoopUsingHashing(Node head1, Node head2) {

        HashSet<Node> set = new HashSet<>();
        Node curr1 = head1;
        Node curr2 = head2;
        while(curr1 != null) {
            set.add(curr1);
            curr1 = curr1.next;
        }

        while(curr2 != null) {
            if(set.contains(curr2))
                return curr2;
            curr2 = curr2.next;
        }
        System.out.println("No intersection");
        return  null;
    }

    public static int countElements (Node head) {
        Node curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    public static Node getIntersection(Node head1, Node head2, int diff) {
        Node curr1 = head1;
        Node curr2 = head2;
        for(int i = 0; i < diff; i++) {
            curr1 = curr1.next;
        }
        while(curr1 != null && curr2 != null) {
            if (curr1 == curr2)
                return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        System.out.println("No Intersection");
        return null;
    }
    public static Node detectLoopWithoutHashing(Node head1, Node head2) {
        int c1 = countElements(head1);
        int c2 = countElements(head2);
        int diff;

        if(c1 > c2) {
            diff = c1 - c2;
            return getIntersection(head1, head2, diff);
        } else {
            diff = c2 - c1;
            return getIntersection(head2, head1, diff);
        }
    }
    public static void main(String[] args) {
        // list 1
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;
        System.out.println("Hashing: "+detectLoopUsingHashing(n1, n2).data);
        System.out.println("Without Hashing: "+detectLoopWithoutHashing(n1, n2).data);

    }
}
