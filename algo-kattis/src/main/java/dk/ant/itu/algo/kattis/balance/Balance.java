package dk.ant.itu.algo.kattis.balance;

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.princeton.cs.algs4.LinkedStack;

/**
 * This is a task based on the mandatory assignment from the Algorithms and Data Structure course.
 * Link to kattis task: https://itu.kattis.com/sessions/ke376g/problems/itu.balance
 * @author Andreas Nicolaj Tietgen
 * @version 1.0.0 
 */
public class Balance {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        LinkedStack<Character> s = new LinkedStack<Character>();

        char[] parenthesis = scanner.next().toCharArray();

        boolean isBalanced = true;

        if ((parenthesis.length % 2) != 0)
            System.out.println(0);
        else if (parenthesis.length == 0)
            System.out.println(1);
        else {

            for(int i = 0; i < parenthesis.length; i++) {
                
                char p = parenthesis[i];

                if(p == '(' || p == '[')
                    s.push(p);
                else {

                    try {

                        char startParenthesis = s.pop();
                        boolean isParaBalanced = (startParenthesis == '(' && p == ')');
                        boolean isSqParaBalanced = (startParenthesis == '[' && p == ']');

                        if(!isParaBalanced && !isSqParaBalanced) {

                            isBalanced = false;
                            break;
                        }
                    } catch (NoSuchElementException ex) {
                        
                        isBalanced = false;
                        break;
                    }
                }
            }

            if(s.size() == 0 && isBalanced)
                System.out.println(1);
            else
                System.out.println(0);
        }

        scanner.close();
    }
}
