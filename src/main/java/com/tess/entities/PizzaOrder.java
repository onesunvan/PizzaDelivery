package com.tess.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "pizza_orders")
@NamedQueries({
    @NamedQuery(name = "PizzaOrder.findAll", query = "SELECT o FROM PizzaOrder o")
})
public class PizzaOrder implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderE order;
    
    private Long amount;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public OrderE getOrder() {
        return order;
    }

    public void setOrder(OrderE order) {
        this.order = order;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
