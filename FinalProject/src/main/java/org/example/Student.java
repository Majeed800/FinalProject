package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;


@Setter
@EqualsAndHashCode

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = generateNextId();
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    private String generateNextId() {
        return "S" + String.format("%05d", nextId++);
    }
    
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);
        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }
        return true;
    }
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }

    /**
     * converts a student to a simple string with only the `studentId`, the `studentName`, and `departmentName`
     * @return the simplified string
     */
    public String toSimplifiedString() {
        return "Student ID: " + studentId + ", Name: " + studentName + ", Department: "
                + department.getDepartmentName();
    }
    @Override
    public String toString() {
        String result = "Student ID: " + studentId + "\n" +
                "Student Name: " + studentName + "\n" +
                "Gender: " + gender + "\n" +
                "Address: " + address + "\n" +
                "Department: " + department.getDepartmentName() + "\n" +
                "Registered Courses:\n";

        for (Course course : registeredCourses) {
            result += "  Course ID: " + course.getCourseId() + ", Course Name: " + course.getCourseName() +
                    ", Department: " + course.getDepartment().getDepartmentName() + "\n";
        }

        return result;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public static int getNextId() {
        return nextId;
    }
}
