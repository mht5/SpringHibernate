package com.test.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="t_customer")
public class Customer {

    @Id
    @GenericGenerator(name="myuuid", strategy="uuid")
    @GeneratedValue(generator="myuuid")
    private String id;
    
    @Length(min=2, max=255)
    @Column(name="name", unique=true, nullable=false)
    private String name;

    @OneToMany(targetEntity=Order.class, mappedBy="c")
    private Set<Order> orders = new HashSet<Order>();

    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
