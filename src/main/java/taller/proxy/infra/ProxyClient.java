/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.proxy.infra;

import taller.proxy.access.Factory;
import taller.proxy.access.IOrderRepository;
import taller.proxy.services.IOrderService;

/**
 *
 * @author DAAC
 */
public class ProxyClient implements IOrderService{
    private IOrderService orderService;

    public ProxyClient(IOrderService orderService) {
        this.orderService = orderService;
    }
    
    public void createOrder(){
        save(Factory.getInstance().getRepository("default"));
    }

    @Override
    public void save(IOrderRepository repo) {
        orderService.save(repo); //To change body of generated methods, choose Tools | Templates.
    }
    
}
