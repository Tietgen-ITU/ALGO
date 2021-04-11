package dk.ant.itu.algo.kattis.HC;

import edu.princeton.cs.algs4.Queue;

public class BFS {
    
    private boolean[] marked;
    private boolean[] color;
    
    private boolean isHarmonious;

    public BFS(Graph g) {
        
        isHarmonious = true;
        marked = new boolean[g.size()];
        color = new boolean[g.size()];
        bfs(g, 0);
    }

    public void bfs(Graph g, int vertex) {

        Queue<Integer> vertices = new Queue<>();
        marked[vertex] = true;
        vertices.enqueue(vertex);

        while(!vertices.isEmpty()) {

            int currentVertex = vertices.dequeue();

            for (Edge edge : g.getAdjacent(currentVertex)) {
                int adjacentVertex = edge.other(currentVertex);
                if(!marked[adjacentVertex]) {

                    if(edge.isConflict())
                        color[adjacentVertex] = !color[currentVertex];
                    else 
                        color[adjacentVertex] = color[currentVertex];
                        
                    marked[adjacentVertex] = true;
                    vertices.enqueue(adjacentVertex);
                } else {
                    if(edge.isConflict()) {

                        if(color[adjacentVertex] == color[currentVertex]) {
                            isHarmonious = false;
                            return;
                        }
                    } else if(!edge.isConflict()) {

                        if(color[adjacentVertex] != color[currentVertex]) {

                            isHarmonious = false;
                            return;
                        }
                    }    
                } 
            }
        }
    }

    public boolean harmonious() {
        return isHarmonious;
    }
}
