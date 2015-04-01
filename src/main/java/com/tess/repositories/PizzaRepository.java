package com.tess.repositories;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface PizzaRepository extends Repository<Pizza> {
    
    List<Pizza> getPizzasByType(PizzaType type);
    
}
