package com.tess.app;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ivan
 */
public class AppJpa {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizza-service");
        EntityManager em = emf.createEntityManager();
        
        Pizza pizza = new Pizza();
        pizza.setName("Oliva");
        pizza.setType(PizzaType.MEAT);
        pizza.setPrice(123.1);
        
        System.out.println("Before: " + pizza );
        
        em.getTransaction().begin();
        em.persist(pizza);
        em.getTransaction().commit();
        System.out.println("After: " + pizza);
        
        em.close();
        emf.close();
    }
}
