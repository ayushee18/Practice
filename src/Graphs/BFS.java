package Graphs;

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(2, 3);
        graph.addEdges(3, 3);
    }
}
