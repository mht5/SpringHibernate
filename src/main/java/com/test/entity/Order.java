package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_order")
public class Order {

    @Id
    @GenericGenerator(name="myuuid", strategy="uuid")
    @GeneratedValue(generator="myuuid")
    private String id;
    
    @Column(name="price", columnDefinition="decimal(5,2)")
    private Double price;
    
    @Column(name="address", nullable=false)
    private String address;

    @ManyToOne(targetEntity=Customer.class)
    @JoinColumn(name="customer_id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Customer c;

    public Customer getC() {
        return c;
    }
    public void setC(Customer c) {
        this.c = c;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
