package com.example.hrapplication.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class User {
	
	@Id
	@Column(name="userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

	@Column(name="name")
    private String name;
	
	@Column(name="email")
    private String email;

	@Column(name = "image", columnDefinition = "LONGBLOB")
    @Lob
    private byte[] image;
	
	@Column(name = "contentType")
    private String contentType;

	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	 public String getContentType() {
	        return contentType;
	    }

	    public void setContentType(String contentType) {
	        this.contentType = contentType;
	    }

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", email=" + email + ", image=" + Arrays.toString(image) + "]";
	}

	public User(Long id, String name, String email, byte[] image) {
		super();
		this.userId = id;
		this.name = name;
		this.email = email;
		this.image = image;
	}

	public User() {
		super();
	}


    
    
	
	
	
}
