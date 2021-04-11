package dk.ant.itu.algo.training.e3;

import edu.princeton.cs.algs4.LinearProbingHashST;

/**
 * This is a class that adds a delete method to the default implementation of the Linear Probing Hash Symbol Table.
 * This is from excersize 3.4.26
 */
public class LPHST<Key, Value> {
    
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    public LPHST() {
        keys = (Key[])    new Object[M];
        vals = (Value[])  new Object[M];
    }

    public void delete(Key key)
    {
        if(!this.contains(key))
            return;

        int i = hash(key);
    }

    public Value get(Key key) {
        for(int i = hash(key); keys[i] != null; i = (i + 1) % M) {

            if(keys[i].equals(key))
                return vals[i];   
        }

        return null;
    }

    public void put(Key key, Value val) {

        if(N >= M/2)
            resize(2*M);
        
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {

            if(keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }

        keys[i] = key;
        vals[i] = val;
        N++;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private boolean contains(Key key) {

        Value val = get(key);

        return val != null;
    }
}
