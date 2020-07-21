package LinkedList;

    public class IntersectionPointOfTwoLists {

        public int getListLength(Node head) {
            Node curr = head;
            int len = 0;

            while(curr != null) {
                curr = curr.next;
                len++;
            }

            return len;
        }

        public int findIntersection(Node head1, Node head2) {
            int len1 = getListLength(head1);
            int len2 = getListLength(head2);

            int diff = Math.abs(len1 - len2);

            Node curr1, curr2;

            if(len1 >= len2){
                curr1 = head1;
                curr2 = head2;
            } else {
                curr1 = head2;
                curr2 = head1;
            }

            int count = 0;

            while(count < diff) {
                curr1 = curr1.next;
                count++;
            }

            while(curr1 != null && curr2 != null) {
                if(curr1.data == curr2.data)
                    return curr1.data;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }

            return -1;
        }

        public static void main(String[] args) {
           // LinkedListIntersection list = new LinkedListIntersection();

            LinkedList list1 = new LinkedList();

            list1.head = new Node(3);
            list1.head.next = new Node(6);
            list1.head.next.next = new Node(9);
            list1.head.next.next.next = new Node(15);
            list1.head.next.next.next.next = new Node(30);

            // creating second linked list
            LinkedList list2 = new LinkedList();
            list2.head = new Node(10);
            list2.head.next = new Node(15);
            list2.head.next.next = new Node(30);

            IntersectionPointOfTwoLists point = new IntersectionPointOfTwoLists();

            System.out.println(point.findIntersection(list1.head, list2.head));
        }
    }

