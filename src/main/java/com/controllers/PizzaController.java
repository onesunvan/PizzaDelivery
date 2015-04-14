package com.controllers;

import com.tess.entities.Pizza;
import com.tess.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ivan
 */
@Controller
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;
    
    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    @ResponseBody
    public String getPizzas() {
        return pizzaService.getAllPizzas().toString();
    }
    
    @RequestMapping(value = "/savePizza", method = RequestMethod.POST)
    public String savePizza(@ModelAttribute Pizza pizza) {
        System.out.println(pizza);
        pizzaService.savePizza(pizza);
        return "redirect:pizzas";
    }

}
