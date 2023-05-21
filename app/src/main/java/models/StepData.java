package models;

import java.util.ArrayList;
import java.util.List;

public class StepData {
    private int totalSteps;
    private int todaySteps;
    private List<Integer> weekSteps = new ArrayList<>();
    private List<Integer> monthSteps = new ArrayList<>();

    public StepData(int totalSteps, int todaySteps, List<Integer> weekSteps, List<Integer> monthSteps) {
        this.totalSteps = totalSteps;
        this.todaySteps = todaySteps;
        this.weekSteps = weekSteps;
        this.monthSteps = monthSteps;
    }

    public StepData() {
        this.totalSteps = 0;
        this.todaySteps = 0;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public int getTodaySteps() {
        return todaySteps;
    }

    public void setTodaySteps(int todaySteps) {
        this.todaySteps = todaySteps;
    }

    public List<Integer> getWeekSteps() {
        return weekSteps;
    }

    public void setWeekSteps(List<Integer> weekSteps) {
        this.weekSteps = weekSteps;
    }

    public List<Integer> getMonthSteps() {
        return monthSteps;
    }

    public void setMonthSteps(List<Integer> monthSteps) {
        this.monthSteps = monthSteps;
    }
}
