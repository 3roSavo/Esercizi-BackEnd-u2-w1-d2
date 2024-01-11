package savogineros.EserciziBackEndu2w1d2.entities;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private int numOrder;
    private Table table;
    private OrderState orderState;
    private int numCovers;
    private LocalDateTime acquisitionDate;
    private List<Item> orderElements;

    // COSTRUTTORE
    public Order(Table table, int numCovers, List<Item> orderElements) {
        if (numCovers > table.getMaxTableCovers()) { // Controlliamo che il tavolo "sopporti" la capienza del nuovo ordine
            throw new RuntimeException("Numero di coperti maggiore della capienza del tavolo!");
        }
        if (!table.getIsFree()) { // Controlliamo che il tavolo sia libero prima di procedere con la creazione dell'ordine
            throw new RuntimeException("Tavolo occupato!!!");
        }
        Random rndm = new Random();
        this.numOrder = rndm.nextInt(1, 1000000);
        this.orderState = OrderState.IN_PROGRESS;
        this.acquisitionDate = LocalDateTime.now();
        this.table = table;
        table.setIsFree(false); // Il tavolo ora è occupato!
        this.numCovers = numCovers;
        this.orderElements = orderElements;
    }

    // GETTER E SETTER
    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public int getNumCovers() {
        return numCovers;
    }

    public void setNumCovers(int numCovers) {
        this.numCovers = numCovers;
    }

    public LocalDateTime getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDateTime acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public List<Item> getOrderElements() {
        return orderElements;
    }

    public void setOrderElements(List<Item> orderElements) {
        this.orderElements = orderElements;
    }

    // METODI
    public void totalPrice() { // Otteniamo il prezzo totale dell'ordine (prezzo coperti + prezzo elementi)
        double totalPriceElements = getNumCovers() * table.getCoverPrice();
        for (int i = 0; i < orderElements.size(); i++) {
            totalPriceElements += orderElements.get(i).getPrice();
        }
         System.out.println("Totale ordine = " + totalPriceElements);
    }
    public void printOrder() {
        System.out.println("****ORDINE****");
        System.out.println("Numero dell'ordine = " + getNumOrder());
        System.out.println("Stato dell'ordine = " + getOrderState());
        System.out.println("Numero di coperti occupati = " + getNumCovers());
        System.out.println("Ora inserimento ordine = " + getAcquisitionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        // Ho preso la data che include l'ora e minuti con LocalDateTime, poi ho importato pure DateTimeFormatter per renderla più leggibile :D
        System.out.println("Lista di cibi nell'ordine:");
        getOrderElements().forEach(element -> System.out.println(element));
        System.out.println("Info relative al tavolo associato:");
        getTable().printTable();
    }


}
