package models;

public class Exercise {
    private String title;
    private int count;
    private int ExerciseImage;
    private String level;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getExerciseImage() {
        return ExerciseImage;
    }

    public void setExerciseImage(int exerciseImage) {
        ExerciseImage = exerciseImage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Exercise(String title, int count, int exerciseImage, String level) {
        this.title = title;
        this.count = count;
        ExerciseImage = exerciseImage;
        this.level = level;
    }
}
