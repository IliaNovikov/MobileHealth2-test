package models;

import android.graphics.Color;
import android.media.Image;

public class Section {
    private int imageResource;
    private String title;
    private int backgroundColor;

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Section(int imageResource, String title, int backgroundColor) {
        this.imageResource = imageResource;
        this.title = title;
        this.backgroundColor = backgroundColor;
    }
}
