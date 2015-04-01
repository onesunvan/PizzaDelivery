package com.tess.repositories.jpa;

import com.tess.entities.Customer;
import com.tess.entities.OrderE;
import com.tess.repositories.CustomerRepository;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */
@Repository("customerRepository")
public class JpaCustomerRepository extends JpaEntityRepository<Customer>
    implements CustomerRepository {

    public JpaCustomerRepository() {
        super(Customer.class);
    }

    @Transactional
    @Override
    public List<Customer> readAll() {
        return readAll("Customer.findAll");
    }

    @Transactional
    @Override
    public Long save(Customer entity) {
        saveEntity(entity);
        return entity.getId();
    }
    
}
