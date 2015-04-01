package com.tess.services;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface PizzaService {
    
    List<Pizza> getAllPizzas();
    
    List<Pizza> getPizzasByType(PizzaType pizzaType);
    
    Pizza getPizzaById(Long id);
    
    void savePizza(Pizza pizza);
    
    void updatePizza(Pizza pizza);
}
