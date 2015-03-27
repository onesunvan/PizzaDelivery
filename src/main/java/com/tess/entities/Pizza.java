package com.tess.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ivan
 */
@Entity
public class Pizza implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private Double price;
    
    @Enumerated(EnumType.STRING)
    private PizzaType type;

    @Override
    public String toString() {
        return "Pizza{" + "name=" + name + ", price=" + price + ", type=" + type + '}';
    }

    public Pizza(String name, Double price, PizzaType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Pizza() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
