package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTree {

    public static void printBFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.data + " ");

            if(temp.left != null)
                queue.add(temp.left);


            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    public static void printDFS(Node root) {

    }

    public static void main(String[] args) {
        /*             1
        *             2 3
        *           4 5   6          */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        System.out.println("Level order traversal of binary tree is - ");
        printBFS(tree.root);
    }
}
