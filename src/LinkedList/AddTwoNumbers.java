package LinkedList;

/*Given two numbers represented by two linked lists, write a function that returns the sum list.
The sum list is linked list representation of the addition of two input numbers. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).
Input:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
*/
public class AddTwoNumbers {

    LinkedList result = new LinkedList();
    LinkedList list1 = new LinkedList();
    LinkedList list2 = new LinkedList();
    int sum = 0, carry = 0;

    public void addListsSameSize(Node head1, Node head2) {
        if(head1 == null || head2 == null)
            return;

        addListsSameSize(head1.next, head2.next);

        int temp = head1.data + head2.data + carry;
        sum = temp%10;
        carry = temp/10;
        result.push(sum);
    }

    public int findSize(Node head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public Node makePointerCorrect(Node head, int diff) {
        int count = 0;
        while(count < diff) {
            head = head.next;
            count++;
        }
        return head;
    }

    public void propogateCarry(Node head, int diff) {
        if(diff == 0)
            return;
        diff--;
        propogateCarry(head.next, diff);
        int temp = head.data + carry;
        sum = temp%10;
        carry = temp/10;
        result.push(sum);
    //    diff--;
    }

    public void addLists(Node head1, Node head2) {
        int size1 = findSize(head1);
        int size2 = findSize(head2);

        if(size1 == size2)
            addListsSameSize(head1, head2);
        else {
            Node curr1 = head1, curr2 = head2;
            int diff = Math.abs(size1 - size2);
            if(size1 > size2)
                curr1 = makePointerCorrect(head1, diff);
            else
                curr2 = makePointerCorrect(head2, diff);
            addListsSameSize(curr1, curr2);

            if(size1 > size2)
                propogateCarry(head1, diff);
            else
                propogateCarry(head2, diff);
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        //addTwoNumbers.list1.push(3); addTwoNumbers.list1.push(6); addTwoNumbers.list1.push(5);
        addTwoNumbers.list1.push(6); addTwoNumbers.list1.push(4); addTwoNumbers.list1.push(9);
        addTwoNumbers.list1.push(5); addTwoNumbers.list1.push(7);
       // addTwoNumbers.list2.push(2); addTwoNumbers.list2.push(4); addTwoNumbers.list2.push(8);
        addTwoNumbers.list2.push(4); addTwoNumbers.list2.push(8);
        addTwoNumbers.addLists(addTwoNumbers.list1.head, addTwoNumbers.list2.head);
        addTwoNumbers.result.printAll();
    }
}
