package LinkedList;

public class DeleteWithoutHeadPointer {

    public static void deleteNode(Node node) {

        if(node == null)
            return;

        else if(node.next == null)
            System.out.println("Last node cannot be deleted");

        else {
            node.data = node.next.data;
            node.next = node.next.next;
        }

    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.push(0); list.push(1); list.push(2);
        list.printAll();
        System.out.println();
        deleteNode(list.head.next);
        list.printAll();
    }
}
