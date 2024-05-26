package org.yv;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId;

    // Calculate assignment average
    public void calcAssignmentAvg() {
        if (scores.isEmpty()) {
            assignmentAverage = 0.0;
        } else {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            assignmentAverage = (double) sum / scores.size();
        }
    }

    // Generate random scores for all students in the assignment
    public void generateRandomScore(int numberOfStudents) {
        Random random = new Random();
        for (int i = 0; i < numberOfStudents; i++) {
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
            scores.add(score);
        }
        calcAssignmentAvg(); // Recalculate the average after generating scores
    }

    // String representation with details
    @Override
    public String toString() {
        return String.format("AssignmentId: %s, AssignmentName: %s, Weight: %.2f, MaxScore: %d",
                assignmentId, assignmentName, weight, maxScore);
    }
}
