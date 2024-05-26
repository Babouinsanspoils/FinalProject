package org.yv;

import lombok.EqualsAndHashCode;
import java.util.ArrayList;

@EqualsAndHashCode
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId;

    // Constructor
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<Course>();
    }

    // Generate student ID
    private String generateStudentId() {
        return "S" + String.format("%05d", nextId++);
    }

    // Register course method
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false; // Course already registered
        }

        registeredCourses.add(course); // Add course to student's list
        course.addStudent(this); // Add student to course's list
        course.appendNullScores(this); // Append null scores for this student

        return true;
    }

    // Drop course method
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false; // Course not registered
        }

        registeredCourses.remove(course); // Remove course from student's list
        course.removeStudent(this); // Remove student from course's list

        return true;
    }

    // Simplified string representation
    public String toSimplifiedString() {
        return String.format("StudentId: %s, Name: %s, Department: %s",
                studentId, studentName, department.getName());
    }

    // String representation with details
    @Override
    public String toString() {
        String studentDetails = "StudentId: " + studentId + "\n" +
                "Name: " + studentName + "\n" +
                "Gender: " + gender + "\n" +
                "Address: " + address + "\n" +
                "Department: " + department.getName() + "\n" +
                "Registered Courses: \n";

        for (Course course : registeredCourses) {
            studentDetails += "    " + course.toSimplifiedString() + "\n";
        }

        return studentDetails;
    }

    // Check if there is unnecessary code
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }
}
