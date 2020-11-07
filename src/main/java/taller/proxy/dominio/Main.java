package taller.proxy.dominio;

import taller.proxy.services.IOrderService;
import taller.proxy.infra.ProxyClient;
import taller.proxy.access.IOrderRepository;
import taller.proxy.access.Factory;
import taller.proxy.dominio.State;
import taller.proxy.dominio.Customer;
import taller.proxy.dominio.Dish;
import taller.proxy.dominio.OrderFacade;

/*
 * Cliente que llama a los servicios de la facada
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Main {

    public static void main(String[] args) {

        //El sujeto real.
        OrderFacade orderFacade = new OrderFacade();

        //El objeto proxy. Se le pasa el objeto real por el constructor
        IOrderService orderProxy = new OrderServiceLogger(orderFacade);

        //Se opera normal el sujeto real
        orderFacade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 BarrioCaldas", "3115677899", "Popayán"));
        orderFacade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
        orderFacade.addDish(new Dish(2, "Hamburguesa sencilla", 4000), 3);
        orderFacade.addDish(new Dish(3, "Jugo hit", 1000), 2);
        System.out.println("Pedido creado");
        orderFacade.changeState(State.CONFIRMED);
        System.out.println("Se cambio el estado a " + orderFacade.getOrder().getState());
        orderFacade.changeState(State.DISPACHED);
        System.out.println("Se cambio el estado a " + orderFacade.getOrder().getState());
        orderFacade.changeState(State.FINALIZED);
        System.out.println("Se cambio el estado a " + orderFacade.getOrder().getState());
        System.out.println("El valor total del pedido es: " + orderFacade.calculateTotal());
        System.out.println("Total de platos pedidos: " + orderFacade.totalDishes());

        //Ahora ejecutamos el cliente proxy, y le pasamos el sujeto que debe utilizar.
        ProxyClient client = new ProxyClient(orderProxy);
        client.createOrder();
    }
}
