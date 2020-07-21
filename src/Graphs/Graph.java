package Graphs;

import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adj [];

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adj = new LinkedList[vertices];

        for(int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdges(int v, int data) {
        adj[v].add(data);
    }
}
