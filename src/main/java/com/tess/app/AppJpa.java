package com.tess.app;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import com.tess.services.PizzaService;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ivan
 */
public class AppJpa {
    
    public static void main(String[] args) {
        System.out.println("=================================================================");
        ApplicationContext repositoriesContext = new ClassPathXmlApplicationContext("jpa-repositories.xml");
        System.out.println("=================================================================");
        System.out.println(Arrays.toString(repositoriesContext.getBeanDefinitionNames()));
        ApplicationContext appContext = 
                new ClassPathXmlApplicationContext(new String[] {"service.xml"}, repositoriesContext);
        PizzaService pizzaService = appContext.getBean("pizzaService", PizzaService.class);
        
        Pizza pizza = new Pizza("vanna", 12., PizzaType.MEAT);
        
        pizzaService.savePizza(pizza);
        
    }
}
