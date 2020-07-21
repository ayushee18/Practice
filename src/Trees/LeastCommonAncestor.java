package Trees;

public class LeastCommonAncestor {
    public static Node findLCA(Node root, int node1, int node2) {
        if(root == null)
            return null;
        if(root.data == node1 || root.data == node2)
            return  root;
        Node left = findLCA(root.left, node1, node2);
        Node right = findLCA(root.right, node1, node2);

        if(left != null && right != null)
            return root;
        if(left == null && right == null)
            return null;
        return left != null ? left : right;
    }
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = findLCA(tree.root,4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = findLCA(tree.root, 4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }
}
