package com.tess.app;

import com.tess.entities.Address;
import com.tess.entities.Customer;
import com.tess.entities.OrderE;
import com.tess.entities.OrderStatus;
import com.tess.entities.Pizza;
import com.tess.entities.PizzaOrder;
import com.tess.entities.PizzaType;
import com.tess.repositories.AddressRepository;
import com.tess.repositories.CustomerRepository;
import com.tess.repositories.OrderRepository;
import com.tess.repositories.PizzaOrderRepository;
import com.tess.services.OrderService;
import com.tess.services.PizzaService;
import java.util.Arrays;
import java.util.Date;
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
        OrderRepository orderRepository = appContext.getBean("orderRepository", OrderRepository.class);
        System.out.println(orderRepository.read(16L));
    }
}
