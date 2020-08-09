package Trees;

public class FindHeightOfTree {

    public int findHeight(Node root) {
        if(root == null)
            return 0;

        int lDepth = findHeight(root.left);
        int rDepth = findHeight(root.right);

        if(lDepth > rDepth)
            return 1+lDepth;
        else
            return 1+rDepth;
    }

    public static void main(String[] args) {
        /*       1
        *       2  3
        *      4 */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
      //  tree.root.left.right = new Node(5);

        FindHeightOfTree findHeightOfTree = new FindHeightOfTree();

        System.out.println("Height of tree is : " + findHeightOfTree.findHeight(tree.root));

    }
}
