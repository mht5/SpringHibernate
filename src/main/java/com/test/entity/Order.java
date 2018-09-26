package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

    @Max(10000)
    @Min(0)
    @Column(name="price", columnDefinition="decimal(6,2)")
    private Double price;
    
    @Max(999)
    @Min(1)
    private Integer count;
    
    @Column(name="address", nullable=false)
    private String address;

    @ManyToOne(targetEntity=Customer.class)
    @JoinColumn(name="customer_id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Customer customer;

    @ManyToOne(targetEntity=Book.class)
    @JoinColumn(name="book_id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Book book;
    
    private transient String customerId;
    
    private transient String bookId;

    public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
