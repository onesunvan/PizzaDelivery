package com.tess.repositories;

import com.tess.entities.Order;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface OrderRepository {
    List<Order> readAll();
    Order read(Long id);
    Order createNew();
    void save(Order order);

    public Long newId();
}
