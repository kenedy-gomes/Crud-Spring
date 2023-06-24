package com.crudcilia.demo.DTO;

import java.io.Serializable;
import java.util.Date;

import com.crudcilia.demo.model.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String password;
	private Date date;
	
	public ClientDTO() {}

	public ClientDTO(Client obj ) {
	   id = obj.getId();
	   name = obj.getName();
	   email = obj.getEmail();
	   password = obj.getPassword();
	   date =obj.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	 
	
}
