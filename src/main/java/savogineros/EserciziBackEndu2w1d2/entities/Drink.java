package savogineros.EserciziBackEndu2w1d2.entities;

public class Drink extends Item{
    private String name;


    public Drink(int calories, double price, String name) {
        super(calories, price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", calories='" + getCalories() +
                "', price='" + getPrice() + '\'' +
                '}';
    }
}
