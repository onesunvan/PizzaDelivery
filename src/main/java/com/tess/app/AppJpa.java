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
import java.time.Instant;
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
        PizzaService pizzaService = appContext.getBean("pizzaService", PizzaService.class);
        OrderService orderService = appContext.getBean("orderService", OrderService.class);
        
        PizzaOrderRepository pizzaOrderRepository = 
                appContext.getBean("pizzaOrderRepository", PizzaOrderRepository.class);
        
        OrderE order = orderService.getOrderById(16L);
        Pizza pizza = pizzaService.getPizzaById(9L);
        
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setAmount(5L);
        pizzaOrder.setPizza(pizza);
        pizzaOrder.setOrder(order);
        
        OrderRepository orderRepository = appContext.getBean("orderRepository", OrderRepository.class);
        
        CustomerRepository customerRepository = appContext.getBean("customerRepository", CustomerRepository.class);
        
        AddressRepository addressRepository = appContext.getBean("addressRepository", AddressRepository.class);
        
//        Address address = new Address();
//        address.setCountry("Україна");
//        address.setCity("Київ");
//        address.setStreet("Сєченова");
//        address.setNumber(6L);
//        
//        System.out.println(addressRepository.save(address));
//        
//        Customer customer = new Customer();
//        customer.setFirstName("Іван");
//        customer.setLastName("Михайловський");
//        customer.setAddress(address);
//        
//        customerRepository.save(customer);
        
//        pizzaOrderRepository.save(pizzaOrder);
        
        
//        OrderE order = new OrderE();
//        order.setName("motherfucker");
//        order.setDate(new Date());
//        order.setStatus(OrderStatus.ACCEPTED);
        
//        System.out.println(orderService.getAllOrders());
        
//        orderService.placeOrder(order);
//        Pizza pizza1 = new Pizza("lol pizza", 122., PizzaType.MEAT);
//        pizza1.setId(10L);
//        Pizza pizza2 = new Pizza("sea breath", 20., PizzaType.MIX);
//        
//        pizzaService.savePizza(pizza1);
//        pizzaService.savePizza(pizza2);
        
//        System.out.println(pizzaService.getPizzasByType(PizzaType.MIX));
//        pizzaService.updatePizza(pizza1);
        
        Customer customer = customerRepository.read(27L);
        
        System.out.println(orderRepository.getOrdersWithinPeriod(customer, 
                Date.from(Instant.EPOCH), Date.from(Instant.now())));
    }
}
