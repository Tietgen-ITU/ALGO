package dk.ant.itu.algo.kattis.HC;

import edu.princeton.cs.algs4.Bag;

public class Graph {
    
    private final Bag<Edge>[] adjacentVertices;
    private final int verticesCount;

    public Graph(int n) {
        this.verticesCount = n;
        this.adjacentVertices = new Bag[n];
        for(int i = 0; i < n; i++)
            adjacentVertices[i] = new Bag<>();
    }

    public void addEdge(int v, int w, int c) {

        Edge newEdge = new Edge(v, w, c);

        this.adjacentVertices[v].add(newEdge);
        this.adjacentVertices[w].add(newEdge);
    }

    public Iterable<Edge> getAdjacent(int v) {

        return this.adjacentVertices[v];
    }

    public int size() {
        return this.verticesCount;
    }
}
