package com.tess.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "pizzas")
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p"),
    @NamedQuery(name = "Pizza.findAllByType", 
            query = "SELECT p FROM Pizza p WHERE p.type = :type")
})
public class Pizza implements Serializable {

    @Id
    @GeneratedValue
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
