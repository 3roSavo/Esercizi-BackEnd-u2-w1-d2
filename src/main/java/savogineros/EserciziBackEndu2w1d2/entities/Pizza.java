package savogineros.EserciziBackEndu2w1d2.entities;

import java.util.List;

public class Pizza extends Item{
    private String name;
    List<Topping> toppingList;


    public Pizza(String name, List<Topping> toppingList) {
        super(800, 5.0);
        this.name = name;
        this.toppingList = toppingList;
        setCalories(setCalories(toppingList)); // se avessi usato gli attributi su Item in stile protected avrei potuto fare
        setPrice(setPrice(toppingList));       // this.calories = setCalories(toppingList). avrei potuto usare il nome dell'attributo
    }                                          // ovunque, nei metodi, nel setter ecc...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", toppingList=" + toppingList +
                ", calories=" + getCalories() + // avrei anche potuto mettere getCalories(), dato che ho a disposizione tutti i metodi della classe astratta
                ", price=" + getPrice() + // avrei anche potuto mettere getPrice(), dato che ho a disposizione tutti i metodi della classe astratta
                '}';
    }

    // METODI

    public int setCalories(List<Topping> toppingList) {
        int totalCalories = 800;
        if (toppingList != null) {
            for (int i = 0; i < toppingList.size(); i++) {
                totalCalories += toppingList.get(i).getCalories();
            }
        }
        return totalCalories;
    }
    public double setPrice(List<Topping> toppingList) {
        double totalPrice = 5;
        if (getPrice() != 0) {
            for (int i = 0; i < toppingList.size(); i++) {
                totalPrice += toppingList.get(i).getPrice();
            }
        }
        return totalPrice;
    }
}
