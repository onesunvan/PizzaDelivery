package com.tess.repositories.jpa;

import com.tess.entities.PizzaOrder;
import com.tess.repositories.PizzaOrderRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */
@Repository("pizzaOrderRepository")
public class JpaPizzaOrderRepository extends JpaEntityRepository<PizzaOrder>
    implements PizzaOrderRepository {

    public JpaPizzaOrderRepository() {
        super(PizzaOrder.class);
    }

    @Transactional
    @Override
    public List<PizzaOrder> readAll() {
        return readAll("PizzaOrder.findAll");
    }

    @Transactional
    @Override
    public Long save(PizzaOrder entity) {
        saveEntity(entity);
        return entity.getId();
    }
    
}
