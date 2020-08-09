package Trees;

public class CheckForBST {

    static Node prev;

    public static boolean isBST(Node root) {

        if(root == null)
            return true;

        if(!isBST(root.left))
            return false;

        if(prev != null && root.data <= prev.data)
            return false;

        prev = root;

        if(!isBST(root.right))
            return false;

        return true;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        System.out.println(isBST(tree.root));
    }
}
