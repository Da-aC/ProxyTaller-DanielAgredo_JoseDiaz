/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.proxy.services;

import taller.proxy.access.IOrderRepository;

/**
 *
 * @author DAAC
 */
public interface IOrderService {
    
    public void save(IOrderRepository repo);
}
