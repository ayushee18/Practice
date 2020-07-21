package Trees;

public class NodeTrees {
    int data;
    NodeTrees left, right;

    public NodeTrees(int data)
    {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "NodeTrees{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
  