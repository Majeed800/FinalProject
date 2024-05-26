package org.example;

import lombok.EqualsAndHashCode;

import lombok.ToString;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EqualsAndHashCode
@ToString

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private double[] finalScores;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = generateNextId(department);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new double[registeredStudents.size()];
    }

    private String generateNextId(Department department) {
        return "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
    }

    public boolean isAssignmentWeightValid() {
        double sumOfWeights = 0;
        for (Assignment assignment : assignments) {
            sumOfWeights += assignment.getWeight();
        }
        return sumOfWeights == 1.0;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        finalScores = new double[registeredStudents.size()];
        return true;
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;
            double weightSum = 0;
            for (int j = 0; j < assignments.size(); j++) {
                if (assignments.get(j).getScores().get(i) != null) {
                    sum += assignments.get(j).getScores().get(i) * assignments.get(j).getWeight();
                    weightSum += assignments.get(j).getWeight();
                }
            }
            averages[i] = weightSum > 0 ? (int) Math.round(sum / weightSum) : 0;
        }
        return averages;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(assignment);
        for (Student student : registeredStudents) {
            assignment.getScores().add(null);
        }
        return true;
    }

    public void generateScores() {
        Random rand = new Random();
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
            for (int i = 0; i < registeredStudents.size(); i++) {
                int score = assignment.getScores().get(i);
                finalScores[i] += score * assignment.getWeight();
            }
        }
        for (int i = 0; i < registeredStudents.size(); i++) {
            finalScores[i] /= assignments.size();
        }
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + "(" + courseId + ")");
        System.out.println("Assignments:");
        for (Assignment assignment : assignments) {
            System.out.println("\t" + assignment);
        }
        System.out.println("Registered Students:");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.print("\t" + student.getStudentName() + "\t");
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.print((score != null ? score : "N/A") + "\t");
            }
            System.out.println(finalScores[i]);
        }
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCredits() {
        return credits;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public double[] getFinalScores() {
        return finalScores;
    }

    public static int getNextId() {
        return nextId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void setRegisteredStudents(List<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public void setFinalScores(double[] finalScores) {
        this.finalScores = finalScores;
    }

    public static void setNextId(int nextId) {
        Course.nextId = nextId;
    }
}
