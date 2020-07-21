package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalOfATree {

    public static void printLevelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
         while(!queue.isEmpty()) {
             Node temp = queue.poll();
             System.out.print(temp.data+" ");

             if(temp != null && temp.left != null)
                 queue.add(temp.left);

             if(temp != null && temp.right != null)
                 queue.add(temp.right);
         }
    }

    public static void main(String[] args) {
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder(tree_level.root);
    }
}
