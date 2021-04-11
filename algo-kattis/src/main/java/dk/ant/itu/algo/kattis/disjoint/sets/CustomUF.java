package dk.ant.itu.algo.kattis.disjoint.sets;

/**
 * This class is an inspiration of the data structure weighted union-find but with path compression.
 * @author Andreas Nicolaj Tietgen
 * @version 1.0.1 
 */
public class CustomUF {
    
    private int[] id; // The different sites (nodes)
    private int[] size; // Size of the trees

    /**
     * Initializes the data structure with n elements of singleton sets
     * @param n number of elements to initalize
     */
    public CustomUF(int n) {

        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {

            id[i] = i; // They have to point at them self
            size[i] = 1; // Because they are singletons, then they only have a tree size on 1
        }
    }

    /**
     * Checks whether or not p and q is in the same connected component
     * @param p site number between 0 <= p < n
     * @param q site number between 0 <= q < n
     * @return Returns true if the two sites are connected, else then false
     */
    public boolean isConnected(int p, int q) {

        // Find the root of the component
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ; // Check if the root values are the same
    }

    /**
     * If the to sites are not connected then it will union the two components the sites are a part of
     * @param p site number between 0 <= p < n
     * @param q site number between 0 <= p < n
     */
    public void union(int p, int q) {

        // Find the root of the component
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ)
            return; // Abort mission...
        
        // Join the to trees
        if(rootP < rootQ) {

            id[rootP] = rootQ;
            size[rootQ] += size[rootP]; // Add the size of the tree
        } else {

            id[rootQ] = rootP; 
            size[rootP] += size[rootQ]; // Add the size of the tree
        }
    }

    /**
     * If the two sites are not connected then it will take only the site p and connect it to the root of site q's component 
     * @param p site number between 0 <= p < n
     * @param q site number between 0 <= p < n
     */
    public void move(int p, int q) {

        // Find the root of the component
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ)
            return; // Abort mission...
        
        if(id[p] == rootP) {

            // Move all the sub nodes
            for(int i = 0; i < id.length; i++) {

                
            }
        } else {

            // Move only the node
            id[p] = rootQ;
        }
    }

    /**
     * Find the root for the component of p
     * @param p site number between 0 <= p < n
     * @return Returns the root of the component the site p is a member of
     */
    private int find(int p) {

        // Assign new variable so we don't mess up p
        int root = p;

        // Loop until value of root is the same value as the id
        while(root != id[root]) {

            id[root] = id[id[id[id[root]]]]; // path compression line
            root = id[root];
        }

        return root;
    }
}
