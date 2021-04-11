package dk.ant.itu.algo.kattis.HC;

import java.util.Scanner;

/**
 * This class is for the mandatory Harmony & Conflict excerzise.
 * Link: https://itu.kattis.com/sessions/ztdei3/problems/itu.harmony
 */
public class HarmonyConflict {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Graph g = new Graph(n);

        // Build graph with edges
        for(int i = 0; i < m; i++) {

            // Get line information about the edge
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();

            g.addEdge(u, v, c);
        }

        BFS b = new BFS(g);

        if(b.harmonious()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }
}
