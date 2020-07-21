package LinkedList;

public class LinkedList {

    Node head;

    //this is tempeorary implementation, write a better reusable method later, not this bullshit
    public void push(int data) {

        if (head == null)
            head = new Node(data);
        else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new Node(data);
        }
    }

    public void printAll() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public void  deleteWithoutHead(Node nodePtr) {
        Node temp = nodePtr.next;
        nodePtr.next = null;
        nodePtr.next = temp.next;
        nodePtr.data = temp.data;
        temp = null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);

        linkedList.printAll();

        System.out.println();

        linkedList.deleteWithoutHead(linkedList.head);

        linkedList.printAll();

    }
}
