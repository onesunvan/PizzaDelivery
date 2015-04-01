package com.tess.entities;

import com.tess.annotations.OrderAnno;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author ivan
 */
@OrderAnno
@Scope(value = "prototype")
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM OrderE o"),
    @NamedQuery(name = "Order.findCustomerPeriod",
            query = "SELECT o FROM OrderE o "
                    + "WHERE o.customer=:customer AND "
                    + "o.date > :minDate AND o.date < :maxDate")
})
public class OrderE implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String name;

    private Double price = 0.;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Set<PizzaOrder> pizzaOrders = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    public OrderE(Long id, Date date, String name) {
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public OrderE() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(Set<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public Double getPrice() {
        return price;
    }

    public void addPizzaOrder(PizzaOrder pizzaOrder) {
        pizzaOrders.add(pizzaOrder);
        price += pizzaOrder.getPizza().getPrice();
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + 
                ", name=" + name + ", pizzaOrders=" + pizzaOrders + ", price=" + price + '}';
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
