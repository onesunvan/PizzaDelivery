package com.tess.services;

import com.tess.entities.Order;
import com.tess.repositories.OrderRepository;
import java.util.Date;
import java.util.List;


public abstract class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    
    
    public SimpleOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.readAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.read(id);
    }

    @Override
    public Order createOrder() {
        Order order = createNewOrder();
        order.setId(orderRepository.newId());
        order.setDate(new Date());
        order.setName(order.getId() + " -- " + order.getDate());
        return order;
        
    }

    @Override
    public void placeOrder(Order order) {
        orderRepository.save(order);
    }
    
    public abstract Order createNewOrder();
    
}
