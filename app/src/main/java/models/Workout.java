package models;

public class Workout {
    private String title;
    private String shortDescription;
    private int img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Workout(String title, String shortDescription, int img) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.img = img;
    }
}
