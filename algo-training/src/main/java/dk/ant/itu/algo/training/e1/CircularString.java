package dk.ant.itu.algo.training.e1;

import edu.princeton.cs.algs4.LinkedQueue;

/**
 * Exercise 1.2.6, week 2
 */
public class CircularString {
    
    public static void main(String[] args) {
        
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";

        System.out.println(IsCircularString(s1, s2));
    }

    /**
     * Checks if this is a circular string.
     * Credit to Amalie Bøgild Sørensen (ABSO)
     * @param s1
     * @param s2
     * @return True if the string is a circular string 
     */
    public static boolean IsCircularString(String s1, String s2) {
        
        String s = s1 + s1;

        return s.contains(s2);
    }
} 