package com.controllers;

import com.tess.entities.Pizza;
import com.tess.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author ivan
 */
@Controller
@SessionAttributes("pizzaToUpdate")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;
    
    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    @ResponseBody
    public String getPizzas() {
        return pizzaService.getAllPizzas().toString();
    }
    
    @RequestMapping(value = "/savePizza", method = RequestMethod.POST)
    public String savePizza(@ModelAttribute("pizzaToUpdate") Pizza pizza) {
        System.out.println(pizza);
        if (pizza.getId() == null) {
            pizzaService.savePizza(pizza);
        } else {
            pizzaService.updatePizza(pizza);
        }
        return "redirect:pizzas";
    }

    @RequestMapping(value = "/updatePizza/{id}")
    public String editPizza(@PathVariable("id") Long id, Model model) {
        Pizza pizza = pizzaService.getPizzaById(id);
        System.out.println(pizza);
        if (!(pizza == null)) {
            model.addAttribute("pizzaToUpdate", pizza);
            return "forward:/save_pizza.jsp";
        } else {
            return "redirect:/pizzas";
        }
    }
}
