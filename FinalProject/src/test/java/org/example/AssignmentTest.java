package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AssignmentTest {

    @Test
    public void testCalcAssignmentAvg() {
        Assignment assignment = new Assignment("Test Assignment", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(70);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(80.0, assignment.getAssignmentAverage(), 0.01);
    }

    @Test
    public void testCalcAssignmentAvgSingleScore() {
        Assignment assignment = new Assignment("Test Assignment", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(90);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(90.0, assignment.getAssignmentAverage());
    }

    @Test
    public void testCalcAssignmentAvgAllZeroScores() {
        Assignment assignment = new Assignment("Test Assignment", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(0);
        scores.add(0);
        scores.add(0);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(0.0, assignment.getAssignmentAverage());
    }

    @Test
    public void testCalcAssignmentAvgMaxScores() {
        Assignment assignment = new Assignment("Test Assignment", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(100);
        scores.add(100);
        scores.add(100);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(100.0, assignment.getAssignmentAverage());
    }
}
