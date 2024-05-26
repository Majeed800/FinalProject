package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CourseTest {

    @Test
    void testCalcStudentsAverage1() {
        Department department = new Department("Computer Science");

        Address address1 = new Address(123, "New", "Toronto", "ON", "A1b 3c4",
                "Canada");
        Address address2 = new Address(456, "Old", "Toronto", "ON", "A1b3c4",
                "Canada");
        Address address3 = new Address(789, "Wise", "Toronto", "ON", "A1b 3c9",
                "Canada");


        Student student1 = new Student("Jane", Gender.FEMALE, address1, department);
        Student student2 = new Student("bill", Gender.MALE, address2, department);
        Student student3 = new Student("max", Gender.MALE, address3, department);

        Course course = new Course("Introduction to Programming", 3.0, department);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);


        course.addAssignment("Assignment 1", 0.3, 100);
        course.addAssignment("Assignment 2", 0.4, 100);
        course.addAssignment("Assignment 3", 0.3, 100);

        ArrayList<Assignment> assignments = (ArrayList<Assignment>) course.getAssignments();
        assignments.get(0).setScores(new ArrayList<>(List.of(80, 90, 70)));
        assignments.get(1).setScores(new ArrayList<>(List.of(70, 85, 75)));
        assignments.get(2).setScores(new ArrayList<>(List.of(85, 80, 90)));

        int[] expectedAverages = {78, 85, 78};

        Assertions.assertArrayEquals(expectedAverages, course.calcStudentsAverage());
    }
    @Test
    void testCalcStudentsAverage2() {
        Department department = new Department("Computer Science");

        Address address1 = new Address(123, "New", "Toronto", "ON", "A1b 3c4",
                "Canada");
        Address address2 = new Address(456, "Old", "Toronto", "ON", "A1b3c4",
                "Canada");
        Address address3 = new Address(789, "Wise", "Toronto", "ON", "A1b 3c9",
                "Canada");


        Student student1 = new Student("Jane", Gender.FEMALE, address1, department);
        Student student2 = new Student("bill", Gender.MALE, address2, department);
        Student student3 = new Student("max", Gender.MALE, address3, department);

        Course course = new Course("Introduction to Programming", 3.0, department);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);


        course.addAssignment("Assignment 1", 0.3, 100);
        course.addAssignment("Assignment 2", 0.4, 100);
        course.addAssignment("Assignment 3", 0.3, 100);

        ArrayList<Assignment> assignments = (ArrayList<Assignment>) course.getAssignments();
        assignments.get(0).setScores(new ArrayList<>(List.of(0, 0, 0)));
        assignments.get(1).setScores(new ArrayList<>(List.of(0, 0, 0)));
        assignments.get(2).setScores(new ArrayList<>(List.of(0, 0, 0)));

        int[] expectedAverages = {0, 0, 0};

        Assertions.assertArrayEquals(expectedAverages, course.calcStudentsAverage());
    }
    @Test
    void testCalcStudentsAverage3() {
        Department department = new Department("Computer Science");

        Address address1 = new Address(123, "New", "Toronto", "ON", "A1b 3c4",
                "Canada");
        Address address2 = new Address(456, "Old", "Toronto", "ON", "A1b3c4",
                "Canada");
        Address address3 = new Address(789, "Wise", "Toronto", "ON", "A1b 3c9",
                "Canada");


        Student student1 = new Student("Jane", Gender.FEMALE, address1, department);
        Student student2 = new Student("bill", Gender.MALE, address2, department);
        Student student3 = new Student("max", Gender.MALE, address3, department);

        Course course = new Course("Introduction to Programming", 3.0, department);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);


        course.addAssignment("Assignment 1", 1, 100);
        course.addAssignment("Assignment 2", 1, 100);
        course.addAssignment("Assignment 3", 1, 100);

        ArrayList<Assignment> assignments = (ArrayList<Assignment>) course.getAssignments();
        assignments.get(0).setScores(new ArrayList<>(List.of(2, 0, 70)));
        assignments.get(1).setScores(new ArrayList<>(List.of(3, 1, 90)));
        assignments.get(2).setScores(new ArrayList<>(List.of(1, 0, 40)));

        int[] expectedAverages = {2, 0, 67};

        Assertions.assertArrayEquals(expectedAverages, course.calcStudentsAverage());
    }
}