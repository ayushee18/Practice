package Trees;

import java.util.Stack;

public class BinaryTreeTraversalIterative {

    public static void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while(curr != null || stack.size() != 0) {
            stack.push(curr);
            while(curr != null) {
                curr = curr.left;
                stack.push(curr);
            }
            curr = stack.pop();
            System.out.println(curr);
            while(curr != null)
                curr = curr.right;
                stack.push(curr);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        inorder(tree.root);
    }
}
