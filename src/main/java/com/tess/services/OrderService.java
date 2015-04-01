package com.tess.services;

import com.tess.entities.OrderE;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface OrderService {
    List<OrderE> getAllOrders();
    OrderE getOrderById(Long id);
    OrderE createOrder();
    void placeOrder(OrderE order);
}
