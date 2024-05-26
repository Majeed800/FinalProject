package org.example;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@EqualsAndHashCode
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(){

    }

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = "A" + String.format("%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
    }


    public void calcAssignmentAvg() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        assignmentAverage = (double) sum / scores.size();
    }

    public void generateRandomScore() {
        Random rand = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int randomNum = rand.nextInt(11);
            int score;
            if (randomNum == 0) {
                score = rand.nextInt(60);
            } else if (randomNum < 3) {
                score = rand.nextInt(60, 70) ;
            } else if (randomNum < 5) {
                score = rand.nextInt(70, 80) ;
            } else if (randomNum < 9) {
                score = rand.nextInt(80, 90);
            } else {
                score = rand.nextInt(90, 101);
            }
            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment ID: " + assignmentId + ", Assignment Name: " + assignmentName + ", Weight: " + weight + ", Max Score: " + maxScore;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public double getAssignmentAverage() {
        return assignmentAverage;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public static int getNextId() {
        return nextId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setAssignmentAverage(double assignmentAverage) {
        this.assignmentAverage = assignmentAverage;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public static void setNextId(int nextId) {
        Assignment.nextId = nextId;
    }
}
