package LinkedList;

public class DetectAndRemoveLoopInALinkedList {

    public static void detectAndRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                System.out.println("List has loop");
                slow = head;
                removeLoop(slow, fast);
                return;
            }
        }
        System.out.println("No loop detected");
    }

    public static void removeLoop(Node slow, Node fast) {
        while(fast.next != slow.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        detectAndRemoveLoop(list.head);
        System.out.println("Linked List after removing loop : ");
        list.printAll();
    }
}
