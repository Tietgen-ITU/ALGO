package dk.ant.itu.algo.kattis.HC;

public class Edge {
    
    private final int vertex1, vertex2;
    private final boolean conflict;

    public Edge(int v, int w, int connection) {
        
        this.vertex1 = v;
        this.vertex2 = w;
        this.conflict = connection == 1;
    }

    public int other(int vertex) {

        if      (vertex == this.vertex1) return this.vertex2;
        else if (vertex == this.vertex2) return this.vertex1;
        else throw new RuntimeException("Inconsistent edge");
    }

    public boolean isConflict() {
        return this.conflict;
    }
}
