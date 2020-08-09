package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    static int max_level = 0;

    public static void printLeft(Node root, int level) {
        if(root == null)
            return;

        if(max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }

        printLeft(root.left, level+1);
        printLeft(root.right, level+1);
    }

    public static void printRight(Node root, int level) {

        if(root == null)
            return;

        if(max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }

        printRight(root.right, level+1);
        printRight(root.left, level+1);
    }


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        tree.root.right.right.right = new Node(50);

        printLeft(tree.root, 1);
        max_level = 0;
        System.out.println();
        printRight(tree.root, 1);
    }
}
