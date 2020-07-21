package Trees;

public class CheckIfTwoTreesAreMirrorImageOfEachOther {

    public static boolean ifTheyAreMirrorImages(Node node1, Node node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null)
            return false;

        return node1.data == node2.data && ifTheyAreMirrorImages(node1.left, node2.right) && ifTheyAreMirrorImages(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Node node1, node2;

        node1 = new Node(1);
        node1.left = new Node(3);
        node1.right = new Node(2);
        node1.right.left = new Node(5);
        node1.right.right = new Node(4);

        node2 = new Node(1);
        node2.left = new Node(2);
        node2.left.left = new Node(4);
        node2.left.right = new Node(5);
        node2.right = new Node(3);

        System.out.println(ifTheyAreMirrorImages(node1, node2));
    }
}
