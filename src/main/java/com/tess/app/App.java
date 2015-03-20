package com.tess.app;

import com.tess.entities.Order;
import com.tess.entities.Pizza;
import com.tess.repositories.OrderRepository;
import com.tess.repositories.PizzaRepository;
import com.tess.repositories.SimpleOrderRepository;
import com.tess.repositories.SimplePizzaRepository;
import com.tess.services.OrderService;
import com.tess.services.PizzaService;
import com.tess.services.SimpleOrderService;
import com.tess.services.SimplePizzaService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ivan
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("test-repositories-spring.xml");
        
        
        PizzaService pizzaService = appContext.getBean("pizzaService", PizzaService.class);
        
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        
        OrderService orderService = appContext.getBean("orderService", OrderService.class);
        
        Order newOrder1 = orderService.createOrder();
        newOrder1.addPizza(pizzas.get(0));
        newOrder1.addPizza(pizzas.get(1));
        orderService.placeOrder(newOrder1);
        
        Order newOrder2 = orderService.createOrder();
        newOrder2.addPizza(pizzas.get(0));
        orderService.placeOrder(newOrder2);
        
        List<Order> orders = orderService.getAllOrders();

        System.out.println(orders);
        
    }
}
