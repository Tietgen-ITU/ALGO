package dk.ant.itu.algo.training.e1;

/**
 * This is a class for the exercise 1.1.14
 */
public class LogAlgorithm {
    
    // Place to run things
    public static void main(String[] args) {
        
        int testInt = 10;

        System.out.println("Base-2 log: " + log2(testInt));
        System.out.println("Greatest integer: " + getCreatesIntegerBehindLog(testInt));
    }

    /**
     * This is a method to get the greatest integer that is smaller than the base 2 logarithm
     * @param x
     * @return
     */
    private static int getCreatesIntegerBehindLog(int x) {

        double log2Result = log2(x); // Calculate the base-2 logarithm
        double remainder = log2Result % 1;

        int result = (int)(log2Result - remainder);

        return log2Result == result ? result - 1 : result; // If the result is equal to log2Result then -1
    }

    /**
     * Calculates the base 2 logarithm.
     * Inspiration from: https://www.techiedelight.com/calculate-log-base-2-in-java/
     * @param x
     * @return
     */
    private static double log2(int x) {

        return Math.log(x) / Math.log(2);
    }
}
