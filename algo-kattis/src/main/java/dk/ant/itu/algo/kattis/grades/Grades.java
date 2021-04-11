package dk.ant.itu.algo.kattis.grades;

import java.util.Scanner;
import edu.princeton.cs.algs4.Insertion;

public class Grades {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        try {

            int n = scanner.nextInt();
            Student[] students = new Student[n];

            scanner.nextLine();

            for(int i = 0; i < n; i++) {

                // Readline
                String[] studentAttr = scanner.nextLine().split(" ");

                students[i] = new Student(studentAttr[0], studentAttr[1]);
            }

            Insertion.sort(students);

            for (Student student : students) {
                
                System.out.println(student);
            }
        } catch (Exception ex) {

            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {

            scanner.close();
        }
    }
}
