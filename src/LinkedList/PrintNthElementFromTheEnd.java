package LinkedList;

public class PrintNthElementFromTheEnd {

    public static Node fromTheEnd(Node head, int n) {
        int len = 0;
        Node curr1 = head;
        while(curr1 != null) {
            len++;
            curr1 = curr1.next;
        }
        if(len < n) {
            System.out.println("N more than Length");
            return null;
        }

        int index = len - n;
        curr1 = head;
        for (int i = 0; i <= index; i++) {
            if(i == index)
                return curr1;
            curr1 = curr1.next;
        }

        return null;
    }

    /*move refernce pointer till distance n and then move main pointer to next until ref pointer becomes null,
    then main pointer is result*/
    public static Node fromEndOptimized(Node head, int n) {
        int count = 0;
        Node result = head;
        Node ref = head;

        while(ref != null) {
            if(count >= n)
                result = result.next;
            ref = ref.next;
            count++;
        }

//        while(main != null && ref != null) {
//            main = main.next;
//            ref = ref.next;
//        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
       // System.out.println(fromTheEnd(linkedList.head, 3).data);
        System.out.println(fromEndOptimized(linkedList.head, 2).data);
    }
}
