package LinkedList;

public class SortListOf012 {

    public static Node sortList(Node head) {
        Node curr = head;
        int [] count = {0, 0, 0};

        while(curr != null) {
            count[curr.data]++;
            curr = curr.next;
        }

        curr = head;
        int index = 0;

        while(curr != null) {
            if(count[index] == 0)
                index++;
            else {
                curr.data = index;
                count[index]--;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(0);
        list.push(1);
        list.push(0);
        list.push(2);
        list.push(1);
        list.push(1);
        list.push(2);
        list.push(1);
        list.push(2);

        list.printAll();

        Node result = sortList(list.head);
        System.out.println();

        while(result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
