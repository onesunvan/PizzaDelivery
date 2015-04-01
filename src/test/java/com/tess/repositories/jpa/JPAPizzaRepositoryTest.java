/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tess.repositories.jpa;

import com.tess.entities.Pizza;
import com.tess.entities.PizzaType;
import com.tess.repositories.PizzaRepository;
import com.tess.repositories.RepositoryTestsTemplate;
import javax.transaction.Transactional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author ivan
 */
public class JPAPizzaRepositoryTest extends RepositoryTestsTemplate {
    
    @Autowired
    private PizzaRepository pizzaRepository;
    
    public JPAPizzaRepositoryTest() {
    }
    
    @Rollback
    @Transactional
    @Test
    public void testSave() {
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.MEAT);
        pizza.setPrice(123.1);
        
        Long id = pizzaRepository.save(pizza);
        System.out.println(id);

        assertNotNull(1);
    }
    
}
