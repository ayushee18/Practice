package Trees;

class Height {
    int height;

    @Override
    public String toString() {
        return "Height{" +
                "height=" + height +
                '}';
    }
}

public class CheckIfTreeIsBalanced {

    public static  boolean isBalanced (Node root, Height height) {

        if(root == null) {
            height.height = 0;
            return true;
        }

        Height lheight = new Height();
        Height rheight = new Height();

        boolean l = isBalanced(root.left, lheight);
        boolean r = isBalanced(root.right, rheight);

        height.height = (lheight.height > rheight.height ? lheight.height : rheight.height) + 1;

        if(lheight.height - rheight.height >= 2 || rheight.height - lheight.height >= 2)
            return false;

        else
            return l && r;

    }

    public static void main(String[] args) {
        Height height = new Height();

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

        if (isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
