package com.tess.repositories;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface PizzaRepository {
    List<Pizza> readAll();
    
    List<Pizza> getPizzasByType(PizzaType type);
    
    Long save(Pizza pizza);
}
