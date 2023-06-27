package com.crudcilia.demo.DTO;

import com.crudcilia.demo.model.Client;
import com.crudcilia.demo.model.Product;

public class SaleDTO {
	
	private Long id;
	private Client client;
	private Product product; 
	
	public SaleDTO() {}

	public SaleDTO(Long id, Client client, Product product) {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
