package com.tess.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "customers")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT o FROM Customer o")
})
public class Customer implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<OrderE> orders;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Address address;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<OrderE> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderE> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        id = address.getId();
        this.address = address;
    }

}
