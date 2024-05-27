package org.yv;

import lombok.*;

import java.util.ArrayList;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId;

    // Check if the sum of weights of all assignments equals to 1 (100%)
    public boolean isAssignmentWeightValid() {
        double totalWeight = 0.0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1.0;
    }

    // Register a student to the course
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false; // Student already registered
        }

        registeredStudents.add(student); // Add student to course's list
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null); // Add a null score for the new student
        }
        finalScores.add(null); // Add a null for the final score of the new student

        return true;
    }

    // Calculate weighted average score of a student
    public int[] calcStudentsAverage() {
        int[] studentAverages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            double weightedSum = 0.0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    weightedSum += score * assignment.getWeight();
                }
            }
            studentAverages[i] = (int) Math.round(weightedSum);
        }
        return studentAverages;
    }

    // Add a new assignment to the course
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment newAssignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(newAssignment);
        for (Student student : registeredStudents) {
            newAssignment.getScores().add(null); // Add a null score for each student
        }
        return true;
    }

    // Generate random scores for each assignment and student
    public void generateScores() {
        Random random = new Random();
        for (Assignment assignment : assignments) {
            assignment.getScores().clear();
            for (int i = 0; i < registeredStudents.size(); i++) {
                int rand = random.nextInt(11); // Random number in range [0, 10]
                int score;
                if (rand == 0) {
                    score = random.nextInt(60); // [0, 60)
                } else if (rand <= 2) {
                    score = 60 + random.nextInt(10); // [60, 70)
                } else if (rand <= 4) {
                    score = 70 + random.nextInt(10); // [70, 80)
                } else if (rand <= 8) {
                    score = 80 + random.nextInt(10); // [80, 90)
                } else {
                    score = 90 + random.nextInt(11); // [90, 100]
                }
                assignment.getScores().add(score);
            }
        }
        int[] studentAverages = calcStudentsAverage();
        for (int i = 0; i < finalScores.size(); i++) {
            finalScores.set(i, (double) studentAverages[i]);
        }
    }

    // Display scores in a table
    public void displayScores() {
        System.out.println("Course: " + courseName + "(" + courseId + ")");
        System.out.print("           ");
        for (Assignment assignment : assignments) {
            System.out.print(assignment.getAssignmentName() + "   ");
        }
        System.out.println("Final Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.print(student.getStudentName() + "   ");
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.print((score == null ? "N/A" : score) + "   ");
            }
            System.out.println(finalScores.get(i));
        }

        System.out.print("Average   ");
        for (Assignment assignment : assignments) {
            assignment.calcAssignmentAvg();
            System.out.print(assignment.getAssignmentAverage() + "   ");
        }
        System.out.println();
    }

    // Convert to a simplified string
    public String toSimplifiedString() {
        return String.format("CourseId: %s, CourseName: %s, Credits: %d, Department: %s",
                courseId, courseName, credits, department.getDepartmentName());
    }

    // Convert to a detailed string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CourseId: ").append(courseId).append("\n")
                .append("CourseName: ").append(courseName).append("\n")
                .append("Credits: ").append(credits).append("\n")
                .append("Department: ").append(department.getDepartmentName()).append("\n")
                .append("Assignments: \n");
        for (Assignment assignment : assignments) {
            sb.append("    ").append(assignment.toString()).append("\n");
        }
        sb.append("Registered Students: \n");
        for (Student student : registeredStudents) {
            sb.append("    ").append(student.toSimplifiedString()).append("\n");
        }
        return sb.toString();
    }
}
