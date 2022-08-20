package Trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopAndBottomView {
  static class NodeInfo {
    Node node;
    int horizontalDistance;

    NodeInfo(Node node, int horizontalDistance) {
      this.node = node;
      this.horizontalDistance = horizontalDistance;
    }
  }

  public static void topView(Node root) {
    Map<Integer, Integer> map = bottomViewUtil(root);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
  }

  // Top View of binary tree
  public static Map<Integer, Integer> topViewUtil(Node root) {
    Map<Integer, Integer> topViewNodes = new TreeMap<>();
    Queue<NodeInfo> queue = new LinkedList<>();
    NodeInfo nodeInfo = new NodeInfo(root, 0);
    queue.add(nodeInfo);

    while(!queue.isEmpty()) {
      NodeInfo element = queue.poll();
      Node node = element.node;
      int distance = element.horizontalDistance;
      if (!topViewNodes.containsKey(distance)) {
        topViewNodes.put(distance, node.data);
      }

      if (node.left != null) {
        queue.add(new NodeInfo(node.left, element.horizontalDistance - 1));
      }

      if (node.right != null) {
        queue.add(new NodeInfo(node.right, element.horizontalDistance + 1));
      }
    }
    return topViewNodes;
  }

  // Bottom view of binary tree
  public static Map<Integer, Integer> bottomViewUtil(Node root) {
    Map<Integer, Integer> topViewNodes = new TreeMap<>();
    Queue<NodeInfo> queue = new LinkedList<>();
    NodeInfo nodeInfo = new NodeInfo(root, 0);
    queue.add(nodeInfo);

    while(!queue.isEmpty()) {
      NodeInfo element = queue.poll();
      Node node = element.node;
      int distance = element.horizontalDistance;
      topViewNodes.put(distance, node.data);

      if (node.left != null) {
        queue.add(new NodeInfo(node.left, element.horizontalDistance - 1));
      }

      if (node.right != null) {
        queue.add(new NodeInfo(node.right, element.horizontalDistance + 1));
      }
    }
    return topViewNodes;
  }
}
