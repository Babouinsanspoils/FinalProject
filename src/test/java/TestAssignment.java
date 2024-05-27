import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yv.Assignment;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssignment {

    @Test
    public void testcalcAssignmentAvg1() {
        Assignment assignment = new Assignment();
        assignment.setScore(80);
        assignment.setScore(90);
        assignment.setScore(100);
        assignment.calcAssignmentAvg();
        double expected = 90.0;
        double result = assignment.getAssignmentAverage();
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testcalcAssignmentAvg2() {
        Assignment assignment = new Assignment();
        assignment.setScore(70);
        assignment.setScore(85);
        assignment.setScore(60);
        assignment.calcAssignmentAvg();
        double expected = 71.66;
        double result = assignment.getAssignmentAverage();
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testcalcAssignmentAvg3() {
        Assignment assignment = new Assignment();
        assignment.setScore(80);
        assignment.setScore(90);
        assignment.setScore(100);
        assignment.setScore(100);
        assignment.calcAssignmentAvg();
        double expected = 92.5;
        double result = assignment.getAssignmentAverage();
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testcalcAssignmentAvg4() {
        Assignment assignment = new Assignment();
        assignment.setScore(0);
        assignment.setScore(0);
        assignment.setScore(0);
        assignment.calcAssignmentAvg();
        double expected = 0;
        double result = assignment.getAssignmentAverage();
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, result);
    }
}
