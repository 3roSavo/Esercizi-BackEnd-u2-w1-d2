package savogineros.EserciziBackEndu2w1d2.entities;

public abstract class Item {
    private int calories;
    private double price;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
