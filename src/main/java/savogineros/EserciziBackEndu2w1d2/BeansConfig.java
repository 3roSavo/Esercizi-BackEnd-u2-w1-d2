package savogineros.EserciziBackEndu2w1d2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import savogineros.EserciziBackEndu2w1d2.entities.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {

    // TOPPINGS

    @Bean
    Topping toppingPomodoro() {
        return new Topping(28,0.5,"Pomodoro");
    }
    @Bean
    Topping toppingMozzarella() {
        return new Topping(45,1.0,"Mozzarella");
    }
    @Bean
    Topping toppingSalame() {
        return new Topping(88,1.5,"Salame");
    }
    @Bean
    Topping toppingPatatine() {
        return new Topping(134,2.0, "Patatine");
    }
    @Bean
    Topping toppingProsciutto() {
        return new Topping(30,1.75,"Prosciutto");
    }
    @Bean
    Topping toppingFunghiPorcini() {
        return new Topping(120,3.0, "Funghi Porcini");
    }
    @Bean
    Topping toppingSalsiccia() {
        return new Topping(110,1.0,"Salsiccia");
    }
    @Bean
    Topping toppingFormaggioAsiago() {
        return new Topping(64,0.5,"Formaggio Asiago");
    }

    // BEVANDE
    @Bean
    Drink drinkCocaCola() {
        return new Drink(68,3.0,"Coca cola");
    }
    @Bean
    Drink drinkAcqua() {
        return new Drink(0,1.5,"Acqua");
    }
    @Bean
    Drink drinkAranciata() {
        return new Drink(22,2.0,"Aranciata");
    }
    @Bean
    Drink drinkVino() {
        return new Drink(43,4.0, "Vino della casa");
    }

    // PIZZE
    @Bean
    Pizza pizzaMargherita() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(toppingPomodoro());
        toppings.add(toppingMozzarella());
        return new Pizza("Margherita", toppings);
    }
    @Bean
    Pizza pizzaAsiago() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(toppingPomodoro());
        toppings.add(toppingMozzarella());
        toppings.add(toppingFormaggioAsiago());
        return new Pizza("Pizza Asiago", toppings);
    }
    @Bean
    Pizza pizzaProsciuttoEFunghi() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(toppingPomodoro());
        toppings.add(toppingMozzarella());
        toppings.add(toppingProsciutto());
        toppings.add(toppingFunghiPorcini());
        return new Pizza("Pizza Prosciutto e Funghi", toppings);
    }
    @Bean
    Pizza pizzaSalsicciaEPatatine() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(toppingPomodoro());
        toppings.add(toppingMozzarella());
        toppings.add(toppingSalsiccia());
        toppings.add(toppingPatatine());
        return new Pizza("Pizza Salsiccia e Patatine", toppings);
    }

    // IL MENU!
    @Bean
    Menu menu() {
        List<Topping> toppings = new ArrayList<>(List.of(toppingPatatine(),toppingSalame(),toppingPomodoro(),
                toppingProsciutto(),toppingMozzarella(),toppingFormaggioAsiago(),toppingFunghiPorcini(),
                toppingSalsiccia()));
        List<Pizza> pizzas = new ArrayList<>(List.of(pizzaMargherita(),pizzaAsiago(),pizzaSalsicciaEPatatine(),pizzaProsciuttoEFunghi()));
        List<Drink> drinks = new ArrayList<>(List.of(drinkAcqua(),drinkAranciata(),drinkCocaCola(),drinkVino()));
        return new Menu(pizzas,drinks,toppings);
    }

    // TAVOLI
    @Bean("Tavolo1")
    Table getTable1(@Value("${cover.price}") double coverPrice) {
        return new Table(1,4,true, coverPrice);
    }
    @Bean("Tavolo2")
    Table getTable2(@Value("${cover.price}") double coverPrice) {
        return new Table(2,6,true, coverPrice);
    }
    @Bean("Tavolo3")
    Table getTable3(@Value("${cover.price}") double coverPrice) {
        return new Table(3,2,true, coverPrice);
    }
    @Bean("Tavolo4")
    Table getTable4(@Value("${cover.price}") double coverPrice) {
        return new Table(4,4,false, coverPrice);
    }

    /*// ORDINI
    @Bean
    Order order1() {
        // nelle soluzioni fanno gli ordini direttamente nel runner col costruttore che accetta solo
        // numero ordine e tavolo...
        // Facendo qui l'ordine dovò prima crearmi un tavolo.... che poi aggiungerò al nuovo ordine....
        // un casino insomma. Proviamo a seguire la soluzione...
        return new Order(1,)
    }*/
}
