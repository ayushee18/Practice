package LinkedList;

public class RotateTheLinkedList {

    /*Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
     For example, if the given linked list is 10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40.
     Assume that k is smaller than the count of nodes in linked list.
     */
    /*To solve this get kth node and k+1 node, find last node of the list and put last.next = head, put kth node .next = null and then mark k+1 node as head*/
    public static void rotate(LinkedList list, int k) {
        Node curr = list.head;
        int count = 0;
        Node kthNode = null;

        //Find kth node
        while(count < k && curr != null) {
            kthNode = curr;
            curr = curr.next;
            count++;
        }

        //If k>length do nothing
        if(curr == null)
            return;

        Node nextTokthNode = kthNode.next;

        //Find last node of the list
        while(curr.next != null)
            curr = curr.next;

        //mark next of the last node as head
        curr.next = list.head;

        //next of kth node as null
        kthNode.next = null;

        //make k+1 node as new head
        list.head = nextTokthNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 60; i >= 10; i -= 10)
            list.push(i);

        list.printAll();
        System.out.println();
        rotate(list, 4);
        list.printAll();
        //------------------------------------------------
        //If you want to pass head not full list then u will have to return the head otherwise reference will be lost
//        Node head = rotate(list.head, 4);
//        Node curr = head;
//        while(curr != null) {
//            System.out.print(curr.data + " ");
//            curr = curr.next;
//       }
    }
}
