package dk.ant.itu.algo.kattis.grades;


public class Student implements Comparable<Student> {
 
    private String name;
    private String grade;

    public Student(String name, String grade) {
        
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {

        int compareResult = grade.compareTo(o.grade);

        if (compareResult == 0)
            return this.name.compareTo(o.name); // If the compare result is equal then we have to compare names
        
        if ((this.grade.equals("FX") && o.grade.equals("F")) || (o.grade.equals("FX") && this.grade.equals("F")))
            return compareResult * -1;

        return compareResult;
    }

    @Override
    public String toString() {

        return this.name;
    }
}
