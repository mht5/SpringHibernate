package com.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Length(min=1, max=20)
	@Column(name = "username")
	private String username;
	
	@Length(min=1, max=20)
	@Column(name = "name")
	private String name;
	
	@Past
	@Column(name = "birthday")
	private Date birthday;

	@Max(1)
	@Min(0)
	@Column(name = "gender")
	private int gender;
	
	@Length(min=1, max=150)
	@Column(name = "image_url")
	private String imageUrl;
	
	@Length(min=1, max=150)
	@Column(name = "file_url")
	private String fileUrl;
	
	private transient MultipartFile image;
	
	private transient MultipartFile file;
	
}
