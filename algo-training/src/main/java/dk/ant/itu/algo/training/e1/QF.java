package dk.ant.itu.algo.training.e1;

import edu.princeton.cs.algs4.QuickFindUF;

/**
 * This class is for the Quick Find exercise (1.5.1)
 */
public class QF {
    
    public static void main(String[] args) {
        
        // 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2
        QuickFindUF qf = new QuickFindUF(10);
        qf.union(9, 0);
        qf.union(3, 4);
        qf.union(5, 8);
        qf.union(7, 2);
        qf.union(2, 1);
        qf.union(5, 7);
        qf.union(0, 3);
        qf.union(4, 2);
    }
}
