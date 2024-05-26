Final Project
Project Description
This project consists of several classes representing components of a college or university system:

Address: Represents an address with fields for street number, street name, city, province, postal code, and country.

Department: Represents a department with fields for department ID and department name.

Student: Represents a student with fields for student ID, student name, gender, address, department, and registered courses.

Assignment: Represents an assignment with fields for assignment ID, assignment name, weight, maximum score, assignment average, and scores.

Course: Represents a course with fields for course ID, course name, credits, department, assignments, registered students, and final scores.

Gender: Enum representing genders - FEMALE and MALE.

Util: Contains utility methods, including a method to convert strings to title case.

Unit tests are provided for the following methods:

Address: isPostalCodeValid
Assignment: calcAssignmentAvg
Course: calcStudentAvg
Util: toTitleCase