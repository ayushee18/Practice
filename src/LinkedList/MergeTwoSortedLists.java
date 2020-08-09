package LinkedList;

public class MergeTwoSortedLists {

    public Node mergeSortedLists(Node head1, Node head2) {
        Node result;
        Node curr1 = head1; Node curr2 = head2;
        if(curr1.data < curr2.data) {
            result = curr1;
            curr1 = curr1.next;
        }
        else {
            result = curr2;
            curr2 = curr2.next;
        }
        Node temp = result;
        while(curr1 != null && curr2 != null) {
            if(curr1.data < curr2.data) {
                result.next = curr1;
                curr1 = curr1.next;
            } else {
                result.next = curr2;
                curr2 = curr2.next;
            }
            result = result.next;
        }
        while (curr1 != null) {
            result.next = curr1;
            curr1 = curr1.next;
            result = result.next;
        }
        while (curr2 != null) {
            result.next = curr2;
            curr2 = curr2.next;
            result = result.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.push(5); list1.push(10); list1.push(15);

        LinkedList list2 = new LinkedList();
        list2.push(2); list2.push(3); list2.push(20); list2.push(30);

        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        Node result = merge.mergeSortedLists(list1.head, list2.head);

        while(result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
