package savogineros.EserciziBackEndu2w1d2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import savogineros.EserciziBackEndu2w1d2.entities.*;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        // METODO VECCHIO
		/*Topping salame = new Topping(34,1.0,"salame");
		Topping prosciutto = new Topping(44,0.50, "prosciutto");
		Pizza pizza = new Pizza("Margherita", Arrays.asList(salame, prosciutto));
		//System.out.println(pizza);
		*/

        // METODO COI BEANS
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EserciziBackEndU2W1D2Application.class);
        System.out.println("STAMPIAMO QUALCHE PIZZA");
        System.out.println(ctx.getBean("pizzaMargherita"));
        System.out.println(ctx.getBean("pizzaAsiago"));
        System.out.println(ctx.getBean("pizzaProsciuttoEFunghi"));
        System.out.println(ctx.getBean("pizzaSalsicciaEPatatine"));
        System.out.println("ORA QUALCHE DRINKSSSSS");
        System.out.println(ctx.getBean("drinkCocaCola"));
        System.out.println(ctx.getBean("drinkAranciata"));
        System.out.println("QUALCHE INGREDIENTE");
        System.out.println(ctx.getBean("toppingPatatine"));
        System.out.println(ctx.getBean("toppingSalsiccia"));
        Menu menu = (Menu) ctx.getBean("menu");
        menu.printMenu();

        System.out.println("---------------------------------------------------------------------------------------------");
        // PRENDIAMO DAL CONTENITORE UN TAVOLO E CREIAMOLO EFFETTIVAMENTE
        Table table1 = (Table) ctx.getBean("Tavolo1");
        table1.printTable();

        // QUI INVECE CREIAMO UN ORDINE SENZA UTILIZZARE UN BEAN
        Order order1 = new Order(table1,4, List.of((Pizza)ctx.getBean("pizzaMargherita"), (Drink)ctx.getBean("drinkAranciata")));
        order1.printOrder();
        order1.totalPrice();
    }
}
