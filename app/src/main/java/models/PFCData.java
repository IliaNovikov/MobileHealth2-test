package models;

public class PFCData {
    private int proteinTotal;
    private int fatTotal;
    private int carbTotal;

    private int proteinCurrent;
    private int fatCurrent;
    private int carbCurrent;

    public PFCData(int proteinTotal, int fatTotal, int carbTotal, int proteinCurrent, int fatCurrent, int carbCurrent) {
        this.proteinTotal = proteinTotal;
        this.fatTotal = fatTotal;
        this.carbTotal = carbTotal;
        this.proteinCurrent = proteinCurrent;
        this.fatCurrent = fatCurrent;
        this.carbCurrent = carbCurrent;
    }

    public PFCData() {

    }

    public int getProteinTotal() {
        return proteinTotal;
    }

    public void setProteinTotal(int proteinTotal) {
        this.proteinTotal = proteinTotal;
    }

    public int getFatTotal() {
        return fatTotal;
    }

    public void setFatTotal(int fatTotal) {
        this.fatTotal = fatTotal;
    }

    public int getCarbTotal() {
        return carbTotal;
    }

    public void setCarbTotal(int carbTotal) {
        this.carbTotal = carbTotal;
    }

    public int getProteinCurrent() {
        return proteinCurrent;
    }

    public void setProteinCurrent(int proteinCurrent) {
        this.proteinCurrent = proteinCurrent;
    }

    public int getFatCurrent() {
        return fatCurrent;
    }

    public void setFatCurrent(int fatCurrent) {
        this.fatCurrent = fatCurrent;
    }

    public int getCarbCurrent() {
        return carbCurrent;
    }

    public void setCarbCurrent(int carbCurrent) {
        this.carbCurrent = carbCurrent;
    }
}
