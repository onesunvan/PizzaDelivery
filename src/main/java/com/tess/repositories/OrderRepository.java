package com.tess.repositories;

import com.tess.entities.Customer;
import com.tess.entities.OrderE;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface OrderRepository extends Repository<OrderE> {
    List<OrderE> getOrdersWithinPeriod(Customer customer, Date date1, Date date2);
}
