package taller.proxy.access;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAAC
 */
public class Factory {
   
    private static Factory instance;

    private Factory() {
    }
    
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }
    
    public IOrderRepository getRepository(String tipo){
        IOrderRepository repo = null;
        if("default".equals(tipo)){
            repo=new OrderRepositoryListas();
        }
        return repo;
    }
}
