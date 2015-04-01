package com.tess.repositories.simple;

import com.tess.entities.Customer;
import com.tess.entities.OrderE;
import com.tess.repositories.OrderRepository;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("orderRepository")
public class SimpleOrderRepository implements OrderRepository {
    
    private final List<OrderE> orders = new LinkedList<>();
    
    public SimpleOrderRepository() {
        
    }
    
    
    @Override
    public List<OrderE> readAll() {
        return orders;
    }

    @Override
    public OrderE read(Long id) {
        for (OrderE order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Long save(OrderE order) {
        if (!orders.contains(order)) {
            orders.add(order);
        }
        return order.getId();
    }

    @Override
    public void delete(OrderE entity) {
        orders.remove(entity);
    }

    @Override
    public void update(OrderE entity) {
        
    }

    @Override
    public List<OrderE> getOrdersWithinPeriod(Customer customer, Date date1, Date date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
