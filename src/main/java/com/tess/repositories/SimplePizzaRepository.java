package com.tess.repositories;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
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
    
}
