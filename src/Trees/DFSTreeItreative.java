package Trees;

import java.util.Stack;

public class DFSTreeItreative {

    public void inorderItreative(Node root) {

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || stack.size() != 0) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public void preorderItreative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        stack.push(curr);

        while(!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(curr.data + " ");

            if(curr.right != null)
                stack.push(curr.right);

            if(curr.left != null)
                stack.push(curr.left);

        }
    }

    public static void main(String[] args) {
        /*   1
        *   2 3
        * 4 5*/
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        DFSTreeItreative dfs = new DFSTreeItreative();
        dfs.inorderItreative(tree.root);

        System.out.println();

        dfs.preorderItreative(tree.root);
    }
}
