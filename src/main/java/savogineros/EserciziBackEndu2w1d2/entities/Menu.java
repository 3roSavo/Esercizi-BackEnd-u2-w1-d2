package savogineros.EserciziBackEndu2w1d2.entities;

import java.util.List;

public class Menu {
    private List<Pizza> pizzaList;
    private List<Drink> drinkList;
    private List<Topping> toppingList;

    public Menu(List<Pizza> pizzaList, List<Drink> drinkList, List<Topping> toppingList) {
        this.pizzaList = pizzaList;
        this.drinkList = drinkList;
        this.toppingList = toppingList;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    // METODI
    public void printMenu() {
        System.out.println("*****Menù!*****");
        System.out.println("PIZZE");
        getPizzaList().forEach(pizza -> System.out.println(pizza));
        System.out.println("INGREDIENTI");
        getToppingList().forEach(topping -> System.out.println(topping));
        System.out.println("DRINK");
        getDrinkList().forEach(drink -> System.out.println(drink));
    }
}
