package com.tess.repositories.jpa;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import com.tess.repositories.PizzaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository("pizzaRepository")
public class JPAPizzaRepository implements PizzaRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Pizza> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pizza> getPizzasByType(PizzaType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    @Override
    public Long save(Pizza pizza) {
        em.persist(pizza);
        return pizza.getId();
    }
    
}
