package com.tess.services;

import com.tess.entities.Order;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder();
    void placeOrder(Order order);
}
