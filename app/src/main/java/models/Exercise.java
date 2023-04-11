package models;

public class Exercise {
    private String title;
    private String count;
    private int ExerciseImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getExerciseImage() {
        return ExerciseImage;
    }

    public void setExerciseImage(int exerciseImage) {
        ExerciseImage = exerciseImage;
    }

    public Exercise(String title, String count, int exerciseImage) {
        this.title = title;
        this.count = count;
        ExerciseImage = exerciseImage;
    }
}
