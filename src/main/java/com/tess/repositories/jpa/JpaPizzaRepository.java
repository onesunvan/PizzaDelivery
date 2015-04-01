package com.tess.repositories.jpa;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import com.tess.repositories.PizzaRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository("pizzaRepository")
public class JpaPizzaRepository extends JpaEntityRepository<Pizza>
    implements PizzaRepository {

    public JpaPizzaRepository() {
        super(Pizza.class);
    }

    @Transactional
    @Override
    public List<Pizza> readAll() {
        return readAll("Pizza.findAll");
    }

    @Transactional
    @Override
    public List<Pizza> getPizzasByType(PizzaType type) {
        TypedQuery<Pizza> query = em.createNamedQuery("Pizza.findAllByType", Pizza.class);
        List<Pizza> pizzas = query.setParameter("type", type).getResultList();
        return pizzas;
    }
    
    @Transactional
    @Override
    public Long save(Pizza pizza) {
        saveEntity(pizza);
        return pizza.getId();
    }
    
    
    
}
