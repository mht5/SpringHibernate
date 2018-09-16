package com.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="t_book")
public class Book {
	
	@Id
    @GenericGenerator(name="myuuid", strategy="uuid")
    @GeneratedValue(generator="myuuid")
	private String id;
	
	@Column(name="name", length=30, unique=true, nullable=false)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date publicationDate;
	
	@Type(type="double")
	@Column(name="price", nullable=true, columnDefinition="decimal(5,2)")
	private Double price;
	
	@Max(999)
	private int storage;

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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

}
