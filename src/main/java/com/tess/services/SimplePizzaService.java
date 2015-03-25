package com.tess.services;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import com.tess.repositories.PizzaRepository;
import java.util.Date;
import java.util.LinkedList;
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
        List<Pizza> resultPizzaList = new LinkedList<>();
        List<Pizza> allPizzas = pizzaRepository.readAll();
        for (Pizza pizza : allPizzas) {
            if (pizza.getType() == pizzaType) {
                resultPizzaList.add(pizza);
            }
        }
        return resultPizzaList;
    }
    
    public void init() {
        logger.info("Simple order service created at " + new Date());
    }
    
    public void destroy() {
        logger.info("Simple order service destroyed at " + new Date());
    }
    
}
