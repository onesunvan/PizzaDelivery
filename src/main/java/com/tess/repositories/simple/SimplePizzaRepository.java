package com.tess.repositories.simple;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import com.tess.repositories.PizzaRepository;
import java.util.LinkedList;
import java.util.List;


public class SimplePizzaRepository implements PizzaRepository {

    private List<Pizza> pizzas = new LinkedList<>();
    
    public SimplePizzaRepository() {
//        pizzas.add(new Pizza("tasty-boom", 12., PizzaType.MEAT));
//        pizzas.add(new Pizza("meat-party", 20., PizzaType.MEAT));
//        pizzas.add(new Pizza("vegan-rock", 15., PizzaType.VEGAN));
//        pizzas.add(new Pizza("mixed-night", 14., PizzaType.MIX));
    }
    
    @Override
    public List<Pizza> readAll() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public List<Pizza> getPizzasByType(PizzaType type) {
        List<Pizza> pizzas = new LinkedList<>();
        for (Pizza pizza : this.pizzas) {
            if (pizza.getType() == type) {
                pizzas.add(pizza);
            }
        }
        return pizzas;
    }

    @Override
    public Long save(Pizza pizza) {
        if (pizzas != null) {
            pizzas.add(pizza);
        }
        return (long) (pizzas.size() - 1);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public Pizza read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pizza entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pizza entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
