/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.proxy.dominio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taller.proxy.access.IOrderRepository;
import taller.proxy.services.IOrderService;
/**
 *
 * @author DAAC
 */
public class OrderServiceLogger implements IOrderService {
    OrderFacade orderFacade;
    public OrderServiceLogger(OrderFacade orderFacade) {
        this.orderFacade=orderFacade;
    }

    @Override
    public void save(IOrderRepository repo) {
        repo.createOrder(orderFacade.getOrder());
        //se hace el log
        Logger logger= LoggerFactory.getLogger(OrderServiceLogger.class);
        String message = "Pedido guardado en la base de datos";
        logger.info("Pedido guardado en la base de datos");
    }
    
}
