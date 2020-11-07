/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.proxy.access;
import java.util.ArrayList;
import taller.proxy.dominio.Order;

/**
 *
 * @author DAAC
 */
public class OrderRepositoryListas implements IOrderRepository{
    private final ArrayList<Order> orders;
    
    public OrderRepositoryListas(){
        this.orders = new ArrayList<>();
    }
    
    @Override
    public void createOrder(Order order) {
        this.orders.add(order); 
    }
}
