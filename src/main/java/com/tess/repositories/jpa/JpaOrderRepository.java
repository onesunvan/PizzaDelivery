package com.tess.repositories.jpa;

import com.tess.entities.Customer;
import com.tess.entities.OrderE;
import com.tess.repositories.OrderRepository;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */
@Repository("orderRepository")
public class JpaOrderRepository extends JpaEntityRepository<OrderE>
    implements OrderRepository {

    public JpaOrderRepository() {
        super(OrderE.class);
    }

    @Override
    public List<OrderE> readAll() {
        return readAll("Order.findAll");
    }

    @Transactional
    @Override
    public Long save(OrderE entity) {
        saveEntity(entity);
        return entity.getId();
    }
    
    @Override
    public List<OrderE> getOrdersWithinPeriod(Customer customer, Date minDate, Date maxDate) {
        return em.createNamedQuery("Order.findCustomerPeriod", OrderE.class)
                .setParameter("customer", customer)
                .setParameter("minDate", minDate)
                .setParameter("maxDate", maxDate).getResultList();
    }
}
