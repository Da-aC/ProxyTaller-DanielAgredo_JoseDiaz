/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.proxy.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAAC
 */
public class Order {
    public int despatch;
    private Customer customer;
    private LocalDate date;
    private State state=State.NEW;
    private List<Item> details;

    public Order(Customer customer) {
        this.customer = customer;
        despatch=1500;
        details=new ArrayList<Item>();
    }

    public int getDespatch() {
        return despatch;
    }

    public void setDespatch(int despatch) {
        this.despatch = despatch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Item> getDetails() {
        return details;
    }

    public void setDetails(List<Item> details) {
        this.details = details;
    }

    public void addDish(Dish dish, int i) {
        details.add(new Item(dish, i));
    }
    
    public int calculateTotal(){
        int total=0;
        for(Item i:details){
            total = total + (i.getAmount()*i.getDish().getPrice());
        }
        return total+despatch;
    }
    
    
    
}
