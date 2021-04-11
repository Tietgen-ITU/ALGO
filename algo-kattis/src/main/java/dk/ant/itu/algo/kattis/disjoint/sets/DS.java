package dk.ant.itu.algo.kattis.disjoint.sets;

import java.util.Scanner;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * This is a task based on the mandatory assignment from the Algorithms and Data Structure course.
 * Link to kattis task: https://itu.kattis.com/sessions/skkmtp/problems/itu.disjointsets
 * @author Andreas Nicolaj Tietgen
 * @version 2.0.0 
 */
public class DS {
    
    /**
     * Starting point of the program
     * @param args Arguments passed to it before
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            
            // Read initial input (Setup the playing field)
            int n = scanner.nextInt(); // Initial number of singletons... 
            int m = scanner.nextInt(); // Lines of commands to loop through

            // Create data structure
            CustomUF uf = new CustomUF(n);

            // Do the stuff
            for(int i = 0; i < m; i++) {

                // Read the new line
                scanner.nextLine();
                int operation = scanner.nextInt();
                int p = scanner.nextInt();
                int q = scanner.nextInt();

                if(operation == 0) {

                    boolean isConnected = uf.isConnected(p, q);
                    if(isConnected)
                        System.out.println(1);
                    else
                        System.out.println(0);

                } else if(operation == 1) {

                    uf.union(p, q);
                } else if(operation == 2) {

                    uf.move(p, q);
                }

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        } finally {

            scanner.close(); // Remember to close...
        }
    }
}