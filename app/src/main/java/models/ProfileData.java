package models;

import java.util.Date;

public class ProfileData {
    private String name;
    private int height;
    private int weight;
    private long birthDate;

    public ProfileData(String name, int height, int weight, long birthDate) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }
}
