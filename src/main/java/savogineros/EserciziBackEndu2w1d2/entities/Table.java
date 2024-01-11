package savogineros.EserciziBackEndu2w1d2.entities;

public class Table {
    private int numTable;
    private int maxTableCovers;
    private boolean isFree;
    private double coverPrice;

    // COSTRUTTORE
    public Table(int numTable, int maxTableCovers, boolean isFree, double coverPrice) {
        this.numTable = numTable;
        this.maxTableCovers = maxTableCovers;
        this.isFree = isFree;
        this.coverPrice = coverPrice;
    }

    // GETTER E SETTER
    public int getNumTable() {
        return numTable;
    }

    public void setNumTable(int numTable) {
        this.numTable = numTable;
    }

    public int getMaxTableCovers() {
        return maxTableCovers;
    }

    public void setMaxTableCovers(int maxTableCovers) {
        this.maxTableCovers = maxTableCovers;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean free) {
        isFree = free;
    }

    public double getCoverPrice() {
        return coverPrice;
    }

    public void setCoverPrice(double coverPrice) {
        this.coverPrice = coverPrice;
    }

    // METODI
    public void printTable() {
        System.out.println("Numero tavolo = " + numTable);
        System.out.println("Numero massimo coperti = " + maxTableCovers);
        System.out.println("Occupato/Libero = " + (isFree? "Libero" : "Occupato"));
    }
}
