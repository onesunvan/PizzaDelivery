package com.tess.services.simple;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import com.tess.repositories.PizzaRepository;
import com.tess.services.PizzaService;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pizzaService")
public class SimplePizzaService implements PizzaService {
    
    private final static Logger logger = Logger.getLogger(SimpleOrderService.class);
    
    private final PizzaRepository pizzaRepository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    
    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.readAll();
    }

    @Override
    public List<Pizza> getPizzasByType(PizzaType pizzaType) {
        return pizzaRepository.getPizzasByType(pizzaType);
    }
    
    public void init() {
        logger.info("Simple order service created at " + new Date());
    }
    
    public void destroy() {
        logger.info("Simple order service destroyed at " + new Date());
    }

    @Override
    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    @Override
    public void updatePizza(Pizza pizza) {
        pizzaRepository.update(pizza);
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return pizzaRepository.read(id);
    }
    
}
