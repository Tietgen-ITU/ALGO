package dk.ant.itu.algo.kattis.grades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StudentTest {
    
    @Test 
    public void compareTo_sameGradeDifferentName_resultIsMinusOne() {
        
        // Arrange 
        int expectedResult = -1;
        Student s1 = new Student("aa", "A");
        Student s2 = new Student("ab", "A");

        // Act 
        int compareResult = s1.compareTo(s2);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test 
    public void compareTo_sameGradeDifferentName_resultIs1() {
        
        // Arrange 
        int expectedResult = 1;
        Student s1 = new Student("aa", "A");
        Student s2 = new Student("ab", "A");

        // Act 
        int compareResult = s2.compareTo(s1);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test 
    public void compareTo_sameGradeSameName_resultIs0() {
        
        // Arrange 
        int expectedResult = 0;
        Student s1 = new Student("aa", "A");
        Student s2 = new Student("aa", "A");

        // Act 
        int compareResult = s1.compareTo(s2);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test 
    public void compareTo_differentGradeSameName_resultIsMinusOne() {
        
        // Arrange 
        int expectedResult = -1;
        Student s1 = new Student("aa", "A");
        Student s2 = new Student("ab", "B");

        // Act 
        int compareResult = s1.compareTo(s2);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void compareTo_differentGradeSameName_resultIs1() {
        
        // Arrange 
        int expectedResult = 1;
        Student s1 = new Student("aa", "A");
        Student s2 = new Student("ab", "B");

        // Act 
        int compareResult = s2.compareTo(s1);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void compareTo_fxGradeIsLessThanGradeF_resultIsMinusOne() {
        
        // Arrange 
        int expectedResult = -1;
        Student s1 = new Student("aa", "FX");
        Student s2 = new Student("ab", "F");

        // Act 
        int compareResult = s1.compareTo(s2);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void compareTo_fGradeIsGreaterThanGradeFX_resultIsOne() {
        
        // Arrange 
        int expectedResult = 1;
        Student s1 = new Student("aa", "FX");
        Student s2 = new Student("ab", "F");

        // Act 
        int compareResult = s2.compareTo(s1);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void compareTo_fxGradeIsGreaterThanGradeE_resultIsOne() {
        
        // Arrange 
        int expectedResult = 1;
        Student s1 = new Student("aa", "FX");
        Student s2 = new Student("ab", "E");

        // Act 
        int compareResult = s1.compareTo(s2);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void compareTo_fxGradeIsEqualToGradeFX_resultIsZero() {
        
        // Arrange 
        int expectedResult = 0;
        Student s1 = new Student("aa", "FX");
        Student s2 = new Student("aa", "FX");

        // Act 
        int compareResult = s2.compareTo(s1);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void compareTo_fxGradeIsEqualToGradeFXButNameIsNot_resultIsMinusOne() {
        
        // Arrange 
        int expectedResult = -1;
        Student s1 = new Student("aa", "FX");
        Student s2 = new Student("ab", "FX");

        // Act 
        int compareResult = s1.compareTo(s2);

        // Assert
        assertEquals(expectedResult, compareResult);
    }

    @Test
    public void compareTo_fxGradeIsEqualToGradeFXButNameIsNot_resultIsOne() {
        
        // Arrange 
        int expectedResult = 1;
        Student s1 = new Student("aa", "FX");
        Student s2 = new Student("ab", "FX");

        // Act 
        int compareResult = s2.compareTo(s1);

        // Assert
        assertEquals(expectedResult, compareResult);
    }
}
