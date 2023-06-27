package com.crudcilia.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;	
	
	 @ManyToOne
	 @JoinColumn(name = "client_id")
	 private Client client;
	
	 @ManyToMany
	 @JoinTable(name = "sale",
	 inverseJoinColumns = @JoinColumn(name = "product_id"))
	 private List<Product> product = new ArrayList<>();
	 
	 public Sale() {}
	 
	public Sale(Long id, Client client, List<Product> product) {
		super();
		this.id = id;
		this.client = client;
		this.product = product;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProducts(List<Product> product) {
		this.product = product;
	}

}
