package com.tess.services.simple;

import com.tess.entities.OrderE;
import com.tess.repositories.OrderRepository;
import com.tess.services.OrderService;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class SimpleOrderService implements OrderService {

    private final static Logger logger = Logger.getLogger(SimpleOrderService.class);
    
    private final OrderRepository orderRepository;
    
    @Autowired
    public SimpleOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    
    @Override
    public List<OrderE> getAllOrders() {
        return orderRepository.readAll();
    }

    @Override
    public OrderE getOrderById(Long id) {
        return orderRepository.read(id);
    }

    @Override
    public OrderE createOrder() {
        OrderE order = createNewOrder();
        order.setDate(new Date());
        order.setName(" -- " + order.getDate());
        return order;
        
    }

    @Override
    public void placeOrder(OrderE order) {
        orderRepository.save(order);
    }
    
    public abstract OrderE createNewOrder();
    
    public void init() {
        logger.info("Simple order service created at " + new Date());
    }
    
    public void destroy() {
        logger.info("Simple order service destroyed at " + new Date());
    }
    
}
