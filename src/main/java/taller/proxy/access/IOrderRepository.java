/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.proxy.access;
import taller.proxy.dominio.Order;

/**
 *
 * @author DAAC
 */
public interface IOrderRepository {

   public void createOrder(Order order);
    
}
