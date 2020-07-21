package Trees;

public class FindHeightOfTree {

    public int findHeight(Node root) {
        if(root == null)
            return 0;
        else{
            int lheight = findHeight(root.left);
            int rheight = findHeight(root.right);

            if(lheight > rheight)
                return 1 + lheight;
            else
                return 1 + rheight;
        }
    }

    public static void main(String[] args) {
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
