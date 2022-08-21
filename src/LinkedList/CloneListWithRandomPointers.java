package LinkedList;

public class CloneListWithRandomPointers {
  public static Node copyRandomList(Node head) {
    Node result = new Node(0);
    Node curr1 = head;
    Node curr2 = result;

    while (curr1 != null) {
      curr2.next = new Node(curr1.val);
      curr1 = curr1.next;
      curr2 = curr2.next;
    }

    curr2 = result.next;
    curr1 = head;

    while(curr1 != null && curr2 != null) {
      Node next1 = curr1.next;
      Node next2 = curr2.next;
      curr1.next = curr2;
      curr2.next = next1;
      curr1 = next1;
      curr2 = next2;
    }
    curr1 = head;
    curr2 = result.next;

    while (curr1 != null && curr2 != null) {
      curr2.random = curr1.random != null ? curr1.random.next : null;
      curr1 = curr1.next != null ? curr1.next.next : null;
      curr2 = curr2.next !=null ? curr2.next.next : null;
    }

    curr1 = head;
    curr2 = result.next;

    while (curr1 != null && curr2 != null) {
      curr1.next = curr2.next != null ? curr2.next : null;
      curr2.next = curr1.next != null ? curr1.next.next : null;
      curr1 = curr1.next;
      curr2 = curr2.next;
    }
    return result.next;
  }

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
