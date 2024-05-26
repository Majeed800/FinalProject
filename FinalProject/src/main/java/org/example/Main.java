package org.example;

import util.Util;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create a Department
        Department department = new Department( "CS");

        // Create an Address instance
        Address address1 = new Address(123, "Main St", "Springfield", "IL", "h3n2s1", "USA");
        Address address2 = new Address(456, "Elm St", "Springfield", "IL", "h3n2s1", "USA");
        Address address3 = new Address(789, "Oak St", "Springfield", "IL", "h3n2s1", "USA");

        // Create Student instances
        Student alice = new Student("Alice", Gender.FEMALE, address1, department);
        Student bob = new Student("Bob", Gender.MALE, address2, department);
        Student charlie = new Student("Charlie", Gender.MALE, address3, department);

        // Create a Course instance
        Course course = new Course("Introduction to Programming", 3.0, department);

        // Register students in the course
        course.registerStudent(alice);
        course.registerStudent(bob);
        course.registerStudent(charlie);

        // Add some assignments
        course.addAssignment("Assignment 1", 0.3, 100);
        course.addAssignment("Assignment 2", 0.4, 100);
        course.addAssignment("Assignment 3", 0.3, 100);

        // Add scores for the assignments
        List<Assignment> assignments = course.getAssignments();
        assignments.get(0).setScores(new ArrayList<>(List.of(80, 90, 70)));
        assignments.get(1).setScores(new ArrayList<>(List.of(70, 85, 75)));
        assignments.get(2).setScores(new ArrayList<>(List.of(85, 80, 90)));

        // Calculate and display the average scores
        int[] averages = course.calcStudentsAverage();
        System.out.println("Average Scores:");
        for (int i = 0; i < averages.length; i++) {
            System.out.println(course.getRegisteredStudents().get(i).getStudentName() + ": " + averages[i]);
        }

        // Display the course details and scores
        course.displayScores();
    }
}
