package models;
public class Medical {
    private String medName;
    private String receptionTime;
    private String receptionDuration;
    private String receptionDaysRemaining;

    private int img;

    public String getReceptionDaysRemaining() {
        return receptionDaysRemaining;
    }

    public void setReceptionDaysRemaining(String receptionDaysRemaining) {
        this.receptionDaysRemaining = receptionDaysRemaining;
    }

    public Medical(String medName, String receptionTime, String receptionDuration, int img) {
        this.medName = medName;
        this.receptionTime = receptionTime;
        this.receptionDuration = receptionDuration;
        this.img = img;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getReceptionTime() {
        return receptionTime;
    }

    public void setReceptionTime(String receptionTime) {
        this.receptionTime = receptionTime;
    }

    public String getReceptionDuration() {
        return receptionDuration;
    }

    public void setReceptionDuration(String receptionDuration) {
        this.receptionDuration = receptionDuration;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
