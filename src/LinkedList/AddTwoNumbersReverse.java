package LinkedList;

/*Given two numbers represented by two lists, write a function that returns the sum list.
The sum list is list representation of the addition of two input numbers.
     Input:
    List1: 5->6->3 // represents number 365
    List2: 8->4->2 // represents number 248
    Output:
    Resultant list: 3->1->6 // represents number 613
    Explanation: 365 + 248 = 613

    Input:
    List1: 7->5->9->4->6 // represents number 64957
    List2: 8->4 // represents number 48
    Output:
    Resultant list: 5->0->0->5->6 // represents number 65005
    Explanation: 64957 + 48 = 65005
 */
public class AddTwoNumbersReverse {

    public static Node addTwoList(Node head1, Node head2) {
        Node curr1 = head1, curr2 = head2;

        int carry = 0, sum = 0;

        Node dummy = new Node(0);
        Node result = dummy;

        while(head1 != null || head2 != null) {
            sum = carry + (head1 != null ? head1.data:0) + (head2 != null ? head2.data:0);
            dummy.next = new Node(sum%10);
            carry = sum/10;
            dummy = dummy.next;
            if(head1 != null)
                head1 = head1.next;
            if(head2 != null)
                head2 = head2.next;
        }

//        while(curr1 != null && curr2 != null) {
//            int temp = curr1.data + curr2.data + carry;
//            dummy.next = new Node(temp % 10);
//            carry = temp/10;
//            curr1 = curr1.next;
//            curr2 = curr2.next;
//            dummy = dummy.next;
//        }
//
//        while(curr1 != null) {
//            int temp = curr1.data + carry;
//            dummy.next = new Node(temp%10);
//            carry = temp/10;
//            dummy = dummy.next;
//            curr1 = curr1.next;
//        }
//
//        while(curr2 != null) {
//            int temp = curr2.data + carry;
//            dummy.next = new Node(temp%10);
//            carry = temp/10;
//            dummy = dummy.next;
//            curr2 = curr2.next;
//        }

        return result.next;
    }

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
       // list1.push(7); list1.push(5); list1.push(9); list1.push(4); list1.push(6);
        list1.push(5); list1.push(6); list1.push(3);

        LinkedList list2 = new LinkedList();
        //list2.push(8); list2.push(4);
        list2.push(8); list2.push(4); list2.push(2);

        Node result = addTwoList(list1.head, list2.head);

        while(result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
